package application.controllers;

import application.beans.Animal;
import application.dao.AnimalDAO;
import application.dao.UserDAO;
import application.services.AnimalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController
{
    /**
     * Represente la table Animal mySQL ou sont stockes tout les animaux
     * @see AnimalDAO
     */
    @Autowired
    private AnimalDAO animalDAO;

    /**
     * Represente la table User mySQL ou sont stockes tout les utilisateurs
     * @see UserDAO
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Retourne tout les animaux enregistres dans la base de donnees
     * @return
     */
    @GetMapping(path="/all")
    public Iterable<Animal> allAnimal()
    {
        return animalDAO.findAll();
    }

    /**
     * Reception d'une requete POST pour l'ajout d'un animal
     * @param animalRequest
     * @return
     * Cree un animal dans la base de donnees
     */
    @PostMapping(path = "/{id}")
    public ResponseEntity<String> addAnimal(@RequestBody AnimalRequest animalRequest, @PathVariable int id)
    {
        System.out.println("Add animal");
         String response = animalRequest.createAnimal(animalDAO, userDAO);

         if (response.equals(AnimalRequest.ANIMALCREATED))
         {
             return new ResponseEntity<>(response, HttpStatus.CREATED);
         }

         return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    /**
     * Reception d'une requete DELETE pour supprimer un animal
     * @param idAnimal
     * la cle primaire de l'animal a supprimer
     * @param idUser
     * la cle primaire de l'utilisateur possedant l'animal
     * @return
     * Une reponse HTTP avec un message d'erreur ou de succes
     */
    @DeleteMapping(path = "/delete/{idUser}/{idAnimal}")
    public ResponseEntity<String> removeAnimal(@PathVariable("idAnimal") int idAnimal, @PathVariable("idUser") int idUser)
    {
        System.out.println("DELETE an animal");

        if (userDAO.existsById(idUser))
        {
            if (animalDAO.existsById(idAnimal))
            {
                animalDAO.deleteById(idAnimal);
                return new ResponseEntity<>("Animal deleted", HttpStatus.OK);
            }

            else
            {
                return new ResponseEntity<>("Animal doesn't exist", HttpStatus.NOT_FOUND);
            }
        }

        return new ResponseEntity<>("User doesn't exist", HttpStatus.NOT_FOUND);
    }


}
