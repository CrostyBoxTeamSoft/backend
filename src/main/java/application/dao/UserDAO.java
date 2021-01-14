package application.dao;

import application.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface permettant de realiser des operations sur la table User dans mySQL
 */
@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
    /**
     * Retourne la liste des utilisateurs dans la table User
     * @return
     */
    public List<User> findAll();

    /**
     * Retourne l'utilisateur ayant pour cle primaire "id"
     * @param id
     * la cle primaire de l'utilisateur a cherche
     * @return
     * L'utilisateur ayant pour cle primaire "id"
     */
    public User findById(int id);

    /**
     * Enregistre l'utilisateur dans la base de donnees
     * @param user
     * l'utilisateur a sauvegarde
     * @return
     */
    public User save(User user);

    /**
     * Retourne l'utilisateur ayant pour Mail "email"
     * @param email
     * l'email de l'utilisateur a cherche
     * @return
     */
    public User findByEmail(String email);

    /**
     * Retourne l'utilisateur ayant pour pseudo "pseudo"
     * @param pseudo
     * le pseudo de l'utilisateur a cherche
     * @return
     */
    public User findByPseudo(String pseudo);
}
