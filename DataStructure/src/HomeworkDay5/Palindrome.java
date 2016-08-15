package HomeworkDay5;

public class Palindrome {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

class node{
	protected node next;
	protected int d;
	
	public node(int x){
		d=x;
		next=null;
		
	}
}

class IntSlist{
	private node first;
	private node last;
	
	
	public IntSlist(){
		first=null;
		last=null;
		
	}
	
	public void add(int x){
		node n=new node(x);
		if(first!=null){
			last.next=n;
		}
		else{
			first=n;
		}
		last=n;
	}
	
	public static IntSlist buildList(int n){
		IntSlist l=new IntSlist();
		
		for(int i=0;i<n;i++){
			int x=i;
			l.add(x);
		}
		return l;
	}
	
	public boolean remove(int x) {
		node [] nodes = new node[2] ;
		//find(x,nodes) ;
		if (nodes[0] != null) {
		if ((nodes[0] == first) && (nodes[0] == last)) {
		//Does list has only one element
		first = null ;
		last = null ;
		}else if (nodes[0] == first) {
		//first element being removed and list
		//has more than 1 element
		first = nodes[0].next ;
		}else if (nodes[0] == last) {
		//last element being removed and list
		//has more than 1 element
		nodes[1].next = null ;
		last = nodes[1] ;
		}else {
		//You are removing middle element
			nodes[1].next = nodes[0].next ;
		}
		nodes[0] = null ; //Garbage collection
		//decSize();
		return true ;
		}else {
		return false ;
		}
	}
}

