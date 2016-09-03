package DemoDay2;
//Name: Nupur Dixit
//Instructor: Bineet Sharma
//Date: April 21,2016
//Optional Programming question mentioned in Homework1
//Description: This code computes the population in the next 5 years taking
//             into account the birth,deaths and new immigrants every per second.
public class Population {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double birth,death,immigrant;
		long population;
		//Total Birth in 5 years
		birth=(5*365*24*60*60)/7.0;
		//Total deaths in 5 years
		death=(5*365*24*60*60)/13.0;
		//Immigrants in 5 years
		immigrant=(5*365*24*60*60)/45.0;
		System.out.println("Number of births in 5 years    : "+ birth);
		System.out.println("Number of deaths in 5 years    : "+ death);
		System.out.println("Number of immigrants in 5 years: "+ immigrant);
		//Population in 5 years=Current Population +(Births in next 5 years - Deaths in 
		//next 5 years + Immigrants in next 5 years)
		//Note: Current Population is 312032486
		population=(long)(312032486+(birth-death+immigrant));
		System.out.println("Population in next 5 years     : "+population);
	}
}
