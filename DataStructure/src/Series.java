import java.math.BigDecimal;
import java.math.BigInteger;

public class Series {

	public static void main(String[] args) {
		
		seriesConvergeAbsolutely();
		
		harmonicSeries();
		
		printForPrimes();
		for(int i=100;i<=1000000;i*=10){
			numberOfPrimes(i);
		}
		
		chess();

	}
	
	public void testlog(){
		
		
	}
	
	public static void seriesConvergeAbsolutely(){
		
		double geometricSum = 0;
		
		for(int i=0;i<=100;i++){
			
			geometricSum+=Math.pow(0.5, i);
		}
		
		System.out.println("Sum of Geometric series is : "+(int)geometricSum);
		
	}
	
	
	public static void harmonicSeries(){
		double harmonicSum=0;
		for(int i=1;i<=100;i++){
			
			harmonicSum+=(1.0/i);
		}
		double sumByFormula=Math.log(100)+0.57721566;
		
		System.out.println("Sum of given harmonic series is: "+harmonicSum);
		System.out.println("Sum of given harmonic series computed through formula is: "+sumByFormula);
	}
	
	
	public static void chess(){
		double sumOfRice=0;
		double power=0;
		long sumOfRiceByFormula=0L;
		for(int i=1;i<=64;i++){
			power=Math.pow(2,i-1);
			sumOfRice+=power;
			
			System.out.println("On square "+i+" = "+ (long)power);
		}
		sumOfRiceByFormula+=Math.pow(2,64)-1;
		System.out.println("Total rice = "+(long)sumOfRice);
		System.out.println("Total rice computed by the formula for geometric series = "+sumOfRiceByFormula);
		
	}
	
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
