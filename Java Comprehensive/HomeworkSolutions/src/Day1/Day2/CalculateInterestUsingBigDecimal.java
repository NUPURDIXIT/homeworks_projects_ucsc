package Day2;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

	
public class CalculateInterestUsingBigDecimal {

	    public static void main(String[] args)
	    {
	   	        
	        // welcome the user to the program
	        System.out.println("Welcome to the Interest Calculator");
	        System.out.println();  // print a blank line
	        
	        // create a Scanner object and start a while loop
	        Scanner sc = new Scanner(System.in);
	        String choice = "y";
	        while (choice.equalsIgnoreCase("y"))
	        {
	            // get the input from the user
	            System.out.print("Enter loan amount:   ");
	            double loanAmount = sc.nextDouble();

	            System.out.print("Enter interest rate:   ");
	            double interestRate = sc.nextDouble();
	            double monthlyInterestRate=interestRate/12/100;
	            
	            BigDecimal bgLoanAmount=new BigDecimal(Double.toString(loanAmount));
	            bgLoanAmount=bgLoanAmount.setScale(2,RoundingMode.HALF_UP);
	            
	            //BigDecimal bgInterestRate=new BigDecimal(Double.toString(InterestRate));
	            BigDecimal bgInterestRate=new BigDecimal(Double.toString(interestRate));
	            
	            
	            // calculate the Interest using loan amount and monthly interest rate
	           	            	            
	            BigDecimal bgInterest =bgLoanAmount.multiply(bgInterestRate);
	            bgInterest=bgInterest.setScale(2,RoundingMode.HALF_UP);
	            // get the currency and percent formatter objects
	            NumberFormat currency = NumberFormat.getCurrencyInstance();
	            NumberFormat percent = NumberFormat.getPercentInstance();
	            percent.setMinimumFractionDigits(2);

	            // display the results
	            String message =
	                "Loan Amount : " + currency.format(bgLoanAmount) + "\n"
	              + "Interest Rate :  " + percent.format(bgInterestRate) + "\n"
	              + "Interest : " + currency.format(bgInterest) ;
	              
	            System.out.println(message);

	            // see if the user wants to continue
	            System.out.print("Continue? (y/n): ");
	            choice = sc.next();
	            System.out.println();
	        }
	    }
	}