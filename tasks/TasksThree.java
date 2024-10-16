package tasks;

import java.util.*;

public class TasksThree {
    public static void main(String[] args) {
        System.out.println(isStrangePair("hello", "harry"));

        ArrayList<ArrayList<Object>> prices = new ArrayList<>();
        ArrayList<Object> item1 = new ArrayList<>();
        item1.add("Phone");
        item1.add(51450);
        ArrayList<Object> item2 = new ArrayList<>();
        item2.add("Laptop");
        item2.add(13800);
        prices.add(item1);
        prices.add(item2);
        System.out.println(sale(prices, 25));

        System.out.println(successShot(-2, -3, 4, 5, -6));
        System.out.println(parityAnalysis(12));
    }

    
    public static boolean isStrangePair (String first, String second) {
        return first.charAt(0)==second.charAt(second.length()-1) || first.charAt(first.length()-1)==second.charAt(0);
    }
    
    public static ArrayList<ArrayList<Object>> sale (ArrayList<ArrayList<Object>> startPrice, int discount) {
        for (ArrayList<Object> item : startPrice) {
            int discounted = (int)Math.ceil((int)item.get(1)*(100-discount)*0.01);
            if (discounted>=1) {
                item.set(1, discounted);
            } else item.set(1, 1);
        }
        return startPrice;
    }

    public static boolean successShot (int x, int y, int r, int m, int n) {
        //векторы, расстояние от 1 точки до другой
        double distance = Math.pow(Math.pow(x*x-y*y, 2) + Math.pow(m*m-n*n, 2), 0.5);
        return distance <= r;
    }

    public static boolean parityAnalysis (int num) {
        int sum = 0;
        int num1 = num;
        for (int i=0; i<Integer.toString(num).length(); i++) {
            sum += num1%10;
            num1 /= 10;
        }
        return sum%2==num%2;
    }

    public static String rps (String first, String second) {
        //прописать все исходы на бумаге чтобы сократить кол-во ифов
        if (first.equals(second)) {
            return "Tie";
        } else if (first=="rock" && se) {
            
        }
    }
}
