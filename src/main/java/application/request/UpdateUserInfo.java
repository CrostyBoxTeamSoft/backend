package application.request;

import application.beans.User;
import application.repositories.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;

/**
 * Representation du formulaire pour des changements de donnees pour un utilisateur
 */
public class UpdateUserInfo
{
    /**
     * Ancienne donnee
     */
    private String oldInfo;

    /**
     * Nouvelle donnee
     */
    private String newInfo;

    /**
     * Message d'erreur si l'ancien mail entree est errone
     */
    public static final String OLDEMAILNOK = "Old email is wrong";

    /**
     * Message d'erreur si le nouveau mail entree est deja pris
     */
    public static final String NEWEMAILNOK = "Email is already taken";

    /**
     * Message d'erreur si l'ancien mot de passe entree est errone
     */
    public static final String PASSWORDNOK = "Old password is wrong";

    /**
     * Message d'erreur si l'utilisateur que l'on souhaite modifie n'existe pas
     */
    public static final String USERNOK = "User doesn't exist";

    /**
     * Message de confirmation si l'email a ete mis a jour
     */
    public static final String EMAILOK = "Email has been updated";

    /**
     * Message de confirmation si le mot de passe a ete mis a jour
     */
    public static final String PASSWORDOK = "Password has been updated";

    /**
     * Message d'erreur si le format du nouveau mail est incorrect
     */
    public static final String NEWEMAILFORMATNOK = "Please enter a valid email";

    /**
     * Message d'erreur si l'ancien et le nouveau mails sont les memes.
     */
    public static final String SAMEEMAIL = "Old and new emails can't be the same";

    /**
     * Retourne l'ancienne donnee a modifie
     * @return
     */
    public String getOldInfo()
    {
        return oldInfo;
    }

    /**
     * Definit l'ancienne donnee a modifie
     * @param oldInfo
     */
    public void setOldInfo(String oldInfo)
    {
        this.oldInfo = oldInfo;
    }

    /**
     * Retourne la nouvelle donnee a inscrire
     * @return
     */
    public String getNewInfo()
    {
        return newInfo;
    }

    /**
     * Definit la nouvelle donnee a inscrire
     * @param newInfo
     */
    public void setNewInfo(String newInfo)
    {
        this.newInfo = newInfo;
    }

    /**
     * Mis a jour du mail
     * @param userRepository
     * Representation de la table User
     * @param id
     * Cle primaire de l'utilisateur a modifie
     * @return
     * Message d'erreur ou de confirmation
     */
    public String updateEmail(UserRepository userRepository, int id)
    {
        EmailValidator emailValidator = EmailValidator.getInstance();

        if (!emailValidator.isValid(newInfo))
        {
            return NEWEMAILFORMATNOK;
        }
        if (userRepository.findById(id).isPresent())
        {
            User user = userRepository.findById(id).get();

            if (user.getEmail().matches(oldInfo))
            {
                if (userRepository.findByEmail(newInfo).isEmpty())
                {
                    user.setEmail(newInfo);
                    userRepository.save(user);
                    return EMAILOK;
                }

                return NEWEMAILNOK;
            }

            return OLDEMAILNOK;

        }

        return USERNOK;
    }

    /**
     * Mis a jour du mot de passe
     * @param userRepository
     * Representation de la table User
     * @param id
     * Cle primaire de l'utilisateur a mettre a jour
     * @return
     * Message d'erreur ou de confirmation
     */
    public String updatePassword(UserRepository userRepository, int id)
    {
        if (userRepository.findById(id).isPresent())
        {
            User user = userRepository.findById(id).get();

            if (user.getPassword().matches(oldInfo))
            {
                user.setPassword(newInfo);
                userRepository.save(user);

                return PASSWORDOK;
            }

            return PASSWORDNOK;
        }

        return USERNOK;
    }
}
