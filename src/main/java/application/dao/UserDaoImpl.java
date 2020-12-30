package application.dao;


import application.beans.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDAO
{
    public static List<User> users = new ArrayList<>();
    static {
        users.add(new User(20, "a pseudo", "psw", "ma@maa.com", null, "Profil pic"));
        users.add(new User(21, "a 2nd pseudo", "psw", "ma1@maa.com", null, "Profil pic"));
        users.add(new User(22, "a 3rd pseudo", "psw", "ma2@maa.com", null, "Profil pic"));
        users.add(new User(23, "a 4th pseudo", "psw", "ma3@maa.com", null, "Profil pic"));
    }

    @Override
    public List<User> findAll()
    {
        return users;
    }

    @Override
    public User findById(int id)
    {
        for(User user : users)
        {
            if (user.getIdUser()==id)
            {
                return user;
            }
        }

        return null;
    }

    @Override
    public User save(User user)
    {
        users.add(user);
        return user;
    }

    @Override
    public User findByEmail(String email)
    {
        for(User user : users)
        {
            if (user.getEmail().equals(email))
            {
                return user;
            }
        }

        return null;
    }

    @Override
    public User findByPseudo(String pseudo)
    {
        for(User user : users)
        {
            if (user.getPseudo().equals(pseudo))
            {
                return user;
            }
        }

        return null;
    }
}
