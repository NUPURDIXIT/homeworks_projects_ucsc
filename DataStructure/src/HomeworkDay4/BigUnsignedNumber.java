package HomeworkDay4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * File Name: BigUnsignedNumber.java Infinite capacity Unsigned Number
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: BigUnsignedNumber.java CharArray.java Cstring
 * IntUtil.java
 */

class BigUnsignedNumber {
	private Cstring d; // data
	static IntUtil u = new IntUtil();
	// Cannot add any more data fields

	// WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS

	// CANNOT CHANGE ANYTHING BELOW
	public BigUnsignedNumber() {
		d = new Cstring();
	}

	public BigUnsignedNumber(char ch) {
		d = new Cstring(ch);
	}

	public BigUnsignedNumber(String str) {
		d = new Cstring(str);
	}

	public BigUnsignedNumber(char[] ch) {
		d = new Cstring(ch);

	}

	public BigUnsignedNumber(int num) {
		char[] chArray = String.valueOf(num).toCharArray();
		d = new Cstring(chArray);
	}

	public BigUnsignedNumber(Cstring cstring) {
		d = cstring;
	}

	public void pLn(String t) {
		d.pLn(t);
		System.out.println();
	}

	public BigUnsignedNumber clone() {
		Cstring c = this.d.clone();
		BigUnsignedNumber b = new BigUnsignedNumber(c);
		return b;
	}

	public BigUnsignedNumber add(BigUnsignedNumber b) {
		int i = this.d.size();
		int j = b.d.size();
		int sizeDifference = 0;
		if (i > j) {
			sizeDifference = i - j;
			for (int a = j - 1; a >= 0; a--) {
				b.d.setCharAtIndex(a + sizeDifference, b.d.get(a));
			}

			for (int a = 0; a < sizeDifference; a++) {
				b.d.setCharAtIndex(a, '0');
			}

			j = b.d.size();

		} else {
			sizeDifference = j - i;
			for (int a = i - 1; a >= 0; a--) {
				this.d.setCharAtIndex(a + sizeDifference, this.d.get(a));
			}
			for (int a = 0; a < sizeDifference; a++) {
				this.d.setCharAtIndex(a, '0');
			}
			i = this.d.size();
		}

		CharArray num1 = this.d.getCharArray();
		CharArray num2 = b.d.getCharArray();

		int carry = 0;
		int sum = 0;

		BigUnsignedNumber num = new BigUnsignedNumber();
		System.out.println("i is: " + i);
		num.d.setCharAtIndex(i, '\0');
		while (i > 0 || j > 0) {
			sum = 0;
			int digitA = num1.get(i - 1) - '0';
			int digitB = num2.get(j - 1) - '0';
			sum = (digitA + digitB + carry) % 10;
			carry = (digitA + digitB + carry) / 10;
			num.d.append(sum + "");
			i--;
			j--;
		}
		if (carry > 0) {
			num.d.append(carry + "");
		}
		num.d.reverse();
		return num;
	}

	public BigUnsignedNumber add(String s) {
		BigUnsignedNumber b = new BigUnsignedNumber(s);
		BigUnsignedNumber c = this.add(b);
		return c;
	}

	private void setDigit(int index, int ch) {
		this.d.setCharAtIndex(index, Character.forDigit(ch, 10));
	}

	private int getDigit(int index) {
		return this.d.get(index) - '0';
	}

	private void addDigitAtPosition(int index, int ch) {

	}

	public boolean isEqual(BigUnsignedNumber b) {
		boolean flag = this.d.isEqual(b.d);
		return flag;

	}

	public boolean isEqual(String str) {
		BigUnsignedNumber b = new BigUnsignedNumber(str);
		return this.isEqual(b);

	}

	public boolean isEqual(int num) {
		BigUnsignedNumber b = new BigUnsignedNumber(num);
		return b.isEqual(num);

	}

	public BigUnsignedNumber mult(BigUnsignedNumber num) {
		BigUnsignedNumber output = new BigUnsignedNumber();
		for (int i = 0; i < this.d.size() + num.d.size(); i++) {
			output.d.setCharAtIndex(i, '0');
		}
		int outputIndex = 0;
		int maxOutputIndex = 0;
		// for(int i = 0; i<=10; i++){
		// System.out.println(String.format("digit at %d: %d", i,
		// output.getDigit(i)));
		// }
		for (int index = num.d.size() - 1; index >= 0; index--) {
			int digit = num.getDigit(index);
			int offset = num.d.size() - 1 - index;
			outputIndex = offset;
			int carry = 0;
			int sumCarry = 0;
			for (int index1 = d.size() - 1; index1 >= 0; index1--) {
				int digit1 = getDigit(index1);
				// System.out.println(String.format("Digit: %d, Digit1: %d",
				// digit, digit1));
				int temp = digit * digit1 + carry;
				int toAdd = temp % 10;
				carry = temp / 10;

				// System.out.println(String.format("toAdd: %d,
				// getDigit(outputIndex): %d", toAdd,
				// output.getDigit(outputIndex)));
				int sum = output.getDigit(outputIndex) + toAdd + sumCarry;

				// System.out.println(String.format("temp: %d, toAdd: %d, Carry:
				// %d, sum: %d outputIndex: %d", temp, toAdd, carry, sum,
				// outputIndex));
				// System.out.println(String.format("sum10: %d,
				// getDigit(outputIndex+1): %d, sum/10: %d", sum%10,
				// output.getDigit(outputIndex+1), sum/10));
				int temp1 = sum % 10;
				sumCarry = sum / 10;
				// int temp2 = output.getDigit(outputIndex+1)+sum/10;
				output.setDigit(outputIndex, temp1);
				// output.setDigit(outputIndex+1, temp2);
				// System.out.println(String.format("temp1: %d, sumCarry: %d",
				// temp1, sumCarry));
				if (index1 == 0) {
					int temp3 = output.getDigit(outputIndex + 1) + carry + sumCarry;
					output.setDigit(outputIndex + 1, temp3 % 10);
					output.setDigit(outputIndex + 2, temp3 / 10);
				}
				if (outputIndex + 1 > maxOutputIndex) {
					maxOutputIndex = outputIndex + 1;
				}
				outputIndex++;

			}
		}
		// System.out.println(String.format("maxOutputIndex: %d",
		// maxOutputIndex));
		// for(int i = 0; i<=10; i++){
		// System.out.println(String.format("digit at %d: %d", i,
		// output.getDigit(i)));
		// }
		output.d.setCharAtIndex(maxOutputIndex + 1, '\0');
		output.d.reverse();
		return output;
	}
	// int i=this.d.size();
	// // System.out.println("i is: "+i);
	// int j=num.d.size();
	// // System.out.println("j is: "+j);
	//
	// for(int a=1;a<result;a++){
	// prod=num1.add(num);
	// num1=prod;
	// }
	// return prod;
	//
	/*
	 * int sum; // int[] list=new int[i]; int carry=0;
	 * 
	 * for(int a=0;a<i;a++){ this.d.setCharAtIndex(a, this.d.get(a));
	 * 
	 * // System.out.println("list is: "+a+"is :"+this.d.get(a));
	 * 
	 * }
	 * 
	 * for(int a=0;a<i;a++){ num.d.setCharAtIndex(a, num.d.get(a));
	 * 
	 * // System.out.println("list is: "+a+"is :"+this.d.get(a));
	 * 
	 * }
	 * 
	 * BigUnsignedNumber prod=new BigUnsignedNumber(); //BigUnsignedNumber
	 * num1=num; BigUnsignedNumber zero=new BigUnsignedNumber('0');
	 * BigUnsignedNumber one=new BigUnsignedNumber('1');
	 * prod.d.setCharAtIndex(i+j+1, '\0'); int result=0; if(i<j){
	 * BigUnsignedNumber num1=num; for(int a=0;a<i;a++){
	 * result=(10*result)+this.d.get(a)-'0'; } if(result==0 || num==zero) return
	 * zero; else if(result==1) return num; else if(num==one) return this; else{
	 * for(int a=1;a<result;a++){ prod=num1.add(num); num1=prod; } return prod;
	 * }
	 * 
	 * 
	 * } else{ BigUnsignedNumber num1=this;
	 * 
	 * for(int a=0;a<j;a++){ result=(10*result)+num.d.get(a)-'0'; } if(result==0
	 * || this==zero) return zero; else if(result==1) return this; else
	 * if(this==one) return num; else{ for(int a=1;a<result;a++){
	 * prod=num1.add(this); num1=prod; } return prod; } } }
	 */

	public static BigUnsignedNumber factorial(int num){
		BigUnsignedNumber one=new BigUnsignedNumber('1');
		BigUnsignedNumber fact=new BigUnsignedNumber(num);
		if(num==1){
			return one ;
		}
		return fact.mult(factorial(num-1));
	}
	
	public int size(){
		return this.d.size();
	}
	
	
	private static void test1() {
		BigUnsignedNumber b = new BigUnsignedNumber(10);

	}

	private static void testBench() {
		System.out.println("------------test1---------------------");
		test1();
	}

	public static void main(String[] args) {
		System.out.println("BigUnsignedNumber.java");
		/*BigUnsignedNumber a = new BigUnsignedNumber(99);
		BigUnsignedNumber b = new BigUnsignedNumber(99);
		a.pLn("a = ");
		b.pLn("b = ");
		BigUnsignedNumber c = a.add(b);
		c.pLn("a + b =  c = ");
		System.out.println(c.d.size());
		BigUnsignedNumber p = BigUnsignedNumber.factorial(5) ;
		p.pLn("p is:");
		// BigUnsignedNumber ba = new BigUnsignedNumber(240) ;
		// BigUnsignedNumber bb = new BigUnsignedNumber(150) ;
		// BigUnsignedNumber mm = ba.mult(bb) ;
		// mm.pLn("mm=: ");*/
		testBench();
		System.out.println("Done");
	}
}
