import java.util.EmptyStackException;
import java.util.NoSuchElementException;

class MyStack<E> {

    Node<E> head;

    public MyStack(E headValue) {
        Node<E> head = new Node<E>(headValue);
        this.head = head;
    }

    public MyStack() {
        head = null;
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

class MyQueue<E> {

    Node<E> head;
    Node<E> tail;
    private int count;

    public MyQueue(E headValue) {
        Node<E> head = new Node<E>(headValue);
        this.head = head;
        this.tail = head;
        this.count = 1;
    }

    public void offer(E nodeValue) {
        Node<E> node = new Node<E>(nodeValue);
        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        count++;
    }

    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E value = head.getValue();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        count--;
        return value;
    }

    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.getValue();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public int size() {
        return count;
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

public class Project10_Giyash_Stack {

    public static String isBalanced(String expression) {
        MyStack<Character> expected = new MyStack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '(')
                expected.push(')');
            else if (c == '[')
                expected.push(']');
            else if (c == '{')
                expected.push('}');
            else if (c == ')' || c == ']' || c == '}') {
                if (expected.isEmpty()) {
                    return "Error at position " + i + ": found '" + c
                            + "' but there is no opening bracket for it";
                }
                char want = expected.pop();
                if (c != want) {
                    return "Error at position " + i + ": found '" + c
                            + "' but expected '" + want + "'";
                }
            }
        }

        if (!expected.isEmpty()) {
            return "Error at position " + expression.length()
                    + ": reached the end but expected '" + expected.peek() + "'";
        }
        return "Balanced";
    }

    public static void main(String[] args) {

        // MyStack
        MyStack<String> stack = new MyStack<>("A");

        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");

        stack.pop();
        stack.pop();
        System.out.println("Stack: ");
        stack.printStack();

        System.out.println("Stack Peek: " + stack.peek());

        // MyQueue
        MyQueue<String> queue = new MyQueue<>("A");

        queue.offer("B");
        queue.offer("C");
        queue.offer("D");
        queue.offer("E");
        queue.offer("F");

        queue.poll();
        queue.poll();
        System.out.println("Queue: ");
        queue.printQueue();
        System.out.println("Size: " + queue.size());

        System.out.println("Queue Peek: " + queue.peek());

        // Expression Checker
        System.out.println(isBalanced("{}{}[][]()()()"));
        System.out.println(isBalanced("{}{}][])()()"));
    }
}
