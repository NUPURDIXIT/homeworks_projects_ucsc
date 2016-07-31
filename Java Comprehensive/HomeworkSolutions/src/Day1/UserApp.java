import Day3.Validator;

import java.text.NumberFormat;
import java.util.Scanner;

public class UserApp {
	
	static boolean  flagToEndTransaction=false;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		performTransactions();
		/*if(flagToEndTransaction)
		{	
			printFeeAndInterestEarned();
			printFinalBalance(flagToEndTransaction);
		}*/
	}
	
	public static void performTransactions(){
		boolean flag=false;
		String choice="y";
		double amount=0;
		Scanner sc=new Scanner(System.in);
	
		Account checking=new CheckingAccount();
		Account savings=new SavingsAccount();
		
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
				flag=false;
				if(choiceToWithdrawOrDeposit.equals("w")){
					while(!flag){
						if(amount>checking.getBalance()){
							System.out.println("Overdraft is not allowed, please withdraw amount less than your current balance\n ");
							amount=Validator.getDouble(sc, "Amount?");
							
						}
						else{
							flag=true;
						}
					}
					checking.withdraw(amount);
				}
				else{
					
					checking.deposit(amount);
				}
			}
			else{
				
				if(choiceToWithdrawOrDeposit.equals("w")){
					flag=false;
					while(!flag){
						if(amount>savings.getBalance()){
							System.out.println("Overdraft is not allowed, please withdraw amount less than your current balance\n ");
							amount=Validator.getDouble(sc, "Amount?");
							
						}
						else{
							flag=true;
						}
					}
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
		//NumberFormat currency=NumberFormat.getCurrencyInstance();
		System.out.println("\nMonthly Payment and Fees");
		
		System.out.println("Checking fee:              "+  checking.getFormattedFees()+"\n"+
				           "Savings interest payment:  "+savings.getFormattedInterestPayment());
		
		checking.finalBalance(flagToEndTransaction);
		savings.finalBalance(flagToEndTransaction);
				
		System.out.println("\nFinal Balances\n"
				+ "Checking:  "+checking.getFormattedBalance()+"\n"+
				  "Savings:   "+savings.getFormattedBalance());
		
		//System.out.println("\nFinal Balances\n"
		//					+ "Checking:  "+currency.format(checking.getBalance())+"\n"+
		//					  "Savings:   "+currency.format(savings.getBalance()));
		//return flagToEndTransaction;
	}
}
	
	/*
	public static void printFeeAndInterestEarned(){
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		System.out.println("\nMonthly Payment and Fees");
		
		System.out.println("Checking fee:   "+currency.format(checking.getFees())+"\n"+
				"Savings interest payment:  "+currency.format(savings.getInterestPayment()));
		
	}
	
	public static void printFinalBalance(boolean flagToEndTransaction){
		
		checking.finalBalance(flagToEndTransaction);
		savings.finalBalance(flagToEndTransaction);
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		
		System.out.println("\nFinal Balances\n"
							+ "Checking: "+currency.format(checking.getBalance())+"\n"+
							  "Savings:  "+currency.format(savings.getBalance()));
	
							
	}*/


