import java.util.ArrayList;
import java.util.Comparator;

class MyPriorityQueue<E> {

    private Comparator<E> comparator;
    private ArrayList<E> heap = new ArrayList<>();

    public MyPriorityQueue(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void enqueue(E e) {
        heap.add(e);
        int i = heap.size() - 1;

        while (i != 0) {
            int parent = (i - 1) / 2;

            if (comparator.compare(heap.get(i), heap.get(parent)) < 0) {
                E temp = heap.get(parent);
                heap.set(parent, heap.get(i));
                heap.set(i, temp);
                i = parent;
            }
        }
    }

    public void dequeue() {

    }

}

public class Exercise24_06_Giyash {
    public static void main(String[] args) {

    }
}
