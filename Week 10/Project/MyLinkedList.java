import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> after = head.next;

        newNode.prev = head;
        newNode.next = after;
        head.next = newNode;
        after.prev = newNode;
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> before = tail.prev;

        newNode.prev = before;
        newNode.next = tail;
        before.next = newNode;
        tail.prev = newNode;
        size++;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<E> after = head.next;
        for (int i = 0; i < index; i++) {
            after = after.next;
        }
        Node<E> before = after.prev;

        Node<E> newNode = new Node<>(e);
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        size++;
    }

    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> first = head.next;

        head.next = first.next;
        first.next.prev = head;
        size--;
        return first.element;
    }

    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> last = tail.prev;

        tail.prev = last.prev;
        last.prev.next = tail;
        size--;
        return last.element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        Node<E> before = current.prev;
        Node<E> after = current.next;
        before.next = after;
        after.prev = before;
        size--;
        return current.element;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }

        Node<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldElement = current.element;
        current.element = e;
        return oldElement;
    }

    public int indexOf(E e) {
        Node<E> current = head.next;
        int index = 0;

        while (current != tail) {
            if (e == null && current.element == null) {
                return index;
            } else if (e != null && e.equals(current.element)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(E e) {
        return indexOf(e) != -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public String toString() {
        String result = "[";
        Node<E> current = head.next;

        while (current != tail) {
            result = result + current.element;
            if (current.next != tail) {
                result = result + ", ";
            }
            current = current.next;
        }
        return result + "]";
    }

    public Iterator<E> iterator() {
        return new ListIterator<>(head.next, tail);
    }

    public void reverse() {
        if (size <= 1) {
            return;
        }

        Node<E> oldFirst = head.next;
        Node<E> oldLast = tail.prev;

        Node<E> current = oldFirst;
        while (current != tail) {
            Node<E> temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        }

        head.next = oldLast;
        oldLast.prev = head;
        tail.prev = oldFirst;
        oldFirst.next = tail;

        // Trace: head <-> A <-> B <-> C <-> D <-> tail
        //
        // Swap prev and next on each node:
        // A: next = head, prev = B;
        // B: next = A, prev = C;
        // C: next = B, prev = D;
        // D: next = C, prev = tail;
        //
        // Fix the ends:
        // head.next = D, D.prev = head;
        // tail.prev = A, A.next = tail;
        //
        // Result: head <-> D <-> C <-> B <-> A <-> tail

    }

    private static class ListIterator<E> implements Iterator<E> {
        private Node<E> current;
        private Node<E> end;

        ListIterator(Node<E> start, Node<E> end) {
            this.current = start;
            this.end = end;
        }

        public boolean hasNext() {
            return current != end;
        }

        public E next() {
            if (current == end) {
                throw new NoSuchElementException();
            }
            E element = current.element;
            current = current.next;
            return element;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        System.out.println("Empty list: " + list);
        System.out.println("isEmpty: " + list.isEmpty());

        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.add(2, "C");
        list.add(4, "E");
        System.out.println();
        System.out.println("After adding: " + list);
        System.out.println("Size: " + list.size());

        System.out.println();
        System.out.println("get(2): " + list.get(2));
        System.out.println("set(2, X) returned: " + list.set(2, "X"));
        System.out.println("After set: " + list);
        System.out.println("indexOf(D): " + list.indexOf("D"));
        System.out.println("indexOf(Z): " + list.indexOf("Z"));
        System.out.println("contains(A): " + list.contains("A"));
        System.out.println("contains(Z): " + list.contains("Z"));

        System.out.println();
        System.out.print("For-each loop: ");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println();
        System.out.println("removeFirst(): " + list.removeFirst());
        System.out.println("removeLast(): " + list.removeLast());
        System.out.println("remove(1): " + list.remove(1));
        System.out.println("After removing: " + list);

        list.clear();
        System.out.println();
        System.out.println("After clear: " + list);
        System.out.println("Size: " + list.size());

    }
}