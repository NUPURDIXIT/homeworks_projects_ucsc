package Day2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculateAreaWithValidation {
	static double length,width;
	static String choice;
	public static void main(String[] args) throws MyOutOfRangeException {
		// TODO Auto-generated method stub
			
	        Scanner sc = new Scanner(System.in);
	        choice = "y";
	        System.out.println("Welcome to the Area and Perimeter Calculator");
	        while (!choice.equalsIgnoreCase("n"))
	        {
	            // get the input from the user
	           
	            length = getDoubleLengthWithinRange(sc,choice,0.0,1000000.0);
	            //System.out.print("Enter width: ");
	            width = getDoubleWidthWithinRange(sc,choice,0.0,1000000.0);
	            //calculate area and perimeter
	            double area = length*width;
	            double perimeter=2*(length+width);

	            System.out.println("Area:  "+area);
	            System.out.println("Perimeter: "+perimeter);
	                              
	            System.out.println();

	            // see if the user wants to continue
	            choice=getChoiceValue(sc);
	            
	            
	            System.out.println();
	        }
	    }
	
//Validation for getting length as double and within range
	public static double getDoubleLengthWithinRange(Scanner sc,String prompt,double min,double max){
		boolean flag;
		double length=0;
		do{
			try{
				flag=true;
				 System.out.print("Enter length:   ");
				length=sc.nextDouble();
				if(length<min || length>max){
					flag=false;
					throw new MyOutOfRangeException("Error! Length must be greater than 0.0 and less than 1000000.0");
				}
				
			}
			catch(InputMismatchException e){
				flag=false;
				System.out.println("Error! Invalid decimal value.Try again.");
				sc.nextLine();
				System.out.println();
				//System.out.println("Flag value is :"+flag);
				
			}
			catch(MyOutOfRangeException e){
				flag=false;
				System.out.println("Error! Length must be greater than 0.0 and less than 1000000.0");
				sc.nextLine();
				System.out.println();
				
			}
		}while(flag==false);
		return length;
	}
	
	
	//Validation for getting width as double and within range
	public static double getDoubleWidthWithinRange(Scanner sc,String prompt,double min,double max){
		boolean flag;
		double width=0;
		do{
			try{
				flag=true;
				 System.out.print("Enter width:   ");
				width=sc.nextDouble();
				if(width<min || width>max){
					throw new MyOutOfRangeException("Error! Length must be greater than 0.0 and less than 1000000.0");
				}
				
			}
			catch(InputMismatchException e){
				System.out.println("Error! Invalid decimal value.Try again.");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
			catch(MyOutOfRangeException e){
				System.out.println("Error! Width must be greater than 0.0 and less than 1000000.0");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
		}
			while(flag==false);
		return width;
	}
	
//Validation for getting user choice as y or n only
	
public static String getChoiceValue(Scanner sc){
boolean flag;
String choice1="";
	do{
			flag=true;
			System.out.print("Continue? (y/n): ");
			choice1 = sc.nextLine();
			
			if(choice1.equals("")){
				System.out.println("This field is required.Try again");
				flag=false;
				
			}
				
			else if(!(choice1.equalsIgnoreCase("y")) && !(choice1.equalsIgnoreCase("n"))){
				System.out.println("Please enter only y or n as the choice");
				flag=false;
			}
			else{
				
				break;
			}
			
	}while(flag==false);
	return choice1;
}	

}

class MyOutOfRangeException extends Exception{
	MyOutOfRangeException(String message){
		super(message);
	}
}



