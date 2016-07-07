import java.util.Random;
public class Bartender {
	private int min;
	private int max;
	
	Bartender(int min, int max){
		this.min=min;
		this.max=max;
	}
	
	private int guess(int g,boolean show){
	
		int midNum;
		int count=0;
		int newMin=min;
		int newMax=max;
		if(show){
			System.out.println("Number to be guessed "+g );
			System.out.println("-------------------------");
		}
		
		//Run the loop till the actual number to be guessed does not match the number being guessed each time
		do{
			++count;
			
			//Find the number exactly at half range of min and max, check whether it lies to the left or right range.
			// If it matches with the mid number then return the count at that time only
			
			midNum=(int)Math.ceil((newMin+newMax)/2);
			
			if(show){
				System.out.println(count+":"+" l= "+newMin+" "+"r= "+ newMax+" "+"m= "+midNum+"\n");
			}
			if(midNum==g){
				return count;
			}
			else if(midNum<g){
				
				newMin=midNum+1;
				
			}
			else {
				newMax=midNum-1;
								
			}
			
		}while(g!=midNum);
		
		
		return count;
	
	}
	
	private static void test(int s,int b,int m,boolean useRandom,boolean show){
		Random r=new Random();
		int min=9999;
		int max=0;
		Bartender h=new Bartender(s,b);
		for(int i=0;i<m;++i){
			int v=i+s;
			if(useRandom){
				v=RandomInt.getRandomInt(r,s,b);
			}
			int n=h.guess(v,show);
			
			if(n>max){
				max=n;
			}
			if(n<min){
				min=n;
			}
		}
		System.out.print("For numbers between "+s +" to "+b+" ");
		if(useRandom){
			System.out.print("(random numbers)");
			
		}
		else{
			System.out.print("(not random numbers)");
		}
		System.out.println("the min guess is "+min+" max guess is "+max);
		
	}
	private static void testBench(){
		test(1,10,10,false,true);
		test(1,1000000,1000000,false,false);
		test(1,1000000,1000,true,false);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Bartender.java");
		testBench();
		System.out.println("DONE");

	}

}
