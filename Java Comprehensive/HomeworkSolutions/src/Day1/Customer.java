
public class Customer extends Person {
	
	String customerNumber;
	public Customer(){
		super();
	}
	
	public String getCustomerNumber(){
		return customerNumber;
	}
	
	public void setCustomerNumber(String custNumber){
		this.customerNumber=custNumber;
	}
	
	@Override
	public String getDisplayText(){
		return super.toString()+
				"Customer Number: "+getCustomerNumber()+"\n";
	}
	
	
}
