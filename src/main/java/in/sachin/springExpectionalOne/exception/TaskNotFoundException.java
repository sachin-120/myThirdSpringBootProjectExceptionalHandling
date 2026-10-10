package in.sachin.springExpectionalOne.exception;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String message){
        super(message);
    }

}
