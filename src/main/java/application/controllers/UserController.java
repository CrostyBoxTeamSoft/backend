package application.controllers;

import application.dao.UserDAO;
import application.exceptions.UserNotFoundException;
import application.request.InscriptionParameters;
import application.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Cette classe permet de gerer la reception de requetes HTTP. Elle est utilisee pour les requetes en lien avec la
 * creation, modification d'utilisateur
 */
@RestController
@RequestMapping(path="/user")
public class UserController
{
    /**
     * @see UserDAO
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Reception d'une requete GET demandant d'afficher la liste des utilisateurs dans la base de donnes ainsi que
     * leurs informations.
     * A utiliser uniquement pour des fins de test. Sera supprime pour l'application finale
     * @return  La liste des utilisateurs dans la base de donnees
     */
    @GetMapping(path = "/all")
    public List<User> listeUser()
    {
        return userDAO.findAll();
    }

    /**
     * Reception d'une requete GET demandant d'afficher un utilisateur en particulier
     * @param id
     * Cle primaire dans la base de donne de l'utilisateur dont on veut les informations
     * @return L'utilisateur ayant la cle primaire " id " dans la base de donnees
     * @throws UserNotFoundException
     * @see User
     */
    @GetMapping(path = "/{id}")
    public User userById(@PathVariable int id) throws UserNotFoundException
    {
        User user = userDAO.findById(id);

        if (user==null)
        {
            throw new UserNotFoundException(id);
        }

        return user;
    }

    /**
     * Reception d'une requête POST envoyant la liste des reseaux WiFi environnant
     * @param networks
     * La liste des reseaux WiFi environnant. Techniquement on peut envoyer n'importe quelle liste, mais ici ce n'est
     * pas le but
     */
    @PostMapping(path = "/network")
    public void networkList(@RequestBody Map<String, Object> networks)
    {
        System.out.println("*** Network list ***");
        System.out.println(networks);
    }

    /**
     * Reception d'une requete POST avec l'adresse MAC de la machine qui a effectue la requete. Dans notre cas c'est
     * l'adresse MAC de l'Arduino (qui équivaut a la Crosty Box)
     * @param arduinoMacAdress
     * Adresse MAC de l'arduino
     */
    @PostMapping(path = "/arduinomac")
    public void postPath(@PathVariable String arduinoMacAdress)
    {
        System.out.println("Mac adress arduino = "+arduinoMacAdress);
    }

    /**
     * Reception d'une requete POST pour inscrire un utilisateur  dans la base de donnes
     * @param inscriptionParameters
     * Les informations contenues dans le formulaire d'inscription
     * @return Une reponse HTTP en fonction de la reussite (201 Created) ou l'echec (204 No Content) de la creation de
     * compte.
     */
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody InscriptionParameters inscriptionParameters)
    {
        User user = inscriptionParameters.createUser(userDAO);

        if (user!=null)
        {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * Reception d'une requete GET afin de test la bonne connexion entre l'Arduino et le serveur. Uniquement utilise
     * a des fins de tests
     */
    @GetMapping(path = "/arduino")
    public void printArduino()
    {
        System.out.println("Get received from Arduino");
    }

    /**
     * Reception d'une requete afin de modifier l'adresse email
     */
    public void updateEmail()
    {

    }

}