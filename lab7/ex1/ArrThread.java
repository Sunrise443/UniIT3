package ex1;

import java.util.ArrayList;

public class ArrThread extends Thread {
    private final ArrSum arrSum;
    private final ArrayList<Integer> arr;

    public ArrThread(ArrSum arrSum, ArrayList<Integer> arr) {
        this.arrSum = arrSum;
        this.arr = arr;
    }

    @Override
    public void run() {
        for (int i=0; i<arr.size(); i++) {
            arrSum.increment(arr.get(i));
        }
    }
}
