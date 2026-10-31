import java.util.LinkedHashSet;

public class Exercise21_01_Giyash {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        // LinkedHashSets were used in this exercise because they maintain their
        // insertion order and guarantee that each element is unique. A plain HashSet
        // would print the union, difference, and intersection in an unpredictable
        // order based on hash codes, while a LinkedHashSet prints them in the order
        // the names were added, so the results are easy to check against the original
        // lists and come out the same every run. This could
        // be applicable to a case where you have a user that purchased two items and is
        // a candidate for an advertisement of a similar item. For example, if Ethan
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

        // I create a copy for each operation so as not to alter the original set, which
        // will be used as a mould for the rest of the copies.
        LinkedHashSet<String> names1UnionCopy = (LinkedHashSet<String>) names1.clone();

        // Union of both sets. There were 4 overlapping names between the two lists
        // (Olivia, Ethan, Ava, and Lucas) so the addAll() operation combines all the
        // unique names (16).
        names1UnionCopy.addAll(names2);
        System.out.println("Union: " + names1UnionCopy);

        LinkedHashSet<String> names1DiffCopy = (LinkedHashSet<String>) names1.clone();
        // Difference of both sets (names1 - names2). Prints all the names that are only
        // in names1.
        names1DiffCopy.removeAll(names2);
        System.out.println("Difference (names1 - names2): " + names1DiffCopy);

        LinkedHashSet<String> names1IntersecCopy = (LinkedHashSet<String>) names1.clone();
        // Intersection between the two sets.
        names1IntersecCopy.retainAll(names2);
        System.out.println("Intersection: " + names1IntersecCopy);
    }
}