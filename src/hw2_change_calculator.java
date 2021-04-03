import java.util.Scanner;

// This program calculates how much money you need to get after paying your bill.
public class hw2_change_calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the billing price: "); //First, receive the data of billing price
        double billingPrice = input.nextDouble();

        System.out.print("Enter the money given: "); //Secondly, receive the data of money given
        double givenMoney = input.nextDouble();

        double change = givenMoney - billingPrice; //And then calculate the change

        //After that calculate cashier how to pay change
        int twoHundredLiras = (int) change / 200;
        change %= 200;
        int hundredLiras = (int) change / 100;
        change %= 100;
        int fiftyLiras = (int) change / 50;
        change %= 50;
        int twentyLiras = (int) change / 20;
        change %= 20;
        int tenLiras = (int) change / 10;
        change %= 10;
        int fiveLiras = (int)change / 5;
        change %= 5;
        int oneLiras = (int) change;

        change *= 100; //I did this for calculate the pennies easier
        change %= 100;

        int fiftyPennies = (int) change / 50;
        change %= 50;
        int twentyFivePennies = (int) change / 25;
        change %= 25;
        int tenPennies = (int) change / 10;
        change %= 10;
        int fivePennies = (int) change / 5;
        change %= 5;
        int onePennies = (int) change;

        //Finally, print all information on the screen
        System.out.println(twoHundredLiras + " pcs 200 TL");
        System.out.println(hundredLiras + " pcs 100 TL");
        System.out.println(fiftyLiras + " pcs 50 TL");
        System.out.println(twentyLiras + " pcs 20 TL");
        System.out.println(tenLiras + " pcs 10 TL");
        System.out.println(fiveLiras + " pcs 5 TL");
        System.out.println(oneLiras + " pcs 1 TL");
        System.out.println(fiftyPennies + " pcs 50 KR");
        System.out.println(twentyFivePennies + " pcs 25 KR");
        System.out.println(tenPennies + " pcs 10 KR");
        System.out.println(fivePennies + " pcs 5 KR");
        System.out.println(onePennies + " pcs 1 KR");
        System.out.println("The change is: " + (givenMoney - billingPrice));

    }
}
