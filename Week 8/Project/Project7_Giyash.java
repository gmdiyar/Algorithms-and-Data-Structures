import java.util.Arrays;
import java.util.Objects;
import java.util.List;

class Pair<A, B> {

    private A firstValue;
    private B secondValue;

    public Pair(A firstValue, B secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<>(a, b);
    }

    public A getA() {
        return firstValue;
    }

    public B getB() {
        return secondValue;
    }

    @Override
    public String toString() {
        return firstValue + " " + secondValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> other = (Pair<?, ?>) o;

        return Objects.equals(firstValue, other.firstValue) &&
                Objects.equals(secondValue, other.secondValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue);
    }
}

class Triple<A, B, C> {

    private A firstValue;
    private B secondValue;
    private C thirdValue;

    public Triple(A firstValue, B secondValue, C thirdValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
        this.thirdValue = thirdValue;
    }

    public static <A, B, C> Triple<A, B, C> of(A a, B b, C c) {
        return new Triple<>(a, b, c);
    }

    public A getA() {
        return firstValue;
    }

    public B getB() {
        return secondValue;
    }

    public C getC() {
        return thirdValue;
    }

    @Override
    public String toString() {
        return firstValue + " " + secondValue + " " + thirdValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Triple)) {
            return false;
        }
        Triple<?, ?, ?> other = (Triple<?, ?, ?>) o;

        return Objects.equals(firstValue, other.firstValue) &&
                Objects.equals(secondValue, other.secondValue) &&
                Objects.equals(thirdValue, other.thirdValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstValue, secondValue, thirdValue);
    }
}

class SortedArray<T extends Comparable<T>> {

    private T[] array;
    private int count;

    @SuppressWarnings("unchecked")
    public SortedArray() {
        array = (T[]) new Comparable[4];
    }

    public void insert(T element) {
        if (element == null) {
            System.out.println("Element cannot be null.");
        }
        if (count == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        int i = count - 1;
        while (i >= 0 && array[i].compareTo(element) > 0) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = element;
        count++;
    }

    public boolean remove(T element) {
        int index = binarySearch(element);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count--;
        return true;
    }

    public int binarySearch(T target) {
        if (target == null) {
            return -1;
        }

        int low = 0;
        int high = count - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comp = array[mid].compareTo(target);
            if (comp == 0) {
                return mid;
            } else if (comp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public T get(int i) {
        if (i < 0 || i >= count) {
            System.out.println("Index must be between 0 and the size of the array.");
        }
        return array[i];
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < count; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        return sb.append("]").toString();
    }
}

class GenericUtils {

    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static double sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("List cannot be empty.");
        }
        T largest = list.get(0);
        for (T item : list) {
            if (item.compareTo(largest) > 0) {
                largest = item;
            }
        }
        return largest;
    }
}

public class Project7_Giyash {
    public static void main(String[] args) {
        Pair<String, Integer> pair = Pair.of("Hello", 100);

        System.out.println(pair.toString());

        // Pair<String, Integer> badPair = Pair.of("Test", 10.3);
        // The code above gives a type mismatch error because you cannot create a
        // pair.of with a=string and b=double for a pair of a=string and b=integer

        System.out.println("getA: " + pair.getA() + ", getB: " + pair.getB());
        System.out.println("equals same: " + pair.equals(Pair.of("Hello", 100)));
        System.out.println("equals diff: " + pair.equals(Pair.of("Hello", 200)));

        Triple<String, Integer, Double> triple = Triple.of("Diyar", 20, 3.9);
        System.out.println("Triple: " + triple);
        System.out.println("getC: " + triple.getC());
        System.out.println("triple equals: " + triple.equals(Triple.of("Diyar", 20, 3.9)));

        SortedArray<Integer> ints = new SortedArray<>();
        for (int n : new int[] { 42, 7, 19, 3, 25, 7, 100, -5 }) {
            ints.insert(n);
        }

        System.out.println("Integers: " + ints);
        System.out.println("size: " + ints.size());
        System.out.println("search 25: " + ints.binarySearch(25));
        System.out.println("remove 7: " + ints.remove(7) + " -> " + ints);
        System.out.println("get(0): " + ints.get(0));

        SortedArray<Double> doubles = new SortedArray<>();
        for (double d : new double[] { 3.14, 2.71, 1.41, 1.73, 0.5, 9.99 }) {
            doubles.insert(d);
        }

        System.out.println("Doubles: " + doubles);
        System.out.println("size: " + doubles.size());
        System.out.println("search 1.73: " + doubles.binarySearch(1.73));
        System.out.println("remove 9.99: " + doubles.remove(9.99) + " -> " + doubles);
        System.out.println("get(0): " + doubles.get(0));

        SortedArray<String> strings = new SortedArray<>();
        for (String w : new String[] { "diyar", "one", "hello", "there", "test" }) {
            strings.insert(w);
        }

        System.out.println("Strings: " + strings);
        System.out.println("search 'diyar': " + strings.binarySearch("diyar"));
        System.out.println("remove 'hello': " + strings.remove("hello") + " -> " + strings);
        System.out.println("size: " + strings.size());

        // swap
        String[] names = { "Diyar", "Bill", "Evan" };
        GenericUtils.swap(names, 0, 2);
        System.out.println("swap strings: " + Arrays.toString(names));

        Integer[] nums = { 1, 2, 3, 4 };
        GenericUtils.swap(nums, 1, 3);
        System.out.println("swap ints: " + Arrays.toString(nums));

        // sumList
        System.out.println("sum ints: " + GenericUtils.sumList(List.of(1, 2, 3, 4)));
        System.out.println("sum doubles: " + GenericUtils.sumList(List.of(1.5, 2.5, 3.0)));
        System.out.println("sum mixed: " + GenericUtils.sumList(List.<Number>of(10, 2.5, 3L)));

        // max
        System.out.println("max ints: " + GenericUtils.max(List.of(42, 7, 19, 100, -5)));
        System.out.println("max doubles: " + GenericUtils.max(List.of(3.14, 2.71, 1.41)));
        System.out.println("max strings: " + GenericUtils.max(List.of("one", "two", "three")));

    }
}
