import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

class WordFrequencyCounter {

    private File file;

    private HashMap<String, Integer> words = new HashMap<>();

    // Constructor for the file name and instantiation of the file.
    public WordFrequencyCounter(String fileName) {
        try {
            this.file = new File(fileName);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void populteMap() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String token = scanner.next().strip().replaceAll("\\p{Punct}", "").toLowerCase();
                if (!(words.containsKey(token))) {
                    words.put(token, 0);
                }
                Integer freq = words.get(token);
                freq++;
                words.replace(token, freq++);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void sortMap() {

        List<Integer> mostCommonWords = new ArrayList<>();
        for (Integer word : words.values()) {
            mostCommonWords.add(word);
        }

        mostCommonWords.sort((o1, o2) -> Integer.compare(o2, o1));
        mostCommonWords = mostCommonWords.subList(0, 10);
        for (int i = 0; i < words.size();)
            System.out.println(words.get);
        // TreeMap<String, Integer> treeMap = new TreeMap<>(words);
        // System.out.println(treeMap);
    }

    public void getHashMap() {
        System.out.println(words);
    }
}

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name (text.txt): ");
        String input = scanner.nextLine();

        WordFrequencyCounter counter = new WordFrequencyCounter(input);
        counter.populteMap();
        counter.getHashMap();
        counter.sortMap();
    }
}
