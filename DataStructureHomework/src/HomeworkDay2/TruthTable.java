package HomeworkDay2;
import java.lang.*;
import java.math.*;

import com.sun.xml.internal.ws.util.StringUtils;
public class TruthTable {
	static private boolean display = true;
	public static void main(String[] args) {
		test1to8();
	}
	
	//Test set for generating truth tables from 2 till 8
	public static void test1to8(){
		
		generateTruthTable(2);
		generateTruthTable(3);
		generateTruthTable(4);
		generateTruthTable(5);
		generateTruthTable(6);
		generateTruthTable(7);
		generateTruthTable(8);
		display=false;
		generateTruthTable(30);
	}
	
		
	private static void generateTruthTable(int n){
		System.out.println("\n---------Truth table of "+n+" inputs function--------------");
		if(display){
			for(int j=0;j<=(Math.pow(2,n)-1);j++ ){
				String format="%0"+n+"d";
				if(display){
					
					System.out.printf(format,Integer.valueOf(Integer.toBinaryString(j)));
					System.out.println();
				}		
					
			}
		}
		System.out.println("For "+n+" inputs, table size is "+(int)Math.pow(2,n));
	}
}
