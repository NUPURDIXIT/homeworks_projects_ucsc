package Misc;
import java.util.Scanner;

public class MidTerm {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Menu();
	}
	public static void Menu(){
		String choice;
		int choiceInt=0;
		do{
			System.out.println("Welcome to Nupur Dixit's Calculator");
			System.out.println("\n"+"      "+"1.  Addition");
			System.out.println("      "+"2.  Subtraction");
			System.out.println("      "+"3.  Multiplication");
			System.out.println("      "+"4.  Division");
			System.out.println("      "+"5.  Exit");
			
			
			//Create Scanner
			Scanner input=new Scanner(System.in);
			
		
			//Prompts user to enter the choice of operation
			System.out.print("\nWhat would you like to do: ");
			choice=input.nextLine();
			
		//Exception Handling for NumberFormatException	
			try{
				//Convert the choice given as String to Integer
				choiceInt=Integer.parseInt(choice); 
				//If choice entered is not in range then show appropriate message
				if(choiceInt <1 || choiceInt >5 || choice.length()>1){
					System.out.println("You have not entered a number between 1 and 5.Try again.");
				}
				
				
				//Catch the NumberFormatException which would arise if the String cannot be parsed to Integer
			}catch (final NumberFormatException e){
					System.out.println("You have entered an invalid choice.Please re-enter your choice.");
			}
			implementChoice(choiceInt);
		}while(choice!="5");
		
	}
	
	public static void implementChoice(int userChoice){
		String value1,value2;
		float floatValue1,floatValue2,floatResult;
		boolean flag=true;
		//Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Evaluate user choice and perform operations accordingly
		switch(userChoice){
			case 1: 	
					System.out.print("Please enter two floats to add,separated by a space");
					do{
						//Prompts user to enter two String values which are then converted to float variables
						value1=input.next();
						value2=input.nextLine();
						try{
							//convert the string to double 
							floatValue1=Float.parseFloat(value1);
							floatValue2=Float.parseFloat(value2);
							break;
						}catch(final NumberFormatException e){
							System.out.print("\nYou have entered invalid floats.Please re-enter:");
							//input.nextLine();
						}
					}while(true);
					floatResult=Addition(floatValue1,floatValue2);
					System.out.printf("Result of Adding "+floatValue1+" and " +floatValue2+" is %2.2f ",floatResult);
					System.out.println("Press enter key to continue . . .");
					input.nextLine();
					break;
					
			case 2: System.out.print("Please enter two floats to subtract,separated by a space");
					do{
						//Prompts user to enter two String values which are then converted to float variables
						value1=input.next();
						value2=input.nextLine();
						try{
							//convert the string to double 
							floatValue1=Float.parseFloat(value1);
							floatValue2=Float.parseFloat(value2);
							break;
						}catch(final NumberFormatException e){
							System.out.print("\nYou have entered invalid floats.Please re-enter:");
							//input.nextLine();
						}
					}while(true);
					
					floatResult=Subtraction(floatValue1,floatValue2);
					System.out.printf("Result of Subracting "+floatValue1+" and " +floatValue2+" is %2.2f ",floatResult);
					System.out.println("Press enter key to continue . . .");
					input.nextLine();
					break;
					
			case 3: System.out.println("Please enter two floats to multiply,separated by a space");
					do{
						//Prompts user to enter two String values which are then converted to float variables
						value1=input.next();
						value2=input.nextLine();
						try{
							//convert the string to double 
							floatValue1=Float.parseFloat(value1);
							floatValue2=Float.parseFloat(value2);
							break;
						}catch(final NumberFormatException e){
							System.out.print("\nYou have entered invalid floats.Please re-enter:");
							//input.nextLine();
						}
					}while(true);
					
					floatResult=Multiplication(floatValue1,floatValue2);
					System.out.printf("Result of Multiplying "+floatValue1+" and " +floatValue2+" is %2.2f ",floatResult);
					System.out.println("Press enter key to continue . . .");
					input.nextLine();
					break;	
					
			case 4: System.out.println("Please enter two floats to divide,separated by a space");
					do{
						//Prompts user to enter two String values which are then converted to float variables
						value1=input.next();
						value2=input.nextLine();
						try{
						//convert the string to double 
						floatValue1=Float.parseFloat(value1);
							
							
						floatValue2=Float.parseFloat(value2);
						break;
						}catch(final NumberFormatException e){
							System.out.print("\nYou have entered invalid floats.Please re-enter:");
							//input.nextLine();
						}
					}while(true);
					floatResult=Division(floatValue1,floatValue2);
					System.out.printf("Result on Dividing "+floatValue1+" and " +floatValue2+" is %2.2f ",floatResult);
				
				 
					
					System.out.println("Press enter key to continue . . .");
					input.nextLine();
					
					break;
			case 5: Exit();
					break;
		}
	}
	
	//Method to perform Addition
	public static float Addition(float a,float b){
		float c=a+b;
		return c;
		
	}
	
	
	//Method to perform Subtraction
	public static float Subtraction(float a,float b){
		float c=a-b;
		return c;
	}
	
	
	//Method to perform Multiplication
	public static float Multiplication(float a,float b){
		float c=a*b;
		return c;
	}
	
	
	//Method to perform Division
	public static float Division(float a,float b){
		//HANDLE DIVIDE BY ZERO EXCEPTION
		float c=a/b;
		return c;
	}
		
	//Method to quit if user enter Choice 5
	public static void Exit(){
		System.out.println("Thankyou for choosing Nupur Dixit's Handy Calculator");
		
		System.exit(1);
		
	}
}
	

	

	

