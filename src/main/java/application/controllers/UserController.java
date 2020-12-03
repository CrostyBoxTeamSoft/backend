package application.controllers;

import application.beans.InscriptionParameters;
import application.repositories.UserRepository;
import application.beans.User;
import application.responses.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/add")
    public UserResponse inscription(@RequestBody InscriptionParameters inscriptionParameters)
    {
        System.out.println("POST");
        UserResponse userResponse = new UserResponse();

        userResponse.saveUser(userRepository, inscriptionParameters);

        return userResponse;
    }

    @GetMapping(path="/all")
    public Iterable<User> getAll()
    {
        System.out.println("GET");
        return userRepository.findAll();
    }


    /*  A TESTER    */
    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable int id)
    {

        if (!userRepository.existsById(id))
        {
            return "User doesn't exist";
        }

        userRepository.deleteById(id);
        return "User "+" has been deleted";
    }

    /*  A TESTER    */
    @PatchMapping(path = "/update/email/{id}")
    public String updateEmail(@PathVariable int id, @RequestBody String oldEmail, String newEmail)
    {
        if (!userRepository.existsById(id))
        {
            return "User doesn't exist";
        }

        else
        {
            User user = userRepository.findById(id).get();
            if (user.getEmail().matches(oldEmail))
            {
                user.setEmail(newEmail);
                userRepository.save(user);

                return "User updated";
            }

            return "No user found with this email";
        }

    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable int id)
    {
        if (userRepository.existsById(id))
        {
            System.out.println("Prout");

            return userRepository.findById(id).get();
        }

        return null;
    }



}
/*
@Controller // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    User inscription (@RequestParam String pseudo,@RequestParam String mdp,@RequestParam String confirmer,
                         @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setPseudo(pseudo);
        n.setEmail(email);
        n.setPassword(mdp);
        userRepository.save(n);
        System.out.println("Posted");
        return n;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        System.out.println("Get OK");
        return userRepository.findAll();
    }
}*/
