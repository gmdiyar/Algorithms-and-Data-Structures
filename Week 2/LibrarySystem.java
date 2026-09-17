import java.util.ArrayList;

public class LibrarySystem {
    public static void main(String[] args) {
        Author hemingway = new Author("Ernest Hemingway", 1899);
        Author tolstoy = new Author("Leo Tolstoy", 1828);
        Author woolf = new Author("Virginia Woolf", 1882);

        ArrayList<Book> catalog = new ArrayList<>();

        catalog.add(new Book("The Sun Also Rises", "9780393887891", 1926, hemingway, 0));
        catalog.add(new Book("Men Without Women", "9780593468845", 1927, hemingway, 1));
        catalog.add(new Book("War and Peace", "0192816144", 1869, tolstoy, 2));
        catalog.add(new Book("To the Lighthouse", "9780007934416", 1927, woolf, 3));
        catalog.add(new Book("A Room of One's Own", "1618952765", 1929, woolf, 4));

        Book manSea = new Book("The Old Man and the Sea", "2309458371", 1952, hemingway, 5);

        Library library = new Library("Rochester Public Library", "Rochester, MN", catalog);

        // Library Operations:

        library.addBook(manSea);
        library.removeBook("A");
        library.findByAuthor("Virginia Woolf");
        library.findByTitle("War and Peace");
        library.printCataloge();

    }
}

// Author class: The reason that the book-author relationship is composition and
// not aggregation is because a book cannot exist without someone writing it
// (both logically
// and in code.) In practice, this means that you cannot create a book object
// without
// an existing author object.

class Author {

    private String name;
    private int birthYear;

    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "name: " + name + ". birth year: " + birthYear;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Author)) {
            return false;
        }

        Author a = (Author) o;
        return name == a.name && birthYear == a.birthYear;

    }
}

// Book class: The reason the library-book relationship is aggregation and not
// composition is
// that a book can exist without belonging to any libraryies catalog. In this
// case, you can create
// a library object without needing to create a book object and vice verse.

class Book {

    private String title;
    private String ISBN;
    private int yearPublished;
    private Author author;
    private int hashId;

    public Book(String title, String ISBN, int yearPublished, Author author, int hashId) {
        this.title = title;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
        this.author = author;
        this.hashId = hashId;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getAuthor() {
        return author.getName();
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Title: " + title + ". ISBN: " + ISBN + ". Year published: " + yearPublished + ". Author: "
                + author.getName();
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (!(o instanceof Book)) {
            return false;
        }

        Book b = (Book) o;
        return title.equals(b.title) && ISBN.equals(b.ISBN)
                && yearPublished == b.yearPublished
                && author.equals(b.author);
    }

    @Override
    public int hashCode() {
        return hashId;
    }
}

// The two main points in the hashCode() contract are A.) "The value of
// hashCode() may only change if a property that is in equals() changes". The
// way I fulfilled this requirement is by having each instantiation of the book
// class require an ID integer in the constructor. This allows for consistant
// references between the hashCode() and equals() methods, and since the
// relationship between the book and author classes is compositional, any change
// to author's equal() override will follow onto book's hashCode() method.
//
// source: https://www.baeldung.com/java-equals-hashcode-contracts

class Library {

    private String name;
    private String location;
    private ArrayList<Book> books;

    public Library(String name, String location, ArrayList<Book> books) {
        this.name = name;
        this.location = location;
        this.books = books;
    }

    public void addBook(Book b) {
        books.add(b);
    }

    public void removeBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN().equals(isbn)) {
                books.remove(i);
            }
        }
    }

    public void findByAuthor(String authorName) {
        for (Book b : books) {
            if (b.getAuthor().equals(authorName)) {
                System.out.println(b.toString());
            }
        }
    }

    public void findByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                System.out.println(b.toString());
            }
        }
    }

    public void printCataloge() {
        for (Book b : books) {
            System.out.println(b.toString());
        }
    }
}