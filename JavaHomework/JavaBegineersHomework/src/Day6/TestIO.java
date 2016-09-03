package Day6;


import java.util.*;
import java.io.*;

public class TestIO {

	// Scanner can be used with the disk File as well
	static void testFileReaderWithScanner(String fileName) {
		System.out.println("\n\nOutput from testFileReaderWithScanner method\n");
		Scanner readInput;
		String line;
		String [] parseWords;
		try {
			readInput = new Scanner(new File(fileName));
			while (readInput.hasNextLine()) {
				//read one line at a time and display it
				line = readInput.nextLine();
				parseWords = line.split(",");
				for (int i = 0; i < parseWords.length; i++)
					System.out.print(parseWords[i] + " "); //use your data
				System.out.println(); //print each line in different line
			}
		}
		//start with most specific to most general exception
		catch (FileNotFoundException e) {
			System.out.println("File: " + fileName + "not found\n");
		} // end catch
		catch (IOException e) {
			System.out.println("Error Reading from file: "+ fileName + e.getMessage());
		} // end catch
		catch (Exception e) {
			System.out.println(e);
		} // end catch

	}
	
	static void testFileReaderWithBufferedReader(String inputDiskFileName) {
		System.out.println("\n\nOutput from testFileReaderWithBufferedReader method\n");
		try {
			FileReader fileReader = new FileReader(inputDiskFileName); 

			BufferedReader finalInStream = new BufferedReader(fileReader);
			//shorter version:
			//BufferedReader finalInStream =  new BufferedReader(new FileReader(fileReader));
			String s;
			while ((s=finalInStream.readLine()) != null) {
				System.out.println(s);
			}
			finalInStream.close();
		} catch (Exception e) {
			System.out.println("The file input_file.txt is not available in default folder\n");
			//e.printStackTrace();
		}
	}


	// Using output streams, write to a disk file
	static void testOutputStream(String outputFileName) {
		System.out.println("\n\nOutput from testOutputStream method\n");
		PrintWriter textPrintStream = null;
		try {
			textPrintStream = new PrintWriter(new FileOutputStream(outputFileName));
			textPrintStream.println("This output will go to the file " + outputFileName);
			textPrintStream.write("This is Final Grade - retest \n"); //new line does not work
			textPrintStream.write("This is Final Grade - retest 12/13/2013\r\n"); 
			//line separator for Windows is different \r\n 
			//find line separator and use it instead of using \n in print or printf.
			//printline just works fine
			String newLine = System.getProperty("line.separator");
			textPrintStream.write("This is new line " + newLine +"What is this");
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + 
										  outputFileName + "\n" +
					                      e.getMessage());
			System.exit(0);
		}
		textPrintStream.close();
		System.out.println(outputFileName + " has been written and closed");
	}

	public static void main(String[] args) throws IOException {
		testFileReaderWithScanner(args.length > 0? args[0]: "input_final.txt"); 
		testFileReaderWithBufferedReader(args.length > 0? args[0]: "input_final.txt");
		testOutputStream(args.length > 1? args[1]: "output_final.txt");
	} // end main
} // end class
