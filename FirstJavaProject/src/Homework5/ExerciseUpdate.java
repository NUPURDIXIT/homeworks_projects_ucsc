package Homework5;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
public class ExerciseUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processInputOutputFiles(args);
			
		}
	
	public static void processInputOutputFiles(String [] args){
		File inputFile=new File(args[0]);
		if(!inputFile.exists()){
			System.out.println("Input file" + args[0]+ "does not exist");
			System.exit(2);
		}
		File outputFile=new File(args[1]);
		try{
			Scanner input=new Scanner(inputFile);
			PrintWriter output=new PrintWriter(outputFile);
			int i=1;
			while(input.hasNextLine()){
				String line=input.nextLine();
				System.out.println("Student #: "+ i +" "+line);
				String[] studentInfo=line.split(",");
				output.print("Student # "+ i++ +" is: \""+studentInfo[0]+"\" whose raw scores are:");
				for(int j=1;j<studentInfo.length;j++)
					output.print(studentInfo[j]+": ");
				output.println();
			}
			input.close();
			output.close();
		}catch(IOException e){
			System.out.println("Error reading from input file: "+args[0] );
			
		}
		
	}

}
