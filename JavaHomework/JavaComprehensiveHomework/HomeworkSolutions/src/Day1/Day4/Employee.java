package Day4;

public class Employee extends Person {
	String socialSecurityNumber;
	public Employee(){
		super();
	}
	
	public String getSocialSecurityNumber(){
		return socialSecurityNumber;
	}
	
	public void setSocialSecurityNumber(String SSN){
		this.socialSecurityNumber=SSN;
	}
	
	@Override
	public String getDisplayText(){
		return super.toString()+"SocialSecurityNumber: "+getSocialSecurityNumber()+"\n";
	}
	
}
