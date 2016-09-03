package homework1;
//Name: Nupur Dixit
//Instructor: Bineet Sharma
//Date: April 21,2016
//Description: This code displays 3 features:
//             1.Prints JAVA in special pattern.
//             2.Prints the result of an expression.
//             3.Prints the area and perimeter of a Rectangle.
             
public class Assignment1 {
	//To print word JAVA in a special pattern
	public static void exercise1(){
		System.out.println("      J      A     V     V     A");
		System.out.println("      J     A A     V   V     A A" );
		System.out.println("J     J    AAAAA     V V     AAAAA");
		System.out.println(" J   J    A     A     V     A     A" );
	}
	
	//To print the result of expression 9.5*4.5-2.5*3/45.5-3.5
	public static void exercise2(){
		System.out.println("Result of expression is   : "+(9.5*4.5-2.5*3)/(45.5-3.5));
	}
	
	//To print Area and Perimeter of rectangle with width=4.5 and height=7.9
	//Note: Area of Rectangle=width*height
	//Note: Perimeter of Rectangle=2*(width+height)
	public static void exercise3(){
		System.out.println("Area of Rectangle is      : "+(4.5*7.9));
		System.out.println("Perimeter of Rectangle is : "+(2*(4.5+7.9)));
	}
	//Main method to invoke the three methods i.e. exercise1(),exercise2() and
	//exercise3()
	public static void main(String[] args) {
		exercise1();
		System.out.println("");
		exercise2();
		System.out.println("");
		exercise3();
		}
}
