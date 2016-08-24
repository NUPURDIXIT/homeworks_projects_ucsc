package Final;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

import HomeworkDay5.IntBtree;

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
	
	static class Node implements Comparable{	
		public int id;
		public int freq;
		public char letter;
		public Node left;
		public Node right;
		
		Node(int id,int freq,char letter,Node left,Node right) {
			this.id=IdCounter++;
			//this.id=id;
			this.freq=freq;
			this.letter=letter;
			left = null;
			right = null;
			
		}
		
		public boolean isLeaf(){
			return (left==null && right==null);
		}
		
		public int compareTo(Object o){
			Node n;
			
			if(o instanceof Node){
				n=(Node)o;
				//return freq - n.freq;
				
			}
			else{
				return 0;
			}
			
			return (freq < n.freq) ? -1 : ((freq > n.freq) ? 1 : 0);
				
			
			
		}
	}
	/*
	 * method to decode the string
	 */
	
	public void decode(){
		HashMap<Character,Integer> letterSet=new HashMap<Character,Integer>();
		letterSet=countOccurence(s);
		buildHauffmanTree(letterSet);
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
		
		for(Character key:letterSet.keySet()){
			System.out.println("occurence of key '"+ key +"' is "+letterSet.get(key));
		}
		return letterSet;
	}
	/*
	 * method to sort the values using priority queue
	 */

	public static Node buildHauffmanTree (HashMap<Character,Integer> letterSet){
		PriorityQueue<Node> pq=new PriorityQueue<Node>();
		
		for(char key:letterSet.keySet()){
			System.out.println("id is"+IdCounter);
			System.out.println("freq is" + letterSet.get(key));
			System.out.println("key is "+ key);
			pq.add(new Node(IdCounter,letterSet.get(key),key,null,null));
		}
		
		while(pq.size()>1){
			Node left=pq.poll();
			Node right=pq.poll();
			pq.add(new Node(IdCounter,left.freq+right.freq,'\0',left,right));
		}
		return pq.poll();
	}
	
	
		
	public static void main(String[] args){
		Hauffman h=new Hauffman("aaAbbbbbC",true,"file");
		//Hauffman h=new Hauffman("Baa, baa, black sheep, have you any wool?",true,"file");
		h.decode(); 
	}

	
	
	
}


	
	
