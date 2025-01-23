package org.example;

import java.util.*;
import java.util.stream.Collectors;

class Book
{
    private String title, author_name, category, publisher;
    private double price;
    private int availability;

    // Parameterized Constructor;

    public Book(String title, String author_name, String category, String publisher, double price, int availability) {
        this.title = title;
        this.author_name = author_name;
        this.category = category;
        this.publisher = publisher;
        this.price = price;
        this.availability = availability;
    }

    /* Getter methods that provide encapsulation benefits; here, the individual attributes are not
    directly accessible other than by the Getter Methods */

    public String getTitle() {
        return title;
    }

    public String getAuthorName() {
        return author_name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailability() {
        return availability;
    }

    // default toString() method is inherited from the Object class. While it usually returns info such as Classname@hashcode,
    // to provide meaningful results we changed it to return a string. Purpose of this class is nothing but to provide a human readable version of the object

    @Override
    public String toString() {
        return "Book\n{\n" +
                "\ttitle='" + title + "'\n" +
                "\tauthor_name='" + author_name + "'\n" +
                "\tcategory='" + category + "'\n" +
                "\tpublisher='" + publisher + "'" +
                "\n\tprice=" + price +
                "\n\tavailability=" + availability +
                "\n}\n\n";
    }
}

// Define a common interface for all search strategies
interface SearchStrategy {
    List<Book> search(String query, List<Book> books);
}

// Strategy for searching by author
class SearchByAuthor implements SearchStrategy {
    public List<Book> search(String authorName, List<Book> books) {
        return books.stream()
                .filter(book -> book.getAuthorName().equalsIgnoreCase(authorName) && book.getAvailability() > 0)
                .collect(Collectors.toList());
    }
}

// Strategy for searching by title
class SearchByTitle implements SearchStrategy {
    public List<Book> search(String title, List<Book> books) {
        return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(title.toLowerCase()) && book.getAvailability() > 0)
                .collect(Collectors.toList());
    }
}

// Strategy for searching by category
class SearchByCategory implements SearchStrategy {
    public List<Book> search(String category, List<Book> books) {
        return books.stream()
                .filter(book -> book.getCategory().equalsIgnoreCase(category) && book.getAvailability() > 0)
                .collect(Collectors.toList());
    }
}

// SearchService uses a strategy to perform searches
class SearchService {
    private SearchStrategy strategy;

    // No-argument constructor
    public SearchService() {
        // Nothing to initialize here for now
    }

    public void setSearchStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Book> performSearch(String query, List<Book> books) {
        return strategy.search(query, books);
    }
}

public class App {
    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        // Programming Books
        books.add(new Book("Effective Java", "Joshua Bloch", "Programming", "Addison-Wesley", 45.99, 10));
        books.add(new Book("Clean Code", "Robert C. Martin", "Programming", "Prentice Hall", 42.99, 0));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", "Programming", "Addison-Wesley", 39.99, -1));
        books.add(new Book("Head First Java", "Kathy Sierra", "Programming", "O'Reilly Media", 35.99, 12));
        books.add(new Book("Design Patterns", "Erich Gamma", "Programming", "Addison-Wesley", 47.99, 7));

        // Fiction Books
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", "J.B. Lippincott & Co.", 10.99, 25));
        books.add(new Book("1984", "George Orwell", "Fiction", "Secker & Warburg", 8.99, 30));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "Charles Scribner's Sons", 9.99, 20));
        books.add(new Book("Pride and Prejudice", "Jane Austen", "Fiction", "T. Egerton", 8.99, 18));
        books.add(new Book("Moby Dick", "Herman Melville", "Fiction", "Harper & Brothers", 11.99, 12));

        // Comics
        books.add(new Book("Batman: Year One", "Frank Miller", "Comics", "DC Comics", 15.99, 10));
        books.add(new Book("Spider-Man: Blue", "Jeph Loeb", "Comics", "Marvel Comics", 13.99, 0));
        books.add(new Book("Watchmen", "Alan Moore", "DC Comics", "Comics", 18.99, 15));
        books.add(new Book("The Sandman: Preludes & Nocturnes", "Neil Gaiman", "Comics", "Vertigo", 20.99, -200));
        books.add(new Book("X-Men: Dark Phoenix Saga", "Chris Claremont", "Comics", "Marvel Comics", 14.99, 8));

        // Fantasy Books
        books.add(new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", "Scholastic", 12.99, 50));
        books.add(new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", "George Allen & Unwin", 10.99, 40));
        books.add(new Book("A Game of Thrones", "George R.R. Martin", "Fantasy", "Bantam Spectra", 15.99, -1));
        books.add(new Book("The Name of the Wind", "Patrick Rothfuss", "Fantasy", "DAW Books", 13.99, 22));
        books.add(new Book("Mistborn: The Final Empire", "Brandon Sanderson", "Fantasy", "Tor Books", 12.99, 25));

        SearchService searchService = new SearchService();

        // Search by author
        searchService.setSearchStrategy(new SearchByAuthor());
        System.out.println("Books by Joshua Bloch (In Stock):");
        List<Book> authorResults = searchService.performSearch("Joshua Bloch", books);
        authorResults.forEach(System.out::println);

        // Search by title
        searchService.setSearchStrategy(new SearchByTitle());
        System.out.println("\nBooks with 'Code' in the title (In Stock):");
        List<Book> titleResults = searchService.performSearch("Code", books);
        titleResults.forEach(System.out::println);

        // Search by category
        searchService.setSearchStrategy(new SearchByCategory());
        System.out.println("\nBooks in the 'Programming' category (In Stock):");
        List<Book> categoryResults = searchService.performSearch("Programming", books);
        categoryResults.forEach(System.out::println);
    }
}