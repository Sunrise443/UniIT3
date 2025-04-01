package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Tasks6 {
    public static void main(String[] args) {
        //1
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        
        //2
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", null));

        //3
        System.out.println(nicoCipher("mubashirhassan", "crazy"));

        //4
        System.out.println(Arrays.toString(twoProduct(new int[] { 1, 2, 3, 9, 4, 5, 15, 3 }, 45)));

        //5
        System.out.println(isExact(6));

        //6
        System.out.println(fractions("0.(6)"));

        //7
        System.out.println(pilishString("33314444"));

        //8
        System.out.println(formula("6 * 4 = 24"));

        //9
        System.out.println(isValid("aabbcd"));

        //10
        System.out.println(palindromeDescendant(13001120));
    }

    //1
    public static String hiddenAnagram(String sentence, String phrase) {
        String cleanSentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
        String cleanPhrase = phrase.replaceAll("[^a-zA-Z]", "").toLowerCase();
        Map<Character, Integer> phraseCharCount = new HashMap<>();
        for (char c : cleanPhrase.toCharArray()) {
            phraseCharCount.put(c, phraseCharCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> windowCharCount = new HashMap<>();
        int left = 0;

        for (int right = 0; right < cleanSentence.length(); right++) {
            char currentChar = cleanSentence.charAt(right);
            windowCharCount.put(currentChar, windowCharCount.getOrDefault(currentChar, 0) + 1);
            if (right - left + 1 > cleanPhrase.length()) {
                char leftChar = cleanSentence.charAt(left);
                windowCharCount.put(leftChar, windowCharCount.get(leftChar) - 1);
                if (windowCharCount.get(leftChar) == 0) {
                    windowCharCount.remove(leftChar);
                }
                left++;
            }
            if (windowCharCount.equals(phraseCharCount)) {
                return cleanSentence.substring(left, right + 1);
            }
        }
        return "noutfond";
    }

    //2
    public static String stripUrlParams(String url, String[] toStrip) {
        String[] urlParts = url.split("\\?", 2);
        String baseUrl = urlParts[0];
        if (urlParts.length == 1) {
            return baseUrl;
        }
        String query = urlParts[1];
        String[] params = query.split("&");
        Set<String> toStripSet = new HashSet<>();
        if (toStrip != null) {
            toStripSet.addAll(Arrays.asList(toStrip));
        }
        Map<String, String> paramMap = new LinkedHashMap<>();
        for (String param : params) {
            String[] keyValue = param.split("=", 2);
            String key = keyValue[0];
            String value = keyValue.length > 1 ? keyValue[1] : "";

            if (!toStripSet.contains(key)) {
                paramMap.put(key, value);
            }
        }
        StringBuilder result = new StringBuilder(baseUrl);
        if (!paramMap.isEmpty()) {
            result.append("?");
            paramMap.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> result.append(entry.getKey()).append("=").append(entry.getValue()).append("&"));

            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }

    //3
    public static String nicoCipher(String message, String key) {
        int keyLength = key.length();
        while (message.length() % keyLength != 0) {
            message += " ";
        }
        Character[] keyArray = new Character[keyLength];
        for (int i = 0; i < keyLength; i++) {
            keyArray[i] = key.charAt(i);
        }
        Integer[] sortedIndices = new Integer[keyLength];
        for (int i = 0; i < keyLength; i++) {
            sortedIndices[i] = i;
        }
        Arrays.sort(sortedIndices, Comparator.comparingInt(o -> keyArray[o]));
        int rows = message.length() / keyLength;
        char[][] grid = new char[rows][keyLength];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < keyLength; j++) {
                grid[i][j] = message.charAt(i * keyLength + j);
            }
        }
        StringBuilder encodedMessage = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int sortedIndex : sortedIndices) {
                encodedMessage.append(grid[i][sortedIndex]);
            }
        }
        return encodedMessage.toString();
    }

    //4
    public static int[] twoProduct(int[] arr, int n) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (n % current == 0) {
                int complement = n / current;
                if (seen.containsKey(complement)) {
                    return new int[] { complement, current };
                }
            }
            seen.put(current, i);
        }
        return new int[0];
    }

    //5
    public static List<Integer> isExact(int num) {
        return isExactRecursive(num, 1, 1);
    }
    private static List<Integer> isExactRecursive(int num, int currentFactorial, int n) {
        if (currentFactorial == num) {
            List<Integer> result = new ArrayList<>();
            result.add(num);
            result.add(n);
            return result;
        }
        if (currentFactorial > num) {
            return new ArrayList<>();
        }
        return isExactRecursive(num, currentFactorial * (n + 1), n + 1);
    }

    //6
    public static String fractions(String s) {
        String[] parts = s.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts.length > 1 ? parts[1] : "";
        if (!decimalPart.contains("(")) {
            int denominator = (int) Math.pow(10, decimalPart.length());
            int numerator = Integer.parseInt(decimalPart);
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            return numerator + "/" + denominator;
        } else {
            int repeatStart = decimalPart.indexOf("(");
            int repeatEnd = decimalPart.indexOf(")");
            String nonRepeatingPart = decimalPart.substring(0, repeatStart);
            String repeatingPart = decimalPart.substring(repeatStart + 1, repeatEnd);
            int nonRepeatingLength = nonRepeatingPart.length();
            int repeatingLength = repeatingPart.length();
            long numerator = Long.parseLong(integerPart + nonRepeatingPart + repeatingPart)
                    - Long.parseLong(integerPart + nonRepeatingPart);
            long denominator = (long) (Math.pow(10, nonRepeatingLength + repeatingLength)
                    - Math.pow(10, nonRepeatingLength));
            long gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
            return numerator + "/" + denominator;
        }
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //7
    public static String pilishString(String txt) {
        int[] piDigits = { 3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9 };
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (int piDigit : piDigits) {
            if (index < txt.length()) {
                String word = txt.substring(index, Math.min(index + piDigit, txt.length()));
                while (word.length() < piDigit) {
                    word += word.charAt(word.length() - 1);
                }
                result.append(word).append(" ");
                index += piDigit;
            } else {
                break;
            }
        }
        return result.toString().trim();
    }

    //8
    public static boolean formula(String str) {
        String[] parts = str.split("=");
        for (int i = 0; i < parts.length - 1; i++) {
            parts[i] = parts[i].trim();
            parts[i + 1] = parts[i + 1].trim();
            if (!isValidExpression(parts[i]) || !isValidExpression(parts[i + 1])) {
                return false;
            }
            if (evaluateExpression(parts[i]) != evaluateExpression(parts[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidExpression(String expr) {
        return expr.matches("[0-9\\s\\+\\-\\*\\/]+");
    }

    private static int evaluateExpression(String expr) {
        String[] tokens = expr.split("\\s+");
        int result = Integer.parseInt(tokens[0]);
        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int number = Integer.parseInt(tokens[i + 1]);
            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operator: " + operator);
            }
        }
        return result;
    }

    //9
    public static String isValid(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int count : charCount.values()) {
            frequencyCount.put(count, frequencyCount.getOrDefault(count, 0) + 1);
        }
        if (frequencyCount.size() == 1) {
            return "YES";
        } else if (frequencyCount.size() == 2) {
            Object[] freqArray = frequencyCount.keySet().toArray();
            int freq1 = (int) freqArray[0];
            int freq2 = (int) freqArray[1];

            if ((frequencyCount.get(freq1) == 1 && (freq1 - freq2 == 1 || freq1 == 1)) ||
                    (frequencyCount.get(freq2) == 1 && (freq2 - freq1 == 1 || freq2 == 1))) {
                return "YES";
            }
        }
        return "NO";
    }

    //10
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static String generateDescendant(String num) {
        StringBuilder descendant = new StringBuilder();
        for (int i = 0; i < num.length() - 1; i += 2) {
            int sum = (num.charAt(i) - '0') + (num.charAt(i + 1) - '0');
            descendant.append(sum);
        }
        return descendant.toString();
    }
    public static boolean palindromeDescendant(int num) {
        String numStr = String.valueOf(num);
        if (isPalindrome(numStr)) {
            return true;
        }
        while (numStr.length() > 2) {
            numStr = generateDescendant(numStr);
            if (isPalindrome(numStr)) {
                return true;
            }
        }
        return isPalindrome(numStr);
    }
}
