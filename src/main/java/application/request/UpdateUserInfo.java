package application.request;

import application.beans.User;
import application.repositories.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;

public class UpdateUserInfo
{
    private String oldInfo;
    private String newInfo;

    public static final String OLDEMAILNOK = "Old email is wrong";
    public static final String NEWEMAILNOK = "Email is already taken";
    public static final String PASSWORDNOK = "Old password is wrong";
    public static final String USERNOK = "User doesn't exist";
    public static final String EMAILOK = "Email has been updated";
    public static final String PASSWORDOK = "Password has been updated";
    public static final String NEWEMAILFORMATNOK = "Please enter a valid email";
    public static final String SAMEEMAIL = "Old and new emails can't be the same";

    public String getOldInfo()
    {
        return oldInfo;
    }

    public void setOldInfo(String oldInfo)
    {
        this.oldInfo = oldInfo;
    }

    public String getNewInfo()
    {
        return newInfo;
    }

    public void setNewInfo(String newInfo)
    {
        this.newInfo = newInfo;
    }

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
