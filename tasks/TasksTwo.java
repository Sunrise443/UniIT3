package tasks;

import java.util.Collections;

public class TasksTwo {
    public static void main (String[] args) {
        System.out.println(duplicateChars("Hello", "Hope"));
        int[] arrayOne = {3, 12, 7, 81, 52};
        System.out.println(dividedByThree(arrayOne));
        System.out.println(getInitials("simonov sergei evgenievich"));
        double[] arrayTwo = {3.5, 7.0, 1.5, 9.0, 5.5};
        System.out.println(normalizator(arrayTwo));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static String duplicateChars(String a, String b) {
        String newString = new String();
        for (int i=0; i<Math.max(a.length(), b.length()); i++) {
            if (b.indexOf(a.charAt(i))==-1) {
               newString += a.charAt(i);
            }
        }
        return newString;
    }

    public static int dividedByThree(int[] nums) {
        int amountOfNums = 0;
        for (int i : nums) {
            if (i%3 == 0) {
                amountOfNums += 1;
            }
        }
        return amountOfNums;
    }

    public static String getInitials (String fullName) {
        String[] splitName = fullName.split(" ");
        char first = Character.toUpperCase(splitName[1].charAt(0));
        char second = Character.toUpperCase(splitName[2].charAt(0));
        String third = splitName[0].substring(0, 1).toUpperCase() + splitName[0].substring(1);
        String finName = first + ". " + second + ". " + third;
        return finName;
    }

    public static double[] normalizator (double[] numbers) {
        minN = Collections.min(numbers);

        for (int i=0; i<numbers.length; i++) {
            x = numbers[i];
            numbers[i] = 
        }
    }
}
