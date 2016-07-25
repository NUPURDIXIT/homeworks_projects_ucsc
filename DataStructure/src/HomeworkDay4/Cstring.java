package HomeworkDay4;
/**

 * File Name: Cstring.java 
 * Implements C String
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
/*
 * To compile you require: CharArray.java Cstring
 */

class Cstring {
  private CharArray d; //Infinte array of char
  static IntUtil u = new IntUtil();
  
 
  //Cannot add any more data fields
  
  //WRITE ALL FUNCTIONS SO THAT ALL TESTS WILL PASS
  
  public Cstring(){
	  d=new CharArray();
  }
  
  public Cstring(char ch){
	  this();
	  d.set(0, ch);
	  d.set(1, '\0');
  }
  
  public Cstring(String str){
		this();
		char[] chArray=str.toCharArray();
		int chArrayLength=chArray.length;
		for(int i=0;i<chArray.length;i++){
			//System.out.println("chArray["+i+"] is: "+chArray[i]);
			d.set(i,chArray[i]);
		}
		d.set(chArrayLength, '\0');
		
	}
	
	public Cstring(char[] ch){
		this();
		for(int i=0;i<ch.length;i++){
			//System.out.println("chArray["+i+"] is: "+chArray[i]);
			d.set(i,ch[i]);
		}
		d.set(ch.length, '\0');
	}
 
  
  public void pLn(String t){
	  System.out.println();
	  char[] ch=t.toCharArray();
	  for(int i=0;i<t.length();i++){
		  System.out.print(ch[i]);
	  }
	 
	  for(int i=0;i<d.size();i++){
		  System.out.print(d.get(i));
	  }
	  System.out.println();
  }
  
  
  public char[] getCharArray(Cstring c){
	  char[] ch=new char[c.d.size()];
	  for(int i=0;i<c.d.size();i++){
		  ch[i]=c.d.get(i);
	  }
	  return ch;
  }
  
  public void setCharArray(int pos,char value){
	  	this.d.set(pos,value);
	}
	
  public char get(int pos){
	  char c=this.d.get(pos);
	  return c;
	 
  }
  
  public void reverse(){
	  int i = 0 ;
	    int j = d.size() - 1 ;
	    while (i < j) {
	      d.swap(i,j) ;
	      ++i ;
	      --j ;
	    }
	    d.set(d.size(),'\0');
	  
  }
  
  public int size(){
	  return d.size();
  }
  
  public Cstring clone(){
	  char[] ch=new char[this.d.size()];
	  for(int i=0;i<this.d.size();i++){
		  ch[i]=this.d.get(i);
	  }
	  Cstring c=new Cstring(ch);
	  return c;
  }
  
  public Cstring add(Cstring b){
		int objLength=this.d.size();
		//System.out.println("objlength is: "+objLength);
		int bLength=b.d.size();
		//System.out.println("blength is: "+bLength);
		char[] concatArray=new char[objLength+bLength];
		for(int i=0;i<objLength;i++){
			concatArray[i]=this.d.get(i);
		}
		
		int i=objLength;
		int j=0;
		while(j<bLength){
			concatArray[i]=b.d.get(j);
			i++;
			j++;
		}
		Cstring s=new Cstring(concatArray);
		return s;
	}
	
	public Cstring add(String str){
		Cstring a=new Cstring(str);
		Cstring d=this.add(a);
		return d;
	}
  
  
	public Cstring append(Cstring a){
		  int objLength=this.d.size();
			
			int aLength=a.d.size();
	
			int i=objLength;
			int j=0;
			while(j<aLength){
				this.d.set(i,a.d.get(j));
				i++;
				j++;
			}
			//System.out.println("Size of a after appending is :"+this.d.size());
			this.d.set(this.d.size(), '\0');
			return a;
	  }
	  
	  public Cstring append(String str){
		  Cstring b=new Cstring(str);
		  Cstring d=this.append(b);
		  return d;
	  }
  
	  public boolean isEqual(Cstring a){
		  int objLength=this.d.size();
		  int aLength=a.d.size();
		  if(objLength==aLength){
			for(int i=0;i<objLength;i++){
				if(this.d.get(i)!=a.d.get(i))
					return false;
			}
			return true;
		 }
		 return false;
		 
	  }
  
  
  //CANNOT CHANGE ANYTHING BELOW 
  private static void testBasic() {
    Cstring a = new Cstring('b') ;
    a.pLn("a = ") ;
    Cstring b = new Cstring('7') ;
    b.pLn("b = ") ;
    Cstring c = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    c.pLn("c = ") ;
    Cstring d = c.clone() ;
    d.pLn("d = ") ;
    Cstring e = new Cstring("A quick brown fox junped over a lazy dog") ;
    e.pLn("e = ") ;
    Cstring f = new Cstring("Gateman sees name garageman sees nametag") ;
    f.pLn("f =  ") ;
    f.reverse() ;
    f.pLn("f' = ") ;
  }
  
  
  
  
  private static void testAdd() {
    Cstring a = new Cstring("UCSC") ;
    Cstring b = new Cstring("Extension") ;
    Cstring c = a.add(b) ;
    a.pLn("a = ") ;
    b.pLn("b = ") ;
    c.pLn("c = ") ;
    Cstring d = c.add("USA") ;
    d.pLn("d = ") ;
    a.append(b) ;
    a.pLn("a+b = ") ;
    a.append("World") ;
    a.pLn("a+b+World = ") ;
  }
  
  private static void testEqual() {
    Cstring a = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    a.pLn("a = ") ;
    Cstring b = new Cstring("123456789012345678901234567890123456789012345678901234567890") ;
    b.pLn("b = ") ;
    u.myassert(a.isEqual(b)) ;
    Cstring c = new Cstring("12345678901234567890123456789012345678901234567890123456789") ;
    c.pLn("c = ") ;
    u.myassert(a.isEqual(c) == false) ;
  }
  
  private static void testBench() {
    System.out.println("-----------Basic----------------");
    testBasic() ;
    System.out.println("-----------Addition----------------");
    testAdd() ;
    System.out.println("-----------Equal----------------");
    testEqual() ;
  }
  
  public static void main(String[] args) {
    System.out.println("Cstring.java");
    testBench();
    System.out.println("Done");
  }
}