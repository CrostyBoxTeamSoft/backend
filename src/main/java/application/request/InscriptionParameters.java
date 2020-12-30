package application.request;


import application.beans.User;
import application.dao.UserDAO;
import org.apache.commons.validator.routines.EmailValidator;

public class InscriptionParameters
{
    private String pseudo, mdp, confirmer, email;

    public String getPseudo()
    {
        return pseudo;
    }

    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }

    public String getMdp()
    {
        return mdp;
    }

    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }

    public String getConfirmer()
    {
        return confirmer;
    }

    public void setConfirmer(String confirmer)
    {
        this.confirmer = confirmer;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    private boolean checkEmail(UserDAO userDAO)
    {
        EmailValidator validator = EmailValidator.getInstance();

        boolean emailValid = validator.isValid(getEmail());

        if (emailValid)
        {
            return userDAO.findByEmail(getEmail())==null;
        }

        return false;
    }

    private boolean checkPseudo(UserDAO userDAO)
    {
        User userAlreadyExist = userDAO.findByPseudo(getPseudo());

        return userAlreadyExist == null;

    }

    private boolean checkMDP()
    {
        return getMdp().matches(getConfirmer());
    }

    private boolean checkUser(UserDAO userDAO)
    {
         return (checkEmail(userDAO) && checkMDP() && checkPseudo(userDAO));
    }

    @Override
    public String toString()
    {
        return "InscriptionParameters{" +
                "pseudo='" + pseudo + '\'' +
                ", mdp='" + mdp + '\'' +
                ", confirmer='" + confirmer + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User createUser(UserDAO userDAO)
    {

        if (checkUser(userDAO))
        {
            User user = new User();

            user.setPassword(getMdp());
            user.setEmail(getEmail());
            user.setPseudo(getPseudo());

            userDAO.save(user);


            return user;
        }


        return null;
    }

}
