package homework2;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : April 28,2016
//Description: This code prompts user for the weight and price for 2 packages and then displays the one 
//             with better price

import java.util.Scanner;
public class CompareCost {

	public static void main(String[] args) {
		// Create Scanner
		Scanner input=new Scanner(System.in);
		
		//prompts user  to enter the weight and price for package 1
		System.out.print("Enter weight and price for package 1:");
		double weightPackage1=input.nextDouble();
		double pricePackage1=input.nextDouble();
		
		//prompts user  to enter the weight for package 1
		System.out.print("Enter the weight and price for package 2");
		double weightPackage2=input.nextDouble();
		double pricePackage2=input.nextDouble();
		
		//calculate the price per weight for package 1:
		double pricePerWeightPackage1=pricePackage1/weightPackage1;
		
		//calculate the price per weight for package 2:
		double pricePerWeightPackage2=pricePackage2/weightPackage2;
		
		//Compare the price per weight for both the packages
		if(pricePerWeightPackage1 > pricePerWeightPackage2 ){
			System.out.print("Package 2 has a better price");
		}
			//if the price per weight for both are same then both are good
			else if(pricePerWeightPackage1 == pricePerWeightPackage2){
				System.out.print("Both the packages are offering the same price, thus both are good");
			}
				else{
					System.out.print("Package 1 has a better price");
				}
	}
}
