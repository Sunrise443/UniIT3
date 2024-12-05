package ex1;

public class ArrSum {
    private int sum;
    
    public synchronized void increment(int element) {
        sum += element;
    }

    public int getSum() {
        return sum;
    }
}
