package Misc;
import java.util.Scanner;
public class ExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			double inputDouble = 0.0;
			boolean isValid = false;
			Scanner readInput=new Scanner(System.in);
			while (isValid == false){
				System.out.print("Please enter a double: ");
				if (readInput.hasNextDouble()){
					inputDouble = readInput.nextDouble();
					isValid = true;
				}
				else {
					System.out.println("Error! Invalid double. Try again.");
				}
			readInput.nextLine();// discard any other data
			}
		System.out.println("The float value enetered is : "+inputDouble);
	}

}
