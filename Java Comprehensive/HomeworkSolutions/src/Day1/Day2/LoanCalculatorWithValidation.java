package Day2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.NumberFormat;

public class LoanCalculatorWithValidation
{	
	static double loanAmount,yearlyInterestRate;
	static int years;
	static String choice;
	
    public static void main(String[] args) throws MyOutOfRangeException{
    
    	
              
        // welcome the user to the program
        System.out.println("Welcome to the Loan Calculator");
        System.out.println();  // print a blank line
        
        // create a Scanner object and start a while loop
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
           loanAmount=getDoubleLoanAmountWithinRange(sc,choice,0,1000000);
           yearlyInterestRate=getRateWithinRange(sc,choice,0,20);
           double monthlyInterestRate=yearlyInterestRate/12.0/100;
           years=getIntYears(sc,choice,0,100);
           int months=years*12;
         
            System.out.println("loan amount: "+loanAmount);
            System.out.println("monthlyInterestRate: "+monthlyInterestRate);
            System.out.println("loan months: "+months);
            //System.out.println("loan amount: "+loanAmount);
            
            double monthlyPayment = (loanAmount*monthlyInterestRate)/(1-(1.0/Math.pow(1+monthlyInterestRate,months)));
            
            
            // get the currency and percent formatter objects
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(2);
            System.out.println();
            // display the results
            String message =
                "Loan Amount: " + currency.format(loanAmount) + "\n"
              + "Yearly Interest Rate:  " + percent.format(yearlyInterestRate/100) + "\n"
              + "Number of years: " + years + "\n"
              + "Monthly Payment: " + currency.format(monthlyPayment);
             
            System.out.println(message);

            // see if the user wants to continue
           
            choice = getChoiceValue(sc);
            System.out.println();
        }
    }
  
  //Validation for getting user choice as y or n only
    public static String getChoiceValue(Scanner sc){
    	boolean flag;
    		do{
    				flag=true;
    				System.out.print("Continue? (y/n): ");
    				choice = sc.nextLine();
    				
    				if(choice.equals("")){
    					System.out.println("This field is required.Try again");
    					flag=false;
    					
    				}
    					
    				else if(!(choice.equalsIgnoreCase("y")) && !(choice.equalsIgnoreCase("n"))){
    					System.out.println("Please enter only y or n as the choice");
    					flag=false;
    				}
    				else{
    					
    					break;
    				}
    				
    		}while(flag==false);
    		return choice;
    	}	
    
  //Validation for getting loan amount as double and within range 
    public static double getDoubleLoanAmountWithinRange(Scanner sc,String prompt,double min,double max){
		boolean flag;
		do{
			try{
				flag=true;
				 System.out.print("Loan Amount:   ");
				loanAmount=sc.nextDouble();
				if(loanAmount<min){
					throw new MyOutOfRangeException("Error! Loan Amount must be greater than 0.0");				}
				if(loanAmount>max){
					throw new MyOutOfRangeException("Error! Loan Amount must be less than 1000000.0");
				}
				
			}
			catch(InputMismatchException e){
				System.out.println("Error! Invalid decimal value.Try again.");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
			catch(MyOutOfRangeException e){
				System.out.println("Error! Width must be greater than 0.0 and less than 1000000.0");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
		}
			while(flag==false);
		return loanAmount;
	}
    
    
  //Validation for getting rate as double and within range
    public static double getRateWithinRange (Scanner sc,String prompt,double min,double max){
		boolean flag;
		do{
			try{
				flag=true;
				 System.out.print("Yearly Interest Rate:   ");
				 yearlyInterestRate=sc.nextDouble();
				if(yearlyInterestRate<min){
					throw new MyOutOfRangeException("Error! Loan Amount must be greater than 0.0");				}
				if(yearlyInterestRate>max){
					throw new MyOutOfRangeException("Error! Loan Amount must be less than 20.0");
				}
				
			}
			catch(InputMismatchException e){
				System.out.println("Error! Invalid decimal value.Try again.");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
			catch(MyOutOfRangeException e){
				System.out.println("Error! Width must be greater than 0.0 and less than 20.0");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
		}
			while(flag==false);
		return yearlyInterestRate;
	}
   
  //Validation for getting number of years as int and within range
  public static int getIntYears(Scanner sc,String prompt,int min,int max){
		boolean flag;
		do{
			try{
				flag=true;
				 System.out.print("Number of years:   ");
				years=sc.nextInt();
				if(years<min){
					throw new MyOutOfRangeException("Error! Loan Amount must be greater than 0");				}
				if(years>max){
					throw new MyOutOfRangeException("Error! Loan Amount must be less than 100");
				}
				
			}
			catch(InputMismatchException e){
				System.out.println("Error! Invalid decimal value.Try again.");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
			catch(MyOutOfRangeException e){
				System.out.println("Error! Width must be greater than 0.0 and less than 1000000.0");
				sc.nextLine();
				System.out.println();
				flag=false;
			}
		}
			while(flag==false);
		return years;
	}
    
    
}

/*class MyOutOfRangeException extends Exception{
	MyOutOfRangeException(String message){
		super(message);
	}
}*/