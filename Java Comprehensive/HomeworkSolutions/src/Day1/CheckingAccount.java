import java.text.NumberFormat;

public class CheckingAccount extends Account {
	
	private final double CHECKING_FEE=1.0;
	//private double finalCheckingAccountBalance;
	//private double withdrawalAmount;
	//private double depositAmount;
	
	public CheckingAccount(){
		super();
		//=1;
		//finalCheckingAccountBalance=0.0;
	}
	
	public double getFees(){
		//NumberFormat currency=NumberFormat.getCurrencyInstance();
		return CHECKING_FEE;
	}
	
	public double getInterestPayment(){
		return 0;
	}
	/*public double getFinalCheckingAccountBalance(){
		return finalCheckingAccountBalance;
	}
	
	public void setFinalCheckingAccountBalance(double finalCheckingAccountBalance){
		this.finalCheckingAccountBalance=calculateFinalAccountBalance();
	}
	
	public double getWithdrawalAmount(){
		return this.withdrawalAmount;
	}
	
	public void setWithdrawalAmount(double withdrawalAmount){
		this.withdrawalAmount=withdrawalAmount;
	}
	
	public double getDepositAmount(){
		return this.depositAmount;
	}
	
	public void setDepositAmount(double depositAmount){
		this.depositAmount=depositAmount;
	}
	
	public double calculateFinalAccountBalance(){
		finalCheckingAccountBalance=super.getStartingBalance()-getWithdrawalAmount()+getDepositAmount()-CHECKING_FEE;
		return finalCheckingAccountBalance;*/
	
	public void addInterest(){
		super.setBalance(super.getBalance()+0); 
	}
	public void deductFee(){
		super.setBalance(super.getBalance()-CHECKING_FEE);
		
	}
	
}
