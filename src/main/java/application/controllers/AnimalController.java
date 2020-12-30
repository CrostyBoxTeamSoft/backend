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
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/all")
    public Iterable<Animal> allAnimal()
    {
        return animalRepository.findAll();
    }

    @PostMapping(path = "/add")
    public String addAnimal(@RequestBody AnimalRequest animalRequest)
    {
        System.out.println("Add Animal");
        return animalRequest.createAnimal(animalRepository, userRepository);
    }

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
