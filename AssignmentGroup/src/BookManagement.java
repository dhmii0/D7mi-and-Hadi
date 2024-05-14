package AssignmentGroup;

//To use arraylists, we need to import it from  java.util library
import java.util.ArrayList;

public class BookManagement {

	//creating a list of managed books
	private ArrayList<Book> books = new ArrayList<>();

	//This is a constructor to store values into the arrayList
	public BookManagement() {
		this.books = new ArrayList<>();
	}

	//method for adding books
	public void addBook(Book book) {
		books.add(book);
	}

	//This is a method to delete books, and checks if a book exists first
	public boolean deleteBook(String bookID) {
		for (Book book : books) {
			if (book.getBookID().equals(bookID)) {
				books.remove(book);
				System.out.println("Book " + book.getTitle() + " deleted successfully! ");
				return true;
			}
		}
		return false;
	}

	//method to allow user to search for a book
	public Book findBook(String bookID) {
		for (Book book : books) {
			if (book.getBookID().equals(bookID)) {
				return book;
			}
		}
		return null;
	}

	//method to display all books
	public void displayAllBooks() {

		int numberList = 0;

		for (Book book : books) {
			numberList++;
			System.out.println(numberList + ". " + book.getTitle() + " by " + book.getAuthor());
		}
	}
}
