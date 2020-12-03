package application.repositories;

import application.beans.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>
{
    List<User> findByPseudo(String pseudo);
    List<User> findByEmail(String email);
    boolean existsByPseudo(String pseudo);
    boolean existsByEmail(String email);
}
