import java.util.List;
import java.util.Scanner;

import controller.AccountHelper;
import model.Account;

public class EnterProgramMenu {
	
	static Scanner scans = new Scanner(System.in);
	static AccountHelper acch = new AccountHelper();
	
	public static void main(String[] args) {
		startingMenu();
	}
	
	public static void addAccount() {
		String name = "";
		float balance = 0;
		System.out.println("'Create new account' selected");
		System.out.print("Please enter the name of the account (limit 20 characters): ");
		name = scans.nextLine();
		while(name.length()>20) {
			System.out.print("Name is too long; please enter a shorter name (limit 20 characters): ");
			name = scans.nextLine();
		}
		System.out.print("Please enter the starting balance of the new account: ");
		balance = scans.nextFloat();
		Account acc = new Account(name, balance);
		acch.insertAccount(acc);
	}
	
	public static void editAccount() {
		System.out.println("'Edit account' selected.");
		boolean quits = false;
		while(!quits) {
			System.out.println("\n\nPlease select an option from the following: ");
			System.out.println("  1  Edit Account Name");
			System.out.println("  2  Subtract from balance");
			System.out.println("  3  Add to balance");
			System.out.println("  4  Return to previous menu");
			System.out.print("  Enter a number: ");
			int selection = scans.nextInt();
			scans.nextLine();
			System.out.println();
			
			switch (selection) {
			case 1: 
				changeAccountName();
				break;
			case 2: 
				subtractAccountBalance();
				break;
			case 3: 
				addAccountBalance();
				break;
			case 4: 
				quits = true;
				System.out.println("Returning to previous menu.");
				break;
			default:
				System.out.println("Command not recognized; please try again.");
				break;
			}
		}
	}
		
	public static void changeAccountName() {
		System.out.println("'Change Account Name' selected.");
		System.out.print("Please enter the account's current name: ");
		String oldName = scans.nextLine();
		Account acc = new Account(oldName, 0);
		List<Account> list = acch.findAccount(acc);
		if(list.size()>0) {
			System.out.print("Please enter the new name of the account (limit 20 characters): ");
			String newName = scans.nextLine();
			while(newName.length()>20) {
				System.out.print("Name is too long; please enter a shorter name (limit 20 characters): ");
				newName = scans.nextLine();
			}
			Account newacc = new Account(newName, list.get(0).getAccount_balance());//there should be done better, but this works for now.
			newacc.setId(list.get(0).getId());
			acch.updateAccount(newacc);
		}else System.out.println("No account by that name was found.  Returning to previous menu.");
		
	}
	
	public static void subtractAccountBalance() {
		System.out.println("'Subtract Balance' selected.");
		System.out.print("Please enter the name of the account: ");
		String accName = scans.nextLine();
		Account acc = new Account(accName, 0);
		List<Account> list = acch.findAccount(acc);
		if(list.size()>0) {
			System.out.print("How much would you like to subtract from the account balance?: ");
			acc.setAccount_balance(list.get(0).getAccount_balance()-scans.nextFloat());
			acc.setId(list.get(0).getId());
			acch.updateAccount(acc);
		}else System.out.println("No account by that name was found.  Returning to previous menu.");
	}
	
	public static void addAccountBalance() {
		System.out.println("'Add Balance' selected.");
		System.out.print("Please enter the name of the account: ");
		String accName = scans.nextLine();
		Account acc = new Account(accName, 0);
		List<Account> list = acch.findAccount(acc);
		if(list.size()>0) {
			System.out.print("How much would you like to add from the account balance?: ");
			acc.setAccount_balance(list.get(0).getAccount_balance()+scans.nextFloat());
			acc.setId(list.get(0).getId());
			acch.updateAccount(acc);
		}else System.out.println("No account by that name was found.  Returning to previous menu.");
	}
	
	public static void deleteAccount() {
		System.out.println("'Delete account' selected.");
		System.out.print("Please enter the name of the account to be deleted: ");
		String accName = scans.nextLine();
		Account acc = new Account(accName, 0);
		List<Account> list = acch.findAccount(acc);
		if(list.size()>0)acch.deleteAccount(list.get(0));
		else System.out.println("No account by that name found.  Returning to previous menu.");
	}
	
	public static void viewAccounts() {
		System.out.println("Displaying all current accounts: ");
		List<Account> list = acch.getAllAccounts();
		System.out.println();
		for(Account acc : list) {
			System.out.println(acc.returnAccountDetatils());
		}
		System.out.println();
	}

	public static void startingMenu() {
		boolean quits = false;
		System.out.println("Starting finance program...");
		while (!quits) {
			System.out.println("\n\nSelect an accounts function");
			System.out.println("  1  Create new account");
			System.out.println("  2  Edit an account (add or subtract balance and change name)");
			System.out.println("  3  Delete an account");
			System.out.println("  4  View all accounts");
			System.out.println("  5  Exit program");
			System.out.print("  Enter a number: ");
			int selection = scans.nextInt();
			scans.nextLine();
			System.out.println();
			
			switch (selection) {
				case 1: 
					addAccount();
					break;
				case 2: 
					editAccount();
					break;
				case 3: 
					deleteAccount();
					break;
				case 4: 
					viewAccounts();
					break;
				case 5: 
					System.out.println("Exiting program...");
					quits = true;
					break;
				default:
					System.out.println("Command not recognized; please try again.");
					break;
			}

		}

	}
}
