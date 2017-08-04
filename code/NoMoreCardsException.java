package code;

/**
 * Created by Artur Komendatskyi on 2017-08-04.
 */
public class NoMoreCardsException extends Exception {

    public NoMoreCardsException() {super();}

    public NoMoreCardsException(String message) {super(message);};

    public NoMoreCardsException(String message, Throwable cause) {super(message, cause);};

    public NoMoreCardsException(Throwable cause) {super(cause);};
}
