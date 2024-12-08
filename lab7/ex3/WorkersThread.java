package ex3;

import java.util.ArrayList;

public class WorkersThread extends Thread{
    private FinStorage finStorage;
    private ProductsLoad productsLoad;
    private ArrayList<Integer> storage0Load;

    public WorkersThread(FinStorage finStorage, ProductsLoad productsLoad, ArrayList<Integer> storage0Load) {
        this.finStorage = finStorage;
        this.productsLoad = productsLoad;
        this.storage0Load = storage0Load;
    }

    @Override
    public void run() {
        while (!storage0Load.isEmpty()) {
            synchronized (this) {
                if (productsLoad.getLoadWeight()<=150 && !storage0Load.isEmpty()) {
                    productsLoad.increment(storage0Load.get(0));
                    storage0Load.remove(0);
                } else if (productsLoad.getLoadWeight()>150) {
                    finStorage.increment(productsLoad.getLoad());
                    productsLoad.increment(-1);
                } else {
                    finStorage.increment(productsLoad.getLoad());
                }
                System.out.println(finStorage.getFin() + "" + productsLoad.getLoad() + productsLoad.getLoadWeight() +" " + storage0Load);
                
            }
        }
    }
}
