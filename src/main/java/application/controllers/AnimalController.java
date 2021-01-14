package application.controllers;

import application.beans.Animal;
import application.repositories.AnimalRepository;
import application.repositories.UserRepository;
import application.request.AnimalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController
{
    /**
     * Represente la table Animal mySQL ou sont stockes tout les animaux
     * @see AnimalRepository
     */
    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Represente la table User mySQL ou sont stockes tout les utilisateurs
     * @see application.beans.User
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Retourne tout les animaux enregistres dans la base de donnees
     * @return
     */
    @GetMapping(path="/all")
    public Iterable<Animal> allAnimal()
    {
        return animalRepository.findAll();
    }

    /**
     * Reception d'une requete POST pour l'ajout d'un animal
     * @param animalRequest
     * @return
     * Cree un animal dans la base de donnees
     */
    @PostMapping(path = "/add")
    public String addAnimal(@RequestBody AnimalRequest animalRequest)
    {
        System.out.println("Add Animal");
        return animalRequest.createAnimal(animalRepository, userRepository);
    }

    /**
     * Reception d'une requete DELETE pour supprimer un animal
     * @param idAnimal
     * la cle primaire de l'animal a supprimer
     * @param idUser
     * la cle primaire de l'utilisateur possedant l'animal
     * @return
     */
    @DeleteMapping(path = "/delete/{idUser}/{idAnimal}")
    public String removeAnimal(@PathVariable("idAnimal") int idAnimal, @PathVariable("idUser") int idUser)
    {
        System.out.println("DELETE an animal");

        if (userRepository.existsById(idUser))
        {
            if (animalRepository.existsById(idAnimal))
            {
                animalRepository.deleteById(idAnimal);
                return "Animal deleted";
            }

            else
            {
                return "Animal doesn't exist";
            }
        }

        return "User doesn't exist";

    }


}
