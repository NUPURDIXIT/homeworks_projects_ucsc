package Misc;
import java.util.Scanner;
public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		int a=calcAverage();
			System.out.println("The average of given 10 numbers is: "+a);
		
	}
	public static int calcAverage(){
		int sum=0;
		int average=0;
		int count=0;
		Scanner input=new Scanner(System.in);
		
		int[] numbers=new int[10];
		System.out.println("Enter numbers");
		for(int i=0;i<numbers.length;i++){
			
			numbers[i]=input.nextInt();
			sum+=numbers[i];
		}
		average=sum/10;
		for(int i=0;i<numbers.length;i++){
			if(numbers[i]>average){
				count++;
			}
		}
		System.out.println(count + " students are above average");
		return average;
		
	}

}
