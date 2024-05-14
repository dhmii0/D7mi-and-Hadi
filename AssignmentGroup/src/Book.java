package AssignmentGroup;

public class Book {
	 
	private String bookID;
	private String title;
	private String author;
	private boolean isAvailable;
 
	public Book(String bookID, String title, String author, boolean isAvailable) {
		this.bookID = bookID;
		this.author = author;
		this.title = title;
		this.isAvailable = isAvailable;
 
	}



	public String getBookID() {
		return bookID;
	}



	public String getTitle() {
		return title;
	}
 
 
	public String getAuthor() {
		return author;
	}
 
 
	public  boolean isAvailable () {
		return isAvailable;
	}
 
	public void toggleAvailability (boolean isAvailable) {
		isAvailable =! isAvailable;
	}
 
	public String toString() {
		return "Book [bookId=" + bookID + ", title=" + title + ", auther=" + author + ", isAvailable=" + isAvailable
				+ "]";
	}
 
 
}
