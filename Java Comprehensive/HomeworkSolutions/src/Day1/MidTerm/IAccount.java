//Name: 	   Nupur Dixit
//Instructor:  Bineet Sharma
//Date: 	   Aug 6,2016
//Description: The project is about a Bank Transactional System,thus this interface ensures that the methods deposit,withdraw,addInterest,
//	           deductFee,getFees and getInterestPayment gets declared in the class implementing it.

package MidTerm;

public interface IAccount {
	public abstract double deposit(double amount);
	public abstract double withdraw(double amount);
	public abstract void addInterest();
	public abstract void deductFee();
	public abstract double getFees();
	public abstract double getInterestPayment();
}
