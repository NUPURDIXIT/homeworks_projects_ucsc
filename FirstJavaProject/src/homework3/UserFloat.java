package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: This program will give the user prompt to enter two float (or double) values. 
// 			   If the values input are correct then display the input two values. 
//			   If user enters characters instead of numbers or if they enter invalid numbers 
//		       then the program will display the error message and ask the user to re-enter the correct values
//			   again. It only exits when the correct input is received and displayed.

import java.util.Scanner;
public class UserFloat {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		String value1,value2;
		double floatValue1,floatValue2;
		System.out.print("Please enter two float numbers separated by space and press enter: ");
		//Exception Handling for NumberFormatException which may arise while converting string to double
		do{
			//Prompts user to enter two String values which are then converted to float variables
			value1=input.next();
			value2=input.nextLine();
			try{
				//convert the string to double 
				floatValue1=Double.parseDouble(value1);
				floatValue2=Double.parseDouble(value2);
				break;
			}catch(final NumberFormatException e){
				System.out.print("\nError reading your input.Please try again:");
				//input.nextLine();
			}
		}while(true);
		
		//Display the successful message
		System.out.println("\nYou entered"+" " +floatValue1+" "+"and"+" "+floatValue2+" "+"successfully");
		System.out.println("Press enter key to continue . . .");
		input.nextLine();
	}

}
