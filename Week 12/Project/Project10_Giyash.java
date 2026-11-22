import java.util.EmptyStackException;

class MyStack<E> {

    Node<E> head;

    public MyStack(E headValue) {
        Node<E> head = new Node<E>(headValue);
        this.head = head;
    }

    public void push(E nodeValue) {
        Node<E> node = new Node<>(nodeValue);
        node.setNext(head);
        this.head = node;
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E value = head.getValue();
        head = head.getNext();
        return value;
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
}

class Node<E> {

    private E value;
    private Node<E> next;

    public Node(E value) {
        this.value = value;
        this.next = null;
    }

    public void setNext(Node<E> node) {
        this.next = node;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public E getValue() {
        return this.value;
    }
}

public class Project10_Giyash {
    public static void main(String[] args) {
        MyStack<String> stack = new MyStack<>("A");

        stack.push("B");
        stack.push("C");

        stack.pop();
        stack.pop();
        stack.printStack();

        System.out.println("Peek: " + stack.peek());
    }
}
