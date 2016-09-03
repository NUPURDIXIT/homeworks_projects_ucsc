package MidTermproject;
//Name: 	   Nupur Dixit
//Instructor:  Bineet Sharma
//Date: 	   May 23,2016
//Description: The program will display a menu when it is run.The menu gives five choices of operation:
//			   addition,subtraction,multiplication,division and a last choice to exit the program.It then prompts 
//			   user to make a choice of the calculation they want to do.Once the user selects the operation,it
//			   check for valid menu choices(and give an appropriate error message if a wrong choice was selected)
//  		   and then prompts the user to enter two numbers separated by space.It the user enter valid values then the 
//			   operation is performed and the result is displayed.In case of faulty value the error message is
//			   displayed.After displaying the result it displays "Press enter key to continue".
//			   Once enter key is pressed it displays the menu again.the program repeats till the user selects
//			   option to exit the program.

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		//Variable for the user choice in the menu
		int choice;   
		
		//Declare Array to store two float numbers
		Float[] inputFloats=new Float[2];
		
		//do-while loop so that the user can use the functionality till he wishes to exit the program
		do{
			//Create Scanner
			Scanner input=new Scanner(System.in); 
			
			//Invokes method userChoice and save the result in variable choice
			choice=getUserChoice();			  
			
			//Invokes method getTwoFloats which takes choice as parameter
			inputFloats=getTwoFloats(choice);
			
			//Invoke method performCaculation which in turn invoke other methods based on user choice
			performCalculation(inputFloats,choice);
			
			//This would get displayed after every operation's result is displayed
			System.out.println("\n\nPress enter to continue...");
			
			//In order to return to a new line
			input.nextLine();
			
		}while(true);						  
	}
	
	//Static method to display the menu for user to select Option of his choice
	public static void displayMenu(){
		System.out.println("Welcome to Nupur Dixit's Handy Calculator");
		System.out.println("\n"+"      "+"1.  Addition");
		System.out.println("      "+"2.  Subtraction");
		System.out.println("      "+"3.  Multiplication");
		System.out.println("      "+"4.  Division");
		System.out.println("      "+"5.  Exit");
		}
	
	//This method calls method 'displayMenu' to display Menu and prompts user to enter a choice between 1-5 
	//thereafter
	public static int getUserChoice(){
		//Invoke method Menu to display the options
		displayMenu();						  
		
		int choiceInt;
		
		//Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts user for choice in the menu
		System.out.print("\nWhat would you like to do? ");	
		
		//Loop to keep asking user for the correct input for choice in case invalid value is entered
		do{
			String choice=input.nextLine();
			
			//Exception Handling during String to integer conversion.This is to handle NumberFormatException	
			try{
				//Convert the choice given as String to Integer
				choiceInt=Integer.parseInt(choice); 
				
				//logic to check if the choice entered is not in range
				if(choiceInt <1 || choiceInt >5 || choice.length()>1){
					
					//Display the message if the user enters any option other than 1 to 5.
					System.out.print("You have not entered a number between 1 and 5.Try again.");
				}
				else{
					break;	
				}
			//Catch the NumberFormatException which would arise if the String cannot be parsed to Integer
			}catch (final NumberFormatException e){
					//Display the message if an invalid choice has been entered by the user
					System.out.print("You have entered an invalid choice,please re-enter your choice: ");
			}
		}while(true);
		return choiceInt; //Method returns the choice as an integer variable through variable choiceInt
	}
	
	//Method to get the input float values for performing calculations from user by taking choice as parameter.
	
	public static Float[] getTwoFloats(int choice){
		//Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Declare float array consisting of 2 float numbers
		Float[] myFloat = new Float[2];
		
		
		//String array for holding the 2 input values originally entered by user
		String [] myString=new String[2];
		
		//This switch case displays the message for entering the float values as per user choice		
			switch(choice){
				case 1:
						System.out.print("\nPlease enter two floats to add,separated by a space: ");
						break;
				case 2:
						System.out.print("\nPlease enter two floats to subtract,separated by a space: ");			
						break;
				case 3:
						System.out.print("\nPlease enter two floats to multiply,separated by a space: ");
						break;
				case 4:
						System.out.print("\nPlease enter two floats to divide,separated by a space: ");
						break;
				default:
						//If the user's choice is 5, then call method Exit
						Exit();
						
			}
			
			//This do-while loop ensures to keep asking user for valid input if in case something wrong has
			//been entered by user
			do{
				myString[0]=input.next();  			//first value entered by user
				myString[1]=input.nextLine();		//second value entered by user
				
				//Method isValidInput is invoked to test whether the value entered is valid or not.
				//This ensures the validity of numbers along with one additional thing i.e. the second
				//number entered by the user cannot be zero if the choice is 4 for division.
				//In case it is zero then the function returns false and the user is again prompted for entering 
				//the valid values
				if(isValidInput(myString, myFloat,choice)){
					break;
				}
			
			}while(true);
			return myFloat;
	}
			
	
		//Method to perform calculation based on user choice
	public static float performCalculation(Float[] myFloat,int choice){
			
			//Variable for storing the final value obtained by various calculations
			float calculatedValue=0;
			
			//The below switch-case is used to call the methods based on user's choice 
			//performAddition  		 : Option 1
			//performSubtraction	 : Option 2
			//performMultiplication	 : Option 3
			//performDivision	     : Option 4
			//Exit					 : Option 5
			//The value returned form all these methods is stored in variable calculatedValue
			
			switch(choice){
				case 1:
						calculatedValue=performAddition(myFloat[0],myFloat[1]);
						//Display the result on adding the two numbers entered by user
						System.out.printf("Result of adding "+myFloat[0]+" and "+myFloat[1]+" is %5.2f",calculatedValue);
						break;
				case 2:
						calculatedValue=performSubtraction(myFloat[0],myFloat[1]);
						//Display the result on subtracting the two numbers entered by user
						System.out.printf("Result of subtracting "+myFloat[1]+" from "+myFloat[0]+" is %5.2f",calculatedValue);
						break;
				case 3:
						calculatedValue=performMultiplication(myFloat[0],myFloat[1]);
						//Display the result on multiplying the two numbers entered by user
						System.out.printf("Result of multiplying "+myFloat[0]+" and "+myFloat[1]+" is %5.2f",calculatedValue);
						break;
				case 4:
						calculatedValue=performDivision(myFloat[0],myFloat[1]);
						//Display the result on dividing the two numbers entered by user
						System.out.printf("Result of dividing "+myFloat[0]+" by "+myFloat[1]+" is %5.2f",calculatedValue);
						break;
				case 5:
						Exit();
						
				default:
						break;
			}
			return calculatedValue;
	}

	
	//Method isValidInput performs below mentioned 2 tasks:
	//1.Tests the validity of the numbers by parsing the strings to float.If they are valid then good
	//	else catch the NumberFormat Exception.
	//2.It also ensures that the second number entered by the user is not 0 on selecting choice 4 for division.
	//	This is to prevent from getting Divide by zero exception
	
	public static boolean isValidInput(String[] myString, Float[] myFloat, int choice) {
		
		//Exception handling for numberFormat exception so as to ensure that the numbers entered by the user are valid
		try{
			//convert the string to double
			
			myFloat[0]=Float.parseFloat(myString[0]);
			myFloat[1]=Float.parseFloat(myString[1]);
			
			//if choice is 4 and second number entered by user is 0 then display message accordingly
			if(choice == 4 && myFloat[1] == 0){
				System.out.print("You can't divide by zero,please re-enter both floats: ");
				return false;
			}
			return true;
		}catch(final NumberFormatException e){
			System.out.print("\nYou have entered invalid floats.Please re-enter: ");
			return false;
		}
	}

	//Method to perform Addition
	public static float performAddition(float a,float b){
		float c=a+b;
		return c;
	}
	
	
	//Method to perform Subtraction
	public static float performSubtraction(float a,float b){
		float c=a-b;
		return c;
	}
	
	
	//Method to perform Multiplication
	public static float performMultiplication(float a,float b){
		float c=a*b;
		return c;
	}
	
	
	//Method to perform Division
	public static float performDivision(float a,float b){
		float c=a/b;
		return c;
	}
		
	//Method to quit if user enter Choice 5
	public static void Exit(){
		System.out.println("\nThank you for using Nupur Dixit's Handy Calculator");
		System.exit(1);
	}
}
	

	

	

