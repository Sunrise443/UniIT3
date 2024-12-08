package ex3;

import java.util.ArrayList;

public class WorkersThread extends Thread{
    private FinStorage finStorage;
    private ArrayList<Integer> workerLoad = new ArrayList<>();
    private int workerLoadWeight = 0;

    public WorkersThread(FinStorage finStorage) {
        this.finStorage = finStorage;
    }

    @Override
    public void run() {
        while (!(ex3.Main.strtStorage).isEmpty()) {
            if (workerLoadWeight<150){
                workerLoadWeight += (ex3.Main.strtStorage).get(0);
                workerLoad.add((ex3.Main.strtStorage).remove(0));
            } else {
                finStorage.increment(workerLoad);
                workerLoadWeight = 0;
                workerLoad.clear();
            }
            System.out.println((Thread.currentThread().getName()+"") + " finstorage" + finStorage.getFin() + " load" + workerLoad);
        }
        finStorage.increment(workerLoad);
        workerLoadWeight = 0;
    }
}
