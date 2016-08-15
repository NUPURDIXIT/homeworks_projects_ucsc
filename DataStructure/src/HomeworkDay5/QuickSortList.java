package HomeworkDay5;
/**
 * 
 */
//package codingpractise.list;

/**
 * @author arnavawasthi
 *
 */
public class QuickSortList {

	
	public static node solution(Node root){
		return quickSort(root, root, null);
	}
	
	public static node quickSort(node root, node start, node end){
		if(start == null || start == end) return start;
		
		node[] nodes = partition(start, end);
//		if(nodes[0] != null) nodes[0].print("Before Pivot: ");
//		if(nodes[1] != null) nodes[1].print("From Pivot: ");
		node start1 = quickSort(root, nodes[0], nodes[1]);
//		start1.print();
		node start2 = quickSort(root, nodes[1].next, end);
		nodes[1].next = start2;
		return start1;
	}
	
	public static node[] partition(node start, node end){
		
		node lowRoot = null, lowList = null, highRoot = null, highList = null;
		node pivot = start;
		
		int x = pivot.d;
		start = start.next;
		while(start != null && start != end){
			if(start.d <= x){
				if(lowRoot == null){
					lowRoot = start;
				}else{
					lowList.next = start;
				}
				lowList = start;
			}else{
				if(highRoot == null){
					highRoot = start;
				}else{
					highList.next = start;
				}
				highList = start;
			}
			start = start.next;
		}
		
		pivot.next = highRoot;
		
		//Setting last node's next to null (terminating the list)
		node[] nodes = new node[]{pivot, pivot};
		if(lowList != null){
			lowList.next = null;
			lowList.next = pivot;
			nodes = new node[]{lowRoot, pivot};
			
		}
		if(highList != null){
			highList.next = end;
			
		}else{
			pivot.next = end;
		}
		
		
		
		return nodes;
	}
	
	public static void main(String[] args) {
		{
			int[] a = {6, 5, 1, 7, 2, 3, 1, 4, 9};
			IntSlist2 list = new IntSlist2(a);
			list.root.print();
			solution(list.root).print();
		}
		
		{
			int[] a = {7,6,5,4,3,2,1};
			MyLinkedList list = new MyLinkedList(a);
			list.root.print();
			solution(list.root).print();
		}
		
		{
			int[] a = {1,2,3,4,5,6,7};
			MyLinkedList list = new MyLinkedList(a);
			list.root.print();
			solution(list.root).print();
		}
	}
}

