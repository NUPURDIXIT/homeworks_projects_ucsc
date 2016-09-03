//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 31,2016
//Description: This program prompts user for 10 integers and return the index of the smallest element

package Homework5;
import java.util.Scanner;
public class SmallestIntegerInArray {

	public static void main(String[] args) {
		// variable index prints the final value of the index of the smallest element
		int index;
		
		//declare an array of 10 integers
		Integer[] array=new Integer[10];
		
		//Invoke method which would return integer index of the smallest element
		index=indexOfSmallestElement(array);
		
		//Print the index of the smallest element
		System.out.println("Index of smallest element is :"+index);
	}
	
	//Method to find the index of smallest element in the array 
	public static int indexOfSmallestElement(Integer[] array){
		//Create Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts user to enter 10 integers
		System.out.println("Please enter 10 integers");
		
		int i,index=0;
		
		//Integer[] numberList=new Integer[10];
		for(i=0;i<10;i++){
			array[i]=input.nextInt();
		}
		//Set the first element of the array to be the smallest element
		int min=array[0];
		
		//Run the Loop to find the smallest element and save the index of the smallest element in index variable
		for (i=0;i<10;i++){
			if(array[i]<min){
				min=array[i];
				index=i;
			}
		}
		
		//Return the index of the smallest element
		return index;
	}
}
