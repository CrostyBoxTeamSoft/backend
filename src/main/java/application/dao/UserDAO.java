package application.dao;

import application.beans.User;

import java.util.Collection;
import java.util.List;

public interface UserDAO
{
    public List<User> findAll();
    public User findById(int id);
    public User save(User user);

    public User findByEmail(String email);

    public User findByPseudo(String pseudo);
}
