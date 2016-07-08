//package HomeworkSolutions;


import java.util.Scanner;

public class CalculateArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		{
	        Scanner sc = new Scanner(System.in);
	        String choice = "y";
	        System.out.println("Welcome to the Area and Perimeter Calculator");
	        while (!choice.equalsIgnoreCase("n"))
	        {
	            // get the input from the user
	            System.out.print("Enter length:   ");
	            double length = sc.nextDouble();
	            System.out.print("Enter width: ");
	            double width = sc.nextDouble();
	            //calculate area and perimeter
	            double area = length*width;
	            double perimeter=2*(length+width);

	            System.out.println("Area:  "+area);
	            System.out.println("Perimeter: "+perimeter);
	                              
	            System.out.println();

	            // see if the user wants to continue
	            System.out.print("Continue? (y/n): ");
	            choice = sc.next();
	            System.out.println();
	        }
	    }
	}
	}


