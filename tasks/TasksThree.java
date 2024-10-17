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
        System.out.println(rps("scissors", "paper"));
        System.out.println(bugger(999));
        
        ArrayList<ArrayList<Object>> shop = new ArrayList<>();
        ArrayList<Object> item12 = new ArrayList<>();
        item12.add("Bike");
        item12.add(550);
        item12.add(8);
        ArrayList<Object> item11 = new ArrayList<>();
        item11.add("Helmet");
        item11.add(3750);
        item11.add(4);
        ArrayList<Object> item13 = new ArrayList<>();
        item13.add("Ball");
        item13.add(2900);
        item13.add(10);
        shop.add(item11);
        shop.add(item12);
        shop.add(item13);
        System.out.println(mostExpensive(shop));

        System.out.println(longestUnique("abcade"));
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
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
        String s = "scissors";
        String r = "rock";
        String p = "paper";
        if (first.equals(second)) {
            return "Tie";
        } else if (first.equals(r)&&second.equals(p) || first.equals(p)&&second.equals(s) || first.equals(s)&&second.equals(r)) {
            return "Player 2 wins";
        } else return "Player 1 wins";
    }

    public static int bugger(int num) {
        int count = 0;
        int num1;
        if (num/10>=1) {
            count = 1;
            while (num/10>=1) {
                num1 = num;
                while (num1>0) {
                    num *= num1%10;
                    num1 /= 10;
                }
                count += 1;
            }
        }
        return count;
    }

    public static String mostExpensive(ArrayList<ArrayList<Object>> prices) {
        String iName = "";
        int maxPrice = 0;
        for (ArrayList<Object> item: prices) {
            if ((int)item.get(1)*(int)item.get(2) > maxPrice) {
                maxPrice = (int)item.get(1)*(int)item.get(2);
                iName = (String)item.get(0);
            }
        }
        return "Most expensive item is " + iName + " - " + maxPrice;
    }

    //somme cases are wrong lol (can be fixed but for now won't)
    public static String longestUnique(String s) {
        int mx = 0;
        int n;
        String mxS = "";
        String f = Character.toString(s.charAt(0));
        for (int i=1; i<s.length(); i++){
            f += s.charAt(i);
            if (f.indexOf(i)!=f.lastIndexOf(i)) {
                n = f.length()-1;
                f = f.substring(f.indexOf(i));
            } else {
                n = f.length();
            }
            if (mx<n) {
                mx = n;
                mxS = f.substring(0,i-1);
            }
        }
        return mxS;
    }

    public static boolean doesBrickFit (int a, int b, int c, int w, int h) {
        return (((a==h)&&((c==w)||(b==w))) || ((c==h)&&((a==w)||(b==w))) || ((b==h)&&((a==w)||c==w)));
    }
}
