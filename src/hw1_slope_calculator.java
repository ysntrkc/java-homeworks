import java.util.Scanner;

public class hw1_slope_calculator {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.print("Enter the first point's coordinates (x1 y1): ");
        double x1 = scr.nextDouble();
        double y1 = scr.nextDouble();

        System.out.print("Enter the second point's coordinates (x2 y2): ");
        double x2 = scr.nextDouble();
        double y2 = scr.nextDouble();

        double slope = (y2 - y1) / (x2 - x1);
        double b = y1 - (slope * x1);

        System.out.println("The slope of equation is: " + slope);
        System.out.println("The equation is: y = (" + slope + ")x + (" + b + ")");
    }
}
