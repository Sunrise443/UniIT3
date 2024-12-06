package ex3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        ProductLoad productLoad = new ProductLoad();
        WorkerThread worker1 = new WorkerThread(storage, productLoad);
        WorkerThread worker2 = new WorkerThread(storage, productLoad);
        WorkerThread worker3 = new WorkerThread(storage, productLoad);

        int[] storage0 = {10, 20, 40, 50, 60, 70, 80, 90, 100};
        ArrayList<Integer> storage0Arr = new ArrayList<>();
        for (int i : storage0) {
            storage0Arr.add(i);
        }

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.run(storage0Arr);
            worker2.run(storage0Arr);
            worker3.run(storage0Arr);
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (Exception e) {
        }
    }
}
