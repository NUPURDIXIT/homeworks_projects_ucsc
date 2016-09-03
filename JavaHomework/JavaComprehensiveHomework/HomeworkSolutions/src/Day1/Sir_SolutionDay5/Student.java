package Sir_SolutionDay5;

public class Student implements Comparable{
    private String lastName;
    private String firstName;
    private int score;

    public Student(String lastName, String firstName, int score)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.score = score;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public int getScore()
    {
        return score;
    }

    public String getSummaryLine()
    {
        return this.lastName + ", " + this.firstName
            + ": " + this.score;
    }

    public int compareTo(Object o){
        Student s = (Student) o;
        int lastNameCompare = this.getLastName().compareTo(s.getLastName());
        if (lastNameCompare != 0)
            return lastNameCompare;
        else
            return (this.getFirstName().compareTo(s.getFirstName()));
    }
}

