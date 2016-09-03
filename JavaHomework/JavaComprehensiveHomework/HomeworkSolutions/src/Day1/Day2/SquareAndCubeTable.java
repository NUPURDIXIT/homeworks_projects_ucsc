package Day2;
import java.util.*;
public class SquareAndCubeTable {

/*
 * Program to print the square and cube of the number entered by the user in tabular form
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the squares and cube table");
		Scanner sc=new Scanner(System.in);
		String choice="y";
		while(choice.equalsIgnoreCase("y")){
		//Prompts user for input	
			System.out.println("Enter an Integer:");
			int num=sc.nextInt();
			String table=" ";
			table+="Number   Squared     Cube"+"\n";
			
			table+="======   ========    ====="+"\n";
			
			for(int i=1;i<=num;i++){
				table+=i+"          "+(i*i)+"          "+(i*i*i)+"\n";
				
			}
		System.out.println(table);
		System.out.println("Continue(y or n)?");
		choice=sc.next();
		System.out.println();
		}
			
	}

}
