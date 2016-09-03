//Name: 	   Nupur Dixit
//Instructor:  Bineet Sharma
//Date: 	   Aug 6,2016
//Description: This program is meant to validate the data entered by user.



import java.util.Scanner;

public class Validator
{
	//This method is used to validate whether the choice entered by the user is amongst s1 or s2. If not, error is thrown and the user
	//is again asked to enter the choice.This continues till the user enters correct choice which is then returned.
	
	public static String getChoiceString(Scanner sc,String prompt,String s1,String s2){
		boolean flag=false;
    	String choice=null;
    	while(flag==false){
    		System.out.print(prompt);
	        choice = sc.next();  // read user entry
	        
	        sc.nextLine(); // discard any other data entered on the line
	        if(choice.equalsIgnoreCase(s1) || choice.equalsIgnoreCase(s2) ){
	        	flag=true;
	        }
	        else{
	        	System.out.println("Error! Entry must be '"+s1+"' or '"+s2+"'.Try again\n");
	        }
	       
    	}
        return choice;
	}
  
	//This method ensure that the user enters a double value , if not then an error is thrown and the user is again asked to enter the value
	//of double type. This process continues till the user enter correct value which is then returned.
    public static double getDouble(Scanner sc, String prompt)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
}