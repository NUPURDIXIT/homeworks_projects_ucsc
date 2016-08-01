package MidTerm;
import java.text.NumberFormat;

public class CheckingAccount extends Account {
	
	//Instance variables
	//checking fee which will be $1 
	private final double CHECKING_FEE=1.0;
	
	//This gives the balance after the fee is deducted for Checking Account
	private double balanceAfterFeeDeduction;
	
	//This gives the fee amount to be deducted.This is declared with an intention that if in future the criteria for fee calculation changes,
	//then the value could be computed and kept in this variable.
	private double fee;
	
	//Default constructor
	public CheckingAccount(){
		super();
		balanceAfterFeeDeduction=0.0;
	}
	
	//This method returns the fee to be dedcuted
	public double getFees(){
		return fee;
	}
	
	//This method returns the formatted fee
	public String getFormattedFees(){
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		return currency.format(getFees());
	}
	
	//This method just returns 0 since no interest rate is offered for Checking Account.Since this is an abstract method 
	//of the parent class , thus needs to be defined here
	public double getInterestPayment(){
		return 0;
	}
	
	//This method just formats the result returned by getInterestpayment().Since this is an abstract method 
	//of the parent class , thus needs to be defined here
	public String getFormattedInterestPayment(){
		return getInterestPayment()+"";
	}
	
	//This method doesn't return anything since no interest rate is offered for Checking Account.Since this is an abstract method 
	//of the parent class , thus needs to be defined here
	public void addInterest(){
		return;
	
	}
	
	//This method returns 1 since this is the required minimum balance for a checking account.
	public double minimumBalance(){
		return 1;
	}
	
	//This method calculates the fee to be deducted and then calculates the balance after the fee deduction, thus updates the balance by 
	//calling the setBalance of the parent class.
	public void deductFee(){
		fee=CHECKING_FEE;
		balanceAfterFeeDeduction=super.getBalance()- fee;
		super.setBalance(balanceAfterFeeDeduction); 
		
	}
	
}
