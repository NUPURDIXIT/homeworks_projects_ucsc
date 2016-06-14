package FinalProject;

import java.io.FileNotFoundException;

public class TestLetterGrader {

	public static void main(String[] args) {
		// We need to give 2 arguments viz. input file name and output file name.If the number of arguments are 
		//less than 2 then exit. We need to create an object of class Lettergrader only if 2valid argumnets are
		//passed via command line
		
		if(args.length<2){
			System.out.println("Invalid arguments: Expected inputfile and outputfile names but didn't receive");
			System.exit(2);
		}
		else{
			
			//Create an object of class Lettergrader by passing the arguments .
			//args[0] corresponds to input file name
			//args[1] corresponds to output file name
			LetterGrader lettergrader=new LetterGrader(args[0],args[1]);
			
			
			//In the project 2 main operations are required viz. writing grades to output file and 
			//displaying average,minimum and max on console. Thus, only writing grade method is called 
			//in driver program which in turn would take care of calling displaying averages on console in 
			//another class Lettergrader.
			
			//Exception handling for writing data to output file in case file doesn't exist.
			try {
				lettergrader.writeGradesAndDisplayAvgs();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}
}
