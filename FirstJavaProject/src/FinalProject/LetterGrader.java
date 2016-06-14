package FinalProject;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import FinalProject.utility.Utils;

//class LetterGrader has all the functionalities and is implementing interface Igrader
public class LetterGrader implements IGrader{
	
	/***********************************************************************************************************/
	/*        Declaration of private variables                     											   */
	/***********************************************************************************************************/
	private String input;
	private String output;
	private List<Integer> scoresQuiz1 =new ArrayList<Integer>();
	private List<Integer> scoresQuiz2 =new ArrayList<Integer>();
	private List<Integer> scoresQuiz3 =new ArrayList<Integer>();
	private List<Integer> scoresQuiz4 =new ArrayList<Integer>();
	private List<Integer> scoresMid1 =new ArrayList<Integer>();
	private List<Integer> scoresMid2 =new ArrayList<Integer>();
	private List<Integer> scoresFinal =new ArrayList<Integer>();
	
	//StudentCompare is a class that implements Comparable Interface.
	//Create a list of students of type StudentCompare
	private List<Student> students=new ArrayList<Student>();
	
	
	/***********************************************************************************************************/
	/*        Parameterized Constructor which takes the input file and output file names as the arguments 	   */
	/***********************************************************************************************************/	
	public LetterGrader(String input,String output){
		this.input=input;
		this.output=output;
		processInputFile(input);
	}
	
	/***********************************************************************************************************/
	/*        This Method parses input file and keep values in instance variables
	/***********************************************************************************************************/
	private void processInputFile(String file){
		
		//Create an object of input file whose name is stored in args[0]
		File inputFile=new File(file);
		
//		double studentScoreFinal=0.0;
		
		//if the input file doesn't exists then display proper message and exit
		if(!inputFile.exists()){
			System.out.println("Input file" + file+ "does not exist");
			System.exit(2);
		}
		
		//Exception handling to catch the IOException
		try{
			Scanner input=new Scanner(inputFile);
			
			//Run the while loop till a line is encountered in the input file.
			while(input.hasNextLine()){
				
				//Create an object of class Student
				Student student=new Student();
				
				//Store each line
				String line=input.nextLine();
				
				//parse the line by splitting it with delimiter comma(,)
				String[] studentInfo=line.split(",");
				
				//on splitting line the total number of fields equals 8, thus this check ensures that if
				//there is any line between any two rows in input file then skip else it would result in an error
				if(studentInfo.length!=8){
					continue;
				}
				
				double weightedScore=0.0;
				//Integer Array to store the scores for Quiz1,2,3,4
				Integer[] scoreQuiz=new Integer[4];
				
				////Integer Array to store the scores for Mid1,2
				Integer[] scoreMid = new Integer[2];
				
				//use trim method to remove any spaces before and after each score and then convert it into 
				//Integer with the help of wrapper class.
				
				//Note:
				//Utils class is created to handle exception while parsing the string to integer
				//studentInfo[1] stores the score for Quiz1 
				//studentInfo[2] stores the score for Quiz2
				//studentInfo[3] stores the score for Quiz3
				//studentInfo[4] stores the score for Quiz4
				scoreQuiz[0]=Utils.parseInt(studentInfo[1].trim());
				scoreQuiz[1]=Utils.parseInt(studentInfo[2].trim());
				scoreQuiz[2]=Utils.parseInt(studentInfo[3].trim());
				scoreQuiz[3]=Utils.parseInt(studentInfo[4].trim());
				//studentInfo[5] stores the score for Mid1 
				//studentInfo[6] stores the score for Mid2
				
				scoreMid[0]=Utils.parseInt(studentInfo[5].trim());
				scoreMid[1]=Utils.parseInt(studentInfo[6].trim());
				
				//Integer variable to store Score for Final 
				Integer studentScoreFinale=Utils.parseInt(studentInfo[7].trim());
				student.setScoreFinal(studentScoreFinale);
				//Call Method calculateScores to calculate the total score of each student for the purpose 
				//of calculating final grade
				weightedScore=calculateWeightedScore(scoreQuiz,scoreMid,studentScoreFinale);
				
				//Call method calcLetterGrade to calculate the grade of all students by passing List of total
				//scores of each student as parameter
				String grade=calculateLetterGrade(weightedScore);
				
				
				student.setName(studentInfo[0]);
				student.setGrade(grade);
				
				
				
				//Call setScoreQuiz method of class StudentCompare to set the scores of each Quiz
				//for each student
				student.setScoreQuiz(scoreQuiz);
				
				
				
				////Call setScoreMid method of class StudentCompare to set the scores of each Midterm
				//for each student
				student.setScoreMid(scoreMid);
				
				
				
				
				//List students keep adding the data of all students
				students.add(student);
				
				//Lists to store scores for Quiz1,Quiz2,Quiz3,Quiz4,mid1,mid2,final
				//This is done in order to calculate the Average,Minimum and Maximum score for each term
				scoresQuiz1.add(scoreQuiz[0]);
				scoresQuiz2.add(scoreQuiz[1]);
				scoresQuiz3.add(scoreQuiz[2]);
				scoresQuiz4.add(scoreQuiz[3]);
				scoresMid1.add(scoreMid[0]);
				scoresMid2.add(scoreMid[1]);
				scoresFinal.add(studentScoreFinale);
				
				
			}
				//The object is called to sort since the class already implements comparable interface 
				Collections.sort(students);
				
				input.close();
				
			}catch(IOException e){
				System.out.println("Error reading from input file: "+file );
				
		}

	}

	
	
	/**********************************************************************************************************/
	/*        This Method calculates the total scores of each student                       				  */
	/**********************************************************************************************************/
	
	private double calculateWeightedScore(Integer[] scoreQuiz,Integer[] scoreMid,Integer scoreFinale){
		double totalScores = 0.0;
		double studentScoreQ1=scoreQuiz[0]*0.1;
		double studentScoreQ2=scoreQuiz[1]*0.1;
		double studentScoreQ3=scoreQuiz[2]*0.1;
		double studentScoreQ4=scoreQuiz[3]*0.1;
		double studentScoreMid1=scoreMid[0]*0.2;
		double studentScoreMid2=scoreMid[1]*0.15;
		double studentScoreFinal=scoreFinale*0.25;
		totalScores=studentScoreQ1+studentScoreQ2+studentScoreQ3+studentScoreQ4+studentScoreMid1+
				    studentScoreMid2+studentScoreFinal;
		return totalScores;
	}
	

	/***********************************************************************************************************/
	/*        This Method display the the Average ,Minimum and Maximum score of each term on console                       				   */
	/***********************************************************************************************************/
	
	private void displayAverages(){
			
		//Call method caculateAverage to calculate the average scores for each Quiz,mid and final
		//by passing the lists of each Quiz,mid and final
		double averageQuiz1=calculateAverage(scoresQuiz1);
		double averageQuiz2=calculateAverage(scoresQuiz2);
		double averageQuiz3=calculateAverage(scoresQuiz3);
		double averageQuiz4=calculateAverage(scoresQuiz4);
		double averageMid1=calculateAverage(scoresMid1);
		double averageMid2=calculateAverage(scoresMid2);
		double averageFinal=calculateAverage(scoresFinal);
		
		
		//Call method caculateAverage to calculate the minimum scores for each Quiz,mid and final
		//by passing the lists of each Quiz,mid and final
		int minQ1=calculateMinimum(scoresQuiz1);
		int minQ2=calculateMinimum(scoresQuiz2);
		int minQ3=calculateMinimum(scoresQuiz3);
		int minQ4=calculateMinimum(scoresQuiz4);
		int minMidI=calculateMinimum(scoresMid1);
		int minMidII=calculateMinimum(scoresMid2);
		int minFinal=calculateMinimum(scoresFinal);
		
		
		//Call method caculateAverage to calculate the maximum scores for each Quiz,mid and final
		//by passing the lists of each Quiz,mid and final
		int maxQ1=calculateMaximum(scoresQuiz1);
		int maxQ2=calculateMaximum(scoresQuiz2);
		int maxQ3=calculateMaximum(scoresQuiz3);
		int maxQ4=calculateMaximum(scoresQuiz4);
		int maxMidI=calculateMaximum(scoresMid1);
		int maxMidII=calculateMaximum(scoresMid2);
		int maxFinal=calculateMaximum(scoresFinal);
		
		System.out.println("Letter grade has been calculated for students listed in input file "+input+"  and written to\noutput file "+output);
		System.out.println("\nHere is the class averages:\n");
		System.out.println("             Q1        Q2       Q3       Q4      Mid1     Mid2    Final");
		System.out.printf("Average: %8.2f  %8.2f %8.2f %8.2f %8.2f %8.2f %8.2f",averageQuiz1,averageQuiz2,averageQuiz3,
				averageQuiz4,averageMid1,averageMid2,averageFinal);
		System.out.println();
		System.out.printf("Minimum: %8d  %8d %8d %8d %8d %8d %8d",minQ1,minQ2,minQ3,minQ4,minMidI,minMidII,minFinal);
		System.out.println();	
		System.out.printf("Maximum: %8d  %8d %8d %8d %8d %8d %8d",maxQ1,maxQ2,maxQ3,maxQ4,maxMidI,maxMidII,maxFinal);
	}
	
	
	/***********************************************************************************************************/
	/*        This Method calculates the Average scores for each term                      				   */
	/***********************************************************************************************************/
	
	private double calculateAverage(List<Integer> scoreListEachTerm){
		double sum=0;
		double scoreEachQuizAverage;
		for(Integer score:scoreListEachTerm){
			sum+=score;
		}
		
		scoreEachQuizAverage=sum/scoreListEachTerm.size();
		return scoreEachQuizAverage;
		
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
	/*        This Method calculates the Maximum score for each term                          				   */
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
	
	private String calculateLetterGrade(double score){
		String result="";
		
		if(score>=90){
			result="A";
			
		}
		else if(score>=80){
			result="B";
			
		}
		else if(score>=70){
			result="C";
			
		}
		else if(score>=60){
			result="D";
			
		}
		else{
			result="F";
		}
		
		return result;
	}

	/***********************************************************************************************************/
	/*        This Method writes grades against each student's name in the output file                         */
	/***********************************************************************************************************/
	/**
	 * @throws FileNotFoundException *******************************
	 * 
	 */
	public void writeGradesAndDisplayAvgs() throws FileNotFoundException{
		
		PrintWriter output=new PrintWriter(this.output);
	
		output.println("Letter grade for "+students.size()+" students given in "+this.input+" file is:");
		output.println();
		
		//Run iterator on students in order to write the studentname along with grades in sorted manner
		for(Student student:students){
			output.println(student.getNameGradeString());
			
		}
		
		output.flush();
		output.close();
		
		//Call method displayAverages to show Average,Min and Max of all the terms on console
		displayAverages();
	}
	
	
	/***********************************************************************************************************/
	/*        This is a class whose instance is created in the class LetterGrader. This class implements       */
	/* 		  Comparable Interface.                                                         				   */
	/***********************************************************************************************************/

	private class Student implements Comparable{
		private String studentName;
		private String grade;
		
		private Integer[] scoreQuiz = new Integer[4];
		private Integer[] scoreMid = new Integer[2];
		private Integer scoreFinal;
		
		
		/***********************************************************************************************************/
		/*        This Method returns the student name 						                       				   */
		/***********************************************************************************************************/
		
		public String getStudentName(){
			return studentName;
		}
		
		
		/***********************************************************************************************************/
		/*        This Method returns the grade for each student                               					   */
		/***********************************************************************************************************/
		
		public String getGrade(){
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
		/*        This Method sets the score for each Quiz                           						   */
		/***********************************************************************************************************/
		
		public void setScoreQuiz(Integer[] scoreQuiz){
			this.scoreQuiz=scoreQuiz;
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
			Student studcomp;
			//check if the object o is instance of StudentCompare class then type cast it as object of StudentCompare
			if(o instanceof Student){
				studcomp=(Student)o;
			}
			else{
				return 0;
			}
			 
			String studentName1=studcomp.getStudentName();
			
			//returns the result of comparing names in the output file and sort it on this basis(i.e. ascending order of names)
			return studentName.compareTo(studentName1);
		}
		
		
		/***********************************************************************************************************/
		/*        This Method prepares the strings for student name and grades to be written in the output file   */
		/***********************************************************************************************************/
		public String getNameGradeString(){
			int length = 30;
			
			StringBuilder line = new StringBuilder();
			length -= getStudentName().length();
			
			line.append(getStudentName()).append(":");
			while(length > 0){
				line.append(' ');
				length--;
			}
			line.append(getGrade());
			
			return line.toString();
		}
		
		/***********************************************************************************************************/
		/*        This Method can be used to view the list object of type StudentCompare                           */
		/***********************************************************************************************************/
		@Override
		public String toString() {
			return "StudentCompare [studentName=" + studentName + ", grade=" + grade + ", scoreQuiz="
					+ Arrays.toString(scoreQuiz) + ", scoreMid=" + Arrays.toString(scoreMid) + ", scoreFinal="
					+ scoreFinal + "]";
		}
	}
}




	
