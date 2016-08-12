package Sir_SolutionDay5;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieListApp
{

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        System.out.println("Welcome to the Movie List Application.\n");

        ArrayList<Movie> movies = getMovies();      // fills the array list

        System.out.println("There are " + movies.size() + " movies in the list.\n");

        String category;                            // used to search for films of a specific category

        do
        {
            category = getString("What category are you interested in? ");
            for (Movie m : movies)
            {
                if (m.category.equalsIgnoreCase(category))
                    System.out.println(m.title);
            }
            System.out.println();
        } while (getContinue());
    }

    public static ArrayList<Movie> getMovies()
    {
        Movie m;
        ArrayList<Movie> movies = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
        {
            m = MovieIO.getMovie(i);
            movies.add(m);
        }
        return movies;
    }

    public static String getString(String prompt)
    {
        String s = "";
        boolean isValid = false;

        while (!isValid)                        // loops until user enters a non-blank line
        {
            System.out.print(prompt);
            s = sc.nextLine();
            if (!s.equals(""))
                isValid = true;
        }
        return s;
    }


    public static boolean getContinue()
    {
        System.out.print("Continue? (y/n): " );
        String choice = sc.nextLine();
        if (choice.equalsIgnoreCase("Y"))
            return true;
        else
            return false;
    }

}
