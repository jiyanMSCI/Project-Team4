package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private SearchService searchService;
    private List<Book> books;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        books = new ArrayList<>();
        books.add(new Book("Effective Java", "Joshua Bloch", "Programming", "Addison-Wesley", 45.99, 10));
        books.add(new Book("Clean Code", "Robert C. Martin", "Programming", "Prentice Hall", 42.99, 5));
        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", "Programming", "Addison-Wesley", 39.99, -1));
        books.add(new Book("Head First Java", "Kathy Sierra", "Programming", "O'Reilly Media", 35.99, 12));
        books.add(new Book("Design Patterns", "Erich Gamma", "Programming", "Addison-Wesley", 47.99, 7));
        searchService = new SearchService();
    }

    /**
     * Rigorous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testSearchByAuthor() {
        searchService.setSearchStrategy(new SearchByAuthor());
        List<Book> result = searchService.performSearch("Joshua Bloch", books);
        assertEquals(1, result.size());
        assertEquals("Effective Java", result.get(0).getTitle());
    }

    public void testSearchByTitle() {
        searchService.setSearchStrategy(new SearchByTitle());
        List<Book> result = searchService.performSearch("Code", books);
        assertEquals(1, result.size());
        assertEquals("Clean Code", result.get(0).getTitle());
    }

    public void testSearchByCategory() {
        searchService.setSearchStrategy(new SearchByCategory());
        List<Book> result = searchService.performSearch("Programming", books);
        assertEquals(4, result.size());
    }

    public void testSearchByAuthorNotFound() {
        searchService.setSearchStrategy(new SearchByAuthor());
        List<Book> result = searchService.performSearch("Unknown Author", books);
        assertEquals(0, result.size());
    }

    public void testSearchByTitleNotFound() {
        searchService.setSearchStrategy(new SearchByTitle());
        List<Book> result = searchService.performSearch("Unknown Title", books);
        assertEquals(0, result.size());
    }

    public void testSearchByCategoryNotFound() {
        searchService.setSearchStrategy(new SearchByCategory());
        List<Book> result = searchService.performSearch("Unknown Category", books);
        assertEquals(0, result.size());
    }







    // Negative test cases that are expected to fail
    public void testSearchByAuthorNegative() {
        searchService.setSearchStrategy(new SearchByAuthor());
        List<Book> result = searchService.performSearch("Joshua Bloch", books);
        assertEquals(2, result.size()); // This should fail as there is only 1 book by Joshua Bloch
    }

    public void testSearchByTitleNegative() {
        searchService.setSearchStrategy(new SearchByTitle());
        List<Book> result = searchService.performSearch("Code", books);
        assertEquals(2, result.size()); // This should fail as there is only 1 book with 'Code' in the title
    }

    public void testSearchByCategoryNegative() {
        searchService.setSearchStrategy(new SearchByCategory());
        List<Book> result = searchService.performSearch("Programming", books);
        assertEquals(5, result.size()); // This should fail as there are only 4 books in the 'Programming' category
    }
}