import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Reader {

    private File file;
    private List<String> wordList = new ArrayList<>();

    public Reader(String fileName) {
        try {
            this.file = new File(fileName);
            populateWordlist();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void sortWordlist() {
        wordList.sort(null);
    }

    public void populateWordlist() {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext() && Character.isLetter(scanner.next().charAt(0))) {
                String token = scanner.next();
                wordList.add(token);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found: " + e);
        }
    }

    public void getFileName() {
        System.out.println(file.toString());
    }

    public void printWords() {
        for (String token : wordList) {
            System.out.println(token);
        }
    }
}

public class FileReader {
    public static void main(String[] args) {
        
        System.out.println("Enter file path with extention (ex: file.txt): ");
        Scanner input = new Scanner(System.in);

        Reader reader = new Reader(input.nextLine());
        reader.sortWordlist();
        reader.printWords();
    }
}