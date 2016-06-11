package Misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;


public class LetterGrader{
	private String grade;
	private List<Double> totalScore =new ArrayList<Double>();
	private List<Integer> scoreQuarter1Total =new ArrayList<Integer>();
	private List<Integer> scoreQuarter2Total =new ArrayList<Integer>();
	private List<Integer> scoreQuarter3Total =new ArrayList<Integer>();
	private List<Integer> scoreQuarter4Total =new ArrayList<Integer>();
	private List<Integer> scoreMid1Total =new ArrayList<Integer>();
	private List<Integer> scoreMid2Total =new ArrayList<Integer>();
	private List<Integer> scoreFinalTotal =new ArrayList<Integer>();
	
	//StudentCompare is a class that implements Comparable Interface.
	//Create a list of students of type StudentCompare
	private List<StudentCompare> students=new ArrayList<StudentCompare>();
	
	/***********************************************************************************************************/
	/*        Declaration of private variables                     											   */
	/***********************************************************************************************************/
	
	//private String[] args;
	//private String args0;
	//private String args1;
	
	/***********************************************************************************************************/
	/*        Default Constructor for class LetterGrader           					           				   */
	/***********************************************************************************************************/
//	public LetterGrader(){
//	}
	
	/***********************************************************************************************************/
	/*        Parameterized Constructor which takes the input file and output file names as the arguments 	   */
	/***********************************************************************************************************/	
	public LetterGrader(String input){
		processInputFile(input);
	}
	
	/***********************************************************************************************************/
	/*        This Method calculates the Average scores of each student                       				   */
	/***********************************************************************************************************/
	private void processInputFile(String file){
		
		//Create an object of input file whose name is stored in args[0]
		File inputFile=new File(file);
		
//		double studentScoreFinal=0.0;
		
		//if the input file doesn't exists then exit
		if(!inputFile.exists()){
			System.out.println("Input file" + file+ "does not exist");
			System.exit(2);
		}
		
		//
		try{
			Scanner input=new Scanner(inputFile);
			
//			int i=1;
//			int q=0;
			
			while(input.hasNextLine()){
				
				StudentCompare studentComp=new StudentCompare();
				String line=input.nextLine();
				
				String[] studentInfo=line.split(",");
				
				
				double totalScores=0.0;
				
				//Call Method calculateScores to calculate the total score of each student for the purpose 
				//of calculating final grade
				totalScores=calculateScores(studentInfo[1],studentInfo[2],studentInfo[3],studentInfo[4],studentInfo[5],studentInfo[6],studentInfo[7]);
				
				//keep adding the total scores of each student in a list 
				totalScore.add(totalScores);
				
				//Call method calcLetterGrade to calculate the grade of all students by passing List of total
				//scores of each student as parameter
				grade=calcLetterGrade(totalScore);
				
				
				studentComp.setName(studentInfo[0]);
				studentComp.setGrade(grade);
				
				//Integer Array to store the scores for Quarter1,2,3,4
				Integer[] scoreQuarter=new Integer[4];
				
				////Integer Array to store the scores for Mid1,2
				Integer[] scoreMid = new Integer[2];
				
				//use trim method to remove any spaces before and after each score and then convert it into 
				//Integer with the help of wrapper class.
				
				//Note:
				//studentInfo[1] stores the score for quarter1 
				//studentInfo[2] stores the score for quarter2
				//studentInfo[3] stores the score for quarter3
				//studentInfo[4] stores the score for quarter4
				scoreQuarter[0]=Integer.parseInt(studentInfo[1].trim());
				scoreQuarter[1]=Integer.parseInt(studentInfo[2].trim());
				scoreQuarter[2]=Integer.parseInt(studentInfo[3].trim());
				scoreQuarter[3]=Integer.parseInt(studentInfo[4].trim());
				
				
				//Call setScoreQuarter method of class StudentCompare to set the scores of each quarter
				//for each student
				studentComp.setScoreQuarter(scoreQuarter);
				
				//studentInfo[5] stores the score for Mid1 
				//studentInfo[6] stores the score for Mid2
				
				scoreMid[0]=Integer.parseInt(studentInfo[5].trim());
				scoreMid[1]=Integer.parseInt(studentInfo[6].trim());
				
				////Call setScoreMid method of class StudentCompare to set the scores of each Midterm
				//for each student
				studentComp.setScoreMid(scoreMid);
				
				
				//Integer variable to store Score for Final 
				Integer studentScoreFinale=Integer.parseInt(studentInfo[7].trim());
				studentComp.setScoreFinal(studentScoreFinale);
				
				//List students keep adding the data of all students
				students.add(studentComp);
				
				//Lists to store scores for quarter1,quarter2,quarter3,quarter4,mid1,mid2,final
				//This is done in order to calculate the Average,Minimum and Maximum score for each term
				scoreQuarter1Total.add(scoreQuarter[0]);
				scoreQuarter2Total.add(scoreQuarter[1]);
				scoreQuarter3Total.add(scoreQuarter[2]);
				scoreQuarter4Total.add(scoreQuarter[3]);
				scoreMid1Total.add(scoreMid[0]);
				scoreMid2Total.add(scoreMid[1]);
				scoreFinalTotal.add(studentScoreFinale);
				
				//Increment the variable so that the loop keep running till the condition becomes false
//				i++;
//				q++;
			}
				//The object is called to sort since the class already implements comparable interface 
				Collections.sort(students);
				
				//Call method 'displayAverages' to display the average,minimum and maximum of each term on console
//				displayAverages();
				
				
				//Call method 'writeToOutputFile' to write the data to output file
//				writeToOutputFile(outputFile);
				
				
				//Call Method doCleanup to close the input and output file
				doCleanup(input);
				
				
			}catch(IOException e){
				System.out.println("Error reading from input file: "+file );
				
		}

	}

	
	
	/**********************************************************************************************************/
	/*        This Method calculates the total scores of each student                       				  */
	/**********************************************************************************************************/
	
	private double calculateScores(String studentInfo1,String studentInfo2,String studentInfo3,String studentInfo4,String studentInfo5,String studentInfo6,String studentInfo7){
		double totalScores = 0.0;
		double studentScoreQ1=Integer.parseInt(studentInfo1.trim())*0.1;
		double studentScoreQ2=Integer.parseInt(studentInfo2.trim())*0.1;
		double studentScoreQ3=Integer.parseInt(studentInfo3.trim())*0.1;
		double studentScoreQ4=Integer.parseInt(studentInfo4.trim())*0.1;
		double studentScoreMid1=Integer.parseInt(studentInfo5.trim())*0.2;
		double studentScoreMid2=Integer.parseInt(studentInfo6.trim())*0.15;
		double studentScoreFinal=Integer.parseInt(studentInfo7.trim())*0.25;
		totalScores=studentScoreQ1+studentScoreQ2+studentScoreQ3+studentScoreQ4+studentScoreMid1+
				    studentScoreMid2+studentScoreFinal;
		return totalScores;
	}
	

	/***********************************************************************************************************/
	/*        This Method display the the Average ,Minimum and Maximum score of each term on console                       				   */
	/***********************************************************************************************************/
	
	public void displayAverages(){
			
			//Call method caculateAverage to calculate the average scores for each quarter,mid and final
			//by passing the lists of each quarter,mid and final
			double averageQuarter1=calculateAverage(scoreQuarter1Total);
			double averageQuarter2=calculateAverage(scoreQuarter2Total);
			double averageQuarter3=calculateAverage(scoreQuarter3Total);
			double averageQuarter4=calculateAverage(scoreQuarter4Total);
			double averageMid1=calculateAverage(scoreMid1Total);
			double averageMid2=calculateAverage(scoreMid2Total);
			double averageFinal=calculateAverage(scoreFinalTotal);
			
			
			//Call method caculateAverage to calculate the minimum scores for each quarter,mid and final
			//by passing the lists of each quarter,mid and final
			int minQ1=calculateMinimum(scoreQuarter1Total);
			int minQ2=calculateMinimum(scoreQuarter2Total);
			int minQ3=calculateMinimum(scoreQuarter3Total);
			int minQ4=calculateMinimum(scoreQuarter4Total);
			int minMidI=calculateMinimum(scoreMid1Total);
			int minMidII=calculateMinimum(scoreMid2Total);
			int minFinal=calculateMinimum(scoreFinalTotal);
			
			
			//Call method caculateAverage to calculate the maximum scores for each quarter,mid and final
			//by passing the lists of each quarter,mid and final
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
		}
	
	
	/***********************************************************************************************************/
	/*        This Method calculates the Average scores of each student                       				   */
	/***********************************************************************************************************/
	
	private double calculateAverage(List<Integer> scoreListEachTerm){
		double sum=0;
		double scoreEachQuarterAverage;
		for(Integer score:scoreListEachTerm){
			sum+=score;
		}
		
		scoreEachQuarterAverage=sum/scoreListEachTerm.size();
		return scoreEachQuarterAverage;
		
	}
	
	/***********************************************************************************************************/
	/*        This Method calculates the Minimum score for each term                         				   */
	/***********************************************************************************************************/
	
	private int calculateMinimum(List<Integer> scoreListEachTerm){
		int min=scoreListEachTerm.get(0);
		for(Integer i:scoreListEachTerm){
			if(i<min){
				min=i;
			}
		}
		return min;
	}
	
	/***********************************************************************************************************/
	/*        This Method calculates the Maximum scores for each term                          				   */
	/***********************************************************************************************************/
	
	private int calculateMaximum(List<Integer> scoreListEachTerm){
		int max=scoreListEachTerm.get(0);
		for(Integer i:scoreListEachTerm){
			if(i>max){
				max=i;
			}
		}
		return max;
	}
	
	 /**********************************************************************************************************/
	 /*        This Method calculates the Grade for each student                                               */	           
	 /* 		  If Final Score>=90% then letter grade is A                                                   */
	 /* 			80-89% : B                                                                                 */
	 /* 			70-79% : C																				   */
	 /* 			60-69% : D																	               */
	 /* 			<=59%  : F															                       */
	 /***********************************************************************************************************/
	
	private String calcLetterGrade(List<Double> totalScore){
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
		
		return result;
	}

	/**
	 * @throws FileNotFoundException *******************************
	 * 
	 */
	public void writeGrades(String outputFile) throws FileNotFoundException{
		
		PrintWriter output=new PrintWriter(outputFile);
	//Run iterator on students in order to write the studentname along with grades in sorted manner
		for(StudentCompare data:students){
			output.printf("%-20s : %-10s\n" ,data.getNames(),data.getgrades());
			output.println();
		}
		
		output.flush();
		output.close();
	}
	
	/***********************************************************************************************************/
	/*        This Method closes the input and output file                                   				   */
	/***********************************************************************************************************/
	
	private void doCleanup(Scanner input){
		input.close();
//		output.close();
	}
	
	/***********************************************************************************************************/
	/*        This is a class whose instance is created in the class LetterGrader. This class implements       */
	/* 		  Comparable Interface.                                                         				   */
	/***********************************************************************************************************/

	private class StudentCompare implements Comparable{
		private String studentName;
		private String grade;
		
		private Integer[] scoreQuarter = new Integer[4];
		private Integer[] scoreMid = new Integer[2];
		private Integer scoreFinal;
		
		/***********************************************************************************************************/
		/*        Default Constructor         								                    				   */
		/***********************************************************************************************************/
		
		public StudentCompare(){
			this.studentName="null";
			this.grade="null";
			this.scoreFinal=0;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method calculates the Average scores of each student                       				   */
		/***********************************************************************************************************/
		
		public StudentCompare(String studentName,String grade,Integer[] scoreQuarter,Integer[] scoreMid,Integer scoreFinal){
			this.studentName=studentName;
			this.grade=grade;
			this.scoreQuarter=scoreQuarter;
			this.scoreMid=scoreMid;
			this.scoreFinal=scoreFinal;
			
		}
		
		/***********************************************************************************************************/
		/*        This Method returns the student name 						                       				   */
		/***********************************************************************************************************/
		
		public String getNames(){
			return studentName;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method returns the grade for each student                               					   */
		/***********************************************************************************************************/
		
		public String getgrades(){
			return grade;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method sets the student name              			                     				   */
		/***********************************************************************************************************/
		
		public void setName(String studentName){
			this.studentName=studentName;
		}
		
		/***********************************************************************************************************/
		/*        This Method sets the grade                         			                   				   */
		/***********************************************************************************************************/
		
		public void setGrade(String grade){
			this.grade=grade;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method sets the score for each quarter                           						   */
		/***********************************************************************************************************/
		
		public void setScoreQuarter(Integer[] scoreQuarter){
			this.scoreQuarter=scoreQuarter;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method sets the score for each Midterm for each student				      				   */
		/***********************************************************************************************************/
		
		public void setScoreMid(Integer[] scoreMid){
			this.scoreMid=scoreMid;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method sets the final score for each student                       						   */
		/***********************************************************************************************************/
		
		public void setScoreFinal(Integer scoreFinal){
			this.scoreFinal=scoreFinal;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method defines the compareTo method of Interface Comparable in order to sort the output file
		 *        on the basis of names                                                          				   */
		/***********************************************************************************************************/
		
		public int compareTo(Object o){
			StudentCompare studcomp;
			//check if the object o is instance of StudentCompare class then type cast it as object of StudentCompare
			if(o instanceof StudentCompare){
				studcomp=(StudentCompare)o;
			}
			else{
				return 0;
			}
			 
			String studentName1=studcomp.getNames();
			
			//returns the result of comparing names in the output file and sort it on this basis(i.e. ascending order of names)
			return studentName.compareTo(studentName1);
		}
		
		/***********************************************************************************************************/
		/*        This Method can be used to view the list object of type StudentCompare                           */
		/***********************************************************************************************************/
		@Override
		public String toString() {
			return "StudentCompare [studentName=" + studentName + ", grade=" + grade + ", scoreQuarter="
					+ Arrays.toString(scoreQuarter) + ", scoreMid=" + Arrays.toString(scoreMid) + ", scoreFinal="
					+ scoreFinal + "]";
		}
	}
}




	
