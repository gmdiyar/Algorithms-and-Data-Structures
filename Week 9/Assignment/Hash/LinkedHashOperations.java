import java.util.LinkedHashSet;

public class LinkedHashOperations {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // LinkedHashSets were used in this excercise because they maintain their
        // insertion order and guarantee that each element is unique. This could
        // be applicable to a case where you have a user that purchased two items and is
        // a cadidate for an advertisment of a similar item. For example, if Ethan
        // (exists in both sets) purchases an item from list A and is added to that list
        // of buyers, and purchases an item from list B and is added to that list of
        // buyers, the intersection of the two lists of buyers can be used as an input
        // for a recommendation algorithm to suggest a third item that Ethan is likely
        // to purchase.

        LinkedHashSet<String> names1 = new LinkedHashSet<>();
        names1.add("Emma");
        names1.add("Liam");
        names1.add("Olivia");
        names1.add("Noah");
        names1.add("Ava");
        names1.add("Ethan");
        names1.add("Sophia");
        names1.add("Mason");
        names1.add("Isabella");
        names1.add("Lucas");

        LinkedHashSet<String> names2 = new LinkedHashSet<>();
        names2.add("Mia");
        names2.add("Ethan");
        names2.add("Harper");
        names2.add("Olivia");
        names2.add("James");
        names2.add("Charlotte");
        names2.add("Lucas");
        names2.add("Amelia");
        names2.add("Benjamin");
        names2.add("Ava");

        // I create a copy for each operation so as not to alter the orginal set, which
        // will be used as a mould for the rest of the copies.
        LinkedHashSet<String> names1UnionCopy = new LinkedHashSet<>(names1);
        LinkedHashSet<String> names2UnionCopy = new LinkedHashSet<>(names2);

        // Union of both sets. There were 4 overlapping names between the two lists
        // (Olivia, Ethan, Ava, and Lucas) so the addAll() operation combines all the
        // unique names (16).
        names1UnionCopy.addAll(names2UnionCopy);
        System.out.println(names1UnionCopy);

        LinkedHashSet<String> names1DiffCopy = new LinkedHashSet<>(names1);
        LinkedHashSet<String> names2DiffCopy = new LinkedHashSet<>(names2);
        // Difference of both sets (names1 - names2). Prints all the names that are only
        // in names1.
        names1DiffCopy.removeAll(names2DiffCopy);
        System.out.println(names1DiffCopy);

        LinkedHashSet<String> names1IntersecCopy = new LinkedHashSet<>(names1);
        LinkedHashSet<String> names2IntersecCopy = new LinkedHashSet<>(names2);
        // Intersection between the two sets.
        names1IntersecCopy.retainAll(names2IntersecCopy);
        System.out.println(names1IntersecCopy);
    }
}
