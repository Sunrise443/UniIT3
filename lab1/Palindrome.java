package lab1;

public class Palindrome {
    public static void main (String[] args) {
        for (int i=0; i<args.length; i++) {
            String s = args[i];
            System.out.println(isPalindrome(s));
        }
    }

    public static String reverseString(String s) {
        String sr = "";
        for (int j=0; j<s.length(); j++) {
            sr =  s.charAt(j) + sr;
        }
        return sr;
    }

    public static boolean isPalindrome(String s){
        return reverseString(s).equals(s);
    }
}
