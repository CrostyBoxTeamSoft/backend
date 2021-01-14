package application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class PasswordMismatchedException extends RuntimeException
{
    public PasswordMismatchedException()
    {
        super("Passwords don't match");
    }
}
