package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


import problemdomain.User;

public class BankSystemManager {
	
	private final String DATABASE = "res/database.txt";
	private Scanner keyboard;
	private UserManager userManager; // array gets created at the beginning, doesn't have to be remade every time 
	
	public BankSystemManager() {
		keyboard = new Scanner(System.in);
		userManager = new UserManager();
		DisplayBankMenu();
	}
	
	// display menu
	public void DisplayBankMenu() {
		boolean running = true; 
		
		while (running) {
			System.out.println("Welcome to Gwingotts!");
			System.out.println("Choose an option to get started:");
			System.out.println("1 - Manage an existing account");
			System.out.println("2 - Create a new account");
			System.out.println("3 - Exit\n");
			
			int option = -1; // default invalid value
			while (true) {
			    System.out.print("Enter an option: ");
			    
			    if (keyboard.hasNextInt()) {
			        option = keyboard.nextInt();
			        keyboard.nextLine(); // consume leftover newline
			        break; // valid input, exit loop
			    } else {
			        System.out.println("Invalid input. Please enter a number (1-3).");
			        keyboard.nextLine(); // consume the invalid input
			    }
			}
			if (option == 1) {
				System.out.print("\nEnter the ID of the user you would like to edit:\n");

				int userId = keyboard.nextInt();
				boolean found = false;
				User user = new User();
				
				for (User u : userManager.getUsers()) {
					if (u.getId() == userId) {
						System.out.println(u);
						found = true;
						user = u;
					}
				}
				
				if (!found || user == null) {
					System.out.println("User not found. Please try again.\n");
					continue;
				}
				
				// TODO: add exception if user doesn't exist
				
				boolean managingUser = true;

				while (managingUser) {
					System.out.println("\nManage existing account:");
				    System.out.println("1 - Edit account");
				    System.out.println("2 - Check account balance");
				    System.out.println("3 - Withdraw");
				    System.out.println("4 - Deposit");
				    System.out.println("5 - Save & exit");    
				    System.out.println("\nEnter an option:");

				    int manageOption = keyboard.nextInt();
				    keyboard.nextLine(); // consume newline

				    if (manageOption == 1) {
				        manageAccount(user);
				        saveFile();    
				    }
				    else if (manageOption == 2) {
				        checkBalance(user);
				    }
				    else if (manageOption == 3) {
				        withdraw(user);
				        saveFile();    
				    }
				    else if (manageOption == 4) {
				        deposit(user);
				        saveFile();    
				    }
				    else if (manageOption == 5) {
				        saveFile();
				        System.out.println("\nReturning to main menu...\n");
				        managingUser = false; // sends you back to main menu
				    }
				    else {
				        System.out.println("Invalid entry. Please enter a valid option (1-5).");
				    }
				}
			}

			else if (option == 2) {
				User user = userManager.createUser();
				saveFile();	
			}
			
			else if (option == 3) {
				running = false; // stops loop and ends program
				System.out.println("Thank you for using Gwingotts!");
			}
			
			else {
				System.out.println("Invalid input. Please enter a valid option (1-3).");
				keyboard.nextLine();
			}
		}
	}

	// create new user account - first name, last name, address, phone number, account balance
	// edit user account
	// delete user account
	public void manageAccount(User user) {
		userManager.displayUserManagerMenu(user);
	}
	
	// check balance 
	public void checkBalance(User user) {
		float balance = user.getAccountBalance();
		System.out.println("\nAccount balance: " + balance + "\n");
	}
	
	// withdraw 
	public void withdraw(User user) {
		System.out.println("Enter the amount to withdraw: ");
		int withdrawAmount = keyboard.nextInt();
		keyboard.nextLine();
		
		user.setAccountBalance(user.getAccountBalance() - withdrawAmount);
		System.out.println("Remaining balance: " + user.getAccountBalance());
	}
	
	// deposit
	public void deposit(User user) {
		System.out.println("Enter the amount to deposit: ");
		int depositAmount = keyboard.nextInt();
		keyboard.nextLine();
		
		user.setAccountBalance(user.getAccountBalance() + depositAmount);
		System.out.println("\nNew balance: " + user.getAccountBalance());
	}
	
	// save database
	public void saveFile() {
		System.out.println("\nSaving to file...\n");
		File file = new File(DATABASE);
		try 
		{
			PrintWriter outFile = new PrintWriter(file);
			for(User u : userManager.getUsers())
			{
				outFile.println(u.formatForFile());
			}
			outFile.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

}
