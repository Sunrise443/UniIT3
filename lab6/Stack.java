package lab6;

public class Stack<T> {
    private final T[] data;
    private int size;

    public Stack (int capacity){
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public void push (T element) { // adding an element
        if (size == data.length) {
            throw new StackOverflowError("Error: the stack is full.");
        }
        data[size++] = element;
        System.out.println("The element has been added.");
    }

    public T pop() { //delete top element
        if (isEmpty()) {
            throw new IllegalStateException("Error: the stack is empty");
        } else {
            T element = data [--size];
            data[size] = null;
            System.out.println("The element has been deleted.");
            return element;
        }
    }

    public T peek() { //top element without deletion
        if (isEmpty()) {
            throw new IllegalStateException("Error: the stack is empty");
        } else {
            return data[size-1];
        }
    }

    public boolean isEmpty() {
        return size==0;
    }
}
