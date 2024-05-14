package AssignmentGroup;

import java.util.ArrayList;

public class UserManagement {
    private ArrayList<LibraryUser> users = new ArrayList<>();
 
    public UserManagement() {
        this.users = new ArrayList<>();
    }
 
    public void addUser(LibraryUser user) {
        users.add(user); 
    }
 
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
 
    public LibraryUser findUser(String userID) {
        for (LibraryUser user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;
    }
 
    public void displayAllUsers() {
        int numberList = 0;
		for(LibraryUser user : users) {
            numberList++;
			System.out.println(numberList + ". " + user.getName() + ", Age: " + user.getAge() +
                    ", User ID: " + user.getUserID());
		}
    }
}