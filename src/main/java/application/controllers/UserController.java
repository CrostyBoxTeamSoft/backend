package application.controllers;

import application.dao.UserDAO;
import application.request.InscriptionParameters;
import application.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path="/user")
public class UserController
{
    /*
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
        System.out.println("GET all user");
        return userRepository.findAll();
    }

    @GetMapping(path = "/testget")
    public String testGet()
    {
        System.out.println("Test GET");
        return "Just made a GET request";
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable int id)
    {

        System.out.println("DELETE a user");

        if (!userRepository.existsById(id))
        {
            return "User doesn't exist";
        }

        userRepository.deleteById(id);
        return "User has been deleted";
    }

    @PatchMapping(path = "/update/email/{id}")
    public String updateEmail(@PathVariable int id, @RequestBody UpdateUserInfo updateUserInfo)
    {
        return updateUserInfo.updateEmail(userRepository, id);
    }

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable int id)
    {
        if (userRepository.findById(id).isPresent())
        {
            return userRepository.findById(id).get();
        }

        return null;
    }

    @PatchMapping(path = "/update/password/{id}")
    public String updatePassword(@PathVariable int id, @RequestBody UpdateUserInfo updateUserInfo)
    {
        return updateUserInfo.updatePassword(userRepository, id);
    }

    */

    @Autowired
    private UserDAO userDAO;

    @GetMapping(path = "/all")
    public List<User> listeUser()
    {
        return userDAO.findAll();
    }

    @GetMapping(path = "/{id}")
    public User userById(@PathVariable int id)
    {
        return userDAO.findById(id);
    }

    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody InscriptionParameters inscriptionParameters)
    {
        User user = inscriptionParameters.createUser(userDAO);

        if (user!=null)
        {
            URI location =
                    ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getIdUser()).toUri();

            return ResponseEntity.created(location).build();
        }

        return ResponseEntity.noContent().build();
    }

}