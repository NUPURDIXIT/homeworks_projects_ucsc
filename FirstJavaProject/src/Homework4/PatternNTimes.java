package Homework4;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 15,2016
//Description: This program would prompt user to enter a line number and 
//             print the pattern accordingly.

import java.util.Scanner;
public class PatternNTimes {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompt user to enter the line number
		System.out.println("Enter the line number");
		int n=input.nextInt();
		
		//Call static method to print the pattern
		displayPattern(n);
	}
	
	//Logic to print the desired pattern
		public static void displayPattern(int n){
		for(int i=1;i<=n;i++){
			for(int j=n;j>=1;j--){
				System.out.print(j<=i?j+" ":" "+" ");
			}			
			System.out.println();
		}
	}
}


