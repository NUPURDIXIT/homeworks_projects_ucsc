//Name: 	   Nupur Dixit
//Instructor:  Bineet Sharma
//Date: 	   Aug 6,2016
//Description: This program is the child class of Accounts class. It has a Interest rate of 1% which is charged at the end of transaction
//			   for this type of account only.It calculates the updated balance after applying the rate and calls parent class which sets the
//			   balance to the latest.Minimum balance to maintain this type of account is 0, which is passed to the parent class for implementing the 
//		       overdraft feature.


import java.text.NumberFormat;

public class SavingsAccount extends Account {
	NumberFormat currency=NumberFormat.getCurrencyInstance();
	private final double savingsMonthlyInterestRate = 1.0;
	private double savingsInterestPayment;
		
	public SavingsAccount(){
		super();
		savingsInterestPayment=0.0;
	}
	
	//Method to calculate the interest payment and the balance on adding the calculated Interest Payment.It then calls setBalance of parent class
	//so as to update the balance
	public void addInterest(){
		savingsInterestPayment=(savingsMonthlyInterestRate/100)*(super.getBalance()); 
		double balanceAfterInterest=super.getBalance() + savingsInterestPayment;
		super.setBalance(balanceAfterInterest);
		
	}
	
	//No fee is charged to this account, thus deduct 0 and set the balance
	public void deductFee(){
		super.setBalance(super.getBalance()-0);
		
	}
	
	//It returns the fee , since its 0 so just return 0.This is an abstract method of the parent class , thus needs to be defined here.
	public double getFees(){
		return 0;
	}
	
	//Return the fee in formatted manner.this is an abstract method of the parent class , thus needs to be defined here
	public String getFormattedFees(){
		return getFees()+"";
	}
	
	//This method returns the calculated Interest payment
	public double  getInterestPayment(){
		return savingsInterestPayment;
	}
	
	//This method returns the minimum balance to maintain this account which is 0
	public double minimumBalance(){
		return 0;
	}
	
	//This method returns the Interest payment in formatted manner
	public String getFormattedInterestPayment(){
		return currency.format(getInterestPayment());
	}
}
