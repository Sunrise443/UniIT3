package lab6;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class TopWords {
    public static void main(String[] args) {
        String filePath = "D:\\projects\\uni proj\\Java\\UniIT3\\lab6\\text.txt";
        File file = new File (filePath);
        Scanner scanner;
        List<Entry<String, Integer>> top10List = new ArrayList<>();

        try {
            scanner = new Scanner(file);

            Map<String, Integer> mWords = new HashMap<>(); //object Map for keeping words and their amount

            //reading file by words and adding them to Map
            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^\\sa-zA-Z0-9']", "").toLowerCase();

                if (mWords.containsKey(word)) {
                    mWords.replace(word, mWords.get(word)+1);
                } else {
                    mWords.put(word, 1);
                }
            }

            scanner.close(); //closing Scanner
            
            List<Entry<String, Integer>> mList = new ArrayList<>(mWords.entrySet()); //list of Map elements

            //sort the list
            Collections.sort(mList, new Comparator<Entry<String, Integer>>() {
                @Override
                public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
    
            //output of top-10 words
            for (int i=0; i<10; i++) {
                top10List.add(mList.get(i));
                System.out.println(mList.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("An error with the file occured.");
            e.printStackTrace();
        }

        System.out.println(top10List);
    }
}
