import java.util.Scanner;

public class Exercise22_01_Giyash {
    public static String longestIncreasingSubstring(String str) {

        if (str.isEmpty()) {
            return "";
        }

        int bestStart = 0;
        int bestLength = 1;

        for (int i = 0; i < str.length(); i++) {
            int j = i;

            while ((j + 1) < str.length() && str.charAt(j + 1) > str.charAt(j)) {
                j++;
            }

            int length = j - i + 1;
            if (length > bestLength) {
                bestStart = i;
                bestLength = length;
            }
        }
        return str.substring(bestStart, bestStart + bestLength);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Longest increasing substring: " + longestIncreasingSubstring(input));
    }
}
