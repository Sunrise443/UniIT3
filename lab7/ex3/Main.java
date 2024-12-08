package ex3;

import java.util.*;

public class Main {
    public static ArrayList<Integer> strtStorage = new ArrayList<>();

    public static void main(String[] args) {
        strtStorage.add(1);
        strtStorage.add(2);
        strtStorage.add(70);
        strtStorage.add(100);

        FinStorage finStorage = new FinStorage();
        ProductsLoad productsLoad = new ProductsLoad();
        
        WorkersThread worker1 = new WorkersThread(finStorage, productsLoad, strtStorage);
        WorkersThread worker2 = new WorkersThread(finStorage, productsLoad, strtStorage);
        WorkersThread worker3 = new WorkersThread(finStorage, productsLoad, strtStorage);

        worker1.start();
        worker2.start();
        worker3.start();

        try {
            worker1.join();
            worker2.join();
            worker3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(finStorage.getFin());
    }
}
