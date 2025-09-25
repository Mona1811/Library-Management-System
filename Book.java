package library_management;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = true; // book is available by default
    }

    // Getters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    // Borrow the book
    public void borrowBook() {
        if(isAvailable) {
            isAvailable = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    // Return the book
    public void returnBook() {
        isAvailable = true;
        System.out.println(title + " has been returned.");
    }

    // Display book details
    public void displayDetails() {
        System.out.println("ID: " + bookId + ", Title: " + title +
                           ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}