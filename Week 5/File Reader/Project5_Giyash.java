import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

class SafeFileReader {
    private ArrayList<String> fileArray = new ArrayList<String>();
    private String fileName;
    private int linesRead = 0;

    public SafeFileReader(String fileName) {
        this.fileName = fileName;
    }

    public ArrayList<String> readLines() {

        // If an exception is thrown at this point for either an unrecognized file or a
        // IO exception, the try-with-resource block gurantees that the resources will
        // be closed before executing either the catch or finally block(s). That's what
        // makes it so safe when dealing with resources, it's much harder to get a
        // resource leak if at any point an error occurs the resources are closed
        // automatically.

        fileArray.clear();
        linesRead = 0;

        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = input.readLine()) != null) {
                fileArray.add(line);
                linesRead++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, File not found. Please ensure the file name is correct: " + e);
        } catch (IOException e) {
            System.out.println("Error, I/O exception: " + e);
        } finally {
            System.out.println("Lines read: " + linesRead);
        }
        return fileArray;
    }
}

public class Project5_Giyash {
    public static void main(String[] args) {
        SafeFileReader reader = new SafeFileReader("text.txt");
        System.out.println(reader.readLines());
    }
}
