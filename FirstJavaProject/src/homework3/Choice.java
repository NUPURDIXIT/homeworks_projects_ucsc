package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: This Program will display the menu with 5 items. It will ask the use to give their choice. 
//             It will trap all possible errors and then print the result when correct input is provided 
//             before exiting the program.

import java.util.Scanner;
public class Choice {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Welcome to sorting program");
		System.out.println("\n"+"      "+"1.  Title");
		System.out.println("      "+"2.  Rank");
		System.out.println("      "+"3.  Date");
		System.out.println("      "+"4.  Stars");
		System.out.println("      "+"5.  Likes");

		String choice;
		
		Scanner input=new Scanner(System.in);
			
		//Prompt user for entering a choice
		
		do{
			System.out.print("\nEnter your choice between 1 and 5 only: ");
			choice=input.nextLine();
		//Exception Handling for NumberFormatException	
			try{
				//Convert the choice given as String to Integer
				int choiceInt=Integer.parseInt(choice); 
				
				//If choice entered is not in range then show appropriate message
				if(choiceInt <1 || choiceInt >5 || choice.length()>1){
					System.out.println("You have not entered a number between 1 and 5.Try again.");
				}
				//The choice entered is valid thus print the message
				else{
					System.out.println("\nYou entered valid choice"+ " "+ choiceInt);
					System.out.println("Thank you for giving your choice");
					break;
				}
				//Catch the NumberFormatException which would arise if the String cannot be parsed to Integer
			}catch (final NumberFormatException e){
					System.out.println("You have entered an invalid choice. Try again.");
				}
				
			}while(true);
		}
}
