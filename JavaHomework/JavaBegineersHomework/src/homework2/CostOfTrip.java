package homework2;
//Name: Nupur Dixit
//Instructor: Bineet Sharma
//Date: April 28,2016
//Description: This code calculates the total cost of the trip by asking user
//             to enter the driving distance,fuel efficiency in miles per gallon
//             and price of the fuel per gallon.

import java.util.Scanner;
public class CostOfTrip {

	public static void main(String[] args) {
		
		// Create Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts the user to enter driving distance
		System.out.print("Enter the driving distance:");
		double drivingDistance= input.nextDouble();
		
		//Prompts user to enter the fuel efficiency in miles per gallon
		System.out.print("Enter miles per gallon:");
		double milesPerGallon = input.nextDouble();
		
		//Prompts user to enter the price of the fuel per gallon
		System.out.print("Enter price per gallon:");
		double pricePergallon = input.nextDouble();
		
		//Calculating the cost of trip
		double costOfDriving=(drivingDistance * pricePergallon)/milesPerGallon;
		
		//Formatting the cost to two places of decimal
		costOfDriving=(int)(costOfDriving*100)/100.0;
		
		//Printing the total dollars spent on the trip
		System.out.println("The cost of driving is $" + costOfDriving);
	}

}
