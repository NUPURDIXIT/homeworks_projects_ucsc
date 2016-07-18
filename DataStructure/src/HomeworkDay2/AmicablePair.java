package HomeworkDay2;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 */

/**
 * @author nupurdixit
 * 
 */
public class AmicablePair {
	int num;
	int count = 0;
	int[] factSum; 
	List<Integer> primes = new ArrayList<Integer>();
	int maxPrimeNumber;
	
	AmicablePair(int n) {
		factSum = new int[n+1];
		maxPrimeNumber = (int)Math.ceil(Math.sqrt(n));
		
		System.out.println("The following are amicable numbers");
		//Keeping precomputed factors sum in an array. 
		//So that factors sum is calculated only once for each number
		for(int j = 2; j <= n; j++){
			factSum[j] = getFactorsSum(j); 
		}		
		
		for (int i = 1; i <= n; i++) {
			
			int sum = factSum[i];
			
			//Checking sum != -1 to remove duplicates
			if(sum != -1 && sum <= n && i != sum && factSum[sum] == i){
				System.out.println(count + " :" + i + " and " + sum);
				count++;
				//Setting factors sum of sum to -1, so that 2nd number is not processed (removing duplicate pairs)
				factSum[sum] = -1;
			}

		}

	}
	
	/**
	 * This method calculates factors sum for a given number
	 * @param num
	 * @return
	 */
	private int getFactorsSum(int num){
		//Calculating square root of given number, loop will run only until square root
		int sqrt1 = (int)Math.sqrt(num);
		int sum1 = 1;
		//Loop will run on primes (list populated by following program itself)
		//using primes so that factors sum calculated for smaller numbers can be 
		//utilized for calculating factors sum of bigger numbers
		for(Integer prime: primes){
			if(prime == 0 || prime > sqrt1) break;
			
			if(num%prime == 0){
				int d = num/prime;
				//If will calculate factors sum for numbers like: 4, 9, 16 ... and 18, 21,  ... 
				if(d%prime != 0){
					if(prime != d){
						sum1 = 1 + prime + d + (factSum[d] - 1) +  (prime*factSum[d] - prime);
					}else{
						sum1 = 1 + prime + (factSum[d] - 1) +  (prime*factSum[d] - prime);
					}
					return sum1;
				}
				// else will calculate factors for number like: 8, 12, 12, 36 ... 
				else{
					
					int counter = 1;
					sum1 = d+factSum[d];
					int temp1 = d;
					while(temp1%prime == 0){
						counter++;
						temp1 = temp1/prime;
					}
					int temp = (int)Math.pow(prime, counter);
					sum1 += temp*factSum[temp1];
					return sum1;
					
				}
			}
		}
		
		//If factors sum is not calculated by above routine, it's a prime number
		//keeping this number into primes list. But won't keep prime numbers greater than maxPrimeNumber
		if(num < maxPrimeNumber){
			primes.add(num);
		}
				
		return 1;
	}
	
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
		System.out.println("  Amicable Pairs MAX=100000000");
		System.out.println();
		long startTime = System.nanoTime();
		int n = 100000000;
		AmicablePair a = new AmicablePair(n);

		long EndTime = System.nanoTime();
		double duration = AmicablePair.timeInSec(EndTime, startTime);
		System.out.println("Run time for n = " + n +" is "+ duration + " secs");
		
	}

}

