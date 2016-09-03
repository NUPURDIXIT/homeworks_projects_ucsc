package Final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

import HomeworkDay5.IntBtree;
//import HomeworkDay5.node;

public class Hauffman{
	static int IdCounter=0;
	
	String s;
	boolean show;
	String dotfilename;
	IntBtree tree=new IntBtree();
	
	public Hauffman(){
		s=null;
		show=false;
		dotfilename=null;
	}
	
	public Hauffman(String s, boolean show, String dotfilename){
		
		//HashMap<Character,Integer> letterSet=new HashMap<Character,Integer>();
		this.s=s;
		this.show=show;
		this.dotfilename=dotfilename;
		
	}
	
	public static class Tree implements Comparable{
		Node root;
		
		public Tree(Tree t1,Tree t2){
			root=new Node();
			root.left=t1.root;
			root.right=t2.root;
			root.freq=t1.root.freq+t2.root.freq;
		}
		
		public Tree(int id,int freq,char letter,Node left,Node right){
			root=new Node(id,freq,letter,left,right);
		}
		
		
	
//		public boolean isLeaf(){
//			return (left==null && right==null);
//		}
		
		public int compareTo(Object o){
			Tree n;
			
			if(o instanceof Tree){
				n=(Tree)o;
				//return freq - n.freq;
				
			}
			else{
				return 0;
			}
			
			return (root.freq < n.root.freq) ? -1 : ((root.freq > n.root.freq) ? 1 : 0);
				
			
			
		}
	
	
	static class Node {	
		public int id;
		public int freq;
		public char letter;
		public Node left;
		public Node right;
		
		Node(){
			
		}
		
		Node(int id,int freq,char letter,Node left,Node right) {
			this.id=IdCounter++;
			//this.id=id;
			this.freq=freq;
			this.letter=letter;
			left = null;
			right = null;
			
		}
		public boolean isLeaf()
		{
			return (left == null && right==null);
			
		}
		
	
	}
	}
	
	/*
	 * method to decode the string
	 */
	
	public String encode(){
		HashMap<Character,Integer> letterSet=new HashMap<Character,Integer>();
		letterSet=countOccurence(s);
		Tree root=buildHauffmanTree(letterSet);
		levelOrder(root.root);
		//System.out.println("Root is: "+root.letter);
		HashMap<Character,String> encode=getEncoding(root);
		String code="";
		for(Character str:encode.keySet()){
			code+=encode.get(str);
			
		}
		System.out.println("Encoded string is: "+code);
		return code;
//		
		//tree.buildTreeFromUserSpec(t);
	}
	
	/*
	 * Method to count the occurrence of each character in the given string
	 */
	public HashMap<Character,Integer> countOccurence(String s){
		HashMap<Character,Integer> letterSet=new HashMap<Character,Integer>();
		System.out.println("s is"+ s);
		char[] charArray=s.toCharArray();
		System.out.println("The given string is"+ s);
		for(char i:charArray){
			letterSet.put(i, letterSet.get(i)==null ? 1 : letterSet.get(i)+1);
		}
		
//		for(Character key:letterSet.keySet()){
//			System.out.println("occurence of key '"+ key +"' is "+letterSet.get(key));
//		}
		return letterSet;
	}
	/*
	 * method to sort the values using priority queue
	 */

	public static Tree buildHauffmanTree(HashMap<Character,Integer> letterSet){
		PriorityQueue<Tree> pq=new PriorityQueue<Tree>();
		//BinaryHeap<Tree> heap=new BinaryHeap<>();
		
		for(char key:letterSet.keySet()){
//			System.out.println("id is"+IdCounter);
//			System.out.println("freq is" + letterSet.get(key)); 
//			System.out.println("key is "+ key);
			pq.add(new Tree(IdCounter,letterSet.get(key),key,null,null));
			
			//heap.add(new Tree(IdCounter,letterSet.get(key),key,null,null));
			
		}
		
		while(pq.size()>1){
			//Node left=pq.poll();
			
			Tree t1=pq.poll();
			System.out.println("The left returned is: "+t1.root.freq);
			
			//System.out.println("The left returned is: "+left.freq);
			//Node right=pq.poll();
			
			Tree t2=pq.poll();
			System.out.println("The right returned is: "+t2.root.freq);
			
			//System.out.println("The right returned is: "+right.freq);
			//pq.add(new Node(IdCounter,left.freq+right.freq,'\0',left,right));
			
			pq.add(new Tree(t1,t2));
			
			//System.out.println("Node added is: "+pq.peek().freq);
		}
		//System.out.println("The root returned is: "+pq.peek().freq);
		//System.out.println("left of root is :"+pq.peek().left.freq+"letter is: ");
		System.out.println("right of root is :"+pq.peek().root.freq);
		return pq.poll();
		
	}
	
	
	/*
	 * gets the string of 0's and 1's associtae dwith each character
	 */
	private static HashMap<Character,String> getEncoding(Tree root){
		HashMap<Character,String> encoding=new HashMap<>();
		System.out.println("root root value is  "+root.root.freq);
		traverse(root.root,"",encoding);
		System.out.println("\nInside Hashmap to get encoded string");
		for(Character key:encoding.keySet()){
			System.out.println("occurence of key '"+ key +"' is "+encoding.get(key));
		}
		return encoding;
	}
	
	/*
	 * level order
	 */
	public int[] levelOrder(Tree.Node root){
		System.out.println("\nInside Level Order");
		int []a=new int[20];
		Queue<Tree.Node> q=new LinkedList<>();
		q.add(root);
		int k=0;
		while(!q.isEmpty()){
			Tree.Node n=q.remove();
			a[k++]=n.freq;
			System.out.print(n.freq);
			if(n.left!=null){
				q.add(n.left);
				System.out.print("->"+n.left.freq);
				
			}
			if(n.right!=null){
				q.add(n.right);
				System.out.print("->"+n.right.freq);
				System.out.println();
			}
			
		}
		System.out.println("Level Order exits\n");
		return a;
	}
		
		
	
	/*
	 * to assign code to each node
	 */
	
	private static void traverse(Tree.Node node,String code,HashMap<Character,String> encode){
		System.out.println("\nEntered Traverse");
		if(node.isLeaf()){
			System.out.println("Node is a leaf");
			encode.put(node.letter, code);
			System.out.println("leaf freq is:" + node.freq);
		}
		else{
			System.out.println("Entered else of traverse");
			if(node.left!=null){
				System.out.println("Entered left pf traverse");
				System.out.println("left freq is: "+node.left.freq);
				traverse(node.left,code+"0",encode);
				System.out.println("Value of left id:" +node.left.freq);
			}
			if(node.right!=null){
				System.out.println("Entered right pf traverse");
				System.out.println("right freq is: "+node.right.freq);
				traverse(node.right,code+"1",encode);
				System.out.println("Value  of right id:" +node.right.freq);
			}
		}
		System.out.println("Exit from TRaverse");
//		for(Character s:encode.keySet()){
//			System.out.println("Value of"+s+" is  "+encode.get(s));
//			
//		}
		
	}
		
	public static void main(String[] args){
		//Hauffman h=new Hauffman("abc",true,"file");
		Hauffman h=new Hauffman("aaAbbbbbC",true,"file");
		//Hauffman h=new Hauffman("Baa, baa, black sheep, have you any wool?",true,"file");
		h.encode(); 
	}

	
	
	
}


	
	
