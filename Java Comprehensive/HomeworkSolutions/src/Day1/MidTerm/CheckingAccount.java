package MidTerm;
import java.text.NumberFormat;

public class CheckingAccount extends Account {
	
	NumberFormat currency=NumberFormat.getCurrencyInstance();
	private final double CHECKING_FEE=1.0;
	private double balanceAfterFeeDeduction;
	private double fee;
	public CheckingAccount(){
		super();
		balanceAfterFeeDeduction=0.0;
		
	}
	
	public double getFees(){
		
		return fee;
	}
	
	public String getFormattedFees(){
		return currency.format(getFees());
	}
	
	
	public double getInterestPayment(){
		return 0;
	}
	
	public String getFormattedInterestPayment(){
		return getInterestPayment()+"";
	}
	
	
	public void addInterest(){
		return;
	
	}
	
	public double minimumBalance(){
		return 1;
	}
	
	public void deductFee(){
		
		fee=CHECKING_FEE;
		
		balanceAfterFeeDeduction=super.getBalance()- fee;
		super.setBalance(balanceAfterFeeDeduction); 
		
	}
	
}
