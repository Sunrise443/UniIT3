package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TasksTwo {
    public static void main (String[] args) {
        System.out.println(duplicateChars("Barack", "Obama"));
        int[] arrayOne = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(arrayOne));
        System.out.println(getInitials("simonov sergei evgenievich"));
        double[] arrayTwo = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println(Arrays.toString(normalizator(arrayTwo))); //
        double[] arrayThree = {1.6, 0, 212.3, 34.8, 0, 27.5};
        System.out.println(compressedNums(arrayThree));
        System.out.println(camelToSnake("helloWorldAgain"));
        System.out.println(secondBiggest(arrayOne));
        System.out.println(localReverse("Hello, I'm under the water, please help me", "e"));
        System.out.println(equal(0, 0, 0));
        System.out.println(isAnagram("hello", "world"));
    }

    public static String duplicateChars(String a, String b) {
        String newString = new String();
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i=0; i<Math.max(a.length(), b.length()); i++) {
            if (b.indexOf(a.charAt(i))==-1) newString += a.charAt(i);
        }
        return newString;
    }

    public static int dividedByThree(int[] nums) {
        int amountOfNums = 0;
        for (int i : nums) {
            if (i%2!=0 && i%3==0) amountOfNums += 1;
        }
        return amountOfNums;
    }

    public static String getInitials (String fullName) {
        String[] splitName = fullName.split(" ");
        char first = Character.toUpperCase(splitName[1].charAt(0));
        char second = Character.toUpperCase(splitName[2].charAt(0));
        String third = splitName[0].substring(0, 1).toUpperCase() + splitName[0].substring(1);
        String finName = first + "." + second + "." + third;
        return finName;
    }

    public static double[] normalizator (double[] numbers) {
        double minN = numbers[0];
        double maxN = numbers[0];
        for (double i : numbers) {
            if (i>=maxN) maxN = i;
            if (i<=minN) minN = i;
        }
        for (int i=0; i<numbers.length; i++) {
            double x = numbers[i];
            if (maxN!=minN) {
                numbers[i] = (x-minN)/(maxN-minN);
            } else {
                numbers[i]=0;
            }
        }
        return numbers;
    }

    public static ArrayList<Integer> compressedNums (double[] firstArr){
        ArrayList<Integer> secondArr = new ArrayList<>();
        for (int i=0; i < firstArr.length; i++) {
            if (firstArr[i] != 0) secondArr.add((int) firstArr[i]);
        }
        Collections.sort(secondArr);
        return secondArr;
    }

    public static String camelToSnake (String camelCase) {
        String[] camelCaseList = camelCase.split("(?=[A-Z])");
        String snakeCase = camelCaseList[0];
        for (int i=1; i<camelCaseList.length; i++) {
            snakeCase += "_" + camelCaseList[i];
        }
        return snakeCase.toLowerCase();
    }

    public static int secondBiggest (int[] nums) {
        int maxN = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i]>maxN) maxN=nums[i];
        }
        int secondMaxN = nums[0];
        for (int i = 1; i<nums.length; i++) {
            if ((nums[i]>secondMaxN)&&(nums[i]!=maxN)) secondMaxN=nums[i];
        }
        return secondMaxN;
    }

    public static String localReverse (String word, String charac) {
        String[] wordList = word.split(charac);
        for (int i=0; i<wordList.length; i++) {
            String toReverse = wordList[i];
            if (i%2!=0) {
                String reversed = "";
                for (int j=0; j<toReverse.length(); j++) {
                    reversed = toReverse.charAt(j) + reversed;
                }
                wordList[i] = reversed;
            }
        }
        String finalString = "";
        for (String i : wordList) {
            finalString += i + charac;
        }
        return finalString;
    }

    public static int equal (int a, int b, int c) {
        int amountEqual;
        if (a==b && b==c) {
            amountEqual=3;
        } else if (a==b || b==c || a==c) {
            amountEqual=2;
        } else {
            amountEqual=0;
        }
        return amountEqual;
    }

    public static boolean isAnagram(String a, String b) {
        //for each letter in the alphabet count how many of the letters are in the word
        int charA;
        a = a.toLowerCase();
        b = b.toLowerCase();
        int charB;
        String alphabet = "qwertyuiopasdfghjklzxcvbnm";
        boolean isAn = true;
        for (int i=0; i<alphabet.length(); i++) {
            charA = a.length() - a.replace(String.valueOf(alphabet.charAt(i)), "").length();
            charB = b.length() - b.replace(String.valueOf(alphabet.charAt(i)), "").length();
            if (charA!=charB) {
                isAn = false;
                break;
            }
        }
        return isAn;
    }
}
