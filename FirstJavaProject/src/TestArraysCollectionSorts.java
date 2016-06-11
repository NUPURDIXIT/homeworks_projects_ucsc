package demoday7;

import java.util.*;

class NewBox implements Comparable{
	//state
	private int 		height = 10;
    private int 		width = 20;
	private String 	hStr = "-";
	private String 	vStr = "|";
	
	private String boxName = "Default Name";
	
	//definition of a default constructor
	public NewBox() {
		
	}
	public NewBox(int h) {
		height = h;
	}

	public NewBox(int h, int w) {
		super();
		height = h;
		width = w;
	}
	
	public NewBox(String boxName) {
		super();
		this.boxName = boxName;
	}

	public NewBox(String boxName, int h, int w) {
		super();
		this.boxName = boxName;
		height = h;
		width = w;
	}

 
	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String bName) {
		this.boxName = bName;
	}

	//accessor methods aka getters
	public int getHeight () {
		return height;
	}

	public int getWidth () {
		return width;
	}

	//mutator methods
	public void setWidth (int width) {
		this.width= width;
	}
	public void setHeight (int height) {
		this.height= height;
	}

	//used by Arrays.sort method internall
	//you are required to implement this to describe what
	//makes your one object is bigger, smaller or equal than other object
	public int compareTo(Object o) {
	    	NewBox passedBox;
	    	if (o instanceof NewBox){
	    		passedBox = (NewBox)o; //safe to cast it
	    	}
	    	else
	    		return 0; //I don't know who you are so can't handle you
	    	
   		int area1 = passedBox.height * passedBox.width; //area of passed box
      	int area2 = height * width; //my area
          	
       if ( area1 < area2 )
           return 1; //I am bigger
       else if ( area1 > area2 )
           return -1; //passed box is bigger
       else
           return 0; //both of them are equal
   }

}

public class TestArraysCollectionSorts {

	//shows how to define array of references
	static void testArrayOfReferences() {
		NewBox [] myBoxArray = new NewBox[10]; 
        // is array of 10 Box objects Java objects
		myBoxArray[0] = new NewBox();
		myBoxArray[1] = new NewBox(5);
		myBoxArray[2] = new NewBox("I am fancy");
		myBoxArray[3] = new NewBox("I am fat and fancy", 30, 60);
		//you can keep adding it.
	}
	
	//ArrayList is better array, shrinks and expands
	//It is jungle out there or a badly managed ZOO
	static void testArrayList(){
		System.out.println("Output from: " + "testArrayList() method");
		//will dynamically grow
		ArrayList listOfValues1 = new ArrayList();
		listOfValues1.add(1); //add integer to it (it eventually converts to inter-object)
		listOfValues1.add(2);
		listOfValues1.add(3);
		System.out.println(listOfValues1);
		
		//remove all of the members
		listOfValues1.clear();
		System.out.println(listOfValues1);
		
		//now add another type of object to same ArrayList
		listOfValues1.add("John");
		listOfValues1.add("Jack");
		listOfValues1.add("Jill");
		System.out.println(listOfValues1);
		System.out.println("3: " + listOfValues1.get(2)); //fiind who is there in third position

		//is not this scary? You can even add newbox in it, WHAT?  wait a minute, how
		//can I mix apple and oranges? How do I know what I have stored in there
		listOfValues1.add(new NewBox(10));
		listOfValues1.add(new NewBox(20));
		listOfValues1.add(new NewBox(30));

		//this definitely looks scary to me
		NewBox getBox = (NewBox)listOfValues1.get(3);
		System.out.println(listOfValues1);
		
		NewBox newBox =new NewBox(30);
		//Ah this is consoling, at least I can test out what is inside the ArrayList before I use it
		//Ok, then looks like it can be used
		if (listOfValues1.contains(newBox)) {
			System.out.println("This Box is present");
		} else
			System.out.println("This Box is not present");
		System.out.println();
	}

	
	static void testNormalArraySort() {
		System.out.println("Output from: " + "testNormalArraySort() method");
		//Use Compare To
        //using with normal array
        NewBox box1 = new NewBox("New Box 3", 10, 20);     
        NewBox box2 = new NewBox("New Box 4", 20, 28);      
        NewBox box3 = new NewBox("New Box 2", 20, 20);      
        NewBox box4 = new NewBox("New Box 1", 25, 20);      

        NewBox[] lotsOfBoxes = new NewBox[] {box1, box2, box3, box4};
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName());
        System.out.println();

        //sort naturally - provided by the object
        //object's compareTo method is called internally by Arrays.sort
        Arrays.sort(lotsOfBoxes);
        for (int i = 0; i < lotsOfBoxes.length; i++)
            System.out.println(lotsOfBoxes[i].getBoxName() + " Area: " +
            		lotsOfBoxes[i].getHeight() * lotsOfBoxes[i].getWidth());
        System.out.println();
	}
	
	static void testArrayListSort() {
		System.out.println("Output from: " + "testArrayListSort() method");
		//Use with ArrayList
        NewBox box_1 = new NewBox("New Box 3", 10, 20);     
        NewBox box_2 = new NewBox("New Box 4", 20, 28);      
        NewBox box_3 = new NewBox("New Box 2", 20, 20);      
        NewBox box_4 = new NewBox("New Box 1", 25, 20);      
        //populate the array list
        ArrayList lotsOfNewBoxes = new ArrayList();
        lotsOfNewBoxes.add(box_1);
        lotsOfNewBoxes.add(box_2);
        lotsOfNewBoxes.add(box_3);
        lotsOfNewBoxes.add(box_4);
        //use it
        System.out.println("In the order of creation:\n");
        for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
        	NewBox nBox = (NewBox)lotsOfNewBoxes.get(i);
            System.out.println(nBox.getBoxName());
        }
        System.out.println();
		
        //sort naturally - provided by the object
        //the objects compareTo method is called by Collections.sort internally
 		System.out.println("\nIn the order of natural sorting:\n");
 		Collections.sort(lotsOfNewBoxes);  //use collections instead of Arrays
 		for (int i = 0; i < lotsOfNewBoxes.size(); i++) {
 			NewBox nBox = (NewBox) lotsOfNewBoxes.get(i);
 			System.out.println(nBox.getBoxName() + " Area: " + nBox.getHeight()
 					* nBox.getWidth());
 		}
        System.out.println();
	}
	
	public static void main(String[] args) {		
		//just like array of primitive data types you can array of references
		testArrayOfReferences();
	
		//using ArrayList
		testArrayList();
		
		//normal sorting
		testNormalArraySort();
		
		//normal sorting ArrayList
		testArrayListSort();	
	}
}