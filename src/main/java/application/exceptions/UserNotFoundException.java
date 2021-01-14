package application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception lorsqu'un utilisateur n'a pas pu etre trouve. Renverra le code HTTP : 404 not found
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException
{
    /**
     * Constructeur
     * @param idNotFound
     * L'id de l'utilisateur qui n'a pas pu etre trouve
     */
    public UserNotFoundException(int idNotFound)
    {
        super("User with id "+idNotFound+" could not be found");
    }
}
