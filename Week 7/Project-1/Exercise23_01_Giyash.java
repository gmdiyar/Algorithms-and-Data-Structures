import java.util.Comparator;
import java.util.Arrays;

public class Exercise23_01_Giyash {

    // Sorts an array in ascending natural
    // order using bubble sort, works with
    // anything that implements Comparable.

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        bubbleSort(list, Comparator.naturalOrder());
    }

    // Bubble sort but the elements don't need
    // to implement comparable because it
    // sorts using a caller-supplied comparator.

    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1 - i; j++) {
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Comparable overload with an integer array.
        Integer[] nums = { 8, 2, 5, 8, 2, 3, 1, 0, 6 };
        System.out.println("Integers (unsorted): " + Arrays.toString(nums));
        bubbleSort(nums);
        System.out.println("Integers (sorted): " + Arrays.toString(nums));

        System.out.println("--------------------------------------------");

        // Same but sorting with lambda (case-insensitive in the words array).
        String[] words = { "T.V", "something", "else", "All", "Mouse", "screen" };
        System.out.println("Words (unsorted): " + Arrays.toString(words));
        bubbleSort(words, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Words (sorted): " + Arrays.toString(words));

    }
}