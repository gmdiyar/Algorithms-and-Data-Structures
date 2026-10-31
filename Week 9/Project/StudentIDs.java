import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class StudentIDs {

    public static void main(String[] args) {
        List<Integer> students = new ArrayList<>();

        Random rand = new Random();

        System.out.println("test");
        for (int i = 0; i < 41; i++) {
            students.add(rand.nextInt(0, 1000));
        }
        // Duplicates
        students.add(55);
        students.add(61);
        students.add(90);
        students.add(14);
        students.add(24);

        students.add(55);
        students.add(61);
        students.add(90);
        students.add(14);
        students.add(24);

        List<Integer> studentsCOPY1 = new ArrayList<>(students);
        // Turns the ArrayList into HashSet, only unique values are kept.
        HashSet studentSet = new HashSet<>(studentsCOPY1);
        System.out.println(
                "-------------------------------- Hash Set: -------------------------------------------------------------");
        System.out.println(studentSet);

        List<Integer> studentsCOPY2 = new ArrayList<>(students);
        // Turns the ArrayList into a TreeSet which is naturally ordered.
        TreeSet studentTreeSet = new TreeSet<>(studentsCOPY2);
        System.out.println(
                "-------------------------------- Tree Set: ------------------------------------------------------------- ");
        System.out.println(studentTreeSet);

        // Using nested loops to find duplicates instead of a hashset would take O(n^2)
        // time which is quadratic time. This means that as n gets bigger (the number of
        // elements in the list) the time it takes to look for duplicates gets much
        // larger. This is because a nested for loop has two stages: the first is to
        // look at the Ith index and the second is the Jth index. It then compares the
        // Ith to the Jth to see if they match. This is guranteed to find all the
        // matches in the array but comes at the cost of time because a nested for loop
        // must reference every element to every other element at least once.

        // The next best option in terms of time compexity to finding duplicates in an
        // array is to sort the array first then look for the elements that are right
        // next to each other and see if they are identicle (this works because a sorted
        // array natually places duplicate elements side by.) This reduces the time need
        // from O(n^2) to O(n * log n) which is a massive improvement.

        // Lastly, the fastest way to look for duplicate elements in an array is to turn
        // it into a hash set. This is because hash sets store the hashes to elements in
        // what are referred to as 'buckets'. These buckets store the hashes to the
        // elements which are then computed with each check. This makes it so that
        // checking weather or not an element exists more than once in array doesn't
        // require checking each and every element in that array, just the hash of the
        // elements and checking the buckets intead. This takes an average time of O(1)
        // per element n so a total time complexity of O(n).
    }
}
