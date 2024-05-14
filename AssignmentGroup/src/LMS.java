package AssignmentGroup;

import java.util.Scanner;

public class LMS {
    private UserManagement userManagement;
    private BookManagement bookManagement;

    public LMS() {
        this.userManagement = new UserManagement();
        this.bookManagement = new BookManagement();
    }

    public void mainMenu() {

        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {

            System.out.println("====================================================");
            System.out.println("Welcome to the Library Management System!");
            System.out.println("====================================================");
            System.out.println("Please select an option:");
            System.out.println("1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Display All Users");
            System.out.println("4. Add Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Display All Books");
            System.out.println("7. Search User by ID");
            System.out.println("8. Search Book by ID");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println();

            scanner.nextLine();
            String name;
            int age;
            String title;
            String author;
            String bookID;
            String userID;
            String userInput;

            if (choice == 1) {
                // a method to add a user to the user arraylist
                System.out.print("Please enter your name: ");
                name = scanner.nextLine();
                System.out.print("Please enter your age: ");
                age = scanner.nextInt();
                System.out.print("Please enter your userID: ");
                userID = scanner.nextLine();
                userID = scanner.nextLine();
                LibraryUser users = new LibraryUser(name, age, userID);
                userManagement.addUser(users);
                System.out.println("User " + name + " added successfully! ");
                System.out.println();
            }
            if (choice == 2) {

                // a method to delete a user from the user arraylist
                System.out.println("Enter user ID to delete: ");
                userID = scanner.nextLine();
                if (userManagement.deleteUser(userID)) {
                    System.out.println();
                } else {
                    System.out.println("Error: No user found with ID " + userID);
                    System.out.println();
                }
            }
            if (choice == 3) {
                //a method to displays All Users
                System.out.println("Displaying All Users");
                userManagement.displayAllUsers();
                System.out.println();

            }
            if (choice == 4) {
                //a method to add a book to the book arraylist
                System.out.print("Please enter bookID: ");
                bookID = scanner.nextLine();
                System.out.print("Please enter book title: ");
                title = scanner.nextLine();
                System.out.print("Please enter author's name: ");
                author = scanner.nextLine();
                Book book = new Book(bookID, title, author, true);
                bookManagement.addBook(book);
                System.out.println("Book" + book.getTitle() + " added successfully! ");
                System.out.println();
            }
            if (choice == 5) {
                // a method to delete a book from the book arraylist
                System.out.print("Please enter book ID: ");
                bookID = scanner.nextLine();
                if (bookManagement.deleteBook(bookID)) {
                    System.out.print("Book " + bookID + " deleted successfully! ");
                    System.out.println();
                } else {
                    System.out.println("Error: No book found with ID " + bookID);
                    System.out.println();
                }
            }
            if (choice == 6) {

                // a method to display all books from the book arraylist
                System.out.println("Displaying All Books");
                bookManagement.displayAllBooks();
                System.out.println();

            }

            if (choice == 7) {

                // a method to find a user from the user arraylist
                System.out.print("Please enter user ID to find user: ");
                userID = scanner.nextLine();

                if (userManagement.findUser(userID) == null) {
                    System.out.println("Error: No user found with ID " + userID);
                    System.out.println();
                } else {
                System.out.println("User found: " + userManagement.findUser(userID));
                    System.out.println();
                }

            }

            if (choice == 8) {

                System.out.print("Please enter book ID to find book: ");
                bookID = scanner.nextLine();

                if (bookManagement.findBook(bookID) == null) {
                    System.out.println("Error: No user found with ID " + bookID);
                    System.out.println();

                } else {

                    System.out.println("Book found: " + bookManagement.findBook(bookID));
                    System.out.println();

                }

            }
            if (choice == 9) {
                System.out.print("Are you sure you want to exit? (yes/no): ");
                userInput = scanner.nextLine();
                if (userInput.trim().equalsIgnoreCase("yes")) {
                    System.out.println("Thank you for using the Library Management System!");
                    break;
                }
            }


            System.out.print("Would you like to perform another operation? (yes/no): ");
            if (scanner.nextLine().trim().equalsIgnoreCase("no")) {
                System.out.println("Thank you for using the Library Management System!");
                break;
            }
        }
    }

}

