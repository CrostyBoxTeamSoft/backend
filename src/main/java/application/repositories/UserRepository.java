package application.repositories;

import application.beans.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Permet de faire des operations sur la table User de la base de donnees
 * @deprecated
 */
public interface UserRepository extends CrudRepository<User, Integer>
{
    List<User> findByPseudo(String pseudo);
    List<User> findByEmail(String email);
    boolean existsByPseudo(String pseudo);
    boolean existsByEmail(String email);
}
