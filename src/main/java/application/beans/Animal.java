package application.beans;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Animal
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAnimal;
    private String race;
    private String type;    //Chat ou chien
    private DateTime anniversaire;
    private double poids;
    private String comportement;
    private String physiologique;
    private String clinique;

    @Override
    public String toString()
    {
        return "Animal{" +
                "race='" + race + '\'' +
                ", type='" + type + '\'' +
                ", anniversaire=" + anniversaire +
                ", poids=" + poids +
                ", comportement='" + comportement + '\'' +
                ", physiologique='" + physiologique + '\'' +
                ", clinique='" + clinique + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.poids, poids) == 0 &&
                Objects.equals(race, animal.race) &&
                Objects.equals(type, animal.type) &&
                Objects.equals(anniversaire, animal.anniversaire) &&
                Objects.equals(comportement, animal.comportement) &&
                Objects.equals(physiologique, animal.physiologique) &&
                Objects.equals(clinique, animal.clinique);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(race, type, anniversaire, poids, comportement, physiologique, clinique);
    }

    public String getRace()
    {
        return race;
    }

    public void setRace(String race)
    {
        this.race = race;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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

    public String getComportement()
    {
        return comportement;
    }

    public void setComportement(String comportement)
    {
        this.comportement = comportement;
    }

    public String getPhysiologique()
    {
        return physiologique;
    }

    public void setPhysiologique(String physiologique)
    {
        this.physiologique = physiologique;
    }

    public String getClinique()
    {
        return clinique;
    }

    public void setClinique(String clinique)
    {
        this.clinique = clinique;
    }

    public Animal()
    {
    }
}
