package Day3;
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
			
			//ask the user the text to be translated
			englishText=sc.nextLine();
			
			//convert the text entered by the user in lowercase
			englishText=englishText.toLowerCase();
			
			String translatedText="";
			
			//split the text into words
			String[] englishTextWord=englishText.split(" ");
			
			//run the loop to check for different criterias in each word
			for(int i=0;i<englishTextWord.length;i++){
				//find the index of y in the word
				int indexOfY=englishTextWord[i].indexOf('y');
				for(char c:arrayOfVowels){
					//if the first character is vowel then add "way" to the word
					if(englishTextWord[i].charAt(0)==c | (indexOfY!=0 && indexOfY!=-1)){
						
						englishTextWord[i]+="way";
						break;
					}
					
					//if the first character is consonant then find the index of vowel and shift the part prior to it at last and add "ay" at the end
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
