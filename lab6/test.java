package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Map.Entry;

public class test {
    public static void main(String[] args) {
        String filePath = "D:\\projects\\uni proj\\Java\\UniIT3\\lab6\\text.txt";
        File file = new File (filePath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        Map<Integer, ArrayList<String>> mWords = new HashMap<>();

        mWords.put(1, new ArrayList<>());

        while (scanner.hasNext()) {
            String word = scanner.next().replaceAll("[^\\sa-zA-Z0-9']", "").toLowerCase();
            boolean found = false;

            for (Entry<Integer, ArrayList<String>> entry : mWords.entrySet()) {
                int key = entry.getKey();
                ArrayList<String> value = entry.getValue();

                if (value.contains(word)) {
                    value.remove(word);
                    if (!mWords.containsKey(key+1)) {
                        mWords.put(key+1, new ArrayList<>());
                    }
                    mWords.get(key+1).add(word);
                    found = true;
                    break;
                }
            }
            if (!found) {
                mWords.get(1).add(word);
            }

        }

        ArrayList list = new a

        System.out.println(mWords);

    }
}
