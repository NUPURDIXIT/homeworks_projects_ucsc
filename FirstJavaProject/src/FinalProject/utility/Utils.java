package FinalProject.utility;

//This class is created to parse the stirng to integer using Integer wrapper class
//and handle the Number format exception that may arise due to faulty value
public class Utils {
	
	public static int parseInt(String str){
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			
			System.out.println("Input file corrupted.");
			System.exit(2);
		}
		
		return -1;
	}
}
