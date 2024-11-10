package lab5;

import java.util.Scanner;
import java.util.regex.*;

public class IPAdress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ip-adress: ");
        String adress = scanner.nextLine();

        try {
            Pattern pattern = Pattern.compile("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){2,}(([01]?\\d\\d?|2[0-4]\\d|25[0-5]))$");
            Matcher matcher = pattern.matcher(adress);

            if (matcher.matches()) {
                System.out.println("Correct ip-adress.");
            } else {
                System.out.println("You can't use that ip-adress.");
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
