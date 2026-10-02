import java.util.Arrays;

class BoundedStack<T> {

    protected int capacity;
    T[] stack;

    @SuppressWarnings("unchecked")
    public BoundedStack(int capacity) {
        this.capacity = capacity;

        this.stack = (T[]) new Object[capacity];
    }

    public void push(T element) {
        try {
            stack = Arrays.copyOf(stack, stack.length);
            stack[stack.length - 1] = element;

        } catch (StackOverflowException e) {
            System.out.println("err: " + e);
        }
    }

    // public T pop() {

    // }

    public void peek() {

    }

    public boolean isEmpty() {
        return stack.length == 0;
    }

    public boolean isFull() {
        return stack.length == capacity;
    }

    public int size() {
        return stack.length;
    }

    public int capacity() {
        return capacity;
    }

    @Override
    public String toString() {
        for (T element : stack) {
            System.out.println(element);
        }
        return ".";
    }
}

class StackOverflowException extends RuntimeException {
    public StackOverflowException(String error) {
        super(error);
    }
}

class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String error) {
        super(error);
    }
}

public class partTwo {
    public static void main(String[] args) {
        BoundedStack<String> stack = new BoundedStack(5);
        stack.push("hi");
        System.out.println(stack);
    }
}
