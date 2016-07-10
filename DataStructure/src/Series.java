import java.math.BigDecimal;
import java.math.BigInteger;

public class Series {

	public static void main(String[] args) {
		
		System.out.println("-----function tesLog() STARTS-----------------------------------");
		System.out.println("n       base10   base2     base e");
		testLog();
		System.out.println("-----function tesLog() ENDS-----------------------------------");
		System.out.println();
		
		
		System.out.println("-----function seriesConvergeAbsolutely() STARTS-----------------------------------");
		seriesConvergeAbsolutely();
		System.out.println("-----function tesLog() ENDS-----------------------------------");
		System.out.println();
		
		
		System.out.println("-----function harmonicSeries() STARTS-----------------------------------");
		harmonicSeries();
		System.out.println("-----function harmonicSeries() ENDS-----------------------------------");
		System.out.println();
		
		
		System.out.println("-----function printForPrimes() STARTS-----------------------------------");
		printForPrimes();
		for(int i=100;i<=1000000;i*=10){
			numberOfPrimes(i);
		}
		System.out.println("-----function printForPrimes() ENDS-----------------------------------");
		System.out.println();
		

		System.out.println("-----function chess() STARTS-----------------------------------");
		chess();
		System.out.println("-----function chess() ENDS-----------------------------------");
		System.out.println();
		

	}
	
/****************************************************************************************************************************************
	The below function prints the log,lg,le 
****************************************************************************************************************************************/	
	
	public static void testLog(){
		
		//Logic prints the log,lg,le for n=1 to 10 at a step of n=n+1
		for(int i=1;i<10;i++){
			System.out.format("%-6d %-5.5f %s %-5.5f %s %-5.5f",i,(Math.log(i)/Math.log(10))," ",(Math.log(i)/Math.log(2))," ",Math.log(i));
			System.out.println();
		}
		
		//Logic prints the log,lg,le for n=10 to 100 at a step of n=n+10
		for(int i=10;i<100;i+=10){
			System.out.format("%-6d %-5.5f %s %-5.5f %s %-5.5f",i,(Math.log(i)/Math.log(10))," ",(Math.log(i)/Math.log(2))," ",Math.log(i));
			System.out.println();
		}
		
		//Logic prints the log,lg,le for n=100 to 1000 at a step of n=n+100	
		for(int i=100;i<1000;i+=100){
			System.out.format("%-6d %-5.5f %s %-5.5f %s %-5.5f",i,(Math.log(i)/Math.log(10))," ",(Math.log(i)/Math.log(2))," ",Math.log(i));
			System.out.println();
		}
		
		//Logic prints the log,lg,le for n=1000 to 10000 at a step of n=n+1000
		for(int i=1000;i<=10000;i+=1000){
			System.out.format("%-6d %-5.5f %s %-5.5f %s %-5.5f",i,(Math.log(i)/Math.log(10))," ",(Math.log(i)/Math.log(2))," ",Math.log(i));
			System.out.println();
		}
		
	}
	
	
/****************************************************************************************************************************************
	The below function computes the result of the given series and the output obtained is 2.
****************************************************************************************************************************************/
	public static void seriesConvergeAbsolutely(){
		
		double geometricSum = 0;
		
		for(int i=0;i<=100;i++){
			
			geometricSum+=Math.pow(0.5, i);
		}
		
		System.out.println("Sum of Geometric series is : "+(int)geometricSum);
	}
	
	
	
/****************************************************************************************************************************************
	The below function computes the result of the given harmonic series. The output obtained is equal to ln(n)+0.57721566
****************************************************************************************************************************************/
	public static void harmonicSeries(){
		double harmonicSum=0;
		for(int i=1;i<=100;i++){
			harmonicSum+=(1.0/i);
		}
		
		////Computing the sum via formula ln(n)+0.57721566
		double sumByFormula=Math.log(100)+0.57721566; 
		
		//Printing the sum by adding the numbers in the given harmonic series
		System.out.println("Sum of given harmonic series is: "+harmonicSum);
		
		//Printing the sum obtained via formula
		System.out.println("Sum of given harmonic series computed through formula is: "+sumByFormula);
	}
	
	
/****************************************************************************************************************************************
	The below function prints the number of rice in each square and total number of rice placed on the chessboard
****************************************************************************************************************************************/
	public static void chess(){
		
		//storing the result in BigInteger
		BigInteger power= BigInteger.ZERO;
		BigInteger sumOfRice= BigInteger.ZERO;
		BigInteger sumOfRiceByFormula= BigInteger.ZERO;
		BigInteger two=new BigInteger("2");
		BigInteger one=new BigInteger("1");
		
		for(int i=1;i<=64;i++){
			power=two.pow(i-1);
			sumOfRice=sumOfRice.add(power);
			System.out.println("On square "+i+" = "+ power);
		}
		
		sumOfRiceByFormula=two.pow(64);
		sumOfRiceByFormula.subtract(one);
		System.out.println("Total rice = "+sumOfRice);
		System.out.println("Total rice computed by the formula for geometric series = "+sumOfRiceByFormula);
		
	}
	
	

/****************************************************************************************************************************************
	The below function prints the expected number of primes using logic and formula n/ln(n)-1
****************************************************************************************************************************************/
	
	
	public static void printForPrimes(){
		System.out.println("n         #P(n)    n/log n -1");
		//System.out.println();
		System.out.println("-------------------------------------------");
	}
	
	public static void numberOfPrimes(int num){
		int count=0;
		boolean flag=true;
		double valueByFormula=0;
		
		for(int i=4;i<=num;i++){
			flag=true;
			int sqrt=(int)Math.sqrt(i);
			for(int j=2;j<=sqrt;j++){
				if(i%j==0){
					flag=false;
					break;
				}
				
			}
			if(flag){
				count++;
			}
			valueByFormula=((num*1.0)/(Math.log(num)-1));
			
		}
		
		
		System.out.format("%-10d %-8d %-8d",num,count+2,(int)valueByFormula);
		System.out.println();
	}
	
	

}
