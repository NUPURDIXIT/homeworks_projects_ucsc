package Day4;
import java.util.Scanner;
public class ValidatorTestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		OOValidator oovalidatorObj=new OOValidator(sc);
		MyValidator myValidatorObj=new MyValidator();
		System.out.println("Welcome to the Validation Tester Application");
		System.out.println();
		System.out.println("Int Test");
		int intInput=oovalidatorObj.getIntWithinRange("Enter an integer between -100 and 100: ",-100,100);
		
		System.out.println();
		System.out.println("Double Test");
		double doubleInput=oovalidatorObj.getDoubleWithinRange("Enter an integer between -100 and 100: ",-100,100);
		
		System.out.println();
		System.out.println("Require String Test");
		String stringInput=myValidatorObj.getRequiredString("Enter your email address: ");
		
		System.out.println();
		System.out.println("required Choice Test");
		String choiceInput=myValidatorObj.getChoiceString("Select one (x/y) :","x","y");
	}

}
