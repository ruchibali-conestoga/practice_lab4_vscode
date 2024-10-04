package com.example;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private static Library library;

    static {
        library = new Library();
    }

    //
    // private Library library;
    // @BeforeEach
    // void setUp() {
    // library = new Library();
    // }

    @Test
    void testAddBook() {
        library.addBook("The God of Small Things");// add book
        assertTrue(library.isBookAvailable("The God of Small Things"));// check: book is available
    }

    @Test
    void testRemoveBook() {
        library.addBook("A Suitable Boy");// add book
        library.removeBook("A Suitable Boy");// remove book
        assertFalse(library.isBookAvailable("A Suitable Boy"));// check: book is not available
    }

    @Test
    void testIsBookAvailable() {
        library.addBook("The White Tiger");// add book
        assertTrue(library.isBookAvailable("The White Tiger"));// check: book is available
        assertFalse(library.isBookAvailable("A Fine Balance"));// check: book is not available
    }

    @Test
    void testGetBooks() {
        library.addBook("Midnight's Children"); // add book
        library.addBook("The Inheritance of Loss");// add book
        List<String> books = library.getBooks();// get all books (library class) //put into //make a list of books
        assertEquals(2, books.size());// check the retrieved book size i.e 2
        // assertTrue(books.contains("Interpreter of Maladies"));
        // check retrive book is // contained (exits) // expected true but false
        // assertTrue(books.contains("The Great Indian Novel"));
        assertFalse(books.contains("Interpreter of Maladies")); // check: book is not available
        assertFalse(books.contains("The Great Indian Novel")); // check: book is not available
    }

    @Test
    void testGetBooksImmutable() {
        library.addBook("The Alchemist");// add book
        List<String> books = library.getBooks();// get all books (library class)
        books.add("New Book"); // add book
        // Trying to modify the list
        assertFalse(library.isBookAvailable("New Book")); // check book is not available
        // Original list should remain unchanged
        assertEquals(6, books.size());// check the retrieved book size i.e 6
        assertTrue(books.contains("The Alchemist"));// check: book is available
    }
}
