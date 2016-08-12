package Sir_SolutionDay5;

import java.util.Scanner;
import java.text.NumberFormat;

public class StackCalculatorApp
{

    static Scanner sc = new Scanner(System.in);
    static NumberFormat nf = NumberFormat.getNumberInstance();
    static StackCalculator calc = new StackCalculator();

    public static void main(String[] args)
    {

        System.out.println("Welcome to the Stack Calculator.\n");
        System.out.println("Commands: push n, add, sub, mult, div, clear, or quit.");

        String command;
        double value;

        // process the user's commands until done
        prompt();
        while (true)
        {
            command = sc.next();
            if (command.equalsIgnoreCase("push"))
            {
                if (sc.hasNextDouble())
                {
                    value = sc.nextDouble();
                    calc.push(value);
                    listValues();
                    prompt();
                }
                else
                {
                    System.out.println("Incorrect value");
                    prompt();
                    continue;
                }
            }
            else if (command.equalsIgnoreCase("add"))
                doCommand("add");
            else if (command.equalsIgnoreCase("sub"))
                doCommand("sub");
            else if (command.equalsIgnoreCase("mult"))
                doCommand("mult");
            else if (command.equalsIgnoreCase("div"))
                doCommand("div");
            else if (command.equalsIgnoreCase("clear"))
            {
                calc.clear();
                listValues();
                prompt();
            }
            else if (command.equalsIgnoreCase("quit"))
                break;
            else
            {
                System.out.println("Unrecognized command.\n");
                prompt();
            }
        }
        System.out.println("\nThanks for using the Stack Calculator.\n");
    }

    public static void prompt()
    {
        System.out.print("\n? ");
    }

    public static void doCommand(String command)

    {
        if (calc.size() < 2)
        {
            System.out.println("Not enough data on the stack");
            listValues();
        }
        else
        {
            if (command.equals("add"))
                calc.add();
            else if (command.equals("sub"))
                calc.subtract();
            else if (command.equals("mult"))
                calc.multiply();
            else if (command.equals("div"))
                calc.divide();
            listValues();
        }
        prompt();
    }


    public static void listValues()
    {
        Double[] values = calc.getValues();
        if (calc.size() > 0)
            for (Double d : values)
                System.out.println(d);
        else
            System.out.println("empty");
    }

}
