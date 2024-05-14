package AssignmentGroup;

//To use arraylists, we need to import it from  java.util library
import java.util.ArrayList;

/*
This is a subclass from the super class Person
It inherits everything from the class Person
 */
public class LibraryUser extends Person {

	private String userID;
	private ArrayList<Book> borrowedBooks = new ArrayList<>();

	//This is a constructor to store values in the attributes. it uses attributes from the super Class
	public LibraryUser(String name, int age, String userID) {
		super(name, age);
		this.userID = userID;
	}

	//This method is used to get the user ID
	public String getUserID() {
		return userID;
	}

	//This method is used to store borrowed books in the borrowedBooks arraylist
	 public void borrowBook(Book book) {
		borrowedBooks.add(book);

	}

	//This method is used to return borrowed books from the borrowedBooks arraylist
	public boolean returnBook(String bookID) {
		for (Book book : borrowedBooks) {
			if (book.getBookID().equals(bookID)) {
				borrowedBooks.remove(book);
				System.out.println("Book " + book + " returned successfully!");
				return true;
			}
		}
		return false;
	}

	//This method lists all the borrowed books in the borrowedBooks arraylist
	public void listBorrowedBooks() {
		System.out.printf("%-30s%-10s%-12s", "Book ID", "Title", "Author");
		System.out.println();
		for(Book book : borrowedBooks) {
			System.out.printf("%-30s%-10s%-12s", book.getBookID(), book.getTitle(), book.getAuthor());
			System.out.println(); 
		}
	}

	//This is a method to display messages.
	public String toString() {
		return super.getName() + ", Age: " + super.getAge() + ", User ID: " + getUserID();
	}
}
