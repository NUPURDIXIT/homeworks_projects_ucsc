package Misc;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//double a=2.5;
		/*double x=Math.pow(2,15);
		char ch='a';
		String message="   Welcome to Java   ";
		System.out.println("String's length is: "+ message.trim()+" "+message.length());
		System.out.println("Value of a is"+ x + "value of ch is :" + ++ch); 
		*/
		//System.out.printf("%5d %f",1,2.0,4);
		//System.out.printf("the amount is %f %2.4e\n",32.32,32.32);
		//System.out.printf("amount is %5.2f%% %5.3e\n",32.327,32.32);
		/*System.out.printf("%6b\n", (1 > 2));
		System.out.printf("%6s\n", "Java");
		System.out.printf("%-6b%s\n", (1 > 2), "Java");
		System.out.printf("%6b%-8s\n", (1 > 2), "Java");*/
		//int n = 10000 * 10000 * 10000;
	    //System.out.println("n is " + n);
	    //System.out.println(-24 % -5 );
		/*int n=09;
		long x=9;
		float x=1.0;*/
		/*int j = 1;
	    int i = j + ++j;
	    	
	    if (i>0) && (j>0){
	    	System.out.println(" i is :" + i);
	    }*/
		/*int x = 1;
	    int y = x = x + 1;
	    System.out.println("y is " + y);*/
			
		
		/*int count = 0;
		do {
		  System.out.println("Welcome to Java");
		  
		  System.out.println("Value of count is: "+ count);
		} while (++count < 10);	*/
		
		
		
		/*for (int i = 1; i <= 10; i++) {
			  System.out.println(i + " ");
			  i++;
			  System.out.println("i is incremented to :"+ i);
			}*/
		
		/*
		int y = 0;
		for (int i = 0; i < 10; ++i) {
		  y += i;
		  System.out.println("i is :"+ i);
		}
		*/
		
		
		/*for (int i = 0; i < 10; i++) 
			  for (int j = 0; j < i; j++)
			    System.out.println("value of j is :"+j+ "value of i is: "+i+ "value of i * j is:"+ j*i);
		*/
		
		
		
		
		for (int i = 1; i <= 6; i++) {
			  for (int j = 6; j >= 1; j--)
			    System.out.print(j <= i ? j + " " : " " + " ");
			  System.out.println();
			}
		
		
	}

}
