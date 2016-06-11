package Misc;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
* Midterm_Hint_1_A
*
* Write a program which will display a sorting menu like this,
* and exit the program if 5 is entered:
*
* 1. Title
* 2. Rank
* 3. Date
* 4. Stars
* 5. Likes
*
* Enter your choice between 1 and 5 only: kasf s fsa fas fa f
* You have entered an invalid choice. Try again.: 8
* You have not entered a number between 1 and 5. Try again.: 3
*
* You entered valid choice 3
*
* Thank you for giving your choice
*
* @author bineetsharma
* @version 1.0
* @since 07-12-2015
*/
public class SolChoice {
/**
* @param args
*/
public static void main(String[] args) {
// Scanner that will read the integer
Scanner readInput = new Scanner(System.in);
int inputInt;
System.out.println("\n\nWelcome to sorting program\n\n\t1.Title\n\t2. Rank\n\t3. Date\n\t4. Stars\n\t5. Likes\n\n ");
do { // Loop until we have correct input
System.out.print("Enter your choice between 1 and 5 only: ");
try {
inputInt = readInput.nextInt();
 // waits for user input
if (inputInt >= 1 && inputInt <= 5) {
break; // Got it, done
} else {
System.out.println("You have not entered a number between 1 and 5. Try again.");
continue;
 // continue looping as it is wrong number
}
} catch (final InputMismatchException e) {
System.out.println("You have entered an invalid choice. Try again.");
readInput.nextLine(); // discard non-int input
continue;
 // keep looping until you found right one
}
} while (true);
System.out.println("\nYou entered valid choice " +
 inputInt);
System.out.println("Thank you for giving your choice");
}
}
