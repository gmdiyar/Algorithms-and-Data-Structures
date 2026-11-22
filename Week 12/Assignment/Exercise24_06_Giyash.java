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
            } else {
                break;
            }
        }
    }

    public E dequeue() {
        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return null;
        }

        E removed = heap.get(0);
        E last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            int i = 0;

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;

                if (left >= heap.size()) {
                    break;
                }

                int smaller = left;
                if (right < heap.size() && comparator.compare(heap.get(right), heap.get(left)) < 0) {
                    smaller = right;
                }

                if (comparator.compare(heap.get(smaller), heap.get(i)) < 0) {
                    E temp = heap.get(i);
                    heap.set(i, heap.get(smaller));
                    heap.set(smaller, temp);
                    i = smaller;
                } else {
                    break;
                }
            }
        }
        return removed;
    }
}

public class Exercise24_06_Giyash {
    public static void main(String[] args) {
        MyPriorityQueue<String> queue = new MyPriorityQueue<>(String.CASE_INSENSITIVE_ORDER);

        queue.enqueue("Tokyo");
        queue.enqueue("chicago");
        queue.enqueue("Denver");
        queue.enqueue("austin");
        queue.enqueue("Boston");
        queue.enqueue("seattle");
        queue.enqueue("Miami");
        queue.enqueue("dallas");
        queue.enqueue("Zurich");
        queue.enqueue("albany");

        System.out.println("Enqueued: Tokyo, chicago, Denver, austin, Boston, seattle, Miami, dallas, Zurich, albany");

        System.out.println("Dequeued:");
        System.out.println("1. " + queue.dequeue());
        System.out.println("2. " + queue.dequeue());
        System.out.println("3. " + queue.dequeue());
        System.out.println("4. " + queue.dequeue());
        System.out.println("5. " + queue.dequeue());
        System.out.println("6. " + queue.dequeue());
        System.out.println("7. " + queue.dequeue());
        System.out.println("8. " + queue.dequeue());
        System.out.println("9. " + queue.dequeue());
        System.out.println("10. " + queue.dequeue());
    }
}
