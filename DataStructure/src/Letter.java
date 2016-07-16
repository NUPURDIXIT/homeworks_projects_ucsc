import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//package Homework_Day3;

//import Homework_Day3.IntUtil;

public class Letter {
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
 * With subroutine
 */
	
	/**
	private static int length(int [] s, int x) {
		
		return subLength(s,x,x);
		}
		
		
	private static int subLength(int[] s,int n,int a){
		
			if(s[a]==n){
				return 0;
			}
			return subLength(s,n,s[a])+1;
		
	}
	*/
	
	/*
	 * Method to find the hops
	 */
	private static int length(int[] s,int x){
		int[] copyOriginalArray=s.clone();
		if(copyOriginalArray[x] == -1){
			return -1;
		}
		int t = copyOriginalArray[x];
		copyOriginalArray[x] = -1;
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
