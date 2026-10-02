public class Exercise12_01_Giyash {

    public static void main(String[] args) {

        // -------------------------------------------
        // Valid run: java Calculator.java 12 / 3
        // Output: 12 / 3 = 4.0

        // Invalid run: java Calculator.java 12 / 3a
        // Output: Wrong Input: '3a' is not a number.

        // -------------------------------------------

        // Checking if arguments are of length 3, this way we exit if there are too
        // many.
        if (args.length != 3) {
            System.out.println(
                    "Wrong Input: " + "Wrong number of arguemnts. The supported format is Operand1 Operator Operand2");
            return;
            // Here we are checking if the operator is actually one operator and not
            // concatenated. ex: *@ or null
        } else if (args[1].length() != 1) {
            System.out.println("Wrong Input: " + "Operator must be one character.");
            return;
        }

        // Declaring both operands here so they can be referenced outside of the
        // try-catch blocks later.
        double operand1;
        double operand2;

        try {
            // Parsing the first argument for (or as) a double.
            operand1 = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            // If no double can be found, we can safely assume the user did not enter a
            // number.
            System.out.println("Wrong Input: " + "'" + args[0] + "'" + " is not a number.");
            // Return nothing to exit gradefully.
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            // If an ArrayIndexOutOfBoundsException is thrown, it means the user
            // entered not enough arguments.
            System.out.println("Wrong Input: Inappropriate number of arguments");
            return;
        } catch (Exception e) {
            // Catch and print whatever exception arrises that we didn't account for in the
            // previous two catch blocks.
            System.out.println("Wrong Input: " + e);
            return;
        }

        // Same thing here but for operand2.
        try {
            operand2 = Double.parseDouble(args[2]);
        } catch (NumberFormatException e) {
            System.out.println("Wrong Input: " + "'" + args[2] + "'" + " is not a number.");
            return;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wrong Input: Inappropriate number of arguments");
            return;
        } catch (Exception e) {
            System.out.println("Wrong Input: " + e);
            return;
        }

        // Begin switch statement with the second argument as a char.
        switch (args[1].charAt(0)) {
            case '+':
                double sum = operand1 + operand2;
                System.out.println(args[0] + " + " + args[2] + " = " + sum);
                break;

            case '-':
                double difference = operand1 - operand2;
                System.out.println(args[0] + " - " + args[2] + " = " + difference);
                break;

            case '*':
                double product = operand1 * operand2;
                System.out.println(args[0] + " * " + args[2] + " = " + product);
                break;

            case '/':
                // Only thing added here is a check for division by 0. It really is not
                // completely necessary for double / double because it either returns NaN or
                // infinity, but this also works to inform the user that it's not allowed.
                if (operand2 == 0) {
                    System.out.println("Wrong Input: Cannot divide by 0");
                    return;
                }
                double quotient = operand1 / operand2;
                System.out.println(args[0] + " / " + args[2] + " = " + quotient);
                break;

            // Any operand that isn't supported is caught with the defualt block.
            default:
                System.out.println(
                        "Wrong Input: " + "'" + args[1] + "'" + " is either not an operator or is not supported.");
                break;
        }
    }
}
