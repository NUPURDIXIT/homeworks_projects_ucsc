package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: Program that prompts the uset to enter a Social Security Number in the format DDD-DD-DDDD,
//             where D is a digit.If the SSN entered is valid then it prints it to be a valid SSN else invalid SSN.

import java.util.Scanner;
public class SocialSecurityNumber {

	public static void main(String[] args) {
		// Create a Scanner
		Scanner input=new Scanner(System.in);
		
		//Prompts user for the SSN
		System.out.print("Enter SSN in DDD-DD-DDDD format: ");
		String socialSecNum=input.nextLine();
		boolean flag=true;
			
		//If the length of SSN exceeds 11 then print it as an invalid SSN
		if (socialSecNum.length() >11 || socialSecNum.length()<11){
			System.out.print(socialSecNum + " " + "is an invalid social security number");
			flag=false;
			}
		
		//Logic to check if the D's in the format of SSN are digits and if '-' is at the correct position.
		//If not, then print the SSN as invalid and come out of the loop.
		if(flag==true){
			for(int i=0;i<socialSecNum.length();i++){
				if(i==3 || i==6){
					//System.out.print("hello");
					if(socialSecNum.charAt(i)!='-'){
						System.out.print(socialSecNum + " " + "is an invalid social security number");
						flag=false;
						break;
					}
				}
				else if(!Character.isDigit(socialSecNum.charAt(i))){
					System.out.print(socialSecNum + " " + "is an invalid social security number");
					flag=false;
					break;
				}
			}
		}
			
			//To display the social Security number as valid if all criteria satisfy
			if(flag==true){
				System.out.print(socialSecNum + " " + "is a valid social security number");
			}

	}

}
