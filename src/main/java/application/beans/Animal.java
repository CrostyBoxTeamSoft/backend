package application.beans;

import application.calculator.Calculator;
import application.enums.Comportement;
import application.enums.Espece;
import application.enums.Physiologie;
import application.enums.Race;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.joda.time.LocalDate;

import javax.persistence.*;

/**
 * Class representant un Animal
 */
@Entity
public class Animal
{
    /**
     * La cle primaire de l'animal dans la base de donnee. Elle est generee automatiquement
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAnimal;

    /**
     * Chat ou chien
     * @see Espece
     */
    private Espece espece;

    /**
     * Race de l'animal
     */
    private String race;

    /**
     * La date de naissance de l'animal afin de calculer son age dynamiquement
     * @see LocalDate
     */
    private LocalDate anniversaire;

    /**
     * Le poids de l'animal
     */
    private double poids;

    /**
     * @see Comportement
     */
    private Comportement comportement;

    /**
     * @see Physiologie
     */
    private Physiologie physiologique;

    /**
     * La Crosty Box liee a l'animal
     */
    private String machine;

    /**
     * Le nom de l'animal
     */
    private String nom;

    /**
     * Une photo de l'animal (optionel)
     */
    private String photo;

    /**
     * La ration journaliere (en gramme) a donne a l'animal. Elle est automatiquement calculee a la creation de
     * l'animal mais
     * peut etre modifiee
     */
    private double ration;

    /**
     * Represente le coefficient de race pour le calcul de ration
     * @see Race
     */
    private Race k1;

    /**
     * Le proprietaire de l'animal
     * @see User
     */
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fk_idUser")
    private User user;

    /**
     * Les calories des croquettes pour 100g que le chien mange. Cette propriete n'est pas represente dans la base de
     * donnees
     */
    @Transient
    private double kcalCroquettes;

    /**
     * Nombre de repas par jour. Initialise a 3 mais peut etre modifie
     */
    private int nbRepas;

    /**
     * Initialisation de l'animal lors de sa creation.
     * Calcul de la ration ideal et nombre de repas journaliers
     */
    public void init()
    {
        nbRepas = 3;
        Calculator.rationJournaliere(this);
    }

    @Override
    public String toString()
    {
        return "Animal{" +
                "idAnimal=" + idAnimal +
                ", espece=" + espece +
                ", race='" + race + '\'' +
                ", anniversaire=" + anniversaire +
                ", poids=" + poids +
                ", comportement=" + comportement +
                ", physiologique=" + physiologique +
                ", machine='" + machine + '\'' +
                ", nom='" + nom + '\'' +
                ", photo='" + photo + '\'' +
                ", ration=" + ration +
                ", k1=" + k1 +
                ", user=" + user +
                ", kcalCroquettes=" + kcalCroquettes +
                ", nbRepas=" + nbRepas +
                '}';
    }

    /**
     * @return
     * Retourne le nombre de repas journalier de l'animal
     */
    public int getNbRepas()
    {
        return nbRepas;
    }

    /**
     * Definie le nombre de repas journaliers
     * @param nbRepas
     * Nombre de repas journalier
     */
    public void setNbRepas(int nbRepas)
    {
        this.nbRepas = nbRepas;
    }

    /**
     * Retourne l'utilisateur associe a l'animal
     * @return
     */
    public User getUser()
    {
        return user;
    }

    /**
     * Definit l'utilisateur associe a l'animal
     * @param user
     * Utilisateur associe a l'animal
     * @see User
     */
    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * Retourne les calories des croquettes
     * @return
     */
    public double getKcalCroquettes()
    {
        return kcalCroquettes;
    }

    /**
     * Definit les calories des croquettes
     * @param kcalCroquettes
     * Calories des croquettes
     */
    public void setKcalCroquettes(double kcalCroquettes)
    {
        this.kcalCroquettes = kcalCroquettes;
    }

    /**
     * Retourne le coefficient lie a la race de l'animal
     * @return
     * @see Race
     */
    public Race getK1()
    {
        return k1;
    }

    /**
     * Definit le coefficient de race de l'animal
     * @param k1
     * @see Race
     */
    public void setK1(Race k1)
    {
        this.k1 = k1;
    }

    /**
     * Retourne la ration journaliere en gramme
     * @return
     */
    public double getRation()
    {
        return ration;
    }

    /**
     * Definit la ration journaliere
     * @param ration
     * Ration journaliere en gramme
     */
    public void setRation(double ration)
    {
        this.ration = ration;
    }

    /**
     * Definit la cle primaire de l'animal dans la base de donnee
     * @param idAnimal
     */
    public void setIdAnimal(Integer idAnimal)
    {
        this.idAnimal = idAnimal;
    }

    /**
     * Retourne le nom de l'animal
     * @return
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Definit le nom de l'animal
     * @param nom
     * Nom de l'animal
     */
    public void setNom(String nom)
    {
        this.nom = nom;
    }

    /**
     * Recupere la photo de l'animal
     * @return
     */
    public String getPhoto()
    {
        return photo;
    }

    /**
     * Defini la photo de l'animal.
     * @param photo
     */
    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    /**
     * Definit la photo de l'animal a null lorsqu'aucune photo n'est precise
     */
    public void setPhoto()
    {
        photo = null;
    }

    /**
     * Retourne la machine associe a l'animal
     * @return
     */
    public String getMachine()
    {
        return machine;
    }

    /**
     * Definit la machine associe a l'animal
     * @param machine
     */
    public void setMachine(String machine)
    {
        this.machine = machine;
    }

    /**
     * Retourne l'espece de l'animal
     * @return
     * @see Espece
     */
    public Espece getEspece()
    {
        return espece;
    }

    /**
     * Definit l'espece de l'animal
     * @param espece
     * @see Espece
     */
    public void setEspece(Espece espece)
    {
        this.espece = espece;
    }

    /**
     * Retourne la race l'animal
     * @return
     * Chien ou chat
     */
    public String getRace()
    {
        return race;
    }

    /**
     * Definit la race de l'animal
     * @param race
     */
    public void setRace(String race)
    {
        this.race = race;
    }

    /**
     * Retourne la date de naissance de l'animal
     * @return
     * @see LocalDate
     */
    public LocalDate getAnniversaire()
    {
        return anniversaire;
    }

    /**
     * Definit la date de naissance de l'animal
     * @param anniversaire
     * @see LocalDate
     */
    public void setAnniversaire(LocalDate anniversaire)
    {
        this.anniversaire = anniversaire;
    }

    /**
     * Retourne le poids de l'animal
     * @return
     */
    public double getPoids()
    {
        return poids;
    }

    /**
     * Definit le poids de l'animal
     * @param poids
     */
    public void setPoids(double poids)
    {
        this.poids = poids;
    }

    /**
     * Retourne le Comportement de l'animal
     * @return
     * @see Comportement
     */
    public Comportement getComportement()
    {
        return comportement;
    }

    /**
     * Definit le comportement de l'animal
     * @param comportement
     * @see Comportement
     */
    public void setComportement(Comportement comportement)
    {
        this.comportement = comportement;
    }

    /**
     * Retourne la physiologie de l'animal
     * @return
     * @see Physiologie
     */
    public Physiologie getPhysiologique()
    {
        return physiologique;
    }

    /**
     * Retourne la cle primaire de l'animal dans la base de donnees
     * @return
     */
    public Integer getIdAnimal()
    {
        return idAnimal;
    }

    /**
     * Definit la Physiologie de l'animal
     * @param physiologique
     * @see Physiologie
     */
    public void setPhysiologique(Physiologie physiologique)
    {
        this.physiologique = physiologique;
    }

    /**
     * Constructeur
     */
    public Animal()
    {
    }

    /**
     * Creation d'un animal avec tout les parametres
     * @param idAnimal
     * @param espece
     * @param race
     * @param anniversaire
     * @param poids
     * @param comportement
     * @param physiologique
     * @param machine
     * @param nom
     * @param photo
     * @param ration
     * @param k1
     * @param user
     * @param kcalCroquettes
     * @param nbRepas
     */
    public Animal(Integer idAnimal, Espece espece, String race, LocalDate anniversaire, double poids, Comportement comportement, Physiologie physiologique, String machine, String nom, String photo, double ration, Race k1, User user, double kcalCroquettes, int nbRepas)
    {
        this.idAnimal = idAnimal;
        this.espece = espece;
        this.race = race;
        this.anniversaire = anniversaire;
        this.poids = poids;
        this.comportement = comportement;
        this.physiologique = physiologique;
        this.machine = machine;
        this.nom = nom;
        this.photo = photo;
        this.ration = ration;
        this.k1 = k1;
        this.user = user;
        this.kcalCroquettes = kcalCroquettes;
        this.nbRepas = nbRepas;
    }
}
