package exceptions;

public class InvalidSurnameFormatException extends Exception{
    public InvalidSurnameFormatException(String message){
        super(message);
    }
}
