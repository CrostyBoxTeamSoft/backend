package application.services;


import application.beans.User;
import application.dao.UserDAO;
import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.constraints.NotEmpty;

/**
 * Class representant les informations fournies dans le formulaire d'inscription lors de l'inscription d'un utilisateur
 */
public class InscriptionParameters
{
    /**
     * Le pseudo renseigne
     */
    @NotEmpty(message = "Please enter a pseudo")
    private String pseudo;

    /**
     * Le mot de passe renseigne
     */
    @NotEmpty(message = "Please enter a password")
    private String mdp;

    /**
     * Repeter le mot de passe pour la confirmation
     */
    @NotEmpty(message = "Please repeat the password")
    private String confirmer;

    /**
     * L'email renseigne
     */
    @NotEmpty(message = "Please enter an email")
    public String email;

    /**
     * Retourne le pseudo renseigne
     * @return
     */
    public String getPseudo()
    {
        return pseudo;
    }

    /**
     * Definit le pseudo
     * @param pseudo
     */
    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }

    /**
     * Retourne le mot de passe
     * @return
     */
    public String getMdp()
    {
        return mdp;
    }

    /**
     * Definit le mot de passe
     * @param mdp
     */
    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }

    /**
     * Retourne la confirmation du mot de passe
     * @return
     */
    public String getConfirmer()
    {
        return confirmer;
    }

    /**
     * Definit la confirmation du mot de passe
     * @param confirmer
     */
    public void setConfirmer(String confirmer)
    {
        this.confirmer = confirmer;
    }

    /**
     * Retourne l'email
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Definit l'email
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Permet de verifier si l'email est valide ou non
     * @param userDAO
     * representation de la table User
     * @return true si email valide, false sinon
     */
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

    /**
     * Verifie la disponibilite du pseudo
     * @param userDAO
     * representation de la table User
     * @return
     * true si pseudo disponible, false sinon
     */
    private boolean checkPseudo(UserDAO userDAO)
    {
        User userAlreadyExist = userDAO.findByPseudo(getPseudo());

        return userAlreadyExist == null;

    }

    /**
     * Verifie si le mot de passe et la confirmation du mot de passe correspondent
     * @return
     * true si ils correspondent, false sinon
     */
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

    /**
     * Creation d'un utilisateur si tout les parametres sont bons
     * @param userDAO
     * representation de la table User
     * @return
     */
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

   /* public ResponseEntity<User> createUser(UserDAO userDAO)
    {
        if (checkUser(userDAO))
        {
            User user = new User();

            user.setPassword(getMdp());
            user.setEmail(getEmail());
            user.setPseudo(getPseudo());

            userDAO.save(user);


            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

        if (!checkPseudo(userDAO))
            return new ResponseEntity<>(null, HttpStatus.IM_USED);

        if (!checkMDP())
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

        return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);

    }*/

}
