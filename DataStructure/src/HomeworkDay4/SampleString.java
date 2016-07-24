package HomeworkDay4;

public class SampleString {
	private CharArray d;
	 static IntUtil u = new IntUtil();
	 
	public SampleString(){
		d=new CharArray();
	}
	
	public SampleString(char ch){
		this();
		d.set(0, ch);
		d.set(1, '\0');
	}
	
	public SampleString(String str){
		this();
		char[] chArray=str.toCharArray();
		int chArrayLength=chArray.length;
		for(int i=0;i<chArray.length;i++){
			//System.out.println("chArray["+i+"] is: "+chArray[i]);
			d.set(i,chArray[i]);
		}
		d.set(chArrayLength, '\0');
		//System.out.println("size is :"+d.size());
		
	}

	
	public SampleString(char[] ch){
		this();
		for(int i=0;i<ch.length;i++){
			//System.out.println("chArray["+i+"] is: "+chArray[i]);
			d.set(i,ch[i]);
		}
		d.set(ch.length, '\0');
		//System.out.println("size is :"+d.size());
	}

	public SampleString add(SampleString b){
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
		SampleString s=new SampleString(concatArray);
		return s;
	}
	
	public SampleString add(String str){
		SampleString a=new SampleString(str);
		SampleString d=this.add(a);
		return d;
	}
	
	
	 public void reverse(){
		  int i = 0 ;
		    int j = d.size() - 1 ;
		    while (i < j) {
		      d.swap(i,j) ;
		      ++i ;
		      --j ;
		    }
		   System.out.println("size is :"+d.size());
		  
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
	  }
	
	  public SampleString clone(){
		  char[] ch=new char[this.d.size()];
		  for(int i=0;i<this.d.size();i++){
			  ch[i]=this.d.get(i);
		  }
		  SampleString c=new SampleString(ch);
		  return c;
	  }
	  
	  public SampleString append(SampleString a){
		  int objLength=this.d.size();
			
			int aLength=a.d.size();
	
			int i=objLength;
			int j=0;
			while(j<aLength){
				this.d.set(i,a.d.get(j));
				i++;
				j++;
			}
			return a;
	  }
	  
	  public SampleString append(String str){
		  SampleString b=new SampleString(str);
		  SampleString d=this.append(b);
		  return d;
	  }
	  
	  public boolean isEqual(SampleString a){
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
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleString str=new SampleString("abcd1232455252");
		str.pLn("a=");
		//System.out.println("a.size() is: ");
		SampleString str1=new SampleString('p');
		str1.pLn("str1= ");
		SampleString text=new SampleString("Hello,what are you doing");
		text.pLn("text= ");
		SampleString copy=text.clone();
		copy.pLn("copy = ");
		text.reverse();
		text.pLn("reversed text= ");
		SampleString a = new SampleString("UCSC") ;
		SampleString b = new SampleString("Extension") ;
		SampleString c = a.add(b) ;
	    a.pLn("a = ") ;
	    b.pLn("b = ") ;
	    c.pLn("c = ") ;
	    SampleString d = c.add("USA") ;
	    d.pLn("d = ") ;
	    a.append(b) ;
	    a.pLn("a+b = ") ;
	    a.append("World") ;
	    a.pLn("a+b+World = ") ;
	    SampleString m = new SampleString("123456789012345678901234567890123456789012345678901234567890") ;
	    m.pLn("m = ") ;
	    SampleString n= new SampleString("123456789012345678901234567890123456789012345678901234567890") ;
	    n.pLn("n = ") ;
	    u.myassert(m.isEqual(n)) ;
	    SampleString o = new SampleString("12345678901234567890123456789012345678901234567890123456789") ;
	    o.pLn("o = ") ;
	    u.myassert(m.isEqual(o) == false) ;
		
	}

}
