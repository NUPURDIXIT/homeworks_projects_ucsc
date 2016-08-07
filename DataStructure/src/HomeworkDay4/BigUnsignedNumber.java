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
		
		//This will keep the output. Old school time method of multiplication
		//each multiplication output will be added to this following the school time methodology
		BigUnsignedNumber output = new BigUnsignedNumber();
		//Initialized it with '0's
		for (int i = 0; i < this.d.size() + num.d.size(); i++) {
			output.d.setCharAtIndex(i, '0');
		}
		//Keeping track of index in output. Once multiplication is done, will reverse the output.
		//that will be our answer
		int outputIndex = 0;
		
		//from AxB (param 'num' will act as B in our logic)
		//So looping through num from right to left
		for (int numIndex = num.d.size() - 1; numIndex >= 0; numIndex--) {
			int numDigit = num.getDigit(numIndex);
			//offset is the count of "x", we used to add in school days 
			int offset = num.d.size() - 1 - numIndex;
			//ouputIndex start from offset (remember we are filling output in reverse order)
			outputIndex = offset;
			
			//Carry got from multiplication of two digits
			int multCarry = 0;
			//Carry got from summation of two multiplications
			int sumCarry = 0;
			for (int thisIndex = d.size() - 1; thisIndex >= 0; thisIndex--) {
				int thisDigit = getDigit(thisIndex);

				//A[i]xB[j] + anyCarryFromPreviousMultiplication
				int digitsMult = numDigit * thisDigit + multCarry;
				//value to be added to output 
				int multAdd = digitsMult % 10;
				//value to be carried over
				multCarry = digitsMult / 10;

				int sum = output.getDigit(outputIndex) + multAdd + sumCarry;

				int sumAdd = sum % 10;
				sumCarry = sum / 10;
				output.setDigit(outputIndex, sumAdd);
				//Handling for last index (in the last index of each inner loop, nothing will go to carry)
				//multCarry and sumCarry of last the index, will be directly added to the next digit
				if (thisIndex == 0) {
					int thisLastDigitCarries = output.getDigit(outputIndex + 1) + multCarry + sumCarry;
					if(thisLastDigitCarries > 0){
						outputIndex += 1;
						output.setDigit(outputIndex, thisLastDigitCarries % 10);
						if(thisLastDigitCarries > 10){
							outputIndex += 1;
							output.setDigit(outputIndex, thisLastDigitCarries / 10);
							
						}
					}
				}
				outputIndex++;

			}
		}
		
		//TODO: couldn't find the exact reason, why extra '0' was appended sometimes.
		//However quick fix for this is to, iterate from the end of output.
		//And find correct position for added end character.
		
		for(int i = outputIndex; i>=1;i--){
			if(output.getDigit(i) == 0){
				outputIndex--;
			}else{
				break;
			}
		}
		
		output.d.setCharAtIndex(outputIndex+1, '\0');
		//output is prepared but in reverse order, so reversing it to get final result
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
