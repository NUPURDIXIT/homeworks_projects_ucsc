package homework2;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : April 28,2016
//Description: This code generates a random number between 1 and 12 and then prints the name of the month
//             correspondingly:
//             1: January
//			   2: February
//			   3: March
//			   4: April
//			   5: May
//			   6: June
//			   7: July
//			   8: August
//		       9: September
//            10: October
//			  11: November
//			  12: December

public class RandomMonth {

	public static void main(String[] args) {
		// To generate a random number between 0 to 12
		int randomNumber=(int)(Math.random()*12)+1;
		
		switch(randomNumber){
			case 1:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"January");
				break;
			case 2:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"February");
				break;
			case 3:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"March");
				break;
			case 4:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"April");
				break;
			case 5:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"May");
				break;
			case 6:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"June");
				break;
			case 7:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"July");
				break;
			case 8:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"August");
				break;
			case 9:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"September");
				break;
			case 10:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"October");
				break;
			case 11:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"November");
				break;
			case 12:
				System.out.println("RandomNumber "+randomNumber+" corresponds to month name " +"December");
				break;
		}
	}
}
