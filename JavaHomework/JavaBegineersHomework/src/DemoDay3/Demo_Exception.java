package DemoDay3;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

//Exception handling examples.  

//Ultimeate: Write your own exception class
class MyOutOfRangeException extends Exception {
	MyOutOfRangeException(String message) {
		super(message);
	}
}

public class Demo_Exception {

	public static double getADouble(Scanner readInput){
	    double inputDouble = 0.0;
	    boolean isValid = false;
	    while (isValid == false){
	        System.out.print("Please enter a double: ");
	        if (readInput.hasNextDouble()){
	        		inputDouble = readInput.nextDouble();
	            isValid = true;
	        }
	        else {
	            System.out.println(
	                "Error! Invalid double. Try again.");
	        }
	        readInput.nextLine();       // discard any other data
	    }
	    return inputDouble;
	}

	public static int getAnInteger(Scanner readInput) {
		int inputInt;
		do { // Loop until we have correct input
			System.out.print("Enter an integer: ");
			try {
				inputInt = readInput.nextInt(); // waits for user input
				break; //if you are here, all is good
			} 
			catch (final InputMismatchException e) {
				System.out.println("Wrong input. Try again.");
				readInput.nextLine(); // discard non-int input
				continue; // keep looping until you found right onee
			}
		} while (true);
		return inputInt;
	}
	// Version 4 static method properly written with exception
	public static int getInputWithinRange(Scanner in) throws NullPointerException,
			                                       InputMismatchException,
			                                       NumberFormatException,
			                                       MyOutOfRangeException {
		int userChoice = 0;
		if (in == null) { // first check if the scanner reference is a null
			throw new NullPointerException("Null Scanner");
		}
		try { // now we are ready to parse integer
			System.out.print("Please enter a value between 1 to 5: ");
			userChoice = Integer.parseInt(in.next());
		} 
		catch (InputMismatchException e) {
			in.nextLine();
			throw e; // pass the buck
		}
		catch (NumberFormatException e) {
			in.nextLine();
			throw e; // pass the buck
		}
		// we come here only when a number is successfully read
		if (userChoice < 1 || userChoice > 5) {
			in.nextLine();
			throw new MyOutOfRangeException("Only choice of 1 to 5 is allowed");
		}
		// if we are here that means all is good
		return userChoice;
	}

	public static void main(String[] args) {
		int userChoice = 0;
		Scanner inputReader = new Scanner(System.in);
		System.out.println("getADouble called: " 
					+ getADouble(inputReader));
		
		System.out.println("getAnInteger called: " 
				+ getAnInteger(inputReader));

		//let us test our ultimate exception handling
		do {
			try {
				userChoice = getInputWithinRange(inputReader);
			}
			// order of catch is important
			catch (NullPointerException e) {
				System.out.print("Message: " + e.getMessage());
			} catch (MyOutOfRangeException e) {
				System.out.print("Message: " + e.getMessage());
			}
			catch (Exception e) {
				System.out.print("Catch all Exception ");
			}

			finally { // always exectued with our without catch
				if (userChoice == 0)
					System.out.println(", try again ...");
				else
					System.out.println("Your choice is: " + userChoice);
			}
		} while (userChoice == 0);
	}
}
