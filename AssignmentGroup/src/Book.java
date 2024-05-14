package AssignmentGroup;

public class Book {

	//these are attributes
	private String bookID;
	private String title;
	private String author;
	private boolean isAvailable;

	//This is a constructor to store values in the attributes
	public Book(String bookID, String title, String author) {
		this.bookID = bookID;
		this.author = author;
		this.title = title;
	}

	//This is a method to get book ID
	public String getBookID() {
		return bookID;
	}

	//a method to get Title
	public String getTitle() {
		return title;
	}

	//a method to get Author
	public String getAuthor() {
		return author;
	}


	//a method to check if book is available
	public  boolean isAvailable () {
		return isAvailable;
	}

	//a method to mark a book as unavailable
	public void toggleAvailability (boolean isAvailable) {
		isAvailable =! isAvailable;
	}

	//This is a method to display messages.
	public String toString() {
		return title + " by " + author;
	}
 
 
}
