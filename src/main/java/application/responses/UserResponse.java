package application.responses;

import application.beans.InscriptionParameters;
import application.beans.User;
import application.repositories.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.ArrayList;
import java.util.List;

public class UserResponse
{
    public static final String PSEUDOERROR = "The pseudo is already taken";
    public static final String MDPERROR = "Passwords don't match";
    public static final String EMAILTAKEN = "This email is already taken";
    public static final String EMAILERROR = "Please enter a valid email";

    private boolean saveUser;
    private boolean pseudoOk;
    private boolean mdpMatche;
    private boolean emailOk;
    private ArrayList<Object> errorMessages = new ArrayList<>();

    private User user = new User();

    public static String getPSEUDOERROR()
    {
        return PSEUDOERROR;
    }

    public static String getMDPERROR()
    {
        return MDPERROR;
    }

    public static String getEMAILTAKEN()
    {
        return EMAILTAKEN;
    }

    public static String getEMAILERROR()
    {
        return EMAILERROR;
    }

    public ArrayList<Object> getErrorMessages()
    {
        return errorMessages;
    }

    public void setErrorMessages(ArrayList<Object> errorMessages)
    {
        this.errorMessages = errorMessages;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    /*  OK  */
    private void processUser(UserRepository userRepository, InscriptionParameters inscriptionParameters)
    {
        System.out.println("Process User");
        checkEmail(userRepository, inscriptionParameters);
        checkMDP(inscriptionParameters);
        checkPseudo(userRepository, inscriptionParameters);
        setSaveUser(errorMessages.isEmpty());
    }

    /*  Checking if pseudo is already taken or not  */
    private boolean isPseudoOk()
    {
        return pseudoOk;  //True = Pseudo available       False = Pseudo taken
    }

    /*  OK  */
    private void checkPseudo(UserRepository userRepository, InscriptionParameters inscriptionParameters)
    {
        System.out.println("Check Pseudo");
        List<User> userAlreadyExist = userRepository.findByPseudo(inscriptionParameters.getPseudo());

        boolean checkPseudo = userAlreadyExist.isEmpty();

        setPseudoOk(checkPseudo);

        if (!checkPseudo)
        {
            errorMessages.add(PSEUDOERROR);
        }

    }

    /*  OK  */
    private void setPseudoOk(boolean pseudoOk)
    {
        this.pseudoOk = pseudoOk;
    }

    /*  OK  */
    private boolean isMdpMatche()
    {
        return mdpMatche;
    }

    /*  Check if mdp and confirmer is the same  */
    private void checkMDP(InscriptionParameters inscriptionParameters)
    {
        System.out.println("Check MDP");
        boolean checkMDP = inscriptionParameters.getMdp().matches(inscriptionParameters.getConfirmer());
        setMdpMatche(checkMDP);

        if (!checkMDP)
        {
            errorMessages.add(MDPERROR);
        }

    }

    /*  OK  */
    private void setMdpMatche(boolean mdpMatche)
    {
        this.mdpMatche = mdpMatche;
    }

    /*  OK  */
    private boolean isEmailOk()
    {
        return emailOk;
    }

    /*  Check if the email is a valid one or not  */
    private void checkEmail(UserRepository userRepository, InscriptionParameters inscriptionParameters)
    {
        System.out.println("Check Email");
        EmailValidator validator = EmailValidator.getInstance();

        boolean emailValid = validator.isValid(inscriptionParameters.getEmail());

        if (emailValid)
        {
          if(!userRepository.findByEmail(inscriptionParameters.getEmail()).isEmpty())
          {
              setEmailOk(false);
              errorMessages.add(EMAILTAKEN);
          }

          setEmailOk(true);
        }
        else
        {
            setEmailOk(false);
            errorMessages.add(EMAILERROR);
        }
    }

    /*  OK  */
    private void setEmailOk(boolean emailOk)
    {
        this.emailOk = emailOk;
    }

    /*  Useless  */
    private void setSaveUser(boolean saveUser)
    {
        this.saveUser = saveUser;
    }

    public void saveUser(UserRepository userRepository, InscriptionParameters inscriptionParameters)
    {
        processUser(userRepository, inscriptionParameters);
        System.out.println("saveuser = "+saveUser);
        if (saveUser)
        {
            System.out.println("Pseudo");
            user.setPseudo(inscriptionParameters.getPseudo());

            System.out.println("MDP");
            user.setPassword(inscriptionParameters.getMdp());

            System.out.println("Email");
            user.setEmail(inscriptionParameters.getEmail());

            userRepository.save(user);
        }
    }
}
