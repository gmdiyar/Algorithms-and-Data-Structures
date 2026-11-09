import java.util.ArrayList;

public class Benchmark {
    public static void main(String[] args) {
        int n = 100000;
        MyLinkedList<Integer> linked = new MyLinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            linked.addFirst(i);
        }
        System.out.println("MyLinkedList addFirst: " + (System.nanoTime() - start) / 1000000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            array.add(0, i);
        }
        System.out.println("ArrayList add(0, e):   " + (System.nanoTime() - start) / 1000000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linked.get(n / 2);
        }
        System.out.println("MyLinkedList get(n/2) x1000: " + (System.nanoTime() - start) / 1000000 + " ms");

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            array.get(n / 2);
        }
        System.out.println("ArrayList get(n/2) x1000:    " + (System.nanoTime() - start) / 1000000 + " ms");

        start = System.nanoTime();
        for (int x : linked) {
        }
        System.out.println("MyLinkedList iterate: " + (System.nanoTime() - start) / 1000000 + " ms");

        start = System.nanoTime();
        for (int x : array) {
        }
        System.out.println("ArrayList iterate:    " + (System.nanoTime() - start) / 1000000 + " ms");
    }
}