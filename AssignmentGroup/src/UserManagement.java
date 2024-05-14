package AssignmentGroup;

//To use arraylists, we need to import it from  java.util library
import java.util.ArrayList;

public class UserManagement {

    //this is an attribute
    private ArrayList<LibraryUser> users = new ArrayList<>();

    //This is a constructer to store users into the arraylist
    public UserManagement() {
        this.users = new ArrayList<>();
    }

    //This is a method to add users
    public void addUser(LibraryUser user) {
        users.add(user); 
    }

    //This is a method to delete users, and checks if a user exists first
    public boolean deleteUser(String userID) {
        for (LibraryUser user : users) {
            if (user.getUserID().equals(userID)) {
                users.remove(user);
                System.out.println("User " + user.getName() + " deleted successfully! ");
                return true;
            }
        }
        return false; 
    }

    //method to allow user to search for a user
    public LibraryUser findUser(String userID) {
        for (LibraryUser user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    //This method displays all users from the LibraryUser ArrayList
    public void displayAllUsers() {
        int numberList = 0;
		for(LibraryUser user : users) {
            numberList++;
			System.out.println(numberList + ". " + user.getName() + ", Age: " + user.getAge() +
                    ", User ID: " + user.getUserID());
		}
    }
}