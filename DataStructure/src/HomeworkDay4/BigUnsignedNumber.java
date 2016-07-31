package HomeworkDay4;
/**
 * File Name: BigUnsignedNumber.java 
 * Infinite capacity Unsigned Number
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: BigUnsignedNumber.java CharArray.java Cstring IntUtil.java
 */

class BigUnsignedNumber {
  private Cstring d; //data
  static IntUtil u = new IntUtil();
  //Cannot add any more data fields
  
  //WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS
  
  //CANNOT CHANGE ANYTHING BELOW 
  public BigUnsignedNumber(){
	  d=new Cstring();
  }
  
  public BigUnsignedNumber(char ch){
	  d=new Cstring(ch);
  }
  
  public BigUnsignedNumber(String str){
		d=new Cstring(str);
  }
	
	public BigUnsignedNumber(char[] ch){
		d=new Cstring(ch);
		
	}
	 
	public BigUnsignedNumber(int num){
		char[] chArray=String.valueOf(num).toCharArray();
		d=new Cstring(chArray);
	}
	
	public BigUnsignedNumber(Cstring cstring){
		d=cstring;
	}
	
  public void pLn(String t){
	  d.pLn(t);
	  System.out.println();
  }
  
  public BigUnsignedNumber clone(){
	  Cstring c=this.d.clone();
	  BigUnsignedNumber b=new BigUnsignedNumber(c);
	  return b;
  }
  
  public BigUnsignedNumber add(BigUnsignedNumber b){
	  	int i=this.d.size();
	  	int j=b.d.size();
	  	int sizeDifference=0;
	  	if(i>j){
	  		sizeDifference=i-j;
	  		for(int a=j-1;a>=0;a--){
	  			b.d.setCharArray(a+sizeDifference, b.d.get(a));
	  		}
	  		
	  		for(int a=0;a<sizeDifference;a++){
	  			b.d.setCharArray(a, '0');
	  		}
	  		
	  		j=b.d.size();
	  		
	  	}
	  	else{ sizeDifference=j-i;
		  	for(int a=i-1;a>=0;a--){
	  			this.d.setCharArray(a+sizeDifference, this.d.get(a));
	  		}
	  		for(int a=0;a<sizeDifference;a++){
	  			this.d.setCharArray(a, '0');
	  		}
	  		i=this.d.size();
	  	}
	  	
	  	char[] num1=this.d.getCharArray(this.d);
	  	char[] num2=b.d.getCharArray(b.d);
	  	
	  	int carry=0;
	  	int sum=0;
	  	
	  	BigUnsignedNumber num=new BigUnsignedNumber();
	  	
	  	num.d.setCharArray(i,'\0');
	  	while(i>0 || j>0){
	  		sum=0;
	  		int digitA=num1[i-1]-'0';
	  		int digitB=num2[j-1]-'0';
	  		sum=(digitA+digitB+carry)%10;
	  		carry=(digitA+digitB+carry)/10;
	  		num.d.append(sum+"");
	  		i--;
	  		j--;
	  	}
	  	if(carry>0){
	  		num.d.append(carry+"");
	  	}
	  	num.d.reverse();
	  	return num;
}
  
  public BigUnsignedNumber add(String s){
	  BigUnsignedNumber b= new BigUnsignedNumber(s);
	  BigUnsignedNumber c=this.add(b);
	  return c;
  }
  
 public boolean isEqual(BigUnsignedNumber b){
	 boolean flag=this.d.isEqual(b.d);
	 return flag;
	 
 }
 
 public BigUnsignedNumber mult(BigUnsignedNumber num){
	 int i=this.d.size();
	 int j=num.d.size();
	 char[] num1=new char[i];
	 char[] num2=new char[j];
	 char[] num3=new char[i+j];
	 int sum;
	 int carry=0;
	 BigUnsignedNumber prod=new BigUnsignedNumber();
	 prod.d.setCharArray(i+j+1, '\0');
	 while(i>=0 || j>=0){
			 sum=0;
			 sum=(num2[b]*num1[a])%10;
			 carry=sum/10;
			 prod.d.append(sum+"");
		 }
		 
	 
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
