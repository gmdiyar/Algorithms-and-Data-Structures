import java.util.HashMap;
import java.util.Map;

class Cache {

    Map<Integer, Long> computed = new HashMap<>();

    public Long fib(Integer n) {

        if (n < 2) {
            return (long) n;
        }

        if (computed.containsKey(n)) {
            return computed.get(n);
        }

        Long result = fib(n - 1) + fib(n - 2);
        computed.put(n, result);
        return result;
    }
}

class BottomUp {

    public long fib(int n) {

        if (n < 2) {
            return (long) n;
        }

        long prev = 0;
        long curr = 1;

        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

}

public class Fibonacci {
    public static void main(String[] args) {
        Cache cache = new Cache();
        System.out.println(cache.fib(50));

        BottomUp bottomUp = new BottomUp();
        System.out.println(bottomUp.fib(50));
    }
}
