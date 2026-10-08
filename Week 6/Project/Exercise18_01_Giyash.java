import java.math.BigInteger;
import java.util.Scanner;

public class Exercise18_01_Giyash {

    // Method to recursivly calculated and return the factoral of a number.
    // The method takes and returns a BigInteger.
    public static BigInteger factorial(BigInteger n) {
        // Base case to check if n is 0. If it is, returns BigInteger.ONE which saves
        // space and time when calculation a small number like one.
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }
        // Otherwise apply the BigInteger operations to calculate the factorial of n and
        // return it.
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {

        // Scanner to get the input from the user.
        Scanner input = new Scanner(System.in);

        // Prompts for the user.
        System.out.println("Enter a non-negative integer: ");

        // Gets the BigInteger from the scanner with the input.next() method.
        BigInteger n = new BigInteger(input.next());

        // Prints the factorial of the given number as "n! = x"
        System.out.println(n + "! = " + factorial(n));

        // Enter a non-negative integer:
        // 25
        // 25! = 15511210043330985984000000

        // Enter a non-negative integer:
        // 50
        // 50! = 30414093201713378043612608166064768844377641568960512000000000000
    }
}
