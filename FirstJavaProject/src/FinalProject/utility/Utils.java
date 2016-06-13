package FinalProject.utility;

public class Utils {
	
	public static int parseInt(String str){
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Input file corrupted.");
			System.exit(2);
		}
		
		return -1;
	}
}
