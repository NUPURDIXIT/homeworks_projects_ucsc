import java.util.ArrayList;
import java.util.List;

/**
 * 
 */

/**
 * @author nupurdixit
 * 
 */
public class AmicablePairOld {
	private int n;
	int num;
	int count = 0;
	List<Integer> listPairs = new ArrayList<Integer>();
	
	
/*
 * Invoke findAmicablePairs and keep storing the obtained pairs in a list so that they are not computed again
 */
	AmicablePairOld(int n) {
		this.n = n;

		for (int i = 2; i < n; i++) {
			if (listPairs.contains(i)) continue;
				findAmicablePairs(i);

		}

	}

/*
 * This method finds all the amicable pairs
 */
	private void findAmicablePairs(int num) {
		
		int sum1 = 1;
		int sum2 = 1;
		int sqrt1 = (int)Math.sqrt(num);
		for (int i = 2; i <= sqrt1; i++) {
			if (num % i == 0) {
				sum1+=i;
				sum1+=(num/i);
				
			}
		}
			
		
		if(sum1 == num) return;
		
		int sqrt2 = (int)Math.sqrt(sum1);
		for (int j = 2; j <= sqrt2; j++) {
			if (sum1 % j == 0) {
				sum2+=j;
			
				sum2+=(sum1/j);
				
			}
		}
	
		if (num == sum2) {
			System.out.println(count + " :" + num + " and " + sum1);
			count++;
			listPairs.add(sum1);
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
		AmicablePairOld a = new AmicablePairOld(n);

		long EndTime = System.nanoTime();
		double duration = AmicablePairOld.timeInSec(EndTime, startTime);
		System.out.println("Run time " + duration + " : secs");

	}

}
