//package demoday2;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WorkingWithBIGNumbers {
	public static void main (String args[]){
		System.out.println("Working with >16 significant digit      :" + "3.1415926535897932384626433832795028841971693993751\n\n");
		//              012345678901234567890123456789012345678901234567890
		double myPi = 3.1415926535897932384626433832795028841971693993751;		
		System.out.println("Using double as is                      :" + myPi); //Prints only 16 significant digits
		
		//1) Use round method from Math class
		double roundedPi = Math.round(myPi);
		System.out.println("Using Math.round()                      :"  + roundedPi);
		
		roundedPi = Math.round(myPi * 10000) / 10000.0;
		System.out.println("Using Math.round() 4 significant digits :" + roundedPi);
		
		//2) Use printf method
		System.out.printf("Using printf()                          :" + "%.20f" + "\n", myPi);
		
		//3) Use DecimalFormat API class
		DecimalFormat decimalFormat = new DecimalFormat("0.0000");
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP); 
		String formattedPi = decimalFormat.format(myPi);
		System.out.println("Using DecimalFormat                     :" + formattedPi);			

		//4) Use BigDecimal
		BigDecimal myBig = new BigDecimal(myPi);
		System.out.println("Using BigDecimal wrong way              :" + myBig.toString()); //digits after 16 decimal is wrong

		//5) Use BigDecimal right way!
		BigDecimal myRightBig = new BigDecimal("3.1415926535897932384626433832795028841971693993751");
		System.out.println("Using BigDecimal right way              :" + myRightBig.toString());
		myRightBig = myRightBig.multiply(new BigDecimal("100"));
		System.out.println("Doing math using BigDecimal             :" + myRightBig.toString());
	}	
}
