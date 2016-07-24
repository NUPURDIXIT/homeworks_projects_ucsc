
public class IntArray {
	private int capacity;
	private int[] darray;
	private int length;
	static private boolean display=false;
	static IntUtil u=new IntUtil();
	
	public void allocate(int s){
		capacity=s;
		darray=new int[s];
	}
	
	public IntArray(){
		this(16);
	}
	
	public IntArray(int s){
		allocate(s);
		if(display==true){
			System.out.println("Creating array of int of capacity :"+capacity);
		}
	}
	
	public int getSize(){
		return length;
	}
	
	public int getPos(int pos){
		if(pos<0){
			return -1;
		}
		if(pos<capacity){
			return darray[pos];
		}
		grow(pos);
		return darray[pos];
		
	}
	
	public void setPos(int pos,int value){
		if(pos<0){
			u.myassert(false);
		}
		if(pos>=capacity){
			grow(pos);
		}
		if(pos>=length){
			length=pos+1;
		}
		darray[pos]=value;
	}
	
	public void grow(int s){
		int[] ta=darray;
		int ts=capacity;
		int ns=capacity;
		do{
			ns=ns*2;
		}while(ns<=s);
		if(display==true){
			System.out.println("The capacity has been increased from "+ts+"to "+ns);
		}
		u.myassert(s<ns);
		allocate(ns);
		for(int i=0;i<s;i++){
			darray[i]=ta[i];
		}
		ta=null;
	}
	
	private static void test1(){
		IntArray a=new IntArray();
		a.setPos(4, 50);
		a.setPos(45, 5000);
		a.setPos(670, 8000);
		int x=a.getPos(5000);
		System.out.println("The value 5000 is at position :"+x);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

}
