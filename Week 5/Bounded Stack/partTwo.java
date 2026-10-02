class BoundedStack<T> {

    final private int capacity;
    private int count = 0;
    private T[] stack;

    // Generic arrays can't be directly created with new T[], so we create an array
    // of Objects and cast it to (T[]). Because the compiler can't verify this cast,
    // it's unchecked. We can circumvent this with a @SuppressWarnings flag that
    // tells the compiler to silence the warnings about casting. This is safe to do
    // because the actual stack (T[capacity]) is private and is only ever
    // interacted with via internal parameterized methods that don't allow for
    // foreign or inappropriate data types.

    @SuppressWarnings("unchecked")
    public BoundedStack(int capacity) {
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
    }

    public void push(T element) {
        if (isFull()) {
            throw new StackOverflowException("Stack is full. Capacity: " + capacity);
        }
        stack[count] = element;
        count++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        count--;
        T tempElement = stack[count];
        stack[count] = null;
        return tempElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackUnderflowException("Stack is empty");
        }
        return stack[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public int size() {
        return count;
    }

    public int capacity() {
        return capacity;
    }
}

// The reason why StackOverflowException should extend RuntimeException and not
// Exception is because RuntimeException is unchecked and does not need to be
// explicitly declared as a method that throws. Exception, on the other hand is
// checked. We don't need to make a potential overflow checked in this instance
// because it would make adding elements to the stack cumbersome without much
// benefit, as overflow and underflows are programming errors. A simple
// try-catch suffices as it can and does catch both overflow and underflow
// errors.

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
        // Normal operation:
        try {
            BoundedStack<Integer> stack = new BoundedStack<>(5);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);

            System.out.println("Is empty: " + stack.isEmpty());
            System.out.println("Is full: " + stack.isFull());
            System.out.println("Size: " + stack.size());
            System.out.println("Capacity: " + stack.capacity());

            System.out.println("Removed: " + stack.pop());
            System.out.println("Removed: " + stack.pop());
            System.out.println("Last element: " + stack.peek());

        } catch (StackOverflowException e) {
            System.out.println("Error: " + e);
        } catch (StackUnderflowException e) {
            System.out.println("Error: " + e);
        }

        // Stack overflow:
        try {
            BoundedStack<Integer> stack = new BoundedStack<>(5);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
            stack.push(5);
            stack.push(6);
        } catch (StackOverflowException e) {
            System.out.println("Error: " + e);
        }

        // Stack underflow:
        try {
            BoundedStack<Integer> stack = new BoundedStack<>(5);
            stack.pop();
        } catch (StackUnderflowException e) {
            System.out.println("Error: " + e);
        }
    }
}
