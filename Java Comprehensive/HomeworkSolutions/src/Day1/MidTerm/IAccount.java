package MidTerm;

public interface IAccount {
	double amount=0.0;
	public abstract double deposit(double amount);
	public abstract double withdraw(double amount);
	public abstract void addInterest();
	public abstract void deductFee();
	public abstract double getFees();
	public abstract double getInterestPayment();
}
