//Name: 	   Nupur Dixit
//Instructor:  Bineet Sharma
//Date: 	   Aug 6,2016
//Description: This program is the child class of Accounts class. It has a Interest rate of 1% which is charged at the end of transaction
//			   for this type of account only.It calculates the updated balance after applying the rate and calls parent class to which sets the
//			   balance.Minimum balance to maintain this type of account is 0, which is passed to the parent class for implementing the 
//		       overdraft feature.

package MidTerm;
import java.text.NumberFormat;

public class SavingsAccount extends Account {
	NumberFormat currency=NumberFormat.getCurrencyInstance();
	private final double savingsMonthlyInterestRate = 1.0;
	private double savingsInterestPayment;
		
	public SavingsAccount(){
		super();
		savingsInterestPayment=0.0;
	}
	
	public void addInterest(){
		savingsInterestPayment=(savingsMonthlyInterestRate/100)*(super.getBalance()); 
		double balanceAfterInterest=super.getBalance() + savingsInterestPayment;
		super.setBalance(balanceAfterInterest);
		
	}
	
	public void deductFee(){
		super.setBalance(super.getBalance()-0);
		
	}
	
	public double getFees(){
		return 0;
	}
	public String getFormattedFees(){
		return getFees()+"";
	}
	
	public double  getInterestPayment(){
		return savingsInterestPayment;
	}
	
	public double minimumBalance(){
		return 0;
	}
	
	public String getFormattedInterestPayment(){
		return currency.format(getInterestPayment());
	}
}
