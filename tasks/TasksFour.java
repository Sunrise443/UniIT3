package tasks;

import java.util.*;

public class TasksFour {
    public static void main(String[] args) {
        System.out.println("1)");
        nonRepeat("aaajaujkkjua");

        System.out.println("2)");
        bruteForce(2, 3);

        System.out.println("3)");
        decode("MTUCI", "MKIIT");
        int[] en = {0, 31, 28, 10, 29};
        encode(en, "MKIIT");

        System.out.println("4)");
        splt("((()))(())()()(()())");

        System.out.println("5)");
        shortHand("abbbbbbbbcd");

        System.out.println("6)");
        convertToRome(7);

        System.out.println("7)");
        uniqueSubstring("12223234333");

        System.out.println("8)");
        int[][] maze = {
            {1, 3, 1},
            {1, -1, 1},
            {4, 2, 1}
        };
        labyrinth(maze);

        System.out.println("9)");
        numericOrder("t3o the5m 1One all6 r4ule ri2ng");

        System.out.println("10)");
        fibString("cccabdddd");
    }

    //1
    public static String nonRepeat(String strt) {
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        Integer count;
        for (int i=0; i<alphabet.length(); i++) {
            count = 0;
            for (int j=0; j<strt.length(); j++) {
                if (strt.charAt(j) == alphabet.charAt(i)) {
                    count += 1;
                }
                if (count>3) {
                    strt = strt.replaceAll(Character.toString(alphabet.charAt(i)), "");
                }
            }
        }
        System.out.println(strt);
        return strt;
    }
    
    //2-------------------------------------
    public static ArrayList<String> bruteForce(int n, int k) {
        ArrayList<String> fin = new ArrayList<>();
        int m;
        if (k<n) {
            return fin;
        } else if (k==n) {
            int kF = 1;
            for (int i=1; i<=k; i++){
                kF *= i;
            }
            m = kF;
        } else{
            int kF = 1;
            int nkF = 1;
            for (int i=1; i<=k; i++){
                kF *= i;
            }
            for (int i=1; i<=(k-n); i++){
                nkF *= i;
            }
            m = kF/nkF; //Количество всех комбинаций
        }
        
        

        System.out.println(fin);
        return fin;
    }

    //3
    public static String encode (int[] toEncode, String key) {
        String encoded = "";
        int[] keys = key.chars().toArray();
        for (int i=0; i<toEncode.length; i++) {
            char encryptedChar = (char) (toEncode[i] ^ keys[i%keys.length]);
            encoded += encryptedChar;
        }
        System.out.println(encoded);
        return encoded;
    }
    public static int[] decode(String text, String key) {
        int[] keys = key.chars().toArray();
        int[] decoded = new int[text.length()];
        for (int i=0; i<text.length(); i++) {
            decoded[i] = text.charAt(i) ^ keys[i%keys.length];
        }
        System.out.println(Arrays.toString(decoded));
        return decoded;
    }

    //4
    public static List<String> splt(String brackets) {
        String[] brArr = brackets.split("");
        int count = 0;
        String toSave = "";
        List<String> fin = new ArrayList<>();
        for (int i=0; i<brackets.length(); i++) {
            if (brArr[i].equals("(")){
                toSave += "(";
                count += 1;
            } else {
                toSave += ")";
                count -= 1;
                if (count==0) {
                    fin.add(toSave);
                    toSave = "";
                }
            }
        }
        System.out.println(fin);
        return fin;
    }


    //5
    public static String shortHand(String strt) {
        String nd = "";
        int count = 1;
        char j = strt.charAt(0);
        for (int i=1; i<strt.length(); i++) {
            if (j == strt.charAt(i)) {
                count += 1;
            } else {
                if (count!=1) {
                    nd += j + "*" + count;
                } else {
                    nd += j;
                }
                count = 1;
            }
            j = strt.charAt(i);
        }
        if (count==1) {
            nd += j;
        } else {
            nd += j + "*" + count;
        }
        System.out.println(nd);
        return nd;
    }


    //6
    public static String convertToRome(int num) {
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String rome = "";
        for (int i=0; i<roman.length; i++) {
            while (num>=decimal[i]) {
                rome += roman[i];
                num -= decimal[i];
            }
        }
        System.out.println(rome);
        return rome;
    }


    //7
    public static String uniqueSubstring(String strt){
        int ch = 1;
        char lch = strt.charAt(0);
        int nch = 1;
        char lnch = strt.charAt(1);
        for (int i=2; i<strt.length(); i++){
            if (i%2==0) {
                if (strt.charAt(i)==lch){
                    ch += 1;
                } else {
                    ch = 1;
                    lch = strt.charAt(i);
                }
            } else {
                if (strt.charAt(i)==lnch){
                    nch += 1;
                } else {
                    nch = 1;
                    lnch = strt.charAt(i);
                }
            }
        }
        if (ch>nch) {
            System.out.println("чет");
            return "чет";
        } else {
            System.out.println("нечет");
            return "нечет";
        }
    }


    //8-----------------------------------------------
    public static List<String> labyrinth(int[][] strt){
        int n = strt.length;
        if (strt[n-1][n-1]<0) {
            return Arrays.asList("Прохода нет");
        }

        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[n-1][n-1] = strt[n-1][n-1];

        for (int i=n-1; i>=0; i--){
            for (int j=n-1; j>=0; j--){
                if (strt[i][j]<0){
                    cost[i][j] = Integer.MAX_VALUE;
                } else {
                    if (i<n-1){
                        cost[i][j] = Math.min(cost[i][j], cost[i+1][j] + strt[i][j]);
                    }
                    if (j<n-1) {
                        cost[i][j] = Math.min(cost[i][j], cost[i][j+1] + strt[i][j]);
                    }
                }
            }
        }

        if (cost[0][0] == Integer.MAX_VALUE) {
            return Arrays.asList("Прохода нет");
        }

        List<String> path = new ArrayList<>();
        int i=0;
        int j=0;
        while (i<n && j<n) {
            path.add(String.valueOf(strt[i][j]));
            if (i==n-1 && j==n-1) break;
            if (i<n-1 && cost[i][j]==cost[i+1][j]+strt[i][j]){
                i++;
            } else if (j<n-1 && cost[i][j]==cost[i][j+1]+strt[i][j]){
                j++;
            } else {
                break;
            }
        }
        String pathString = String.join("-", path);
        System.out.println(Arrays.asList(pathString, String.valueOf(cost[0][0])));
        return Arrays.asList(pathString, String.valueOf(cost[0][0]));
    }


    //9
    public static String numericOrder(String strt) {
        String[] arr = strt.split(" ");
        int amount = arr.length;
        String nd = "";
        for (int i=1; i<=amount; i++) {
            for (String j: arr) {
                if (j.contains(i+"")){
                    nd += j.replace(i+"", "") + " ";
                }
            }
        }
        System.out.println(nd);
        return nd;
    }


    //10
    public static boolean fibString(String strt) {
        ArrayList<Integer> fib = new ArrayList<>();
        fib.add(1);
        fib.add(1);
        for (int i=2; i<strt.length(); i++){
            fib.add(fib.get(i-1)+fib.get(i-2));
        }

        ArrayList<Integer> amount = new ArrayList<>();
        int count = 1;
        char j = strt.charAt(0);
        for (int i=1; i<strt.length(); i++) {
            if (j == strt.charAt(i)) {
                count += 1;
            } else {
                amount.add(count);
                count = 1;
            }
            j = strt.charAt(i);
        }
        amount.add(count);

        for (Integer amount1 : amount) {
            if (fib.contains(amount1)){
                fib.remove(amount1);
            } else {
                System.out.println(false);
                return false;
            }
        }
        System.out.println(true);
        return true;
    }
}
