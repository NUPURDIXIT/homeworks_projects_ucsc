package Misc;

import java.io.FileNotFoundException;

public class TestLetterGrader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		if(args.length<2){
			System.out.println("Usage: java Exercise5 inputfile outputfile");
			System.exit(2);
		}
		else{
			LetterGrader lettergrader=new LetterGrader(args[0]);
//			lettergrader.processInputFile();
//			lettergrader.displayAverages();
			try {
				lettergrader.writeGrades(args[1]);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
