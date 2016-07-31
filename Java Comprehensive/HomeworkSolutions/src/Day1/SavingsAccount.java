import java.text.NumberFormat;

public class SavingsAccount extends Account {
	
	//private double finalSavingsAccountBalance;
	private double savingsMonthlyInterestRate=1.0;
	
	
	public SavingsAccount(){
		super();
		//=1;
		//finalSavingsAccountBalance=0.0;
		savingsMonthlyInterestRate=1.0;
	}
	
	public void addInterest(){
		super.setBalance(super.getBalance()+(1.0/100)*(super.getBalance()));
	}
	
	public void deductFee(){
		super.setBalance(super.getBalance()-0);
		
	}
	
	public double getFees(){
		//NumberFormat currency=NumberFormat.getCurrencyInstance();
		return 0;
	}
	
	
	public double getInterestPayment(){
		//NumberFormat currency=NumberFormat.getCurrencyInstance();
		
		double savingsInterestPayment=(1.0/100)*(super.getBalance());
		//currency.format
		return savingsInterestPayment;
	}
	
	
	/*public double getFinalSavingsAccountBalance(){
		return finalSavingsAccountBalance;
	}
	
	public void setFinalSavingsAccountBalance(double finalCheckingAccountBalance){
		this.finalSavingsAccountBalance=calculateFinalAccountBalance();
	}
	
	public double getWithdrawalAmount(){
		return withdrawalAmount;
	}
	
	public void setWithdrawalAmount(double withdrawalAmount){
		this.withdrawalAmount=withdrawalAmount;
	}
	
	public double getDepositAmount(){
		return depositAmount;
	}
	
	public void setDepositAmount(double depositAmount){
		this.depositAmount=depositAmount;
	}*/
	
	
	
	
	/*public double calculateFinalAccountBalance(){
		finalSavingsAccountBalance=super.getStartingBalance()-getWithdrawalAmount()+getDepositAmount()+getSavingsInterestPayment();
		return finalSavingsAccountBalance;
	}*/
	
	
	
}
