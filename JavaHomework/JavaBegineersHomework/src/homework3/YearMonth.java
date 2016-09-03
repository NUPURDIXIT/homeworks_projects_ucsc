package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: Program that prompts a user to enter the year and the first three letters of the month 
//             with first letter in Uppercase and displays the number of days in month.

import java.util.InputMismatchException;
import java.util.Scanner;
public class YearMonth {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts user for the year
		System.out.print("Enter a year: ");
		try{
		int year=input.nextInt();
		
		//Prompts user for the month
		System.out.print("Enter the first three letter of the month(with first letter in Uppercase): ");
		String month=input.next();
		
		//Reyrieve the first letter of the month
		char ch=month.charAt(0);
		
		//If the user enters more than 3 letter
		if(month.length()>3 || Character.isLowerCase(ch)){
			System.out.print("\nPlease enter only first three letters of the month with first letter in Uppercase");
			System.exit(1);
		}
		
		//Logic to print the number of days in the asked month
		switch(month){
		case "Jan":
		case "Mar":
		case "May":
		case "July":
		case "Aug":
		case "Oct":
		case "Dec":
			System.out.print("\n"+month + " " + year + " " + "has 31 days");
			break;
			
		case "Apr":
		case "Jun":
		case "Sep":
		case "Nov":
			System.out.print("\n"+month + " "+ year + " " + "has 30 days");
			break;
			
		case "Feb":
			if ((year %4==0 && year%100!=0)  || year%400==0){
				System.out.print("\n"+month + " " + year + " " + "has 29 days");
			}
			else{
				System.out.print("\n"+month + " " + year + " " + "has 28 days");
			}
			break;
		default:
			System.out.println("\nInvalid month name entered");
			break;
		}
		}catch(final InputMismatchException e){
			System.out.println("Invalid year entered");
			input.nextLine();
		}
	}
}
