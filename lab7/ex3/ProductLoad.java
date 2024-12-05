package ex3;

public class ProductLoad {
    private int loadWeight;

    public synchronized void increment(int element) {
        if (loadWeight+element > 150) {
            
        }
        loadWeight += element
    }
}
