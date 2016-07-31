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
