package Misc;


import java.util.Scanner;

public class reverseArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] reversedArray=new int[10];
		int[] array=new int[10];
		reversedArray=reverse(array);
		System.out.println("Reversed Array is :"+ reversedArray);
	}
	public static int[] reverse(int[] list){
		int i,j=0;
		int temp=0;
		Scanner input=new Scanner(System.in);
		System.out.println("Please enter 10 integers");
		for(i=0;i<10;i++){
			list[i]=input.nextInt();
		}
		j=list.length-1;
		while(i<j){
			temp=list[i];
			list[j]=list[i];
			list[j]=temp;
			i++;
			j--;
		}
		return list;
	}

}
