import java.util.LinkedHashSet;

public class LinkedHashOperations {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
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
