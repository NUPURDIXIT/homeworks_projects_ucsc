//package HomeworkDay2;

public class primeRevised {
	static int count=0;
	
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
		//int n = 100000000;
		System.out.println("n         #P(n)    n/log n -1");
		System.out.println("-------------------------------------------");
		int n = 1000000000;
		//for(int i=100;i<=100000000;i*=10){
			numberOfPrimes(100000000);
		//}

		long EndTime = System.nanoTime();
		double duration = primeRevised.timeInSec(EndTime, startTime);
		System.out.println("Run time " + duration + " : secs");

	}
		
		
		// TODO Auto-generated method stub
		public static void numberOfPrimes(int num){
		
			boolean flag=true;
			double valueByFormula=0;
			int i=0;
			
			//Starting testing from 4 since 2 and 3 are known prime numbers so would increase the count by 2 at end.
			/*if(num==100){
				i=4;
			}
			else{
				i=(num/10) +1;
			}*/
				
				
			 for(i=4;i<=num;i++){
				flag=true;
				//Calculate the square root of the number to be tested at the beginning of loop so thats its not computed in every iteration
				int sqrt=(int)Math.sqrt(i);
				
				//Run the loop till the square root of the number t be tested for prime. If its divisible by any then set flag to false and break
				
				for(int j=2;j<=sqrt;j++){
					if(i%j==0){
						flag=false;
						break;
					}
					
				}
				//If the number to be tested is not divisible by any number in the loop above then inrease the count of prime numbers obtained in the range
				if(flag){
					count++;
				}
				
				//To calculate the number of primes by the Prime nUmber Theorem 
				valueByFormula=((num*1.0)/(Math.log(num)-1));
				
			}
			
			//Print the count of prime numbers obtained
			System.out.format("%-12d %-8d %-8d",num,count+2,(int)valueByFormula);
			System.out.println();
		}
	}


