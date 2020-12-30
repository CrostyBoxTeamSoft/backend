package application.dao;

import application.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>
{
    public List<User> findAll();
    public User findById(int id);
    public User save(User user);

    public User findByEmail(String email);

    public User findByPseudo(String pseudo);
}
