
public abstract class Person {
	private String firstName;
	private String lastName;
	private String emailAddress;
	public Person(){
		firstName="";
		lastName="";
		emailAddress="";
	}
	
	public Person(String firstName,String lastName,String emailAddress){
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailAddress=emailAddress;
	}
	
	//get the first name
	public String getFirstName(){
		return firstName;
	}
	
	//get the last name
	public String getLastName(){
		return lastName;
	}
	
	//get the email address
	public String getEmailAddress(){
		return emailAddress;
	}
	
	
	//set the first name
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}
	
	//set the last name
	public void setLastName(String lastName){
		this.lastName=lastName;
	}
	
	
	//set the email address
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	
	
	public String toString(){
		return "\nYou entered: \n"+
				"Name: "+getFirstName()+" "+getLastName()+"\n"+
				"Email: "+getEmailAddress()+"\n";
	}
	
	protected abstract String getDisplayText();
}
