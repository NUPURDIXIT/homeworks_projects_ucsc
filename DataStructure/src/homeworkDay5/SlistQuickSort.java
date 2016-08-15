package HomeworkDay5;

/**
 * File Name: SlistQuickSort Sort int slist using Quick Sort
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2016
 */

/*
 * To compile you require: IntUtil.java RandomInt.java IntSlist2.java
 * SlistSort.java SlistQuickSort.java
 */

class SlistQuickSort extends SlistSort {

	@Override
	protected void sort(boolean ascend) {
		// WRITE CODE HERE
		node root = a.first;
		node temp = quickSort(root, root, null);
		this.a.first = temp;
	}

	public node quickSort(node root, node start, node end) {
		if (start == null || start == end)
			return start;

		node[] nodes = partition(start, end);
		numRecursion++;
		node start1 = quickSort(root, nodes[0], nodes[1]);
		numRecursion++;
		node start2 = quickSort(root, nodes[1].next, end);
		nodes[1].next = start2;
		return start1;
	}

	public node[] partition(node start, node end) {

		node lowRoot = null, lowList = null, highRoot = null, highList = null;
		node pivot = start;
		pivot = findPivot(start, end);
		int x = pivot.d;
		while (start != null && start != end) {
			if(start == pivot){
				numCompare++;
				start = start.next;
				continue;
			}
			
			numCompare++;
			if (start.d < x || (start.d == x && start.t < pivot.t)) {
				numCompare++;
				if (lowRoot == null) {
					lowRoot = start;
				} else {
					lowList.next = start;
					numSwap++;
				}
				lowList = start;
			} else {
				numCompare++;
				if (highRoot == null) {
					highRoot = start;
				} else {
					highList.next = start;
					numSwap++;
				}
				highList = start;
			}
			start = start.next;
		}

		pivot.next = highRoot;

		// Setting last node's next to null (terminating the list)
		node[] nodes = new node[] { pivot, pivot };
		if (lowList != null) {
			lowList.next = null;
			lowList.next = pivot;
			nodes = new node[] { lowRoot, pivot };

		}
		if (highList != null) {
			highList.next = end;

		} else {
			pivot.next = end;
		}

		return nodes;
	}

	private node findPivot(node start, node end) {
		node first = start;
		node mid = start;
		node last = start;
		
		while(last != end && last.next != end && last.next.next != end){
			numCompare++;
			mid = mid.next;
			last = last.next.next;
		}
		
		numCompare++;
		if(first.d < last.d){
			numCompare++;
			if(first.d > mid.d){
				return first;
			}else{
				return mid;
			}
		}else{
			numCompare++;
			if(last.d > mid.d){
				return last;
			}else{
				return mid;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("SlistQuickSort.java");
		SlistQuickSort u = new SlistQuickSort();
		u.testBench();
	}
}
