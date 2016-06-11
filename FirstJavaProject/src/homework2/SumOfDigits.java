package homework2;
//Name        : Nupur Dixit
//Instructor  : Bineet Sharma
//Date        : April 28,2016
//Description : This code prompts user for a number between 0 and 1000 and 
//              thereafter calculates the sum of the digits and prints it.
//              If the number entered does not lie in the given range then nothing is calculated.

import java.util.Scanner;
public class SumOfDigits {

	public static void main(String[] args) {
		
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		//Prompt the user for input
		System.out.print("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		
		//Logic to check if the number lies in the range
		if(num > 0 && num < 1000){
			int num1=num/10; //first two digits are retrieved
			int num2=num%10; //third digit is retrieved
			
			//Sum of three digits
			int total=(num1/10)+(num1%10)+num2;
			
			//Display Result
			System.out.print("The sum of the digits is " + total);
		}
			
		//Compute nothing if the number lies outside the range
		else{
			System.out.print("Number entered was not between 0 and 1000,thus exit");
		}
	}
}
