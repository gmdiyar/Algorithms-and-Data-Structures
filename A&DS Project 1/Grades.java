import java.util.ArrayList;
import java.util.Scanner;

public class Grades {

    ArrayList<String> students = new ArrayList<String>();
    
    public static int getStudentCount(){
        Scanner input = new Scanner(System.in);
        int numberOfStudents;

        System.out.println("Please enter number of students: ");
        while (true) {
            if (input.hasNextInt()){
                numberOfStudents = input.nextInt();
                break;
            } else {
                System.out.println("Please enter an integer: ");
                input.nextLine();
            }
        } return numberOfStudents;
    }
    
    public static void populateStudentArray(){
        
        int studentCount = getStudentCount();
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + studentCount + " scores (seperated by spaces): ");

        while (true){

            float line = input.nextFloat(); 
            float[] floats;
            int floatCount = floats.length;

            if (floatCount != studentCount) {
                System.out.println("The number of scores you entered is not equal to the student count or the scores are not in the correct format (float)");
                continue;
            } else if (floatCount == studentCount) {
                for (int i = 0; i < floats.length; i++){
                    System.out.println(floats[i]);
                }
                }
            }
        }      
    }

    public static void main(String[] args) {
        populateStudentArray();
    }
}