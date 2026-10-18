import java.util.Random;

class SortingAlgorithms {

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        mergeHelper(arr, temp, left, mid, right);
    }

    public static void mergeHelper(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid) {
            arr[k++] = temp[i++];
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}

public class Project6_Giyash {

    public static void main(String[] args) {

        int[] sizes = { 1000, 5000, 10000, 50000 };
        int runs = 5;
        Random rand = new Random();

        System.out.printf("%-10s %-18s %-18s %-18s%n",
                "Size", "Selection (ms)", "Insertion (ms)", "Merge (ms)");
        System.out.println("-------------------------------------------------------------");

        for (int size : sizes) {
            long selectionTotal = 0;
            long insertionTotal = 0;
            long mergeTotal = 0;

            for (int i = 0; i < 5; i++) {
                int[] original = new int[size];

                for (int j = 0; j < size; j++) {
                    original[j] = rand.nextInt();
                }
                int[] arr = original.clone();

                long start = System.nanoTime();
                SortingAlgorithms.selectionSort(arr);
                selectionTotal += System.nanoTime() - start;
                if (!SortingAlgorithms.isSorted(arr)) {
                    System.out.println("selectionSort FAILED at size " + size);
                }

                arr = original.clone();
                start = System.nanoTime();
                SortingAlgorithms.insertionSort(arr);
                insertionTotal += System.nanoTime() - start;
                if (!SortingAlgorithms.isSorted(arr)) {
                    System.out.println("insertionSort FAILED at size " + size);
                }

                arr = original.clone();
                start = System.nanoTime();
                SortingAlgorithms.mergeSort(arr);
                mergeTotal += System.nanoTime() - start;
                if (!SortingAlgorithms.isSorted(arr)) {
                    System.out.println("mergeSort FAILED at size " + size);
                }
            }

            double selectionAvg = selectionTotal / (double) runs / 1_000_000.0;
            double insertionAvg = insertionTotal / (double) runs / 1_000_000.0;
            double mergeAvg = mergeTotal / (double) runs / 1_000_000.0;

            System.out.printf("%-10d %-18.3f %-18.3f %-18.3f%n",
                    size, selectionAvg, insertionAvg, mergeAvg);

        }
    }
}