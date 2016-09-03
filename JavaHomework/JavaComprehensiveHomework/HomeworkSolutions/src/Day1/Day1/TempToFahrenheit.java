package Day1;
//package Homework1;
//package HomeworkSolutions;

import java.util.Scanner;

public class TempToFahrenheit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String choice = "y";
        System.out.println("Welcome to the Temperature Converter");
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter degree in Fahrenheit:   ");
            double tempInF = sc.nextDouble();
            
            //convert fahrenheit to celcius
            double tempInC =(int)( (tempInF-32)*(5.0/9)*100)/100.0;
            
            
            System.out.println("Degree in Celcius:  "+tempInC);
                                      
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();

        }
	}
}


