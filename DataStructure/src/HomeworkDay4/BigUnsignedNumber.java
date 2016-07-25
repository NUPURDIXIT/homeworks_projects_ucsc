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
	  	System.out.println("Size of first array is: "+i);
	  	int j=b.d.size();
	  	System.out.println("Size of second array is: "+j);
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
	  	for(int p=0;p<num1.length;p++){
		  	System.out.println("num1 is :"+num1[p]);
		  	System.out.println("num2 is :"+num2[p]);
	  	}
	  	for(int p=0;p<num1.length;p++){
		  	//System.out.println("num1 is :"+num1[p]);
		  	System.out.println("num2 is :"+num2[p]);
	  	}
	  	int carry=0;
	  	int sum=0;
	  	
	  	
	  	BigUnsignedNumber num=new BigUnsignedNumber(sum);
	  	System.out.println("i is: "+i);
	  	System.out.println("j is: "+j);
	  	num.d.setCharArray(i,'\0' );
	  	while(i>0 || j>0){
	  		sum=0;
	  		int digitA=num1[i-1]-'0';
	  		System.out.println("DigitA is:"+digitA);
	  		int digitB=num2[j-1]-'0';
	  		System.out.println("DigitB is:"+digitB);
	  		sum=(digitA+digitB+carry)%10;
	  		System.out.println("Sum is:"+sum);
	  		carry=(digitA+digitB+carry)/10;
	  		num.d.setCharArray(i,'\0');
	  		System.out.println("carry is:"+carry);
	  		//num.d.setCharArray(i-1, (char)sum);
	  		num.d.append(sum+"");
	  		num.pLn("num is : ");
	  		i--;
	  		j--;
	  		
	  	}
	  	if(carry>0){
	  		num.d.append(carry+"");
	  	}
	  	System.out.println("size of num is: "+num.d.size());
	  	
	  	num.d.reverse();
	  	
		System.out.println("size of num after reverse is: "+num.d.size());
	  	num.d.setCharArray(num.d.size()-1, '\0');
	  	return num;
 
  }
  
  public BigUnsignedNumber add(String s){
	  BigUnsignedNumber b= new BigUnsignedNumber(s);
	  BigUnsignedNumber c=this.add(b);
	  return c;
  }
  
 
  
  private static void test1() {
	  BigUnsignedNumber a = new BigUnsignedNumber(9789) ;
	    BigUnsignedNumber b = new BigUnsignedNumber(100000) ;
	    a.pLn("a = ") ;
	    b.pLn("b = ") ;
	    BigUnsignedNumber c = a.add(b) ;
	    c.pLn("a + b =  c = ") ;
	    a = a.add(b) ;
	    a.pLn("a = a + b = ") ;
	    //BigUnsignedNumber d = new BigUnsignedNumber("3490529510847650949147849619903898133417764638493387843990820577");
	    //BigUnsignedNumber e = new BigUnsignedNumber("32769132993266709549961988190834461413177642967992942539798288533");
	    //BigUnsignedNumber f = d.add(e) ;
	    /*BigUnsignedNumber g = new BigUnsignedNumber("36259662504114360499109837810738359546595407606486330383789109110") ;
	    //u.myassert(f.isEqual(g));                                           
	    d.pLn("d = ") ;
	    e.pLn("e = ") ;*/
	    //f.pLn("f = ") ;
    
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
