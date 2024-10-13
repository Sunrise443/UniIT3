package tasks;

import java.util.*;

public class TasksThree {
    public static void main(String[] args) {
        System.out.println(isStrangePair("ati", "operator"));
        System.out.println(sale([["laptop", 122], ["phone", 5]]));
    }

    
    public static boolean isStrangePair (String first, String second) {
        return first.charAt(0)==second.charAt(second.length()-1) || first.charAt(first.length()-1)==second.charAt(0);
    }
    
    public static ArrayList
}
