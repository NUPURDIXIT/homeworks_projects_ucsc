package Day3;
import java.util.Scanner;

import MidTerm.Validator;

public class CircleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String choice="y";
		int count=0;
		System.out.println("Welcome to the Circle Tester");
		System.out.println();
		while(choice.equalsIgnoreCase("y")){
			double AppRadius=Validator.getDouble(sc,"Enter radius: ");
			Circle circleObj=new Circle(AppRadius);
			count=circleObj.getObjectCount();
			System.out.println("Circumference :"+ circleObj.getFormattedCircumference());
			System.out.println("Area:          "+circleObj.getFormattedArea());
			choice=Validator.getChoice(sc, "Continue? (y/n) : " );
			System.out.println();
		}
		System.out.println("Goodbye.You created "+count+" circle object(s)");
	}

}
