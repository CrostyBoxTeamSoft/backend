package application.beans;

import application.enums.Comportement;
import application.enums.Physiologie;
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
    private String espece;
    private String race;    //Chat ou chien
    private DateTime anniversaire;
    private double poids;
    private Comportement comportement;
    private Physiologie physiologique;
    private String machine;

    @Override
    public String toString()
    {
        return "Animal{" +
                "idAnimal=" + idAnimal +
                ", espece='" + espece + '\'' +
                ", race='" + race + '\'' +
                ", anniversaire=" + anniversaire +
                ", poids=" + poids +
                ", comportement=" + comportement +
                ", physiologique=" + physiologique +
                ", machine='" + machine + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Double.compare(animal.poids, poids) == 0 &&
                Objects.equals(idAnimal, animal.idAnimal) &&
                Objects.equals(espece, animal.espece) &&
                Objects.equals(race, animal.race) &&
                Objects.equals(anniversaire, animal.anniversaire) &&
                comportement == animal.comportement &&
                physiologique == animal.physiologique &&
                Objects.equals(machine, animal.machine);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idAnimal, espece, race, anniversaire, poids, comportement, physiologique, machine);
    }

    public String getMachine()
    {
        return machine;
    }

    public void setMachine(String machine)
    {
        this.machine = machine;
    }

    public String getEspece()
    {
        return espece;
    }

    public void setEspece(String espece)
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
