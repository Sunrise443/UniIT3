package lab4.logi;

public class CustomEmptyStackException extends RuntimeException {
    
    public CustomEmptyStackException () {
        super("Error: the stack is empty.");
        System.out.println("Error: the stack is empty.");
    }
}
