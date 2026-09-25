class Person {

    protected String name;
    protected String address;
    protected long phoneNumber;
    protected String email;

    public Person(String name, String address, long phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "This is a person";
    }
}

class Student extends Person {

    public Student(String name, String address, long phoneNumber, String email) {
        super(name, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "This is a student";
    }
}

class Employee extends Person {

    public Employee(String name, String address, long phoneNumber, String email) {
        super(name, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "This is an employee";
    }
}

class Faculty extends Employee {

    public Faculty(String name, String address, long phoneNumber, String email) {
        super(name, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "This is a faculty member";
    }
}

class Staff extends Employee {

    public Staff(String name, String address, long phoneNumber, String email) {
        super(name, address, phoneNumber, email);
    }

    @Override
    public String toString() {
        return "This is a staff member";
    }
}

public class People {
    public static void main(String[] args) {
        Person person = new Person("Adam", "123 Main St. NW", 5071234545L, "adam@mail.com");
        Person student = new Student("Bill", "444 Point Ave. SW", 6074928585L, "bill@school.edu");
        Person employee = new Employee("Dave", "515 Wayne Rd. SW", 7024942589L, "dave@company.edu");
        Person faculty = new Faculty("Eric", "1515 Meadow St. NE", 9573200393L, "eric.@work.org");
        Person staff = new Staff("Jones", "9008 Willow St. NW", 9875649801L, "jones@company.org");

        // Each toString() method is printing a differnt overriden method depending on
        // the actual type as opposed to the declared type. What this means is that even
        // though every class defined above is declared as a Person object, the actual
        // type varies. The JVM parses the overriden method depending on the actual type
        // at runtime. In other words, the JVM looks for the first implementation of the
        // toString method in the most specific class. For example, the toString()
        // method overriden in the student class for Person student = new student();
        // This process is known as Dynamic Binding and it is the reason why calling
        // toString on all of the declared classes above doesn't print "This is a
        // person" for all of them.

        System.out.println(person);
        System.out.println(student);
        System.out.println(employee);
        System.out.println(faculty);
        System.out.println(staff);
    }
}
