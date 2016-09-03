package Homework5;

public class Exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		processCLArguments(args);
	}
	public static void processCLArguments(String[] args){
		if(args.length<2){
			System.out.println("Usage: java Exercise5 inputfile outputfile");
		}
		else{
			System.out.println("Input will be read from: " +args[0] );
			System.out.println("Output will be written into: "+args[1]);
		}
		
	}

}
