//package org.example;
//
//
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//public class SearchServiceTest {
//
//    private SearchService searchService;
//
//    @Before
//    public void setUp() {
//        List<Book> books = new ArrayList<>();
//        books.add(new Book("Effective Java", "Joshua Bloch", "Programming", "Addison-Wesley", 45.99, 10));
//        books.add(new Book("Clean Code", "Robert C. Martin", "Programming", "Prentice Hall", 42.99, 5));
//        books.add(new Book("The Pragmatic Programmer", "Andrew Hunt", "Programming", "Addison-Wesley", 39.99, -1));
//        searchService = new SearchService(books);
//    }
//
//    @Test
//    public void testSearchByAuthor() {
//        List<Book> result = searchService.searchByAuthor("Joshua Bloch");
//        assertEquals(1, result.size());
//        assertEquals("Effective Java", result.get(0).getTitle());
//    }
//
//    @Test
//    public void testSearchByTitle() {
//        List<Book> result = searchService.searchByTitle("Code");
//        assertEquals(1, result.size());
//        assertEquals("Clean Code", result.get(0).getTitle());
//    }
//
//    @Test
//    public void testSearchByCategory() {
//        List<Book> result = searchService.searchByCategory("Programming");
//        assertEquals(3, result.size());
//    }
//
//    @Test
//    public void testSearchByAuthorInStock() {
//        List<Book> result = searchService.searchByAuthorInStock("Joshua Bloch");
//        assertEquals(1, result.size());
//        assertEquals("Effective Java", result.get(0).getTitle());
//    }
//
//    @Test
//    public void testSearchByTitleInStock() {
//        List<Book> result = searchService.searchByTitleInStock("Code");
//        assertEquals(1, result.size());
//        assertEquals("Clean Code", result.get(0).getTitle());
//    }
//
//    @Test
//    public void testSearchByCategoryInStock() {
//        List<Book> result = searchService.searchByCategoryInStock("Programming");
//        assertEquals(2, result.size());
//    }
//}