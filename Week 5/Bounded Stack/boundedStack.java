class BoundedStack<T> {

    protected int capacity;
    T[] stack;

    public BoundedStack(int capacity) {
        this.capacity = capacity;
    }

    public void push(T element) {
        try {
            for (int i = 0; i < stack.length + 1; i++) {
                T[] tempStack;

            }
        } catch (Exception e) {

        }
    }

    public T pop() {

    }

    public void peek() {

    }

    public void isEmpty() {
        return 
    }

    public void isFull() {

    }

    public void size() {

    }

    public void capacity() {

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

public class boundedStack {
    public static void main(String[] args) {

    }
}
