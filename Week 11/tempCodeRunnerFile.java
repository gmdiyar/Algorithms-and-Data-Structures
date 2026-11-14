import java.util.ArrayList;

class Stack<E> extends ArrayList<E> {

    protected ArrayList<E> stack;

    public void push(E e) {
        stack.add(e);
    }

    public void pop() {

    }

    public boolean isEmpty() {
        return this.isEmpty();
    }

    public int getSize() {
        return stack.size();
    }
}


public class assignment {
    public static void main(String[] args) {
        
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);

        System.out.println(stack.toString());
        System.out.println(stack.size());
    }    
}
