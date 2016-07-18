//package HomeworkDay2;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 */

/**
 * @author nupurdixit
 * 
 */
public class AmicablePairModified {
	int num;
	int count = 0;
	int[] factSum; 
	List<Integer> primes = new ArrayList<Integer>();
//	int primeCounter = 0;
//	int[] primesArr;
	int maxPrimeNumber;
	
	AmicablePairModified(int n) {
		factSum = new int[n+1];
		maxPrimeNumber = (int)Math.ceil(Math.sqrt(n));
		
		System.out.println("Started .... ");
		for(int j = 2; j <= n; j++){
			factSum[j] = getFactorsSum(j); 
		}		
		System.out.println("Filled ....");
		
//		for(int k = 1; k < n; k++){
//			System.out.println("Num: "+ k +", Sum: "+factSum[k]);
//		}
		
		for (int i = 1; i <= n; i++) {
			
			int sum = factSum[i];//factorsSum.get(i);
			
			if(sum != -1 && sum <= n && i != sum && factSum[sum] == i){
				System.out.println(count + " :" + i + " and " + sum);
				count++;
				factSum[sum] = -1;
			}

		}

	}
	
	private int getFactorsSum(int num){
		
		int sqrt1 = (int)Math.sqrt(num);
		int sum1 = 1;
		for(Integer prime: primes){
			if(prime == 0 || prime > sqrt1) break;
			
			if(num%prime == 0){
				int d = num/prime;
				if(isPrime(d, primes, 0, primes.size() - 1)){
					if(prime != d){
						sum1 = 1 + prime + d;
					}else{
						sum1 = 1 + prime;
					}
					
					return sum1;
				}else if(d%prime != 0){
					sum1 = 1 + prime + d + (factSum[d] - 1) +  (prime*factSum[d] - prime);
					
					return sum1;
				}else{
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
					
					
//					if(temp1 == 1 || isPrime(temp1, primes, 0, primes.size() - 1)){
//						if(temp < num){
//							sum1 += temp;
//						}
//						return sum1;
//					}else{
//						sum1 += temp*factSum[temp1];
//						return sum1;
//					}
					
				}
			}
		}
		//latest

		
//		for (int i = 2; i <= sqrt1; i++) {
//			if (num % i == 0) {
//				int d = num/i;
//				sum1+=i;
//				if(d != i){
//					sum1 += d;
//				}
//				
//			}
//		}
//		System.out.println("Num: "+num+", Sum1: "+sum1+", Sum2: "+sum2);
		
//		if(sum1 == 1){
			if(num < maxPrimeNumber){
//				primesArr[primeCounter++] = num;
				primes.add(num);
			}
				
//		}
		
		return 1;
	}
	
	private boolean isPrime(int t, List<Integer> list, int l, int h){
		
		if(h<l){
			return false;
		}
		
		int m = (l+h)/2;
		
		if(t == list.get(m)){
			return true;
		}else if(t < list.get(m)){
			return isPrime(t, list, l, m-1);
		}else{
			return isPrime(t, list, m+1, h);
		}
		
	}

	/*private void findAmicablePairs(int num) {
		//List<Integer> divisors1 = new ArrayList<Integer>();
		//List<Integer> divisors2 = new ArrayList<Integer>();
		int sum1 = 1;
		int sum2 = 1;
		if(factorsSum.containsKey(num)){
			sum1 = factorsSum.get(num);
		}else{
			int sqrt1 = (int)Math.sqrt(num);
			for (int i = 2; i <= sqrt1; i++) {
				if (num % i == 0) {
					sum1+=i;
					//divisors1.add(i);
					
					sum1+=(num/i);
						//divisors1.add(num/i);
					
				}
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
		factorsSum.put(sum1, sum2);
		//for (Integer sumOfDivisors1 : divisors2) {
		//	sum2 += sumOfDivisors1;
		//}
		if (num == sum2) {
			System.out.println(count + " :" + num + " and " + sum1);
			count++;
			listPairs.add(sum1);
			//System.out.println("list pairs:" + listPairs);

		}

	}*/

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
		AmicablePairModified a = new AmicablePairModified(n);

		long EndTime = System.nanoTime();
		double duration = AmicablePairModified.timeInSec(EndTime, startTime);
		System.out.println("Run time " + duration + " : secs");
		
//		System.out.println(a.primes);

	}

}

