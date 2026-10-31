
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(words.entrySet());

        entries.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        for (int i = 0; i < 10; i++) {
            Map.Entry<String, Integer> e = entries.get(i);
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public void getTreeMap() {
        TreeMap<String, Integer> treeMap = new TreeMap<>(words);
        System.out.println(treeMap);
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
        counter.getTreeMap();
    }
}
