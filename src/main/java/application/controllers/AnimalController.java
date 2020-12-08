package application.controllers;

import application.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/animal")
public class AnimalController
{
    @Autowired
    private AnimalRepository animalRepository;

    @PostMapping(path = "add")
    public void addAnimal()
    {

    }


}
