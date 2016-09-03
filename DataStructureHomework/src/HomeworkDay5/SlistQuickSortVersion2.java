package HomeworkDay5;

/**
 * File Name: SlistQuickSort 
 * Sort int slist using Quick Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java SlistSort.java SlistQuickSort.java
 */

class SlistQuickSortVersion2 extends SlistSort{
 
  @Override
  protected void sort(boolean ascend) { 
    //WRITE CODE HERE
	  node n=a.first;
	  node before=null;
	//  if(n==null){System.out.println("n is null");}
	 // System.out.println("n is "+n.d);
	  a.first=QuickSort(before,n,a.size());
  }
  
//Singly Linked List Quicksort
private node QuickSort(node before, node first, int n) {
  int Num1=0, Num2=n, i=1;
  node Pivot=first, aNode=first, aNodePrev=first;
  // Pivot Advancement
  for (i=1; i<n; i++, aNode=aNode.next) {
    if (aNode.d>aNode.next.d)
      break;
    if ((i&1)==0) { //every other time through the loop
      Pivot=Pivot.next;
      Num1++;
      }
    }
  //Recognize sortedness in linear time
  if (i == n) return first; //Pivot advanced through entire list and found it to be aleady sorted
  // Partition list by unlinking nodes with values less 
  // than the pivot and pushing them onto front of list
  for (aNodePrev = aNode; i < n; i++) {
    aNodePrev.next = aNode.next;
    if (Pivot.d>aNode.d) {
      aNode.next = first;
      first = aNode;
      Num1++;
      }
    else aNodePrev = aNode;
    }
  if (before!=null) before.next = first;
  Num2 = n - Num1 - 1;
  // Recurse to sort sublists
  System.out.println("Num1  and Num2 are: "+ Num1+" " +Num2);
  if (Num1 > 1) first = QuickSort(before, first, Num1);
  if (Num2 > 1) QuickSort(Pivot, Pivot.next, Num2);
  System.out.println("first is : "+first.d);
  return first;
}
  
/*  private node quickSort(node n){
	  System.out.println("QuickSort starts");
	  
	  if (n==null ||n.next==null){
		  return n;
	  }
	  return quick(n,null);
  }
  
  private node quick(node start,node end){
	  //System.out.println("Enters quick , value of start is"+ start.d);
	  if(start==null || start==end || start.next==end){
		  System.out.println("Enters if condition");
		  return start;
	  }
	  //System.out.println("Start is "+start.d);
	  node[] result=partition(start,end);
	  node resultLeft=quick(result[0],result[1]);
	  node resultRight=quick(result[1].next,end);
	  System.out.println("element is: "+resultLeft.d);
	  return resultLeft;
	   
  }
  
  private node[] partition(node start,node end){
	  System.out.println("Enters partition , value of start is: "+start.d);
	  if(start==null || start==end || start.next==end){
		  return new node[]{start,start};
	  }
	  
	  node dummy=new node(0,0);
	  dummy.next=start;
	  for(node j=start; j!=null && j.next!=null && j.next!=end ;j=j.next ){
		  System.out.println("Indside for loop, value of j is: "+j.d);
		  while(j.next!=null && j.next.d<=start.d){
			  //System.out.println("pivot is: "+start.d);
			  node temp=j.next;
			  j.next=j.next.next;
			  temp.next=dummy.next;
			  dummy.next=temp;
			  System.out.println("Inside for and while loop: ");
			  System.out.println(dummy.next.d);
			  System.out.println(start.d);
		  }
	  }
	  System.out.println("Outside for and while loop: ");
	  System.out.println(dummy.next.d);
	  System.out.println(start.d);
	  return new node[]{dummy.next,start};
  } 
   */
  void sort1(IntSlist2 a) {
	   System.out.println("---------SORT1 Start------------"); 
	    this.a = a ;
//	   
//	    display = false ;
//	    int os = a.size() ;
//	    System.out.println(":size if a is:"+os);
//	    if (os > 0 && os < 20) {
//	      display = true ;
//	    }
	    sort(true); //THIS CODE IS WRITTEN BY USER
	    
	   // if (display) {
	      a.pLn() ;
	   // }
	   // u.printStatistics(a.size(),numCompare,numSwap,0);
	    System.out.println("---------SORT1 End---------------");
	  }
  public static void main(String[] args) {
    System.out.println("SlistQuickSort.java");
    //int a[]={15 ,  5,  64,   8,  12,  11,   4,  35};
   // int a[]={3,4,2,1,5};
    int a[]={30,4,20,10,50,45};
    IntSlist2 s=IntSlist2.buildSlist(a);
    s.pLn();
    SlistQuickSortVersion2 u = new SlistQuickSortVersion2() ;
    u.sort1(s);
    //u.testBench();
    //node[] r=u.partition(s.first,null);
    //for(int i=0;i<r.length;i++){
    //	System.out.println(r[i].d);
    //}
  }

}
