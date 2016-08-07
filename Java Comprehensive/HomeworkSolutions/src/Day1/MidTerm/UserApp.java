//Name: 	   Nupur Dixit
//Instructor:  Bineet Sharma
//Date: 	   Aug 6,2016
//Description: This program displays the feature which the user can use in order to perform transactions and finally see the balance in his
//	           accounts.The user would be first shown the starting balance of both current and savings account which would be always $1000 
//			   as per requirement.Next he would be asked whether he wants to withdraw or deposit money.Next prompt would be for from Current
//	  	       or Savings account.Next he would be asked to enter the amount.If the user wants to continue then he needs to enter 'y' or 'Y' 
//			   else 'n' or 'N' to end the transaction.If he enters 'n' or 'N', the he would be shown the Monthly payment and fees and then the 
//		       Final Balances in both the account.
//			   At any step if the user tries to enter anything not compliant with the requirements then would be thrown an error and would be
//			   given a chance to re-enter correct choice.

package MidTerm;
import java.util.Scanner;

public class UserApp {
	
	//Creating Account references for CheckingAccount and SavingsAccount objects(Polymorphism)
	static Account checking=new CheckingAccount();
	static Account savings=new SavingsAccount();
	
	public static void main(String[] args) {
		//This method would deal with user transactions
		performTransactions();
		
		//Once the user has finished all transactions then finalize method is called so that the fee is deducted and the interest is added
		//to the balance.
		
		checking.finalize();
		savings.finalize();
				
		//to print the monthly fees and interest rate and the final balance in both the accounts.
		
		printFeeAndInterestEarned();
		printFinalBalance();
		
	}
	
	public static void performTransactions(){
		//Initialize the choice to "y"
		String choice="y";
		//amount holds the value user enters to either deposit or withdraw
		double amount=0;
		
		//Scanner to ask for user's input
		Scanner sc=new Scanner(System.in);
				
		System.out.println("Welcome to the Account application\n");
		
		System.out.println("Starting Balances"); 
			
		//Display the starting balance by calling the getFormattedBalance method in parent class
		System.out.println("Checking:  "+checking.getFormattedBalance()+"\n"+
		                   "Savings:   "+savings.getFormattedBalance());
		
		System.out.println("\nEnter the transactions for the month\n");
		
		while(choice.equalsIgnoreCase("y")){
			//User is prompted to give choice for either withdraw or deposit. The choice is validated in Validator class.
			String choiceToWithdrawOrDeposit=Validator.getChoiceString(sc, "Withdrawal or deposit? (w/d): ", "w", "d");
			
			//User is prompted to give choice for either current or savings. The choice is validated in Validator class.
			String choiceOfAcountType=Validator.getChoiceString(sc, "Checking or savings? (c/s): ", "c", "s");
			
			//user is prompted to enter the amount to either withdraw or deposit.The value is validated in Validator class.
			amount=Validator.getDouble(sc, "Amount?: ");
			
			System.out.println();
			
			//if the choice is c or C, then perform operations on Checking account
			if(choiceOfAcountType.equalsIgnoreCase("c")){
				//If choice is w or W, then call method withdraw else deposit
				if(choiceToWithdrawOrDeposit.equalsIgnoreCase("w")){
					
					checking.withdraw(amount);
				}
				else{
					
					checking.deposit(amount);
				}
			}
			//if choice is s or S, then perform operations on savings account
			else{
				//If choice is w or W, then call method withdraw else deposit
				if(choiceToWithdrawOrDeposit.equalsIgnoreCase("w")){
					savings.withdraw(amount);
				}
				else{
					savings.deposit(amount);
				}
			}
			
			
			//user is prompted to enter whether to continue or not. this choice is validated in Validator class.
			choice=Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();
		}
}
	
	//Method to print the formatted fees and interest payment
	public static void printFeeAndInterestEarned(){
		
		System.out.println("\nMonthly Payments and Fees");
		
		System.out.println("Checking fee:              "+checking.getFormattedFees()+"\n"+
				           "Savings interest payment:  "+savings.getFormattedInterestPayment());
		
	}
	
	//Method to print the final balance in both the accounts
	public static void printFinalBalance(){
		
		System.out.println("\nFinal Balances\n"
							+ "Checking: "+checking.getFormattedBalance()+"\n"+
							  "Savings:  "+savings.getFormattedBalance());
	
	}
}


