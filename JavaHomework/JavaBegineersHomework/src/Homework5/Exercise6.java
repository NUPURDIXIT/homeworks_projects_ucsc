package Homework5;

import java.util.*;
import java.io.*;

public class Exercise6 {

	static void processInputOutputFiles(String[] args) {
		String inputDiskFileName = args[0];
		System.out.println("\n\nOutput from testFileReaderWithBufferedReader method\n");
		String s="";
		try {
			FileReader fileReader = new FileReader(inputDiskFileName); 

			BufferedReader finalInStream = new BufferedReader(fileReader);
			//shorter version:
			//BufferedReader finalInStream =  new BufferedReader(new FileReader(fileReader));
			
			PrintWriter textPrintStream = null;
			try {
				textPrintStream = new PrintWriter(new FileOutputStream(args[1]));
				
			} catch (FileNotFoundException e) {
				System.out.println("Error opening the file " + 
											  args[1] + "\n" +
						                      e.getMessage());
				System.exit(0);
			}
			
			int count=1;
			while ((s=finalInStream.readLine()) != null) {
				String target = "Student #:"+count+" " +s;
				System.out.println(target);
				textPrintStream.println(getOutputString(target));
				String newLine = System.getProperty("line.separator");
				textPrintStream.write(newLine);
				count++;
			}
			finalInStream.close();
			textPrintStream.close();
		} catch (Exception e) {
			System.out.println("The file input.txt is not available in default folder\n");
			//e.printStackTrace();
		}
		//return s;
	}


	// Using output streams, write to a disk file
	static String getOutputString(String s) {
		//System.out.println("\n\nOutput from testOutputStream method\n");
		s = s.replace(": ", "");
		s = s.replace(",", ":");
		StringBuffer sb = new StringBuffer(s);
		int hash = sb.indexOf("#");
		sb.insert(hash+2, " is:");
		
		int firstColon = sb.indexOf(": ");
		sb.insert(firstColon+2, "\"");
		
		int secondColon = sb.indexOf(": ", firstColon+2);
		sb.insert(secondColon, "\" whose raw scores are");
		
		sb.append(":");
		
		String target = sb.toString();
		return target;
//		System.out.println(sb);
	}

	public static void main(String[] args) throws IOException {
		String a[] = {"input.txt", "output.txt"};
		processInputOutputFiles(a);
//		testFileReaderWithBufferedReader(args.length > 0? args[0]: "input.txt");
//		testOutputStream(args.length > 1? args[1]: "output.txt");
		String s = "Student #: 2 Ariana B. Smith, 90, 90, 100, 100, 99, 100, 95";
		System.out.println(getOutputString(s));
		//Student #2 is: "Ariana B. Smith" whose raw scores are: 90: 90: 100: 100: 99: 100: 95:
		
	} // end main
} // end class

