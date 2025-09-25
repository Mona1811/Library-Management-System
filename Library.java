package library_management;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    public void displayAllBooks() {
        if(books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for(Book b : books) {
                b.displayDetails();
            }
        }
    }

    public Book searchBook(String title) {
        for(Book b : books) {
            if(b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null; // not found
    }

    public void issueBook(String title, User user) {
        Book book = searchBook(title);
        if(book != null) {
            if(book.isAvailable()) {
                book.borrowBook();
                System.out.println(user.getName() + " borrowed " + book.getTitle());
            } else {
                System.out.println(book.getTitle() + " is currently not available.");
            }
        } else {
            System.out.println("Book not found in library.");
        }
    }

    public void returnBook(String title, User user) {
        Book book = searchBook(title);
        if(book != null) {
            if(!book.isAvailable()) {
                book.returnBook();
                System.out.println(user.getName() + " returned " + book.getTitle());
            } else {
                System.out.println(book.getTitle() + " was not borrowed.");
            }
        } else {
            System.out.println("Book not found in library.");
        }
    }
}