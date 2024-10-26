package lab4.logi;

public class Main {
    public static void main(String[] args) {
        try {
            CustomStack firstStack = new CustomStack(10);
            firstStack.put(19);
            firstStack.put(20);
            firstStack.put(21);
            firstStack.get();

            firstStack.del();
            firstStack.del();
            firstStack.del();
            firstStack.del();
        } catch (Exception e) {
            System.out.println("The error was added to log.");
        }
    }
}
