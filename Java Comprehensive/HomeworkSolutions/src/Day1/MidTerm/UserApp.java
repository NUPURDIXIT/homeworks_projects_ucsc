package MidTerm;
import java.text.NumberFormat;
import java.util.Scanner;

public class UserApp {
	static Account checking=new CheckingAccount();
	static Account savings=new SavingsAccount();
	static boolean  flagToEndTransaction=false;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		performTransactions();
		if(flagToEndTransaction)
		{	
			checking.finalize(flagToEndTransaction);
			savings.finalize(flagToEndTransaction);
			printFeeAndInterestEarned();
			printFinalBalance();
		}
	}
	
	public static void performTransactions(){
		
		String choice="y";
		double amount=0;
		Scanner sc=new Scanner(System.in);
			
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		
		System.out.println("Welcome to the Account application\n");
		
		System.out.println("Starting Balances"); 
				
		System.out.println("Checking:  "+checking.getFormattedBalance()+"\n"+
		                   "Savings:   "+savings.getFormattedBalance());
		
		System.out.println("\nEnter the transactions for the month\n");
		
		while(choice.equalsIgnoreCase("y")){
			String choiceToWithdrawOrDeposit=Validator.getChoiceString(sc, "Withdrawal or deposit? (w/d): ", "w", "d");
			String choiceOfAcountType=Validator.getChoiceString(sc, "Checking or savings? (c/s): ", "c", "s");
			
			amount=Validator.getDouble(sc, "Amount?: ");
			
			System.out.println();
			
			if(choiceOfAcountType.equals("c")){
				if(choiceToWithdrawOrDeposit.equalsIgnoreCase("w")){
					
					checking.withdraw(amount);
				}
				else{
					
					checking.deposit(amount);
				}
			}
			else{
				
				if(choiceToWithdrawOrDeposit.equalsIgnoreCase("w")){			
					savings.withdraw(amount);
				}
				else{
					savings.deposit(amount);
				}
			}
			
			choice=Validator.getChoiceString(sc, "Continue? (y/n): ", "y", "n");
			System.out.println();
		}
		flagToEndTransaction=true;
		
}
	
	
	public static void printFeeAndInterestEarned(){
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		System.out.println("\nMonthly Payment and Fees");
		
		System.out.println("Checking fee:   "+checking.getFormattedFees()+"\n"+
				"Savings interest payment:  "+savings.getFormattedInterestPayment());
		
	}
	
	public static void printFinalBalance(){
		
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		
		System.out.println("\nFinal Balances\n"
							+ "Checking: "+checking.getFormattedBalance()+"\n"+
							  "Savings:  "+savings.getFormattedBalance());
	
							
	}
}


