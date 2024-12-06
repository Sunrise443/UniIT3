package ex1;

import java.util.*;

public class ArrMain {
    public static void main(String[] args) {
        ArrSum arrSum = new ArrSum();
        int[] arr = {1, 1, 1};
        ArrayList<Integer> half1 = new ArrayList<>();
        ArrayList<Integer> half2 = new ArrayList<>();
        for (int i=0; i<arr.length; i++) {
            if (i<=arr.length/2){
                half1.add(arr[i]);
            } else {
                half2.add(arr[i]);
            }
        }

        ArrThread thread1 = new ArrThread(arrSum, half1);
        ArrThread thread2 = new ArrThread(arrSum, half2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The sum of the elements: " + arrSum.getSum());
    }
}
