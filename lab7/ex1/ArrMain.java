package ex1;

import java.util.*;

public class ArrMain {
    public static void main(String[] args) {
        ArrSum arrSum = new ArrSum();
        ArrThread thread1 = new ArrThread(arrSum);
        ArrThread thread2 = new ArrThread(arrSum);
        int[] arr = {1, 1, 1};
        int[] half1 = Arrays.copyOfRange(arr, 0, arr.length/2);
        int[] half2 = Arrays.copyOfRange(arr, arr.length/2, arr.length);

        thread1.start();
        thread2.start();

        try {
            thread1.run(half1);
            thread2.run(half2);
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The sum of the elements: " + arrSum.getSum());
    }
}
