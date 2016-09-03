package Misc;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;


public class FinalBackup{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		//LetterGrader l=new LetterGrader(args[0],args[1]);
		processInputOutputFiles(args);
	}
			
		//}

/*public class LetterGrader extends FinalDraft{
	public LetterGrader(String[] args){
		this.args0=args0;
		this.args1=args1;
	}
	*/
	/*****************************************************************************************************/
	public static void processInputOutputFiles(String [] args){
		File inputFile=new File(args[0]);
		
		List<Double> totalScore =new ArrayList<Double>();
		List<Integer> scoreQuarter1Total =new ArrayList<Integer>();
		List<Integer> scoreQuarter2Total =new ArrayList<Integer>();
		List<Integer> scoreQuarter3Total =new ArrayList<Integer>();
		List<Integer> scoreQuarter4Total =new ArrayList<Integer>();
		List<Integer> scoreMid1Total =new ArrayList<Integer>();
		List<Integer> scoreMid2Total =new ArrayList<Integer>();
		List<Integer> scoreFinalTotal =new ArrayList<Integer>();
		String grade;
		List<String> grades=new ArrayList<String>();
		List<String> names=new ArrayList<String>();
		List<StudentCompare1> students=new ArrayList<StudentCompare1>();
		
		
		
		double studentScoreFinal=0.0;
		
		if(!inputFile.exists()){
			System.out.println("Input file" + args[0]+ "does not exist");
			System.exit(2);
		}
		File outputFile=new File(args[1]);
		try{
			Scanner input=new Scanner(inputFile);
			PrintWriter output=new PrintWriter(outputFile);
			int i=1;
			int q=0;
			
			while(input.hasNextLine()){
				
				StudentCompare1 studentComp=new StudentCompare1();
				String line=input.nextLine();
				
				String[] studentInfo=line.split(",");
				
				
				
				Double totalScores = 0.0;
				Double studentScoreQ1=Integer.parseInt(studentInfo[1].trim())*0.1;
				Double studentScoreQ2=Integer.parseInt(studentInfo[2].trim())*0.1;
				Double studentScoreQ3=Integer.parseInt(studentInfo[3].trim())*0.1;
				Double studentScoreQ4=Integer.parseInt(studentInfo[4].trim())*0.1;
				Double studentScoreMid1=Integer.parseInt(studentInfo[5].trim())*0.2;
				Double studentScoreMid2=Integer.parseInt(studentInfo[6].trim())*0.15;
				studentScoreFinal=Integer.parseInt(studentInfo[7].trim())*0.25;
				totalScores=studentScoreQ1+studentScoreQ2+studentScoreQ3+studentScoreQ4+studentScoreMid1+
						    studentScoreMid2+studentScoreFinal;
				
					
				totalScore.add(totalScores);
				grade=calcLetterGrade(totalScore);
				grades.add(grade);
				studentComp.setName(studentInfo[0]);
				studentComp.setGrade(grade);
				Integer[] scoreQuarter=new Integer[4];
				Integer[] scoreMid = new Integer[2];
				
				scoreQuarter[0]=Integer.parseInt(studentInfo[1].trim());
				scoreQuarter[1]=Integer.parseInt(studentInfo[2].trim());
				scoreQuarter[2]=Integer.parseInt(studentInfo[3].trim());
				scoreQuarter[3]=Integer.parseInt(studentInfo[4].trim());
				
				//System.out.println("Quarter 1 score is :"+scoreQuarter[0]);
				//studentComp.setScoreQuarter(scoreQuarter);
				
				scoreMid[0]=Integer.parseInt(studentInfo[5].trim());
				scoreMid[1]=Integer.parseInt(studentInfo[6].trim());
				//studentComp.setScoreMid(scoreMid);
				
				Integer studentScoreFinale=Integer.parseInt(studentInfo[7].trim());
				//studentComp.setScoreFinal(studentScoreFinale);
				
				students.add(studentComp);
				
				scoreQuarter1Total.add(scoreQuarter[0]);
				scoreQuarter2Total.add(scoreQuarter[1]);
				scoreQuarter3Total.add(scoreQuarter[2]);
				scoreQuarter4Total.add(scoreQuarter[3]);
				scoreMid1Total.add(scoreMid[0]);
				scoreMid2Total.add(scoreMid[1]);
				scoreFinalTotal.add(studentScoreFinale);
				
				
				i++;
				q++;
			}
			Collections.sort(students);
			//System.out.println("quarter 1 total is :"+scoreQuarter1Total);
			double averageQuarter1=calculateAverage(scoreQuarter1Total);
			double averageQuarter2=calculateAverage(scoreQuarter2Total);
			double averageQuarter3=calculateAverage(scoreQuarter3Total);
			double averageQuarter4=calculateAverage(scoreQuarter4Total);
			double averageMid1=calculateAverage(scoreMid1Total);
			double averageMid2=calculateAverage(scoreMid2Total);
			double averageFinal=calculateAverage(scoreFinalTotal);
			
			int minQ1=calculateMinimum(scoreQuarter1Total);
			int minQ2=calculateMinimum(scoreQuarter2Total);
			int minQ3=calculateMinimum(scoreQuarter3Total);
			int minQ4=calculateMinimum(scoreQuarter4Total);
			int minMidI=calculateMinimum(scoreMid1Total);
			int minMidII=calculateMinimum(scoreMid2Total);
			int minFinal=calculateMinimum(scoreFinalTotal);
			
			int maxQ1=calculateMaximum(scoreQuarter1Total);
			int maxQ2=calculateMaximum(scoreQuarter2Total);
			int maxQ3=calculateMaximum(scoreQuarter3Total);
			int maxQ4=calculateMaximum(scoreQuarter4Total);
			int maxMidI=calculateMaximum(scoreMid1Total);
			int maxMidII=calculateMaximum(scoreMid2Total);
			int maxFinal=calculateMaximum(scoreFinalTotal);
			
			
			System.out.println("             Q1        Q2       Q3       Q4     MidI     MidII    Final");
			System.out.printf("Average: %8.2f  %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f",averageQuarter1,averageQuarter2,averageQuarter3,
					averageQuarter4,averageMid1,averageMid2,averageFinal);
			System.out.println();
			System.out.printf("Minimum: %8d  %8d %8d %8d %8d %8d %8d",minQ1,minQ2,minQ3,minQ4,minMidI,minMidII,minFinal);
			System.out.println();	
			System.out.printf("Maximum: %8d  %8d %8d %8d %8d %8d %8d",maxQ1,maxQ2,maxQ3,maxQ4,maxMidI,maxMidII,maxFinal);
					
			for(StudentCompare1 data:students){
				output.printf("%-20s : %-10s\n" ,data.getNames(),data.getgrades());
				output.println();
			}
			
			input.close();
			output.close();
		}catch(IOException e){
			System.out.println("Error reading from input file: "+args[0] );
			
		}

	}
	
	/*********************************************************************/
	
	private static double calculateAverage(List<Integer> scoreQuarter1Total){
		double sum=0;
		double scoreQuarter1Average;
		for(Integer score:scoreQuarter1Total){
			sum+=score;
		}
		
		scoreQuarter1Average=sum/scoreQuarter1Total.size();
		return scoreQuarter1Average;
		
	}
	
	/**********************************************************/
	
	private static int calculateMinimum(List<Integer> scoreQuarter1Total){
		int min=scoreQuarter1Total.get(0);
		for(Integer i:scoreQuarter1Total){
			if(i<min){
				min=i;
			}
		}
		return min;
	}
	
	/************************************************************************/
	
	private static int calculateMaximum(List<Integer> scoreQuarter1Total){
		int max=scoreQuarter1Total.get(0);
		for(Integer i:scoreQuarter1Total){
			if(i>max){
				max=i;
			}
		}
		return max;
	}
	
	/**************************************************************/
	public static String calcLetterGrade(List<Double> totalScore){
		String result="null";
		
		for(double i:totalScore){
			if(i>=90){
				result="A";
				
			}
			else if(i>=80){
				result="B";
				
			}
			else if(i>=70){
				result="C";
				
			}
			else if(i>=60){
				result="D";
				
			}
			else{
				result="F";
				
			}
			i++;
			
		}
		//System.out.println("Grade is"+ result);
		return result;
	}

}

/*******************************************************************************************************/
class StudentCompare1 implements Comparable{
	private String studentName;
	private String grade;
	
	private Integer[] scoreQuarter = new Integer[4];
	private Integer[] scoreMid = new Integer[2];
	private Integer scoreFinal;
	
	/**********************************************************************/
	public StudentCompare1(){
		String studentName="null";
		String grade="null";
		
		Integer scoreFinal=0;
		//List<Double> score=new ArrayList<Double>();
	}
	
	
	/*************************************************************************************/
	public StudentCompare1(String studentName,String grade,Integer[] scoreQuarter,Integer[] scoreMid,Integer scoreFinal){
		this.studentName=studentName;
		this.grade=grade;
		this.scoreQuarter=scoreQuarter;
		this.scoreMid=scoreMid;
		this.scoreFinal=scoreFinal;
		
	}
	
	/**************************************************************************************/
	public String getNames(){
		return studentName;
	}
	
	/********************************************************/
	public String getgrades(){
		return grade;
	}
	
	
	/*********************************************************************************/
	public void setName(String studentName){
		this.studentName=studentName;
	}
	
	/*********************************************************************************/
	public void setGrade(String grade){
		this.grade=grade;
	}
	
	
	/*********************************************************************************/
	public void setScoreQuarter(Integer[] scoreQuarter){
		this.scoreQuarter=scoreQuarter;
	}
	
	
	/*********************************************************************************/
	public void setScoreMid(Integer[] scoreMid){
		this.scoreMid=scoreMid;
	}
	
	
	/*********************************************************************************/
	public void setScoreFinal(Integer scoreFinal){
		this.scoreFinal=scoreFinal;
	}
	
	
	/*********************************************************************************/
	public int compareTo(Object o){
		StudentCompare1 studcomp;
		if(o instanceof StudentCompare1){
			studcomp=(StudentCompare1)o;
		}
		else{
			return 0;
		}
		 
		String studentName1=studcomp.getNames();
		
		return studentName.compareTo(studentName1);
	}
	
	/*********************************************************************************/
	@Override
	public String toString() {
		return "StudentCompare1 [studentName=" + studentName + ", grade=" + grade + ", scoreQuarter="
				+ Arrays.toString(scoreQuarter) + ", scoreMid=" + Arrays.toString(scoreMid) + ", scoreFinal="
				+ scoreFinal + "]";
	}
	
	
	
	
}



	
