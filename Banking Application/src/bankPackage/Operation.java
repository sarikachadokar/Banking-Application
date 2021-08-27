package bankPackage;

import java.util.Scanner;

public class Operation implements BankOperation {

	Scanner sc = new Scanner(System.in);
	double balance;
	double amount;
	double PreviousTransaction;
	String userName;
	UserLoginDetails userDetails = null;
	

	public Operation(String uName) {
		this.userName = uName;
		userDetails = new UserLoginDetails();
		userDetails.setUserName(userName);
		balance = userDetails.getbalance(userName);
	}
    @Override
	public void check_a_Balance() {
		System.out.println("balance" + balance);
	}
    @Override
	public void make_a_Deposit(double amount) {

		balance = balance + amount;
		PreviousTransaction = balance;
		userDetails.updateBalance(userName, balance);
		}

	@Override
	public void make_a_Withdrawal() {

		System.out.println("enter a amount you want to withdraw : ");
		amount = sc.nextDouble();
		if (amount <= balance) {
			balance = balance - amount;
			PreviousTransaction = -balance;
			userDetails.updateBalance(userName, balance);

		} else {
			System.err.println("Transaction cancelled due to insuffiesient balance");
		}
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public void viewPreviousTransaction() {
		// TODO Auto-generated method stub
		if (PreviousTransaction > 0) {
			System.out.println("Deposite : " + PreviousTransaction);
		} else if (PreviousTransaction < 0) {
			System.out.println("Withadrawal : " + Math.abs(PreviousTransaction));
		} else {
			System.out.println("invalid Transaction");
		}

	}

	@Override
	public void calculateIntrest() {
		// TODO Auto-generated method stub
		int principal, rate, time;
		double rateOfInterest;
		System.out.println("Enter Principal amount:  ");
		principal = sc.nextInt();
		System.out.println("Enter Rate  :  ");
		rate = sc.nextInt();
		System.out.println("Enter time :  ");
		time = sc.nextInt();
		rateOfInterest = (principal * rate * time) / 100;
		System.out.println("Rate Of Interest:  " + rateOfInterest);

	}

	@Override
	public void Exit_the_Application() {
		// TODO Auto-generated method stub
		System.out.println("Thank you for using servises. visit again ");
		System.exit(0);
	}

	public void show() {
		int choice;
		System.out.println("Operations");
		System.out.println("1. Check balance");
		System.out.println("2. Deposite");
		System.out.println("3. withdrow");
		System.out.println("4. view previous Transaction");
		System.out.println("5. Rate of Intrest");
		System.out.println("6. Exit");

		do {
			System.out.println(
					"-----------------------------------------------------------------------------------------");
			System.out.println("enter your choice");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();

			switch (choice) {
			case 1:

				check_a_Balance();
				System.out.println(
						"-----------------------------------------------------------------------------------------");

				break;
			case 2:

				System.out.println("enter an amount to deposit ");
				amount = sc.nextDouble();
				make_a_Deposit(amount);
				System.out.println(
						"-----------------------------------------------------------------------------------------");

				break;
			case 3:

				make_a_Withdrawal();
				System.out.println(
						"-----------------------------------------------------------------------------------------");

				break;
			case 4:

				viewPreviousTransaction();
				System.out.println(
						"-----------------------------------------------------------------------------------------");

				break;
			case 5:

				calculateIntrest();
				System.out.println(
						"-----------------------------------------------------------------------------------------");

				break;
			case 6:
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				break;

			default:
				System.out.println("Invalid choice ! please enter again...");
				System.out.println(
						"-----------------------------------------------------------------------------------------");
				break;

			}
		} while (choice != 6);

		Exit_the_Application();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("\n");

	}
}
