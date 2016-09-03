package homework3;
//Name       : Nupur Dixit
//Instructor : Bineet Sharma
//Date       : May 7,2016
//Description: Program to generate a plate number consisting of three uppercase letters followed by 4 digits.

public class VehiclePlate {
		
		public static void main(String[] args) {
			
			// Generate a random 4 digit number 
			int num=1000+(int)(Math.random()*9000);
			
			//Generate 3 random Uppercase Letters
			char ch1= (char)('A'+(Math.random()*('Z'-'A'+1)));
			char ch2= (char)('A'+(Math.random()*('Z'-'A'+1)));
			char ch3= (char)('A'+(Math.random()*('Z'-'A'+1)));
			
			//Print the Vehicle's number plate as a combination of 3 uppercase letters followed by 4 digits
			System.out.println("Plate number is: "+ ch1+ch2+ch3+num);
	}
}
