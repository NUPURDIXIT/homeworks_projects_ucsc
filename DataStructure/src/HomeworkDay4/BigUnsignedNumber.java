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
		char cha = (char)(ch+'0');
		this.d.setCharAtIndex(index, cha);
	}

	private int getDigit(int index) {
		return this.d.get(index) - '0';
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
		return isEqual(b);

	}

	public BigUnsignedNumber mult(BigUnsignedNumber num) {
		BigUnsignedNumber output = new BigUnsignedNumber();
		for (int i = 0; i < this.d.size() + num.d.size(); i++) {
			output.d.setCharAtIndex(i, '0');
		}
		int outputIndex = 0;
		int maxOutputIndex = 0;
		
		for (int index = num.d.size() - 1; index >= 0; index--) {
			int digit = num.getDigit(index);
			int offset = num.d.size() - 1 - index;
			outputIndex = offset;
			int carry = 0;
			int sumCarry = 0;
			for (int index1 = d.size() - 1; index1 >= 0; index1--) {
				int digit1 = getDigit(index1);
				
				int temp = digit * digit1 + carry;
				int toAdd = temp % 10;
				carry = temp / 10;

				int sum = output.getDigit(outputIndex) + toAdd + sumCarry;

				int temp1 = sum % 10;
				sumCarry = sum / 10;
				
				output.setDigit(outputIndex, temp1);
				
				if (index1 == 0) {
					int temp3 = output.getDigit(outputIndex + 1) + carry + sumCarry;
					if(temp3 > 0){
						outputIndex += 1;
						output.setDigit(outputIndex, temp3 % 10);
						if(temp3 > 10){
							outputIndex += 1;
							output.setDigit(outputIndex, temp3 / 10);
							
						}
					}
				}
				if (outputIndex > maxOutputIndex) {
					maxOutputIndex = outputIndex;
				}
				outputIndex++;

			}
		}
		
		for(int i = outputIndex; i>=1;i--){
			if(output.getDigit(i) == 0){
				outputIndex--;
			}else{
				break;
			}
		}
		output.d.setCharAtIndex(outputIndex+1, '\0');
		output.d.reverse();
		return output;
	}
	
	

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
		testBench();
		System.out.println("Done");
	}
}
