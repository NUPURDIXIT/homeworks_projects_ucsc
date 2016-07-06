//package HomeworkSolutions;

import java.util.Scanner;

public class Travel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String choice = "y";
        System.out.println("Welcome to the Travel Time Calculator");
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter miles:   ");
            double miles = sc.nextDouble();
            System.out.print("Enter speed in miles per hour: ");
            double speed = sc.nextDouble();
            
            //calculate estimated travel time in hours and minutes
            double time=(miles*60)/speed;
            int timeInHours =(int)(time/60);
            int timeInMinutes=(int)(time%60);
            System.out.println("Estimated Travel time");
            System.out.println("Hours: "+timeInHours);
            System.out.println("Minutes : "+timeInMinutes);
                              
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
	}

}
