package Homework4;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 15,2016
//Description: This program would ask user to enter time in milliseconds and return 
//			   the string as hours:minute:seconds.

import java.util.Scanner;
public class ConvertMillis {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompt user to enter time in milliseconds
		System.out.println("Enter the time in milliseconds");
		long millis=input.nextLong();
		
		//Call static method to convert the time in format hours:minute:seconds
		convertMillis(millis);
	}
	
	//Method to convert the time in format hours:minute:seconds
	public static String convertMillis(long millis){
		
	    long totalSeconds = millis / 1000;

	    // Compute the current second in the minute in the hour
	    long currentSecond = totalSeconds % 60;

	    // Obtain the total minutes
	    long totalMinutes = totalSeconds / 60;

	    // Compute the current minute in the hour
	    long currentMinute = totalMinutes % 60;

	    // Obtain the total hours
	    long totalHours = totalMinutes / 60;

	    // Compute the current hour
	    //long currentHour = totalHours % 24;
	    
	    String str=totalHours + ":" + currentMinute + ":" + currentSecond;
	    System.out.println("The string is "+ str);
	    return str;
	}
}
