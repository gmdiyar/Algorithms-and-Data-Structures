import java.util.ArrayList;
import java.util.EmptyStackException;

class CustomStack<E> extends ArrayList<E> {

    public void push(E e) {
        add(e);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return remove(size() - 1);
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return get(size() - 1);
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    public int getSize() {
        return size();
    }
}


public class Exercise24_04_Giyash {
    public static void main(String[] args) {
        
        CustomStack<Integer> primes = new CustomStack<>();
        
        int count = 0;
        int num = 2;

        while (count < 50) {
            boolean isPrime = true;
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.push(num);
                count++;
            }
            num++;
        }

        while (!primes.isEmpty()) {
            System.out.println(primes.pop());
        }

        // The while loop above prints the elements on the primes stack as it pops them from largest to smallest because of the LIFO ordering of a stack.
        // The custom push method doesn't do anything that a regular ArrayList doesn't do. Namely, it just appends the specified element to the end of the
        // list. The pop method, however, gets the last element of ArrayList with the 'remove(size() - 1)'. The size() gets the last element since it's at
        // the end of the ArrayList (or length of the ArrayList), and the - 1 makes sure it's not out of range since we are counting up from 0 and not from 1. This ordering returns the
        // last element instead of the first element that was inserted. This is exactly the LIFO (Last in, First out) I mentioned earlier.

        // Sample run:

        // 229
        // 227
        // 223
        // 211
        // 199
        // 197
        // 193
        // 191
        // 181
        // 179
        // 173
        // 167
        // 163
        // 157
        // 151
        // 149
        // 139
        // 137
        // 131
        // 127
        // 113
        // 109
        // 107
        // 103
        // 101
        // 97
        // 89
        // 83
        // 79
        // 73
        // 71
        // 67
        // 61
        // 59
        // 53
        // 47
        // 43
        // 41
        // 37
        // 31
        // 29
        // 23
        // 19
        // 17
        // 13
        // 11
        // 7
        // 5
        // 3
        // 2
    }    
}
