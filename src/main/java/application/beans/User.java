package application.beans;

import application.repositories.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;

    @Column(unique = true)
    private String pseudo;

    private String password;

    @Column(unique = true)
    private String email;

    private ArrayList<Animal> animals;

    public ArrayList<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals)
    {
        this.animals = animals;
    }



    @Override
    public String toString()
    {
        return "User{" +
                "idUser=" + idUser +
                ", pseudo='" + pseudo + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", animals=" + animals +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(idUser, user.idUser) &&
                Objects.equals(pseudo, user.pseudo) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(animals, user.animals);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(idUser, pseudo, password, email, animals);
    }

    public User()
    {
    }

    public Integer getIdUser()
    {
        return idUser;
    }

    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
    }

    public String getPseudo()
    {
        return pseudo;
    }

    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void addAnimal(Animal animal)
    {
        animals.add(animal);
    }

    public void removeAnimal(Animal animal)
    {
        animals.remove(animal);
    }

    public void removeAnimal(int id)
    {
        Animal toDelete = findById(id);

        if (toDelete != null)
        {
            removeAnimal(toDelete);
        }
    }

    public Animal findById(int id)
    {
        for (Animal animal : animals)
        {
            if (id == animal.getIdAnimal())
            {
                return animal;
            }
        }

        return null;
    }

}
