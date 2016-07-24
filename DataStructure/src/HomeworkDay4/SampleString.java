package HomeworkDay4;

public class SampleString {
	private CharArray d;
	
	public SampleString(){
		d=new CharArray();
	}
	
	public SampleString(char ch){
		this();
		d.set(0, ch);
	}
	public SampleString(String str){
		d=new CharArray();
		strToCharArray(str);	
	}

	public void strToCharArray(String str){
		
		char[] chArray=str.toCharArray();
		int chArrayLength=chArray.length;
		//System.out.println("Array length is: "+chArrayLength);
		for(int i=0;i<chArrayLength;i++){
			//System.out.println("chArray["+i+"] is: "+chArray[i]);
			d.set(i,chArray[i]);
		}
		//System.out.println(d.size());
		
	}
	
	 public void reverse(){
		  int i = 0 ;
		    int j = d.size() - 1 ;
		    while (i < j) {
		      d.swap(i,j) ;
		      ++i ;
		      --j ;
		    }
		  
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
		  
		  //System.out.print();
	  }
	
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SampleString str=new SampleString("abcd1232455252");
		str.pLn("a=");
		SampleString str1=new SampleString('p');
		str1.pLn("str1= ");
		SampleString text=new SampleString("Hello,what are you doing");
		text.pLn("text= ");
		text.reverse();
		text.pLn("reversed text= ");
		//System.out.println("str:="+str1);
	}

}
