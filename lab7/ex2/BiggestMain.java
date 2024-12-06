package ex2;

import java.util.*;

public class BiggestMain {
    public static ArrayList<Integer> biggestOfLines = new ArrayList<>();
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
        {4, 5, 0}};
        int mx=Integer.MIN_VALUE;
        
        BiggestRunnable thread1 = new BiggestRunnable(matrix[0]);
        BiggestRunnable thread2 = new BiggestRunnable(matrix[1]);
        
        
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        for (int i : biggestOfLines) {
            if (mx<i) {
                mx = i;
            }
        }
    
        System.out.println("The biggest element of the matrix: " + mx);
    }
}
