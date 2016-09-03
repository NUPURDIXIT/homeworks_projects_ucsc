package Homework4;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 15,2016
//Description: This program would prompt user to enter a number and check whether it is 
//             a palindrome or not. 

import java.util.Arrays;
import java.util.Scanner;
public class CheckPalindrome {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompt user to enter the number
		System.out.println("Enter a number");
		int isNumPalindrome=input.nextInt();
		isPalindrome(isNumPalindrome);
	}
	
	//Method to reverse the given number by the user
	public static int reverse(int revNumber){
		String strRevNumber=""+revNumber;
		int i=0;
		int j=strRevNumber.length()-1;
		String[] strArray=strRevNumber.split("");
		String temp;
		while(i<j){
			temp=strArray[i];
			strArray[i]=strArray[j];
			strArray[j]=temp;
			i++;
			j--;
		}
		String str=String.join("",strArray);
		
		
		int number=Integer.parseInt(str);
		//System.out.println("Reversed string is"+str);
		return number;
		}
	
	//Method to check if the number entered by the user is same as the reverse in
	//order to be a palindrome 
	public static boolean isPalindrome(int number){
		int num1=reverse(number);
		if(num1==number){
			System.out.print("Number is Palindrome");
			return true;
		}
		else{
			System.out.print("Number is not a Palindrome");
			return false;
		}
		
	}
}

