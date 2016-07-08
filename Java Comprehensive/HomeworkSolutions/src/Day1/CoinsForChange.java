//package HomeworkSolutions;

import java.util.Scanner;

public class CoinsForChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String choice = "y";
        System.out.println("Welcome to the Change Calculator");
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter number of cents (0-99) :   ");
            int cents = sc.nextInt();
            
            //calculate quarters,dimes,nickels and pennies
            int Quarters = cents/25;
            int a=cents%25;
            int Dimes = a/10;
            int d=a%10;
            int Nickels=d/5;
            int Pennies=d%5;
            
            
            System.out.println("Quarters:  "+Quarters);
            System.out.println("Dimes: "+Dimes);
            System.out.println("Nickels: "+Nickels);
            System.out.println("Pennies: "+Pennies);
                              
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }

	}

}
