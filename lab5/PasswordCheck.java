package lab5;

import java.util.Scanner;
import java.util.regex.*;

public class PasswordCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password : ");
        String password = scanner.nextLine();

        try {
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);

            if (matcher.matches()) {
                System.out.println("You can use that password.");
            } else {
                System.out.println("You can't use that password. Check the rules again.");
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
