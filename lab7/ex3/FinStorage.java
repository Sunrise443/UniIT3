package ex3;

import java.util.ArrayList;

public class FinStorage {
    private ArrayList<Integer> finStorage = new ArrayList<>();

    public synchronized void increment(ArrayList<Integer> load) {
        for (int element : load) {
            finStorage.add(element);
        }
    }

    public synchronized ArrayList<Integer> getFin() {
        return new ArrayList<>(finStorage);
    }
}
