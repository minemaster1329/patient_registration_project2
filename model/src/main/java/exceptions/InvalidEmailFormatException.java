package exceptions;

/**
 * Exception for invalid email
 */
public class InvalidEmailFormatException extends Exception {
    /**
     * parametrized constructor for exception
     * @param error_message exception message1
     */
    public InvalidEmailFormatException(String error_message){
        super(error_message);
    }
}
