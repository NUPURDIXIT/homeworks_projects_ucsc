package DemoDay4;
public class SwapHandsOnDemo {

	  /** Swap two variables, which does not work*/
	  public static void wrongSwap(int n1, int n2) {
	    // Swap n1 with n2
	    int temp = n1;
	    n1 = n2;
	    n2 = temp;
	  }

	  /** Swap two variables, which does work*/
	  public static void correctSwapArrayAsParameter(int [] n) {
		    // Swap n1 with n2
		    int temp = n[0];
		    n[0] = n[1];
		    n[1] = temp;

		  }

	  /** Swap two variables, which does work*/
	  public static int [] correctSwapArrayAsReturnType(int n1, int n2) {

	    int [] n = new int[2]; //create a local array
	    
	    // Swap n1 with n2 and store in intArray[0] and intArray[1]
	    int temp = n1;
	    n[0] = n2; //populate the array
	    n[1] = temp;

		return n; //you returning whole array;
		          //yes, and it is fine in Java to return a local array
	  }	
	
  /** Main method */
  public static void main(String[] args) {
    // Declare and initialize variables
    int num1 = 46;
    int num2 = 13;

    System.out.println("Before invoking the wrongSwap methods, num1 is " +
    						num1 + 
    						" and num2 is " + 
    						num2);

    // Invoke the swap method to attempt to swap two variables
    wrongSwap(num1, num2);

    System.out.println("After invoking the wrongSwap method, num1 is " +
    						num1 + 
    						" and num2 is " + 
    						num2);
    System.out.println();
    
    int intArray[] = new int[2];
    intArray[0] = num1;
    intArray[1] = num2;
    System.out.println("Before invoking the correctSwapArrayAsParameter method, num1 is " +
			intArray[0] + 
			" and num2 is " + 
			intArray[1]);
    correctSwapArrayAsParameter(intArray);

    System.out.println("After invoking the correctSwapArrayAsParameter method, num1 is " +
    						intArray[0] + 
    						" and num2 is " + 
    						intArray[1]);

    System.out.println();

    System.out.println("Before invoking the correctSwapArrayAsReturnType method, num1 is " +
			num1 + 
			" and num2 is " + 
			num2);
    int newIntArray[] = new int[2];
    newIntArray = correctSwapArrayAsReturnType(num1, num2);

    System.out.println("After invoking the correctSwapArrayAsReturnType method, newIntArray[0] is " +
    						newIntArray[0] + 
    						" and newIntArray[1] is " + 
    						newIntArray[1]);
  }
}
