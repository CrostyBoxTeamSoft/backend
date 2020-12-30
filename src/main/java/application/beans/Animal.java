package application.beans;

import application.calculator.Calculator;
import application.enums.Comportement;
import application.enums.Espece;
import application.enums.Physiologie;
import application.enums.Race;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Entity
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAnimal;
    private Espece espece;
    private String race;    //Chat ou chien
    private LocalDate anniversaire;
    private double poids;
    private Comportement comportement;
    private Physiologie physiologique;
    private String machine;
    private String nom;
    private String photo;
    private double ration;
    private Race k1;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fk_idUser")
    private User user;
    @Transient
    private double kcalCroquettes;
    private int nbRepas;

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

    public int getNbRepas()
    {
        return nbRepas;
    }

    public void setNbRepas(int nbRepas)
    {
        this.nbRepas = nbRepas;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public double getKcalCroquettes()
    {
        return kcalCroquettes;
    }

    public void setKcalCroquettes(double kcalCroquettes)
    {
        this.kcalCroquettes = kcalCroquettes;
    }

    public Race getK1()
    {
        return k1;
    }

    public void setK1(Race k1)
    {
        this.k1 = k1;
    }

    public double getRation()
    {
        return ration;
    }

    public void setRation(double ration)
    {
        this.ration = ration;
    }

    public void setIdAnimal(Integer idAnimal)
    {
        this.idAnimal = idAnimal;
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
        if (photo != null)
        {
            this.photo = photo;
        }

        else
        {
            setPhoto();
        }
    }

    public void setPhoto()
    {
        photo = null;
    }

    public String getMachine()
    {
        return machine;
    }

    public void setMachine(String machine)
    {
        this.machine = machine;
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

    public Integer getIdAnimal()
    {
        return idAnimal;
    }

    public void setPhysiologique(Physiologie physiologique)
    {
        this.physiologique = physiologique;
    }

    public Animal()
    {
    }
}
