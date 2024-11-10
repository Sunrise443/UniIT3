package lab5;

import java.util.Scanner;
import java.util.regex.*;

public class UpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text: ");
        String text = scanner.nextLine();

        try {
            Pattern pattern = Pattern.compile("([a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);
            boolean found = false;

            while (matcher.find()) {;
                found = true;
                text = text.replace(matcher.group(), "!" + matcher.group() + "!");
            }

            if (!found) {
                System.out.println("Nothing has been found");
            } else {
                System.out.println(text);
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
