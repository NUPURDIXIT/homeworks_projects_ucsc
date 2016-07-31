package Day3;
//package day3;
import java.util.Scanner;

public class Validator
{
    public static String getString(Scanner sc, String prompt)
    {
    	System.out.print(prompt);
        String s = sc.next();  // read user entry
        sc.nextLine();  // discard any other data entered on the line
        return s;
    }
    
    public static String getChoice(Scanner sc, String prompt)
    {
    	boolean flag=false;
    	String choice=null;
    	while(flag==false){
    		System.out.print(prompt);
	        choice = sc.next();  // read user entry
	        
	        sc.nextLine();  // discard any other data entered on the line
	        if(choice.equalsIgnoreCase("y") || choice.equalsIgnoreCase("n") ){
	        	flag=true;
	        }
	        else{
	        	System.out.println("Please enter only 'y' or 'n' to continue.");
	        }
    	}
        return choice;
    }
    
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
    
    public static int getInt(Scanner sc, String prompt)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

    public static int getInt(Scanner sc, String prompt,
                              int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getInt(sc, prompt);  //utilize the method already written
            if (i <= min)
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            else if (i >= max)
                System.out.println(
                    "Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return i;
    }

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

    public static double getDouble(Scanner sc, String prompt,
                                  double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDouble(sc, prompt);  //use the method already written
            if (d <= min)
                System.out.println(
                    "Error! Number must be greater than " + min + ".");
            else if (d >= max)
                System.out.println(
                    "Error! Number must be less than " + max + ".");
            else
                isValid = true;
        }
        return d;
    }
}