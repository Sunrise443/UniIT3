package lab4.logi;

public class CustomEmptyStackException extends RuntimeException {
    
    public CustomEmptyStackException () {
        System.out.println("Error: the stack is empty.");
    }
}
