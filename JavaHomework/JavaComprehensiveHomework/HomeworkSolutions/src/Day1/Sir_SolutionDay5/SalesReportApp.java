package Sir_SolutionDay5;

import java.text.NumberFormat;

public class SalesReportApp
{

    public static void main(String[] args)
    {

        System.out.println("Welcome to the Sales Report Application.\n");

        NumberFormat cf = NumberFormat.getCurrencyInstance();

        // declare and initialize the array
        double[][] sales = { { 1540.0, 2010.0, 2450.0, 1845.0} ,        // Region 1
                             { 1130.0, 1168.0, 1847.0, 1491.0} ,        // Region 2
                             { 1580.0, 2305.0, 2710.0, 1284.0} ,        // Region 3
                             { 1105.0, 4102.0, 2391.0, 1576.0} };       // Region 4

        // print all sales
        System.out.println("Region\tQ1\t\tQ2\t\tQ3\t\tQ4");
        for (int region = 0; region < 4; region++)
        {
            System.out.print(region + 1 + "\t");
            double total = 0;
            for (int quarter = 0; quarter < 4; quarter++)
                System.out.print(cf.format(sales[region][quarter]) + "\t");
            System.out.println();
        }
        System.out.println();


        // print sales by region
        System.out.println("Sales by region:");
        for (int region = 0; region < 4; region++)
        {
            double total = 0;
            for (int quarter = 0; quarter < 4; quarter++)
                total += sales[region][quarter];
            System.out.println("Region " + (region + 1) + ": " + cf.format(total));
        }

        System.out.println();

        // print sales by quarter
        System.out.println("Sales by quarter:");
        for (int quarter = 0; quarter < 4; quarter++)
        {
            double total = 0;
            for (int region = 0; region < 4; region++)
                total += sales[region][quarter];
            System.out.println("Q" + (quarter + 1) + ": " + cf.format(total));
        }
        System.out.println();

        // print the total annual sales
        double totalSales = 0.0;
        for (int region = 0; region < 4; region++)
        {
            for (int quarter = 0; quarter < 4; quarter++)
                totalSales += sales[region][quarter];
        }

        System.out.println("Total annual sales, all regions: " + cf.format(totalSales) + "\n");

    }
}
