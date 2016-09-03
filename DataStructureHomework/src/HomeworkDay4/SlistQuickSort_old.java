
/**
 * File Name: SlistQuickSort 
 * Sort int slist using Quick Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */
package HomeworkDay4;
/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistQuickSort.java
 */

import HomeworkDay5.IntSlist2;
import HomeworkDay5.SlistSort;
import HomeworkDay5.IntSlist2.node;

class SlistQuickSort_old extends SlistSort{
 
  @Override
  protected void sort(boolean ascend) { 
    //WRITE CODE HERE
	  node n=a.first;
	  quickSort(n);
  }
  
  private void quickSort(node n){
	  n=first;
	  if(n!=null && n.next!=null){
		  node j=partition(n);
		  node jprev;
		  quickSort(lower);
		  quickSort(j.next);
	  }
	   
  }
  
  private node partition(node n){
	  node pivot=first;
	  int pivotValue=pivot.d;
	  node j=first;
	  node extra=null;
	  node current=pivot.next;
	  while(current!=null){
		  if(current.d<pivotValue){
			  j.next=current.next;
			  extra=current;
			  extra.next=null;
		  }
	  }
	  swap(j,pivot);
	  pivot=j;
	  return j;
  }
  
  private void swap(node a,node b){
	  node temp;
	  temp.d=a.d;
	  a.d=b.d;
	  b.d=temp.d;
  }
  
  public static void main(String[] args) {
    System.out.println("SlistQuickSort.java");
    SlistQuickSort_old u = new SlistQuickSort_old() ;
    u.testBench();
  }

}