package application.dao;

import application.beans.Animal;
import application.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface permettant de realiser des operations sur la table Animal dans mySQL
 */
@Repository
public interface AnimalDAO extends JpaRepository<Animal, Integer>
{
    /**
     * @return
     * Retourne tout les animaux enregistres dans la base de donnees
     */
    public List<Animal> findAll();

    /**
     * @param id
     * Cle primaire de l'animal dans la base de donnees
     * @return
     * Retourne l'animal dont la cle primaire correspond a "id"
     */
    public Animal findById(int id);

    /**
     * @param animal
     * @return
     * Enregistre animal dans la base de donnees
     */
    public Animal save(Animal animal);

    /**
     * @param user
     * @return
     * Retourne la liste des animaux ayant pour proprietaire "user"
     */
    public List<Animal> findByUser(User user);

    /**
     * @param id
     * Cle primaire de l'animal a supprimer
     */
    public void deleteById(int id);

    /**
     * @param id
     * Cle primaire de l'animal
     * @return
     * true si l'animal existe, false sinon
     */
    public boolean existsById(int id);
}
