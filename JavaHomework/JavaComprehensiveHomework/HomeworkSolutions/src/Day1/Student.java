import java.util.ArrayList;
import java.util.Scanner;

import Day3.Validator;

public class Student implements Comparable{
	
	private  static String lastName;
	private  static String firstName;
	private  static double score;
	private static  ArrayList<Student> student;
	
	public Student(){
		student=new ArrayList<>();
	}
	public Student(String lastName,String firstName,double score){
		this.lastName=lastName;
		this.firstName=firstName;
		this.score=score;
		//this.student=new ArrayList<>();
	}
	
	public String getLastName(){
		return lastName;
	}
	public String getFirstName(){
		return firstName;
	}
	public double getScore(){
		return score;
	}
	
	public  void addStudents(Student stud){
		this.student.add(stud);
	}
	
	public ArrayList<Student> getStudents(){
		
		return student;
	}
	
	public  static void performOperations() {
		Student s=new Student();
		int num=0;
		//int numOfStudents=0;
		Scanner sc=new Scanner(System.in);
		// TODO Auto-generated method stub
		int numOfStudents=Validator.getInt(sc, "Enter number of students to enter");
		
		while(num<numOfStudents){
			System.out.println("Welcome to the Student Scores Application.");
			System.out.println();
			
			System.out.println();
			lastName=Validator.getString(sc, "Student last name");
			firstName=Validator.getString(sc, "Student first name");
			score=Validator.getDouble(sc, "Student score");
			num++;
			s.addStudents(new Student(firstName,lastName,score));
		}
		
			
	}
	
	public static void printStudentstList(){
		for(Student s:student){
			System.out.println(s.getLastName()+","+s.getFirstName()+":"+s.getScore());
		}
	}
		
	public static void main(String[] args){
			performOperations();
			printStudentstList();
			
	}

		@Override
	public int compareTo(Object obj) {
		Student s;
		if(obj instanceof Student){
			s=(Student)obj;
		}
		else{
			return 0;
		}
		String studentLastName=getLastName();
		return s.compareTo(studentLastName);
			
		// TODO Auto-generated method stub
		
	}
		
}


