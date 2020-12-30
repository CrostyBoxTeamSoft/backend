package application.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(value = {"password"})
@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    @Column(unique = true)
    private String pseudo;
    private String password;
    @Column(unique = true)
    @Email
    private String email;

    public User(Integer idUser, String pseudo, String password, String email, List<Animal> animals, String profilePic)
    {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.animals = animals;
        this.profilePic = profilePic;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Animal> animals;
    private String profilePic;

    public List<Animal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals)
    {
        this.animals = animals;
    }

    public String getProfilePic()
    {
        return profilePic;
    }

    public void setProfilePic(String profilePic)
    {
        this.profilePic = profilePic;
    }

    public void setProfilePic()
    {
        profilePic = null;
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
        Animal toDelete = findAnimalById(id);

        if (toDelete != null)
        {
            removeAnimal(toDelete);
        }
    }

    public Animal findAnimalById(int id)
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
