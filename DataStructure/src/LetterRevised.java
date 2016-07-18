
public class LetterRevised {

	private static final IntUtil u = new IntUtil();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Length.java");
		testbed() ;
		testbed1() ;
	}
	
	
	private static int length_easy(int [] s, int x) {
		int l = 0 ;
		int gx = x ;
		while (true) {
		if (s[x] == gx) {
		return l ;
		}
		x = s[x] ;
		++l ;
		}
		}
	

		
	/*
	 * Method to find the number of hops
	 */
	private static int length(int[] s,int x){
		Integer a=Integer.MAX_VALUE;
		
		////Exit case for recursion: last step of 2nd round when index is < 0 but value is > 0
		if(x<0 && s[x+a]>=0) return -1;
		
		//2nd round of restoring array values stars when we see first value < 0, not in this round we are not incrementing steps
		if(x<0 || s[x]<0){
			x=(x<0)?x+a:x;
			int b=s[x];
			s[x]=s[x]+a;
			return length(s,b);
		}
		
		//1st round: subtract Integer.MAX_VALUE from every value seen and increment step counter
		s[x]=s[x]-a;
		return length(s,s[x]+a)+1;
		
	}
	
	
		
	public static void testbed() {
		int s[] = {5,1,0,4,2,3} ;
		int y = length_easy(s,3) ;
		System.out.println("length_easy y = " + y);
		u.myassert(y == 4) ;
		int b[] = {5,1,0,4,2,3} ;
		int x = length(s,3) ;
		System.out.println("length x = " + x);
		u.myassert(x == y) ;
		for (int i = 0; i < s.length; ++i) {
		u.myassert(s[i] == b[i]);
		}
		System.out.println("Assert passed");
	}
	
	public static void testbed1() {
		int s[] = {5,1,0,4,2,3} ;
		int b[] = {5,1,0,4,2,3} ;
		int l = s.length ;
		for (int j = 0; j < l ; ++j) {
		int y = length_easy(s,j) ;
		System.out.println("length_easy y = " + y);
		int x = length(s,j) ;
		System.out.println("length x = " + x);
		u.myassert(x == y) ;
		for (int i = 0; i < s.length; ++i) {
		u.myassert(s[i] == b[i]);
		}
		System.out.println("Assert passed");
		}
	}

}



