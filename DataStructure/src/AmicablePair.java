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
	private int n;
	int num;
	int count = 0;
	List<Integer> listPairs = new ArrayList<Integer>();
	
	AmicablePair(int n) {
		this.n = n;

		for (int i = 2; i < n; i++) {
			if (listPairs.contains(i)) continue;
				findAmicablePairs(i);

		}

	}

	private void findAmicablePairs(int num) {
		//List<Integer> divisors1 = new ArrayList<Integer>();
		//List<Integer> divisors2 = new ArrayList<Integer>();
		int sum1 = 1;
		int sum2 = 1;
		int sqrt1 = (int)Math.sqrt(num);
		for (int i = 2; i <= sqrt1; i++) {
			if (num % i == 0) {
				sum1+=i;
				//divisors1.add(i);
				
				sum1+=(num/i);
					//divisors1.add(num/i);
				
			}
		}
			
		
		if(sum1 == num) return;
		//for (Integer sumOfDivisors : divisors1) {
		//	sum1 += sumOfDivisors;
		//}
		int sqrt2 = (int)Math.sqrt(sum1);
		for (int j = 2; j <= sqrt2; j++) {
			if (sum1 % j == 0) {
				sum2+=j;
				//divisors2.add(j);
				
				sum2+=(sum1/j);
					//divisors2.add(sum1/j);
				
				
			}
		}
		//for (Integer sumOfDivisors1 : divisors2) {
		//	sum2 += sumOfDivisors1;
		//}
		if (num == sum2) {
			System.out.println(count + " :" + num + " and " + sum1);
			count++;
			listPairs.add(sum1);
			//System.out.println("list pairs:" + listPairs);

		}

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
		long startTime = System.nanoTime();
		int n = 1000000;
		AmicablePair a = new AmicablePair(n);

		long EndTime = System.nanoTime();
		double duration = AmicablePair.timeInSec(EndTime, startTime);
		System.out.println("Run time " + duration + " : secs");

	}

}
