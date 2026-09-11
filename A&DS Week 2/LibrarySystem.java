import java.util.ArrayList;

public class LibrarySystem {
    public static void main(String[] args) {
        Author a = new Author("bill", 1990);
        Author b = new Author("bill", 1990);
        Book c = new Book("something", "123b", 1990, a, 999);
        Book d = new Book("something", "123b", 1990, a, 999);
  
        System.out.println(c.equals(d));
    }    
}

class Author {

    private String name;
    private int birthYear;

    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "name: " + name + ". birth year: " + birthYear;
    }

    @Override
    public boolean equals(Object o) {

        if ( o == this) {
            return true;
        }

        if (!(o instanceof Author)) {
            return false;
        }

        Author a = (Author) o;
        return name == a.name && birthYear == a.birthYear;

    }
}

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

    @Override
    public String toString() {
        return "x";
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

class Library {

    private String name;
    private String location;
    private ArrayList<Book> books;

    public Library (String name, String location, ArrayList<Book> books) {
        this.name = name;
        this.location = location;
        this.books = books;
    }

    public void addBook(Book b) {

    }

    public void removeBook(String isbn) {

    }

    public void findByAuthor(String authorName) {

    }

    public void findByTitle(String title) {

    }

    public void printCataloge() {
        
    }
}