package Homework5;

import java.util.Scanner;

public class ReverseArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//declare an array of 10 integers
		int[] array=new int[10];
		
		//Invoke reverse method which returns the original list in reversed order
		array=reverse(array);
		
		//print the reversed list
		System.out.println("\nReversed Array is :");
		for(int i=0;i<10;i++){
			System.out.print(array[i]+" ");
		}
	}
	
	//Method to reverse the elements of the array
	public static int[] reverse(int[] list){
		int i,j=0;
		int temp=0;
		
		//Create Scanner
		Scanner input=new Scanner(System.in);
		
		//Initialize array elements
		for(int p=0;p<10;p++){
			list[p]=0;
			
		}
		
		//Prompts user to enter 10 integers
		System.out.println("Please enter 10 integers");
		for(i=0;i<10;i++){
			list[i]=input.nextInt();
			
		}
		
		//print original array of 10 integers entered bu user
		System.out.println("Original Array is :");
		for(i=0;i<10;i++){
			System.out.print(list[i]+" ");
		}
		
		//Logic to reverse the elements of the array
		j=list.length-1;
		i=0;
		while(i<j){
			temp=list[i];
			list[i]=list[j];
			list[j]=temp;
			i++;
			j--;
		}
		
		//Return the reversed array 
		return list;
	}

}
