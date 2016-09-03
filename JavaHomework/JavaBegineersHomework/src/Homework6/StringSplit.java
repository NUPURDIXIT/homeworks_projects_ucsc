package Homework6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringSplit.split("ab#12#23#45","#");
		
		
	}
	public static void split(String s,String regex){
		
		System.out.println(s.replaceAll(regex,",#,"));
		
	}
}
