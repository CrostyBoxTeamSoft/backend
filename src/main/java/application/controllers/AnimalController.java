package application.controllers;

import application.beans.User;
import application.repositories.AnimalRepository;
import application.request.AnimalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController
{
    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping(path = "add")
    public void addAnimal(@RequestBody AnimalRequest animalRequest)
    {
        System.out.println("Add Animal");
        animalRequest.createAnimal(animalRepository);
    }

    @DeleteMapping(path = "delete/{idUser}/{idAnimal}")
    public void removeAnimal(@PathVariable("idUser") int idUser, @PathVariable("idAnimal") int idAnimal)
    {

    }


}
