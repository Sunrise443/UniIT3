package lab4.logi;

import java.util.*;

public class CustomStack {
    private final ArrayList<Integer> stack;
    private int top;
    private final int capacity;

    LoggerFile logger;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        this.stack = new ArrayList<>(capacity);
        top = -1;

        this.logger = new LoggerFile();
    }

    public void put (int value) {
        if (top == capacity-1) {
            logger.log("Full stack error");
            throw new StackOverflowError("Error: the stack is full.");
        }
        stack.add(value);
        top++;
        System.out.println("The element has been added.");
    }

    //deletes the top element
    public void del() {
        if (stack.isEmpty()) {
            logger.log("Empty stack error");
            throw new CustomEmptyStackException();
        } else {
            stack.remove(top);
            System.out.println("The element has been deleted.");
            top--;
        }
    }
    
    public Integer get() {
        if (stack.isEmpty()) {
            logger.log("Empty stack error");
            throw new CustomEmptyStackException();
        } else {
            System.out.println(stack.get(top));
            return stack.get(top);
        }
    }

    public boolean isEmpty() {
        return top==-1;
    }
}
