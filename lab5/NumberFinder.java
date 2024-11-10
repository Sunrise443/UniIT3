package lab5;

import java.util.Scanner;
import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        try {
            Pattern pattern = Pattern.compile("\\b\\d+\\.\\d+|\\b\\d+\\b");
            Matcher matcher = pattern.matcher(text);
            boolean found = false;

            while (matcher.find()) {
                System.out.println(matcher.group());
                found = true;
            }

            if (!found) {
                System.out.println("No numbers have been found");
            }
        } catch (PatternSyntaxException e) {
            System.out.println("Regular expression error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
