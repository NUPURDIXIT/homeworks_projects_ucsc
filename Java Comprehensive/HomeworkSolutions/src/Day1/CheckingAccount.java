import java.text.NumberFormat;

public class CheckingAccount extends Account {
	
	NumberFormat currency=NumberFormat.getCurrencyInstance();
	private final double CHECKING_FEE=1.0;
	
	public CheckingAccount(){
		super();
	}
	
	public double getFees(){
		
		return CHECKING_FEE;
	}
	
	public String getFormattedFees(){
		return currency.format(CHECKING_FEE);
	}
	
	
	public double getInterestPayment(){
		return 0;
	}
	
	public String getFormattedInterestPayment(){
		return "0";
	}
	
	
	public void addInterest(){
		super.setBalance(super.getBalance()+0); 
	}
	public void deductFee(){
		super.setBalance(super.getBalance()-CHECKING_FEE);
		
	}
	
}
