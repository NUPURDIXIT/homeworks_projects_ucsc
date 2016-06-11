package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: Program that prompts the user to enter a letter and display its corresponding number. 

import java.util.Scanner;

public class Telephone {

	public static void main(String[] args) {
		//Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts user for letter
		System.out.print("Enter a letter:");
		String str=input.nextLine();
		str=str.toLowerCase();
		
		//Retrieves the first letter of the text entered by the user
		char ch=str.charAt(0);
		
		//Validation to check if the user enters more than one letter or a digit or character other than letter/digit
		if(str.length()!=1 || Character.isDigit(ch) || (!Character.isLetterOrDigit(ch))){
			System.out.println("Please enter only single letter between a-z");
		}
		
		//Logic to display number corresponding to the letter entered by user
		else if (str.equals("a") || str.equals("b") || str.equals("c")){
			System.out.print("The corresponding number is 2");
		}
			else if(str.equals("d") || str.equals("e") || str.equals("f")){
				System.out.print("The corresponding number is 3");
			}
			else if(str.equals("g") || str.equals("h") || str.equals("i")){
				System.out.print("The corresponding number is 4");
			}
			else if(str.equals("j") || str.equals("k") || str.equals("l")){
				System.out.print("The corresponding number is 5");
			}
			else if(str.equals("m") || str.equals("n") || str.equals("o")){
				System.out.print("The corresponding number is 6");
			}
			else if(str.equals("p") || str.equals("q") || str.equals("r") || str.equals("s")){
				System.out.print("The corresponding number is 7");
			}
			else if(str.equals("t") || str.equals("u") || str.equals("v")){
				System.out.print("The corresponding number is 8");
			}
			else if(str.equals("w") || str.equals("x") || str.equals("y") || str.equals("z")){
				System.out.print("The corresponding number is 9");
			}
			else{
				System.out.println("Invalid value entered");
			}
	}

}
