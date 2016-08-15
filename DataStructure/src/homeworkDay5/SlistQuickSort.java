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
		// print(a.first);
		node root = a.first;
		node temp = quickSort(root, root, null);

		this.a.first = temp;

		// print(temp);
	}

	// public static Node solution(Node root){
	// return quickSort(root, root, null);
	// }

	private void print(node n) {
		while (n != null) {
			System.out.print(n.d + ":" + n.t + " ");
			n = n.next;
		}
		System.out.println();
	}

	public node quickSort(node root, node start, node end) {
		if (start == null || start == end)
			return start;

		node[] nodes = partition(start, end);
		// if(nodes[0] != null) nodes[0].print("Before Pivot: ");
		// if(nodes[1] != null) nodes[1].print("From Pivot: ");
		numRecursion++;
		node start1 = quickSort(root, nodes[0], nodes[1]);
		// start1.print();
		numRecursion++;
		node start2 = quickSort(root, nodes[1].next, end);
		nodes[1].next = start2;
		// print(start1);
		return start1;
	}

	public node[] partition(node start, node end) {

		node lowRoot = null, lowList = null, highRoot = null, highList = null;
		node pivot = start;

		int x = pivot.d;
		start = start.next;
		while (start != null && start != end) {
			numCompare++;
			if (start.d < x) {
				if (lowRoot == null) {
					lowRoot = start;
				} else {
					lowList.next = start;
					numSwap++;
				}
				lowList = start;
			} else {
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

	public static void main(String[] args) {
		System.out.println("SlistQuickSort.java");
		SlistQuickSort u = new SlistQuickSort();
		u.testBench();
	}
}
