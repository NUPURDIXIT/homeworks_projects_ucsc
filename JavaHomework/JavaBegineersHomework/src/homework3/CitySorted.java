package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: Program that prompts under to enter three cities and display them in ascending order.


import java.util.Scanner;
public class CitySorted {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts user to enter three cities in any order
		System.out.print("Enter the first city:");
		String city1=input.nextLine();
		System.out.print("Enter the second city:");
		String city2=input.nextLine();
		System.out.print("Enter the third city:");
		String city3=input.nextLine();
		
		//Comparison between the cities in order to display the cities in ascending order
		if(city1.compareToIgnoreCase(city2)>0 && city1.compareToIgnoreCase(city3)>0){
			if(city2.compareToIgnoreCase(city3) > 0){
				System.out.println("The three cities in alphabetical order are"+ " "+city3+" "+city2+" "+city1);
			}
			else{
				System.out.println("The three cities in alphabetical order are"+ " "+city2+" "+city3+" "+city1);
			}
		}
		else if(city2.compareToIgnoreCase(city1)>0 && city2.compareToIgnoreCase(city3)>0){
			if(city1.compareToIgnoreCase(city3) > 0){
				System.out.println("The three cities in alphabetical order are"+ " "+city3+" "+city1+" "+city2);
			}
			else{
				System.out.println("The three cities in alphabetical order are"+ " "+city1+" "+city3+" "+city2);
			}
		}
		else if(city3.compareToIgnoreCase(city1)>0 && city3.compareToIgnoreCase(city2)>0){
			if(city1.compareToIgnoreCase(city2) > 0){
				System.out.println("The three cities in alphabetical order are"+ " "+city2+" "+city1+" "+city3);
			}
			else{
				System.out.println("The three cities in alphabetical order are"+ " "+city1+" "+city2+" "+city3);
			}
		}
	}

}
