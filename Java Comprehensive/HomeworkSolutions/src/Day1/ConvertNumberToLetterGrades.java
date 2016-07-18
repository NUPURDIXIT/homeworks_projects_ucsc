//package Homework1;
//package HomeworkSolutions;

import java.util.Scanner;

public class ConvertNumberToLetterGrades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String choice = "y";
        System.out.println("Welcome to the Letter Grade Converter");
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter numerical grade:   ");
            double number = sc.nextDouble();
            
            //convert number to letter grade
            char letterGrade=(char)number;
            System.out.println("Letter grade:" +letterGrade);
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
            
        }
	}

}
