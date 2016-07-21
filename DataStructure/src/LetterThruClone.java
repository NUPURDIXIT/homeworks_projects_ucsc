
public class LetterThruClone {
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
		
		//If the element to be searched is at the same index of start then , return the number of hops to be 0
		if(s[x]==x){
			return 0;
		}
		
		//clone the original array to another array named copyOriginalArray and perform Recursion calls to obtain the result.
		//This is done to ensure that the original array remains unchanged after this operation.
		
		int[] copyOriginalArray=s.clone();
		
		//On returning back to the index from where the recursion call started the value would be -1, thus return -1
		if(copyOriginalArray[x] == -1){
			return -1;
		}
		
		int t = copyOriginalArray[x];
		
		//For every traversed index,overwrite the value of that index with -1.
		copyOriginalArray[x] = -1;
		
		//Add 1 to each recursion call, this keeps track of the number of hops
		return length(copyOriginalArray, t)+1;
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
