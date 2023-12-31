package exceptions;

public class InvalidVotingOptionException extends Exception{
    public InvalidVotingOptionException(String message){
        super(message);
    }
}
