class Node<E> {
    E element;
    Node<E> next;

    public Node(E e) {
        this.element = e;
    }
}

class MyLinkedList<E> {

    protected Node<E> head, tail;
    protected int size = 0;

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e) {
        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) {
            return null;
        } else {
            E temp = head.element;
            head = head.next;
            size--;
            if (head == null) {
                tail = null;
            }
            return temp;
        }
    }

    public E removeLast() {
        if (size == 0 || size == 1) {
            return removeFirst();
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            E temp = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
    }

    public E remove(int index) {
        if (index < 0 || index <= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    public boolean contains(Object o) {
        Node<E> current = head;
        while (current != null) {
            if (matches(o, current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int indexOf(Object o) {
        Node<E> current = head;
        int i = 0;
        while (current != null) {
            if (matches(o, current.element)) {
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        Node<E> current = head;
        int i = 0;
        int last = -1;
        while (current != null) {
            if (matches(o, current.element)) {
                last = i;
            }
            current = current.next;
            i++;
        }
        return last;
    }

    public E set(int index, E e) {
        checkIndex(index);
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E temp = current.element;
        current.element = e;
        return temp;
    }

    private boolean matches(Object o, E element) {
        if (o == null) {
            return element == null;
        } else {
            return o.equals(element);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }
}

public class Exercise24_02_Giyash {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("One");
        list.addLast("Two");
        list.addLast("Three");
        list.addLast("Four");
        list.addLast("Five");
        list.addLast("Three");
        list.addLast("Six");
        list.addLast("Four");
        list.addLast("Seven");

        System.out.println("List: One, Two, Three, Four, Five, Three, Six, Four, Seven");
        System.out.println("Duplicates: Three (index 2 and 5), Four (index 3 and 7)");
        System.out.println();

        System.out.println("--- contains ---");
        System.out.println("contains(\"One\"): " + list.contains("One"));
        System.out.println("contains(\"Seven\"): " + list.contains("Seven"));
        System.out.println("contains(\"Ten\"): " + list.contains("Ten"));
        System.out.println();

        System.out.println("--- get ---");
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(4): " + list.get(4));
        System.out.println("get(8): " + list.get(8));
        try {
            list.get(9);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("get(9): index out of range");
        }
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("get(-1): index out of range");
        }
        System.out.println();

        System.out.println("--- indexOf ---");
        System.out.println("indexOf(\"One\"): " + list.indexOf("One"));
        System.out.println("indexOf(\"Three\"): " + list.indexOf("Three"));
        System.out.println("indexOf(\"Four\"): " + list.indexOf("Four"));
        System.out.println("indexOf(\"Ten\"): " + list.indexOf("Ten"));
        System.out.println();

        System.out.println("--- lastIndexOf ---");
        System.out.println("lastIndexOf(\"Three\"): " + list.lastIndexOf("Three"));
        System.out.println("lastIndexOf(\"Four\"): " + list.lastIndexOf("Four"));
        System.out.println("lastIndexOf(\"Seven\"): " + list.lastIndexOf("Seven"));
        System.out.println("lastIndexOf(\"Ten\"): " + list.lastIndexOf("Ten"));
        System.out.println();

        System.out.println("--- set ---");
        System.out.println("get(6) before set: " + list.get(6));
        System.out.println("set(6, \"Ten\") returned: " + list.set(6, "Ten"));
        System.out.println("get(6) after set: " + list.get(6));
        System.out.println("contains(\"Six\"): " + list.contains("Six"));
        System.out.println("contains(\"Ten\"): " + list.contains("Ten"));
        System.out.println("indexOf(\"Ten\"): " + list.indexOf("Ten"));
        try {
            list.set(9, "Eleven");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("set(9, \"Eleven\"): index out of range");
        }

    }
}
