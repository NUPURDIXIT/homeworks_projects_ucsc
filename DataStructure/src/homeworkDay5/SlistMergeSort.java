/**
 * File Name: SlistMergeSort.java 
 * Sort int slist using Merge Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
package HomeworkDay5;
/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistMergeSort.java
 */

class SlistMergeSort extends SlistSort{
 
  @Override
  protected void sort(boolean ascend) {
    //WRITE CODE HERE
	 node n=a.first;
	 a.first = mergeSort(n);
  }
  
  private node mergeSort(node n){
	 
	 if((n==null) || (n.next==null)){return n;}
	 node middle=getMiddle(n);
	 node laterHalf=middle.next;
	 middle.next=null;
	 numRecursion++;
	 n = mergeSort(n);
	 numRecursion++;
	 laterHalf = mergeSort(laterHalf);
	 return merge(n, laterHalf);
  }

//  private void print(node n){
//	  while(n != null){
//		  System.out.print(n.d+" ");
//		  n = n.next;
//	  }
//	  System.out.println();
//  }
  private node merge(node a,node b){
	 // System.out.println("Merge");
	  //print(a);
	  //print(b);
	  
	  //node t=null;
	  node last=null;
	  node first = null;
	  while(a!=null && b!=null){
		  node toAdd;
		  numCompare++;
		  numSwap++;
		  if(a.d<=b.d){
			 // temp=b;
			  toAdd=a;
			  a=a.next;
		  }
		  else{
			 // temp=a;
			  toAdd=b;
			  b=b.next;
			  
		  }
		  if(last == null){
			  last = toAdd;
			  first = last;
		  }else{
			  last.next = toAdd;
			  last=toAdd;
		  }
	  }
	  if(a == null){
		  last.next = b;
	  }
	  
	  if(b == null){
		  last.next = a;
	  }
	  //print(first);
	  return first;
 }
  
  public node getMiddle(node n){
	  if(n==null){ return n;}
	  node slow,fast;
	  slow=fast=n;
	  while(fast.next!=null && fast.next.next!=null){
		  slow=slow.next;
		  fast=fast.next.next;
	  }
	  return slow;
	  
	  
  }
  
  public static void main(String[] args) {
    System.out.println("SlistMergeSort.java");
    SlistMergeSort u = new SlistMergeSort() ;
//  int [] b={6,2,3,4};
//  IntSlist2 l2 =IntSlist2.buildSlist(b) ;
//
//    SlistSort u = new SlistMergeSort();
   // u.a = l2;
    u.testBench();
   
//    int [] a = {6,2,3,4};
  //  u.sort(true);
//    node n=u.merge(l1.first,l2.first);
//    
//    while(n!=null){
//    	
//    	System.out.println(n.d);
//    	n=n.next;
//    	
//    }
//    u.a.pLn();
  }
}


