import java.util.NoSuchElementException;

class MinHeap<E extends Comparable<E>> {

    private Object[] heap;
    private int size;

    public MinHeap() {
        heap = new Object[10];
        size = 0;
    }

    public void insert(E e) {
        if (size == heap.length) {
            grow();
        }
        heap[size] = e;
        siftUp(size);
        size++;
    }

    public E extractMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        E min = get(0);
        size--;
        heap[0] = heap[size];
        heap[size] = null;
        if (size > 0) {
            siftDown(0);
        }
        return min;
    }

    public E peekMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return get(0);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private E get(int i) {
        return (E) heap[i];
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (get(i).compareTo(get(parent)) >= 0) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    private void siftDown(int i) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && get(left).compareTo(get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && get(right).compareTo(get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest == i) {
                break;
            }
            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int a, int b) {
        Object temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    private void grow() {
        Object[] bigger = new Object[heap.length * 2];
        for (int i = 0; i < size; i++) {
            bigger[i] = heap[i];
        }
        heap = bigger;
    }
}

public class PartC {
    public static void main(String[] args) {

        MinHeap<Integer> minHeap = new MinHeap<>();

        int[] nums = { 86, 23, 54, 16, 63, 21, 28, 27, 68, 12, 14, 22, 83, 4, 6, 71, 13, 67, 90, 57 };
        for (int n : nums) {
            minHeap.insert(n);
        }

        System.out.println("Original: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        System.out.println("Heap sorted: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] = minHeap.extractMin());
        }
    }
}
