package library_management;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Welcome to Library Management System ===");

        // Create a user
        System.out.print("Enter your User ID: ");
        int userId = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter your Name: ");
        String userName = sc.nextLine();
        User user = new User(userId, userName);

        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Book (Librarian only)");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    Book book = new Book(bookId, title, author);
                    library.addBook(book);
                    break;

                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    System.out.print("Enter Book Title to search: ");
                    String searchTitle = sc.nextLine();
                    Book found = library.searchBook(searchTitle);
                    if (found != null) {
                        found.displayDetails();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book Title to borrow: ");
                    String borrowTitle = sc.nextLine();
                    library.issueBook(borrowTitle, user);
                    break;

                case 5:
                    System.out.print("Enter Book Title to return: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnTitle, user);
                    break;

                case 6:
                    System.out.println("Exiting... Thank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}