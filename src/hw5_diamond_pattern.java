import java.util.Scanner;

//This program receives some data and than print a diamond pattern with those data.
public class hw5_diamond_pattern {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = scr.nextInt() + 1;

        if (num >= 1) {
            System.out.print("Enter a character: ");
            char ch = scr.next().charAt(0);

            int temp = 1;
            for (int i = 1; i <= 2 * num - 1; i++) {
                for (int j = temp; j <= num - 1; j++)
                    System.out.print(". ");
                for (int k = 1; k <= temp * 2 - 1; k++)
                    System.out.print(ch + " ");
                for (int j = temp; j <= num - 1; j++)
                    System.out.print(". ");

                if (i < num) temp++;
                else temp--;

                System.out.println();
            }
        } else
            System.out.println("You have to enter a positive integer.");
    }
}
