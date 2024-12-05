package ex2;

import java.util.*;

public class BiggestMain {
    public static void main(String[] args) {
        
        BiggestRunnable thread1 = new BiggestRunnable();
        BiggestRunnable thread2 = new BiggestRunnable();
        
        int[][] matrix = {{1, 2, 3},
                            {4, 5, 0}};
        ArrayList<Integer> biggestOfLines = new ArrayList<>();
        int mx;

        thread1.start();
        thread2.start();

        thread1.setLine(matrix[0]);
        thread2.setLine(matrix[1]);

        thread1.run();
        thread2.run();

        biggestOfLines.add(thread1.getResult());
        biggestOfLines.add(thread2.getResult());
        mx = Collections.max(biggestOfLines);

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("The biggest element of the matrix: " + mx);
    }
}
