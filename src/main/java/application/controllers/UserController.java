package application.controllers;

import application.request.InscriptionParameters;
import application.repositories.UserRepository;
import application.beans.User;
import application.request.UpdateUserInfo;
import application.responses.UserResponse;
import org.hibernate.sql.Update;
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
    public String updateEmail(@PathVariable int id, @RequestBody UpdateUserInfo updateUserInfo)
    {
        return updateUserInfo.updateEmail(userRepository, id);
    }

    /*  FOR TEST    */
    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable int id)
    {
        if (userRepository.findById(id).isPresent())
        {
            return userRepository.findById(id).get();
        }

        return null;
    }

    /*  A TESTER    */
    @PatchMapping(path = "/update/password/{id}")
    public String updatePassword(@PathVariable int id, @RequestBody UpdateUserInfo updateUserInfo)
    {
        return updateUserInfo.updatePassword(userRepository, id);
    }



}