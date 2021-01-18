package application.controllers;

import application.beans.Arduino;
import application.dao.ArduinoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path="/arduino")
public class ArduinoController
{
    @Autowired
    private ArduinoDAO arduinoDAO;
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

    @PostMapping(path = "/")
    public void createArduino(@RequestBody Map<String, Object> arduino)
    {
        System.out.println(arduino);
        //Recoit adresse MAC et IP d'arduino
    }


}
