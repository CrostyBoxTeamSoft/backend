package application.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class representant un utilisateur de l'application dans la base de donnees
 */
@JsonIgnoreProperties(value = {"password"})
@Entity
public class User
{
    /**
     * Cle primaire de l'utilisateur dans la base de donnees, generee automatiquement
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    /**
     * Le pseudo de l'utilisateur, doit etre unique
     */
    @Column(unique = true)
    private String pseudo;

    /**
     * Le mot de passe de l'utilisateur, n'est pas affiche lors de l'envoie de requetes
     */
    private String password;

    /**
     * Email de l'utilisateur, doit etre unique
     */
    @Column(unique = true)
    @Email
    private String email;

    /**
     * Utilise pour la verification du mot de passe lors de la creation du compte ou pour un changement de mot de
     * passe. N'est pas enregistre dans la base de donnees
     */
    @Transient
    private String repeatPassword;

    /**
     * La liste des animaux que le user a enregistre dans l'application.
     * @see Animal
     */
    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Animal> animals;

    /**
     * Photo de l'utilisateur, optionel
     */
    private String profilePic;

    /**
     * Creation d'un utilisateur avec tout les parametres
     * @param idUser
     * @param pseudo
     * @param password
     * @param email
     * @param animals
     * @param profilePic
     */
    public User(Integer idUser, String pseudo, String password, String email, List<Animal> animals, String profilePic)
    {
        this.idUser = idUser;
        this.pseudo = pseudo;
        this.password = password;
        this.email = email;
        this.animals = animals;
        this.profilePic = profilePic;
    }

    /**
     * Retourne la liste des animaux que l'utilisateur a enregistre
     * @return
     * @see Animal
     */
    public List<Animal> getAnimals()
    {
        return animals;
    }

    /**
     * Definit la liste des animaux de l'utilisateur
     * @param animals
     * @see Animal
     */
    public void setAnimals(ArrayList<Animal> animals)
    {
        this.animals = animals;
    }

    /**
     * Retourne la photo de profil de l'utilisateur
     * @return
     */
    public String getProfilePic()
    {
        return profilePic;
    }

    /**
     * Definit la photo de profil de l'utilisateur
     * @param profilePic
     */
    public void setProfilePic(String profilePic)
    {
        this.profilePic = profilePic;
    }

    /**
     * Definit la photo de profil de l'utilisateur a null
     */
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

    /**
     * Constructeur sans argument
     */
    public User()
    {
    }

    /**
     * Retourne la cle primaire de l'utilisateur dans la base de donnees
     * @return
     */
    public Integer getIdUser()
    {
        return idUser;
    }

    /**
     * Definit la cle primaire de l'utilisateur dans la base de donnees
     * @param idUser
     */
    public void setIdUser(Integer idUser)
    {
        this.idUser = idUser;
    }

    /**
     * Retourne le pseudo de l'utilisateur
     * @return
     */
    public String getPseudo()
    {
        return pseudo;
    }

    /**
     * Definit le pseudo de l'utilisateur
     * @param pseudo
     */
    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }

    /**
     * Retourne le mot de passe de l'utilisateur
     * @return
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Definit le mot de passe de l'utilisateur
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * L'adresse mail de l'utilisateur
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Definir l'adresse mail de l'utilisateur
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Ajouter un animal a la liste des animaux
     * @param animal
     */
    public void addAnimal(Animal animal)
    {
        animals.add(animal);
    }

    /**
     * Supprime un animal de la liste des animaux
     * @param animal
     */
    public void removeAnimal(Animal animal)
    {
        animals.remove(animal);
    }

    /**
     * Supprime un animal de la liste des animaux
     * @param id
     */
    public void removeAnimal(int id)
    {
        Animal toDelete = findAnimalById(id);

        if (toDelete != null)
        {
            removeAnimal(toDelete);
        }
    }

    /**
     * Retourne un animal de la liste des animaux grace a son ID
     * @param id
     * @return
     * Un animal
     */
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
