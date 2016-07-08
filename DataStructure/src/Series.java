import java.math.BigDecimal;
import java.math.BigInteger;

public class Series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int sum;
		
		//seriesConvergeAbsolutely();
		//System.out.println("Sum of Geometric series is : "+bg1.longValue());
		harmonicSeries();
		numberOfPrimes();
		

	}
	
	public void testlog(){
		
		
	}
	
	/*public static void seriesConvergeAbsolutely(){
		//BigDecimal geometricSum=new BigDecimal(0);
		//double geometricSum = 0;
		BigInteger bg1=new BigDecimal(geometricSum).toBigInteger();
		for(int i=0;i<=100;i++){
			geometricSum+=Math.pow(1/2, i);
		}
		BigInteger bg1=new BigDecimal(geometricSum).toBigInteger();
		System.out.println("Sum of Geometric series is : "+bg1);
		//return geometricSum;
	}*/
	
	
	public static void harmonicSeries(){
		long harmonicSum=0;
		for(int i=1;i<=100;i++){
			harmonicSum+=(1/i);
		}
		double sum=Math.log(100)+0.57721566;
		
		System.out.println("Sum of harmonic series is: "+harmonicSum);
		System.out.println("Sum of right hand side of harmonic series is: "+sum);
	}
	
	
	public void chess(){
		
	}
	
	public static void numberOfPrimes(){
		int count=0;
		boolean flag=true;
		for(int num=4;num<100000000;num++){
			flag=true;
			for(int i=2;i<=Math.sqrt(num);i++){
				if(num%i==0){
					flag=false;
					break;
				}
				
			}
			if(flag){
				count++;
			}
		}
		System.out.println("Number of primes till 100 are :"+(count+2));
	}
	
	

}
