package application.request;

import application.beans.Animal;
import application.beans.User;
import application.enums.Comportement;
import application.enums.Espece;
import application.enums.Physiologie;
import application.repositories.AnimalRepository;
import application.repositories.UserRepository;
import org.joda.time.LocalDate;

/**
 * Class utiliser pour representer les informations recu depuis le formulaire d'ajout d'animal
 */
public class AnimalRequest
{
    /**
     * @see Animal
     */
    private Espece espece;  //Chat ou chien

    /**
     * @see Animal
     */
    private String race;

    /**
     * @see Animal
     */
    private LocalDate anniversaire;

    /**
     * @see Animal
     */
    private double poids;

    /**
     * @see Animal
     */
    private Comportement comportement;

    /**
     * @see Animal
     */
    private Physiologie physiologique;

    /**
     * @see Animal
     */
    private String machine;

    /**
     * @see Animal
     */
    private String nom;

    /**
     * @see Animal
     */
    private String photo;

    /**
     * @see Animal
     */
    private int idUser;

    /**
     * Retourne idUser
     * @return
     */
    public int getIdUser()
    {
        return idUser;
    }

    /**
     * Definit idUser
     * @param idUser
     */
    public void setIdUser(int idUser)
    {
        this.idUser = idUser;
    }

    /**
     * Retourne espece
     * @return
     */
    public Espece getEspece()
    {
        return espece;
    }

    /**
     * Definit espece
     * @param espece
     */
    public void setEspece(Espece espece)
    {
        this.espece = espece;
    }

    /**
     * Retourne race
     * @return
     */
    public String getRace()
    {
        return race;
    }

    /**
     * Definit race
     * @param race
     */
    public void setRace(String race)
    {
        this.race = race;
    }

    /**
     * Retourne anniversaire
     * @return
     */
    public LocalDate getAnniversaire()
    {
        return anniversaire;
    }

    /**
     * Definit anniversaire
     * @param anniversaire
     */
    public void setAnniversaire(LocalDate anniversaire)
    {
        this.anniversaire = anniversaire;
    }

    /**
     * Retourne poids
     * @return
     */
    public double getPoids()
    {
        return poids;
    }

    /**
     * Definit poids
     * @param poids
     */
    public void setPoids(double poids)
    {
        this.poids = poids;
    }

    /**
     * Retourne comportement
     * @return
     */
    public Comportement getComportement()
    {
        return comportement;
    }

    /**
     * Definit comportement
     * @param comportement
     */
    public void setComportement(Comportement comportement)
    {
        this.comportement = comportement;
    }

    /**
     * Retourne physiologie
     * @return
     */
    public Physiologie getPhysiologique()
    {
        return physiologique;
    }

    /**
     * Definit physiologie
     * @param physiologique
     */
    public void setPhysiologique(Physiologie physiologique)
    {
        this.physiologique = physiologique;
    }

    /**
     * Retourne Crosty Box
     * @return
     */
    public String getMachine()
    {
        return machine;
    }

    /**
     * Definit Crosty Box
     * @param machine
     */
    public void setMachine(String machine)
    {
        this.machine = machine;
    }

    /**
     * Retourne nom
     * @return
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Definit nom
     * @param nom
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    /**
     * Retourne photo
     * @return
     */
    public String getPhoto()
    {
        return photo;
    }

    /**
     * Definit photo
     * @param photo
     */
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    /**
     * Cree un animal, l'assigne a un utilisateur, enregistre l'animal et l'utilisateur dans la base de donnees
     * @param animalRepository
     * @param userRepository
     * @return
     */
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
