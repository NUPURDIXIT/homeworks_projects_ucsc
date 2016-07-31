import java.text.NumberFormat;

public abstract class Account implements IAccount{
	private double balance;
	
	
	public Account(){
		balance=1000.0;		
	}
		
	public void setBalance(double balance){
		this.balance=balance;
	}
	
	public double deposit(double amount){
		balance= balance+ amount;
		return balance;
	}
	
	public double withdraw(double amount){
		balance=balance-amount;
		return balance;
	}
	
	public double getBalance(){
		if(balance<0){
			balance=0.0;
		}
		return balance;
	}
	
	public void finalBalance(boolean flag){
		if(flag)
			deductFee();
			addInterest();
	}
	
	public abstract void addInterest();
	public abstract void deductFee();
	public abstract double getFees();
	public abstract double getInterestPayment();
	
	public String getFormattedBalance(){
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		return currency.format(balance);
	}
	
	public String toString(){
		NumberFormat currency=NumberFormat.getCurrencyInstance();
		return "Checking: "+ currency.format(balance)+"\n"
				+ "Savings: "+currency.format(balance);
	}
	
}
