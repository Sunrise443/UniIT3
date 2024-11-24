package tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Tasks5 {
    public static void main (String[] args) {
        System.out.println(sameLetterPattern("BCCBA", "BCDCB")); //1
        System.out.println(memeSum(248, 208)); //2
        System.out.println(digitsCount(4676)); //3
        String[] arg = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(totalPoints(arg, "tossed")); //4
        int[] run = {1, 2, 3, 5, 6, 7, 8, 9};
        System.out.println(longestRun(run)); //5
        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); //6
        System.out.println(maxPossible(91327, 76)); //8
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(isNew(321)); //10
    }

    public static boolean sameLetterPattern (String first, String second) {
        String fir = "123456789";
        String sec = fir;
        String s = "";
        String s1 = "";
        for (int i=0; i<first.length(); i++) {
            if (s.indexOf(first.charAt(i)) == -1) {
                s += first.charAt(i);
            }
            if (s1.indexOf(second.charAt(i)) == -1) {
                s1 += second.charAt(i);
            }
        }
        for (int i=0; i<second.length(); i++) {
            
        }
        for (int i=0; i<s.length(); i++) {
            first = first.replace(s.charAt(i), fir.charAt(0));
            fir = fir.replaceAll(Character.toString(fir.charAt(0)), "");
        }
        for (int i=0; i<s1.length(); i++) {
            second = second.replace(s1.charAt(i), sec.charAt(0));
            sec = sec.replaceAll(Character.toString(sec.charAt(0)), "");
        }
        return first.equals(second);
    }

    public static int memeSum (int n1, int n2) {
        String s1 = Integer.toString(n1);
        String s2 = Integer.toString(n2);
        String fin = "";

        if (s1.length()<s2.length()) {
            s1 = "0" + s1;
        } else if (s1.length()>s2.length()) {
            s2 = "0" + s2;
        }
        
        for (int i=0; i<s1.length(); i++) {
            fin += (Integer.parseInt(Character.toString(s1.charAt(i))) + Integer.parseInt(Character.toString(s2.charAt(i))));
        }

        return Integer.parseInt(fin);
    }

    public static int digitsCount (int num) {
        int result = 1;
        if (num/10==0) return result;
        result += digitsCount(num/10);
        return result;
    }

    public static int totalPoints (String[] said, String need) {
        int points = 0;
        for (String word : said) {
            int sixL = 0;
            int len = word.length();
            if (isAnagram(word, need)) {
                switch (len) {
                    case 3:
                        points+=1;
                        break;
                    case 4:
                        points+=2;
                        break;
                    case 5:
                        points+=3;
                        break;
                    case 6:
                        if (sixL==1) {
                            points += 58;
                        } else if (sixL>1) {
                            points += 54;
                        } else {
                            points += 50;
                        }
                    default:
                        break;
                }

            }
        }
        return points;
    }
    //из 2х тасков
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
            if (charA>charB) {
                isAn = false;
                break;
            }
        }
        return isAn;
    }

    public static int longestRun (int[] nums) {
        int mRun = 1;
        int run = 1;
        for (int i=1; i<nums.length; i++) {
            if ((nums[i-1] == nums[i]-1)||(nums[i-1]==nums[i]+1)) {
                run += 1;
            } else {
                run = 1;
            }
            if (mRun<run) mRun=run;
        }
        return mRun;
    }

    public static String takeDownAverage(String[] grades) {
        int sum = 0;
        int n = grades.length;

        for (String grade : grades) {
            sum += Integer.parseInt(grade.replace("%", ""));
        }

        double currentAverage = (double) sum / n;
        double newAverage = currentAverage * 0.95;
        double x = (newAverage * (n + 1)) - sum;

        int result = (int) Math.round(Math.min(Math.max(x, 0), 100));
        return result + "%";
    }

    public static int maxPossible (int first, int second){
        String both = first+""+second;
        String fir = first+"";
        char[] digits = both.toCharArray();
        Arrays.sort(digits);
        both = "";
        for (int i=fir.length()+1; i>1; i--) {
            both += digits[i];
        }
        return Integer.parseInt(both);
    }

    public static String timeDifference(String cityA, String timestampA, String cityB) {

        Map<String, Integer> cityTimeZones = new HashMap<>();
        cityTimeZones.put("Los Angeles", -8);
        cityTimeZones.put("New York", -5);
        cityTimeZones.put("Caracas", -4);
        cityTimeZones.put("Buenos Aires", -3);
        cityTimeZones.put("London", 0);
        cityTimeZones.put("Rome", 1);
        cityTimeZones.put("Moscow", 3);
        cityTimeZones.put("Tehran", 4);
        cityTimeZones.put("New Delhi", 6);
        cityTimeZones.put("Beijing", 8);
        cityTimeZones.put("Canberra", 10);

        int offsetA = cityTimeZones.get(cityA);
        int offsetB = cityTimeZones.get(cityB);

        SimpleDateFormat formatA = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.US);
        try {
            Date dateA = formatA.parse(timestampA);

            int timeDifference = offsetB - offsetA;

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateA);
            calendar.add(Calendar.HOUR, timeDifference);

            SimpleDateFormat formatB = new SimpleDateFormat("yyyy-M-d HH:mm");
            String timestampB = formatB.format(calendar.getTime());

            return timestampB;
        } catch  (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isNew(int num) {
        char[] numChars = (num+"").toCharArray();
        Arrays.sort(numChars);
        for (int i=1; i<num; i++) {
            char[] iChars = Integer.toString(i).toCharArray();
            Arrays.sort(iChars);
            if (Arrays.equals(numChars, iChars)) {
                return false;
            }
        }
        return true;
    }
}
