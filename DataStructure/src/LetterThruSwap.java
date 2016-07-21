
public class LetterThruSwap {

		private static final IntUtil u = new IntUtil();
		
		
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			long startTime=System.nanoTime();
			System.out.println("Length.java");
			testbed() ;
			testbed1() ;
			long endTime=System.nanoTime();
			double duration = u.timeInSec(endTime, startTime);
			System.out.println("Duration is : "+duration);
			
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
	 * With subroutine
	 */
		
		
		private static int length(int [] s, int x) {
			
			if(s[x]==x){
				return 0;
			}
			int y=s[x];
			int temp=s[x];
			s[x]=s[y];
			s[y]=temp;
			int l=length(s,x)+1;
			temp=s[y];
			s[y]=s[x];
			s[x]=temp;
			return l;
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



