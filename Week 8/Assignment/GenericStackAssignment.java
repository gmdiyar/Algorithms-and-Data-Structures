public class GenericStackAssignment {

    static class GenericStack<E> {

        // I begin by setting the capacity to 1 so that the push method doubles it to 2
        // if anything is added. This then sets up the capacity to be doubled to 4, 8,
        // etc. whenever it reaches capacity.

        private int capacity = 1;

        // Count is set to 0 when the stack is created.

        private int count = 0;

        // I suppres the "Type safety: Unchecked cast from Object[] to E[]" warning when
        // casting the Object array to an E array.

        @SuppressWarnings("unchecked")
        private E[] stack = (E[]) new Object[capacity];

        @SuppressWarnings("unchecked")
        public void push(E value) {

            // Check to see if the count is at capacity, if it is, the capacity is doubled,
            // an E array called oldStack is craeted that is a clone of the current stack, I
            // set the stack to a new Object array at the new doubled capacity then cast it
            // to an E array, and lastly I use a for-loop to copy the oldStack into the new
            // stack with the biggest capacity.
            if (count == capacity) {
                capacity = capacity * 2;

                E[] oldStack = stack.clone();
                stack = (E[]) new Object[capacity];

                for (int i = 0; i < count; i++) {
                    stack[i] = oldStack[i];
                }
            }
            // This actually adds the value that the user called, then increments the count.
            stack[count] = value;
            count++;
        }

        public E pop() {
            // Check if the stack is empty, if it is then we return null.
            if (isEmpty()) {
                return null;
            }
            // I start by decrementing the stack, then I set the item in question (from
            // called by pop()) to the current count (which is one less than the top
            // element), and lastly I return it. the stack[count] = null line sets the top
            // element to be null.
            count--;
            E item = (E) stack[count];
            stack[count] = null;
            return item;
        }

        public E peek() {
            if (isEmpty()) {
                return null;
            }
            // Return the second to last element if the isEmpty check passes.
            return (E) stack[count - 1];
        }

        public boolean isEmpty() {
            if (count <= 0) {
                return true;
            }
            return false;
        }

        public int getSize() {
            return count;
        }

        @Override
        public String toString() {
            for (int i = 0; i < count; i++) {
                System.out.println(stack[i]);
            }
            return "";
        }
    }

    public static void main(String[] args) {

        // push method tests

        GenericStack<Integer> intStack = new GenericStack<>();
        intStack.push(10);
        intStack.push(11);
        intStack.push(12);

        GenericStack<String> stringStack = new GenericStack<>();
        stringStack.push("hello");
        stringStack.push("goodbye");
        stringStack.push("diyar");

        System.out.println("Integer Stack: ");
        intStack.toString();

        System.out.println("String Stack: ");
        stringStack.toString();

        System.out.println("------------------------------------------");
        // other method tests

        System.out.println("Int Stack pop: " + intStack.pop());
        System.out.println("Int Stack peek: " + intStack.peek());
        System.out.println("Int Stack empty check: " + intStack.isEmpty());
        System.out.println("Int Stack size check: " + intStack.getSize());

        System.out.println("String Stack pop: " + stringStack.pop());
        System.out.println("String Stack peek: " + stringStack.peek());
        System.out.println("String Stack empty check: " + stringStack.isEmpty());
        System.out.println("String Stack size check: " + stringStack.getSize());
    }
}
