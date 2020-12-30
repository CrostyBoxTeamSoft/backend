package application.request;

import application.beans.Animal;
import application.beans.User;
import application.calculator.Calculator;
import application.enums.Comportement;
import application.enums.Espece;
import application.enums.Physiologie;
import application.repositories.AnimalRepository;
import application.repositories.UserRepository;
import org.joda.time.LocalDate;

public class AnimalRequest
{
    private Espece espece;  //Chat ou chien
    private String race;
    private LocalDate anniversaire;
    private double poids;
    private Comportement comportement;
    private Physiologie physiologique;
    private String machine;
    private String nom;
    private String photo;
    private int idUser;

    public int getIdUser()
    {
        return idUser;
    }

    public void setIdUser(int idUser)
    {
        this.idUser = idUser;
    }

    public Espece getEspece()
    {
        return espece;
    }

    public void setEspece(Espece espece)
    {
        this.espece = espece;
    }

    public String getRace()
    {
        return race;
    }

    public void setRace(String race)
    {
        this.race = race;
    }

    public LocalDate getAnniversaire()
    {
        return anniversaire;
    }

    public void setAnniversaire(LocalDate anniversaire)
    {
        this.anniversaire = anniversaire;
    }

    public double getPoids()
    {
        return poids;
    }

    public void setPoids(double poids)
    {
        this.poids = poids;
    }

    public Comportement getComportement()
    {
        return comportement;
    }

    public void setComportement(Comportement comportement)
    {
        this.comportement = comportement;
    }

    public Physiologie getPhysiologique()
    {
        return physiologique;
    }

    public void setPhysiologique(Physiologie physiologique)
    {
        this.physiologique = physiologique;
    }

    public String getMachine()
    {
        return machine;
    }

    public void setMachine(String machine)
    {
        this.machine = machine;
    }

    public String getNom()
    {
        return nom;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public String createAnimal(AnimalRepository animalRepository, UserRepository userRepository)
    {

        Animal animal = new Animal();
        animal.setEspece(espece);
        animal.setRace(race);
        animal.setAnniversaire(anniversaire);
        animal.setPoids(poids);
        animal.setComportement(comportement);
        animal.setPhysiologique(physiologique);
        animal.setMachine(machine);
        animal.setNom(nom);
        animal.setPhoto(photo);
        animal.setUser(userRepository.findById(idUser).get());

        User user = userRepository.findById(idUser).get();
        user.addAnimal(animal);

        animal.init();

        animalRepository.save(animal);
        userRepository.save(user);

        return "animal created";

    }


}
