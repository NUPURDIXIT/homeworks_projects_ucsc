package homework2;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : April 28,2016
//Description: This code prompts user for amount and then prints the amount value
//             after the 6th month. The annual rate for this problem is 5%.

import java.util.Scanner;
public class CalculateInterest {
	public static void main(String[] args) {
		//Create Scanner
		Scanner input=new Scanner(System.in);
		
		//Receive input from user
		System.out.print("Enter the monthly saving amount: ");
		double amount=input.nextDouble();
		
		//Annual Rate=5%
		double annualRate=5;
		
		//r is the variable name given to monthly interest rate
		double r=annualRate/(12.0*100.0);
		
		//Amount at the end of 6 months is calculated as :
		//P[(1+r)+(Math.pow(1+r,2))+Math.pow(1+r,3))+Math.pow(1+r,4))+Math.pow(1+r,5))+Math.pow(1+r,6)])
		double a1=Math.pow(1+r,2);
		double a2=Math.pow(1+r,3);
		double a3=Math.pow(1+r,4);
		double a4=Math.pow(1+r,5);
		double a5=Math.pow(1+r,6);
		double cumAmount=amount*(1+r+a1+a2+a3+a4+a5);
		cumAmount=(int)(cumAmount*100)/100.0;
		//Print the amount saved at the end of 6 months
		System.out.print("After the sixth month,the account value is $"+ cumAmount);
	}
}
