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

class SlistQuickSort extends SlistSort{
 
  @Override
  protected void sort(boolean ascend) { 
    //WRITE CODE HERE
	  node n=a.first;
	  if(n==null){System.out.println("n is null");}
	 // System.out.println("n is "+n.d);
	  a.first=quickSort(n);
  }
  
  private node quickSort(node n){
	  System.out.println("QuickSort starts");
	  //n=first;
	  //System.out.println(" n is "+n.d);
	  if (n==null ||n.next==null){
		  return n;
	  }
	  return quick(n,null);
  }
  private node quick(node start,node end){
	  System.out.println("Enters quick");
	  if(start==null || start==end || start.next==end){
		  System.out.println("Enters if condition");
		  return start;
	  }
	  //System.out.println("Start is "+start.d);
	  node[] result=partition(start,end);
	  node resultLeft=quick(result[0],result[1]);
	  node resultRight=quick(result[1].next,end);
	  
	  return resultLeft;
	   
  }
  
  private node[] partition(node start,node end){
	  if(start==null || start==end || start.next==end){
		  return new node[]{start,start};
	  }
	  
	  node dummy=new node(0,0);
	  dummy.next=start;
	  for(node j=start; j!=null && j.next!=null && j.next!=end ;j=j.next ){
		  while(j.next!=null && j.next.d<=start.d){
			  node temp=j.next;
			  j.next=j.next.next;
			  temp.next=dummy.next;
			  dummy.next=temp;
		  }
	  }
	  return new node[]{dummy.next,start};
  }
   
  private void sort1(IntSlist2 a) {
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
    int a[]={3,4,2,1,5};
    IntSlist2 s=IntSlist2.buildSlist(a);
    s.pLn();
    SlistQuickSort u = new SlistQuickSort() ;
    u.sort1(s);
    //u.testBench();
  }

}
