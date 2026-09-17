import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grades {

    ArrayList<String> students = new ArrayList<String>();

    public static int getStudentCount() {
        Scanner input = new Scanner(System.in);
        int numberOfStudents;

        System.out.println("Please enter number of students: ");
        while (true) {
            if (input.hasNextInt()) {
                numberOfStudents = input.nextInt();
                break;
            } else {
                System.out.println("Please enter an integer: ");
                input.nextLine();
            }
        }
        return numberOfStudents;
    }

    public static int validateGrades(ArrayList<Float> scores) {

        float best = Collections.max(scores);

        int index = 0;

        for (float score : scores) {
            if (score >= best - 10) {
                System.out.println("Student " + index + " score is " + score + " and grade is A");
                index++;
            } else if (score >= best - 20) {
                System.out.println("Student " + index + " score is " + score + " and grade is B");
                index++;
            } else if (score >= best - 30) {
                System.out.println("Student " + index + " score is " + score + " and grade is C");
                index++;
            } else if (score >= best - 40) {
                System.out.println("Student " + index + " score is " + score + " and grade is D");
                index++;
            } else {
                System.out.println("Student " + index + " score is " + score + " and grade is F");
                index++;
            }
        }
        return 0;

    }

    public static void getStudentArray() {
        Scanner input = new Scanner(System.in);
        ArrayList<Float> scores = new ArrayList<>();
        int studentCount = getStudentCount();

        System.out.println("Enter " + studentCount + " scores. (extra scores will be discarded.)");
        for (int i = 0; i < studentCount; i++) {
            while (!input.hasNextFloat()) {
                System.out.println("Please enter only floats.");
                input.next();
            }
            scores.add(input.nextFloat());
        }

        validateGrades(scores);

    }

    public static void main(String[] args) {
        getStudentArray();
    }
}