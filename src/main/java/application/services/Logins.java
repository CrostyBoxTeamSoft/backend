package application.services;

import application.beans.User;
import application.dao.UserDAO;

public class Logins {

    private String pseudo;
    private String mdp;

    @Override
    public String toString() {
        return "Logins{" +
                "pseudo='" + pseudo + '\'' +
                ", mdp='" + mdp + '\'' +
                '}';
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public boolean ifExists(UserDAO userDAO)
    {
        if(userDAO.existsByPseudo(pseudo))
        {
            User user = userDAO.findByPseudo(pseudo);
            if (user.getPassword().equals(mdp))
            {
                return true;
            }
        }

        return false;
    }
}
