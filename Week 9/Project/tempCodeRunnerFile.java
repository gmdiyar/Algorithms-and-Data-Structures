        List<Integer> studentsCOPY2 = new ArrayList<>(students);
        // Turns the ArrayList into a TreeSet which is naturally ordered.
        TreeSet studentTreeSet = new TreeSet<>(studentsCOPY2);
        System.out.println(studentTreeSet);