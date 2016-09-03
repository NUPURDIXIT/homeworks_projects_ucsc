package homework2;
//Name        : Nupur Dixit
//Instructor  : Bineet Sharma
//Date        : April 28,2016
//Description : This code prompts user to enter time zone offset to GMT and displays
//              the time in the specified time zone.

import java.util.Scanner;
public class TimeOffset {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		
		//Prompts user to enter the time zone offset to GMT
		System.out.print("Enter the time zone offer to GMT :");
		
		int offset=input.nextInt();
		

		// Obtain the total milliseconds since midnight, Jan 1, 1970
		long currentTotalMilliSeconds=System.currentTimeMillis();
		
		// Obtain the total seconds since midnight, Jan 1, 1970
		long currentTotalSeconds=currentTotalMilliSeconds/1000;
		
	
		
		// Obtain the total minutes
		long totalMinutes=currentTotalSeconds/60;
		
		// Compute the current second in the minute in the hour
		long currentSeconds=currentTotalSeconds%60;
		
		// Obtain the total hours
		long totalHours=totalMinutes/60;
		
		// Compute the current minute in the hour
		long currentMinutes=totalMinutes%60;
		
		// Compute the current hour
		long currentHours=totalHours%24;
		
		//logic to check whether to subtract or add the offset to the current time
		if(offset <0){
			offset=offset*(-1);
			if(currentHours>offset){
				currentHours-=offset ;
			}
			else if(currentHours==offset){
				currentHours=0;
				}
			else{
				currentHours=offset-currentHours;
				currentHours=24-currentHours;
			}
			
		}
		else{
			currentHours=offset+currentHours;
			if(currentHours>24){
				currentHours=currentHours-24;
			}
		}
		
		//Display Results
		System.out.print("The current time is "+currentHours+":"+currentMinutes+ ":"+
		currentSeconds);
	}
}
