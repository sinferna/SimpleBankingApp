package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import problemdomain.User;

public class UserManager {
	private final String DATABASE = "res/database.txt";
	private ArrayList<User> users;
	private Scanner keyboard;
	
	public UserManager() {
		// users needs to be initialized first otherwise if load...() is first users will still be null
		// and load...() will take in a null users array 
		users = new ArrayList<>();
		keyboard = new Scanner(System.in);
		loadUsersFromFile();
	}
	
	public void loadUsersFromFile() {
		File file = new File(DATABASE);
		
		try {
			Scanner inFile = new Scanner(file);
			while (inFile.hasNext()) {
				String line = inFile.nextLine();
				String[] fields = line.split(";");
				
				int id = Integer.parseInt(fields[0]);
				String firstName = fields[1];
				String lastName = fields[2];
				String address = fields[3];
				String phoneNumber = fields[4];
				float accountBalance = Float.parseFloat(fields[5]);
				
				users.add(new User(id, firstName, lastName, address, phoneNumber, accountBalance));
			}
			inFile.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	public void displayUserManagerMenu(User user) {
	    boolean managingAccount = true;

	    while (managingAccount) {
	        System.out.println("\n1 - Edit account details");
	        System.out.println("2 - Delete account");
	        System.out.println("3 - Back\n");

	        System.out.print("Enter an option: ");
	        int option = keyboard.nextInt();
	        keyboard.nextLine();

	        if (option == 1) {
	            editUser(user);
	        }
	        else if (option == 2) {
	            deleteUser(user);
	            managingAccount = false; // go back after delete
	        }
	        else if (option == 3) {
	            managingAccount = false; // go back to account menu
	        }
	        else {
	            System.out.println("Invalid entry. Please enter a valid option (1-3).");
	        }
	    }
	}
	
	// create
	public User createUser() {
		System.out.println("Enter a unique id: "); 
		// TODO: create way to randomize later
		
		int id = keyboard.nextInt();
		keyboard.nextLine(); // consumes new line that is created after user presses enter
		
		System.out.println("Enter your first name: ");
		String firstName = keyboard.nextLine();
		
		System.out.println("Enter your last name: ");
		String lastName = keyboard.nextLine();
		
		System.out.println("Enter your address: ");
		String address = keyboard.nextLine();
		
		System.out.println("Enter your phone number: ");
		String phoneNumber = keyboard.nextLine();
		
		User user = new User(id, firstName, lastName, address, phoneNumber, 0.0f);
		users.add(user);
		
		// TODO: add exception if duplicate entry exists
		
		return user;
	}
	
	// edit
	public void editUser(User user) {		
		System.out.println("\nSelect the field you would like to edit: ");
		System.out.println("1 - First Name");
		System.out.println("2 - Last Name");
		System.out.println("3 - Address");
		System.out.println("4 - Phone number\n");
		System.out.print("Enter an option: ");
		
		int option = keyboard.nextInt();
		keyboard.nextLine();
		
		if (option == 1) {
			System.out.print("Enter new first name: ");
			user.setFirstName(keyboard.nextLine());
		}
		else if (option == 2) {
			System.out.print("Enter new last name: ");
			user.setLastName(keyboard.nextLine());
		}
		else if (option == 3) {
			System.out.print("Enter new address: ");
			user.setAddress(keyboard.nextLine());
		}
		else if (option == 4) {
			System.out.print("Enter new phone number: ");
			user.setPhoneNumber(keyboard.nextLine());
		}
		else {
			System.out.println("Invalid entry. Please enter a valid option (1-4).");
		}
		
		// TODO: add input restrictions (correct address/phone number format, no special characters in name, etc.)
		
	}
	
	// delete
	public void deleteUser(User user) {
		boolean found = users.removeIf(u -> u.getId() == user.getId()); // u is each user in the array
	}
	
	// TODO: add delete confirmation
	
}
