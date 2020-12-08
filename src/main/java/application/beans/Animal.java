package application.beans;

import application.enums.Comportement;
import application.enums.Espece;
import application.enums.Physiologie;
import application.enums.Race;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAnimal;
    private Espece espece;
    private String race;    //Chat ou chien
    private DateTime anniversaire;
    private double poids;
    private Comportement comportement;
    private Physiologie physiologique;
    private String machine;
    private String nom;
    private String photo;
    private double ration;
    private Race k1;

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
                '}';
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
        this.photo = photo;
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
