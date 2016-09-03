import java.util.ArrayList;
import java.util.Scanner;

import Day3.Validator;

public class Movie {
	public String title;
	public String category;
	
	static ArrayList<String> movieCat=new ArrayList<>();
	static ArrayList<String> movieTitle=new ArrayList<>();
	public Movie(){
		title=null;
		category=null;
		
	}
	
	public Movie(String title,String category){
		this.title=title;
		this.category=category;
		
	}
	
	public void setCategory(ArrayList<String> movieCat){
		movieCat.add("animated");
		movieCat.add("drama");
		movieCat.add("horror");
		movieCat.add("scifi");
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String choice="y";
		while(choice.equalsIgnoreCase("y")){
			System.out.println("Welcome to the Movie List Application");
			System.out.println();
			System.out.println("There are 100 movies in the list");
			String cat=Validator.getString(sc, "What category are you interested in?");
			 if (cat.equalsIgnoreCase("scifi"))
		        {
				 	movieTitle.add("Star Wars");
				 	movieTitle.add("Star Wars1");
				 	movieTitle.add("Star Wars2");
				 	movieTitle.add("Star Wars3");
		            movieCat.add("scifi");
		        }
			 
			 else if(cat.equalsIgnoreCase("animated")){
			        
					 	movieTitle.add("animated1");
					 	movieTitle.add("animated2");
					 	movieTitle.add("animated3");
					 	movieTitle.add("animated4");
			            movieCat.add("animated");
			 }
			 
	
		}
		
	}

}
