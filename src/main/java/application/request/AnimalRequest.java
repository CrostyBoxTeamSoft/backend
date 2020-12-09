package application.request;

import application.beans.Animal;
import application.calculator.Calculator;
import application.enums.Comportement;
import application.enums.Espece;
import application.enums.Physiologie;
import application.repositories.AnimalRepository;
import org.joda.time.DateTime;

public class AnimalRequest
{
    private Espece espece;
    private String race;    //Chat ou chien
    private DateTime anniversaire;
    private double poids;
    private Comportement comportement;
    private Physiologie physiologique;
    private String machine;
    private String nom;
    private String photo;


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

    public DateTime getAnniversaire()
    {
        return anniversaire;
    }

    public void setAnniversaire(DateTime anniversaire)
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

    public String createAnimal(AnimalRepository animalRepository)
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

        animal.setRation(Calculator.rationJournaliere(animal));

        animalRepository.save(animal);

        return "animal created";

    }


}
