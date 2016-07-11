package HomeworkDay2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 */

/**
 * @author nupurdixit
 * 
 */
public class AmicableRevised {
	private int n;
	int num;
	int count = 0;
	int[] arraySum=new int[100000000];
	List<Integer> listPairs = new ArrayList<Integer>();
	
	
/*
 * Invoke findAmicablePairs and keep storing the obtained pairs in a list so that they are not computed again
 */
	AmicableRevised(int n) {
		this.n = n;
	
		arraySum=findAmicablePairs(n);

		
		checkPair(arraySum,this.n);

	}

/*
 * This method finds all the amicable pairs
 */
	private  int[] findAmicablePairs(int num) {
		
		//int num=100000;
		//int sqrt1 = (int)Math.sqrt(num);
		int i=0;
		int k=0;
		int sum1 = 1;
		int sum2 = 1;
		//int sqrt1 = (int)Math.sqrt(num);
		for (k = 2; k <= num; k++) {
			sum1=1;
		
			int sqrt1 = (int)Math.sqrt(k);
			for (i = 2; i <= sqrt1; i++) {
				if (k % i == 0) {
					sum1+=i;
					if(i!=(k/i)){
						sum1+=(k/i);
					}
				
				}
			}
		arraySum[k]=sum1;
		
		//System.out.println("arrray sum for"+k+" is"+arraySum[k]);
		
		}
		
		
		return arraySum;
	}
	
	public void checkPair(int[] arraySum,int num){
		int j=0;
		int sum=0;
		for(j=2;j<=num;j++){
			//if(Arrays.asList(arraySum).contains(j)){
			sum=arraySum[j];
			
			//System.out.println("Sum for "+j+" is:"+sum);
			if(arraySum[sum]==j & j!=arraySum[j]){
				count++;
				//arraySum[sum]=-1;
			
				//if(arraySum[j]>0){
					System.out.println(count+" : "+ j + " and " + arraySum[j]);
				//}
			}
			
		}
		
			
	}
		

	
/*
 * Calculate the time taken to find all the amicable pairs till 100000000.
 */
	public static double timeInSec(long endTime, long startTime) {
		long duration = (endTime - startTime);
		if (duration > 0) {
			double dm = (duration / 1000000.0); // Milliseconds
			double d = dm / 1000.0; // seconds

			return d;
		}
		return 0.0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int n = 100000000;
		AmicableRevised a = new AmicableRevised(n);

		long EndTime = System.nanoTime();
		double duration = AmicableRevised.timeInSec(EndTime, startTime);
		System.out.println("Run time " + duration + " : secs");

	}

}
