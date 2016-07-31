package Day3;
import java.util.Scanner;

import MidTerm.Validator;

public class NumberToWords {
	int numberToConvert;
	static String[] oneToNine=new String[]{"","one","two","three","four","five","six","seven","eight","nine"};
	static String[] tenToNineteen=new String[]{"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
	static String[] TwentyToHundred=new String[]{"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberToWords num=new NumberToWords();
		System.out.println("Welcome to the Number to Word Converter");
		Scanner sc=new Scanner(System.in);
		int numberToConvert=0;
		String choice="y";
		while(choice.equalsIgnoreCase("y")){
			String str="";
			//get the number from user and validate it
			numberToConvert=Validator.getInt(sc, "Enter the number you want to convert to words: ");
			if(numberToConvert == 0){
				str="zero";
			}
			else if(numberToConvert<10){
				str=oneToNine[numberToConvert];
			}
			else if(numberToConvert>=10 && numberToConvert<20){
				str=num.numberBetween10And20(numberToConvert);
				
			}
			else if(numberToConvert>=20 && numberToConvert<100){
				str=num.numberBetween20And100(numberToConvert);
				
			}
			else if(numberToConvert>=100 && numberToConvert<1000){
				str=num.numberBetween100And1000(numberToConvert);
				
			}
			else if(numberToConvert>=1000 && numberToConvert<10000){
				str=num.numberBetween100And10000(numberToConvert);
				
			}
			
			System.out.println(str);
			choice=Validator.getChoice(sc, "Convert another number?(y/n): ");
			System.out.println();
			
		}
	}
		
		public String numberBetween10And20(int numberToConvert){
			String str="";
			str=tenToNineteen[numberToConvert%10];
			return str;
		}
		
		public String numberBetween20And100(int numberToConvert){
			String str="";
			str=TwentyToHundred[numberToConvert/10]+" "+oneToNine[numberToConvert%10];
			return str;
		}
		
		public String numberBetween100And10000(int numberToConvert){
			String str="";
			if(numberToConvert%1000==0){
				str=oneToNine[numberToConvert/100]+" thousand ";
			}
			else if(numberToConvert%100==0){
				str=oneToNine[numberToConvert/100]+" thousand "+tenToNineteen[(numberToConvert%1000)/100]+" hundred ";
			}
			else{
				str=oneToNine[numberToConvert/1000]+" thousand "+oneToNine[(numberToConvert%1000)/100]+" hundred "+TwentyToHundred[(numberToConvert%100)/10]+" "+oneToNine[numberToConvert%10];
			}
			return str;
		}
		
		String numberBetween100And1000(int numberToConvert){
			String str="";
			if(numberToConvert%100==0){
				str=oneToNine[numberToConvert/100]+" hundred ";
			}
			else if(numberToConvert%10==0){
				str=oneToNine[numberToConvert/100]+" hundred "+TwentyToHundred[(numberToConvert%100)/10];
			}
			else{
				str=oneToNine[numberToConvert/100]+" hundred "+TwentyToHundred[(numberToConvert%100)/10]+" "+oneToNine[(numberToConvert%100)%10];
			}
			return str;
		}
		
	
}
