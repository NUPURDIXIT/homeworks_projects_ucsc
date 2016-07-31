package MidTerm;
import java.text.NumberFormat;

public abstract class Account implements IAccount{
	private double balance;
	
	//Default constructor to set the starting balance as 1000
	public Account(){
		balance=1000.0;		
	}
	
	//This method sets the balance and is called after the fee is deducted/interest is added in the child classes.
	public void setBalance(double balance){
		this.balance=balance;
	}
	
	//This method updates the balance when some money is deposited by the user
	public double deposit(double amount){
		balance= balance+ amount;
		return balance;
	}
	
	//This method updates the balance when some money is withdrawn by the user
	public double withdraw(double amount){
		if(balance-amount<minimumBalance()){
			System.out.println("Overdraft is not allowed.You need to maintain a minimum balance of $1 for Checking and $0 for savings account'\n ");
		}
		else{
			balance=balance-amount;
		}
		return balance;
	}
	
	//Method to get the current balance. if the ba
	public double getBalance(){
		//if(balance<0){
		//	balance=0.0;
		//}
		return balance;
	}
	
	//This method is invoked when the user is done with the transaction.This is to ensure that the deduction of fee and addition of interest
	//is made just once at the end of transaction
	public void finalize(boolean flag){
		if(flag){
			deductFee();
			addInterest();
		}
	}
	
	public String getFormattedBalance(){
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		return currency.format(balance);
	}
	
	//abstract methods to add interest, deduct fees, get fees to be deducted, get the interest earned. these classes have been defined in the 
	//child classes ie. CheckingAccount and SavingsAccount
	public abstract void addInterest();
	public abstract void deductFee();
	public abstract double getFees();
	public abstract String getFormattedFees();
	public abstract String getFormattedInterestPayment();
	public abstract double minimumBalance();
	
	
	
	
	
}
