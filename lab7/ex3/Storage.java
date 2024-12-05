package ex3;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Integer> products = new ArrayList<>();

    public synchronized void increment(ArrayList<Integer> elements) {
        for (int i=0; i<elements.size(); i++) {
            products.add(elements.get(i));
        }
    }

    public ArrayList<Integer> getAllStoredItems() {
        return products;
    }
}
