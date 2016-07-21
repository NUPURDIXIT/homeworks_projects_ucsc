import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EnglishToPigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Pig Latin Translator");
		Scanner sc=new Scanner(System.in);
		String choice="y";
		char[] arrayOfVowels= new char[]{'a','e','i','o','u'};
		String englishText="";
		
		
		while(choice.equalsIgnoreCase("y")){
			System.out.println("Enter a line to be translated to Pig Latin");
			englishText=sc.nextLine();
			
			englishText=englishText.toLowerCase();
			
			String translatedText="";
			
			String[] englishTextWord=englishText.split(" ");
			
			for(int i=0;i<englishTextWord.length;i++){
				int indexOfY=englishTextWord[i].indexOf('y');
				for(char c:arrayOfVowels){
					
					if(englishTextWord[i].charAt(0)==c | (indexOfY!=0 && indexOfY!=-1)){
						
						englishTextWord[i]+="way";
						break;
					}
					else{
						int a=englishTextWord[i].indexOf(c);
						if(a!=-1){
							englishTextWord[i]=englishTextWord[i].substring(a)+englishTextWord[i].substring(0,a)+"ay";
							break;
						}
						
						
					}
				}
				
				translatedText+=englishTextWord[i]+" ";
			}
			System.out.println(translatedText);
			choice=Validator.getChoice(sc, "Translate another line?(y/n) :");
			System.out.println();
			
		}
		
			
	}
		
		
}
