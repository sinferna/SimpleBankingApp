package manager;

import java.util.Scanner;

public class BankSystemManager {
	
	private final String DATABASE = "res/database.txt";
	
	private Scanner keyboard;
	
	// display menu
	public void DisplayMenu() {
		while(true) {
			System.out.println("1 - Create new account");
			System.out.println("2 - Check account balance");
			System.out.println("3 - Withdraw");
			System.out.println("4 - Deposit");
			System.out.println("5 - Save & exit");
			
			keyboard = new Scanner(System.in);
			System.out.println("Enter an option");
			int option = keyboard.nextInt(); // holds whatever int the user enters
			
			if (option == 1) {
				createAccount();
			}
		
			if (option == 2) {
				checkBalance();
			}
			
			if (option == 3) {
				withdraw();
			}
			
			if (option == 4) {
				deposit();
			}
			
			if (option == 5) {
				saveFile();
			}
			
			else {
				System.out.println("Invalid input. Please enter a valid option (1-5).");
			}
		}
	}
	
	// create new user account - first name, last name, address, phone number, account balance
	public void createAccount() {
		
	}
	
	// check balance 
	public void checkBalance() {
		
	}
	
	// withdraw 
	public void withdraw() {
		
	}
	
	// deposit
	public void deposit() {
		
	}
	
	// save database
	public void saveFile() {
		
	}

}
