package AssignmentGroup;

import java.util.ArrayList;
public class LibraryUser extends Person {
	private String userID;
	private ArrayList<Book> borrowedBooks = new ArrayList<>();
	public LibraryUser(String name, int age, String userID) {
		super(name, age);
		this.userID = userID;
	}
	public String getUserID() {
		return userID;
	}
	
	 public void borrowBook(Book book) {
		borrowedBooks.add(book);

	} 
	
	public boolean returnBook(String bookID) {
		for (Book book : borrowedBooks) {
			if (book.getBookID().equals(bookID)) {
				borrowedBooks.remove(book);
				return true;
			}
		}
		return false;
	}
	
	public void listBorrowedBooks() {
		System.out.printf("%-30s%-10s%-12s", "Book ID", "Title", "Author");
		System.out.println();
 
		for(Book book : borrowedBooks) {
			System.out.printf("%-30s%-10s%-12s", book.getBookID(), book.getTitle(), book.getAuthor());
			System.out.println(); 
		}
	}


	public String toString() {
		return super.getName() + ", Age: " + super.getAge() + ", User ID: " + getUserID();
	}
}
