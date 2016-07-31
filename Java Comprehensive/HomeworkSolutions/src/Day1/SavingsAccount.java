import java.text.NumberFormat;

public class SavingsAccount extends Account {
	NumberFormat currency=NumberFormat.getCurrencyInstance();
	private double savingsMonthlyInterestRate=1.0;
	private double savingsInterestPayment;
	
	public SavingsAccount(){
		super();
		savingsMonthlyInterestRate=1.0;
		savingsInterestPayment=0.0;
	}
	
	public void addInterest(){
		super.setBalance(super.getBalance()+(1.0/100)*(super.getBalance()));
	}
	
	public void deductFee(){
		super.setBalance(super.getBalance()-0);
		
	}
	
	public double getFees(){
		return 0;
	}
	public String getFormattedFees(){
		return "0";
	}
	
	public double getInterestPayment(){
		double savingsInterestPayment=(1.0/100)*(super.getBalance());
		return savingsInterestPayment;
	}
	
	public String getFormattedInterestPayment(){
		return currency.format(getInterestPayment());
	}
}
