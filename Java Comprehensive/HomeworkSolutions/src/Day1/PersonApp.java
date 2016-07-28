
public class PersonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String choiceToContinue="y";
		//Person personObj=new Person();
		Customer customerObj=new Customer();
		Employee employeeObj=new Employee();
		MyValidator myValidatorObj=new MyValidator();
		System.out.println("Welcome to the Person Tester Application");
		System.out.println();
		
		while(choiceToContinue.equalsIgnoreCase("y")){
			String choice=myValidatorObj.getChoiceString("Create Customer or Employee? (c/e): ", "c", "e");
			String inputFirstName=myValidatorObj.getRequiredString("Enter first name: ");
			String inputLastName=myValidatorObj.getRequiredString("Enter last name: ");
			String inputEmailAddress=myValidatorObj.getRequiredString("Enter email address: ");
						
			if(choice.equalsIgnoreCase("c")){
				customerObj.setFirstName(inputFirstName);
				customerObj.setLastName(inputLastName);
				customerObj.setEmailAddress(inputEmailAddress);
				String inputCustomerNumber=myValidatorObj.getRequiredString("Customer Number: ");
				customerObj.setCustomerNumber(inputCustomerNumber);
				
				String displayCustomerText=customerObj.getDisplayText();
				System.out.println(displayCustomerText);
			}
			else{
				employeeObj.setFirstName(inputFirstName);
				employeeObj.setLastName(inputLastName);
				employeeObj.setEmailAddress(inputEmailAddress);
				String inputSocialSecurityNumber=myValidatorObj.getRequiredString("Enter Social Security Number: ");
				employeeObj.setSocialSecurityNumber(inputSocialSecurityNumber);
				String employeeDisplayText=employeeObj.getDisplayText();
				System.out.println(employeeDisplayText);
			}
			choiceToContinue=myValidatorObj.getChoiceString("Continue? (y/n): ", "y", "n");
			
			System.out.println();
			
		}
			
		
	}

}
