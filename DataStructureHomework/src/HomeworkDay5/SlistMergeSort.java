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


  private node merge(node a,node b){
	  node last=null;
	  node first = null;
	  while(a!=null && b!=null){
		  node toAdd;
		  numCompare++;
		  
		  if(a.d<=b.d){
			  numSwap++;
			  toAdd=a;
			  a=a.next;
		  }
		  else{
			  numSwap++;
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
		  numSwap++;
		  last.next = b;
	  }
	  
	  if(b == null){
		  numSwap++;
		  last.next = a;
	  }
	  return first;
 }
  
  public node getMiddle(node n){
	  if(n==null){ return n;}
	  node slow,fast;
	  slow=fast=n;
	  numCompare++;
	  while(fast.next!=null && fast.next.next!=null){
		  slow=slow.next;
		  fast=fast.next.next;
	  }
	  return slow;
	  
	  
  }
  
  public static void main(String[] args) {
    System.out.println("SlistMergeSort.java");
    SlistMergeSort u = new SlistMergeSort() ;
    u.testBench();
  }
}


