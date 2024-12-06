package ex3;

import java.util.ArrayList;

public class ProductsLoad {
    private int loadWeight=0;
    private ArrayList<Integer> load = new ArrayList<>();

    public synchronized void increment(int element) {
        if (element!=-1) {
            load.add(element);
            loadWeight += element;
        } else {
            load.clear();
            loadWeight=0;
        }
    }

    public synchronized ArrayList<Integer> getLoad() {
        return new ArrayList<>(load);
    }

    public synchronized int getLoadWeight() {
        return loadWeight;
    }
}
