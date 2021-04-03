import java.util.Scanner;
    
//This program finds some special numbers.
public class hw6_special_numbers {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the starting value: ");
            int start = scr.nextInt();
            System.out.print("Enter the ending value: ");
            int end = scr.nextInt();

            if (start < 0 || end < 0) {
                System.out.println("\nYou have to enter a number which is bigger or equals to 0.\n");
                continue;
            }

            if (start > end) {
                System.out.println("\nStarting number have to equals or smaller than ending number.\n");
                continue;
            }

            System.out.println("\nWelcome to our Number Finder Program.");
            System.out.println("1. Prime numbers between " + start + " and " + end);
            System.out.println("2. Perfect numbers between " + start + " and " + end);
            System.out.println("3. Fibonacci numbers between " + start + " and " + end);
            System.out.println("4. Woodall numbers between " + start + " and " + end);
            System.out.println("5. Tau numbers between " + start + " and " + end);
            System.out.println("6. Smith numbers between " + start + " and " + end);

            while (true) {
                System.out.print("\nEnter your menu choice (0 for exit): ");
                int choice = scr.nextInt();

                if (choice == 0) {
                    System.out.println("Thanks for using my program.");
                    System.exit(0);
                } else if (choice == 1) {
                    primeNum(start, end);
                } else if (choice == 2) {
                    perfectNum(start, end);
                } else if (choice == 3) {
                    fibonacci(start, end);
                } else if (choice == 4) {
                    woodallNum(start, end);
                } else if (choice == 5) {
                    if (start == 0)
                        start++;
                    tauNum(start, end);
                } else if (choice == 6) {
                    smithNum(start, end);
                } else {
                    System.out.println("You entered an invalid value.");
                    continue;
                }
                break;
            }

            while (true) {
                System.out.print("\nDo you want to find new numbers? (Y/N): ");
                char ans = scr.next().toLowerCase().charAt(0);

                if (ans == 'y') {
                    System.out.println();
                    break;
                } else if (ans == 'n') {
                    System.out.println("Thanks for using my program.");
                    System.exit(0);
                } else {
                    System.out.println("You entered an invalid value.");
                }
            }
        }
    }

    public static void primeNum(int start, int end) {
        String primeNumbers = "";

        for (int i = start; i <= end; i++) {
            int counter = 0;
            for (int num = i; num >= 1; num--) {
                if (i % num == 0)
                    counter++;
            }

            if (counter == 2)
                primeNumbers += i + " ";
        }

        if (primeNumbers.equals(""))
            System.out.println("\nNo prime numbers found between " + start + " and " + end + ".");
        else
            System.out.print("\nPrime numbers between " + start + " and " + end + " : " + primeNumbers);
    }

    public static void perfectNum(int start, int end) {
        String perfectNumbers = "";

        for (int i = start; i <= end; i++) {
            int sum = 0;
            for (int num = i - 1; num >= 1; num--) {
                if (i % num == 0)
                    sum += num;
            }
            if (sum == i)
                perfectNumbers += i + " ";
        }

        if (perfectNumbers.equals(""))
            System.out.println("\nNo perfect numbers found between " + start + " and " + end + ".");
        else
            System.out.print("\nPerfect numbers between " + start + " and " + end + " : " + perfectNumbers);
    }

    public static void fibonacci(int start, int end) {
        String fibonacci = "";
        int previousValue = 0;
        int nextValue = 1;

        while (previousValue <= end) {
            if (previousValue >= start)
                fibonacci += previousValue + " ";

            int sum = previousValue + nextValue;
            previousValue = nextValue;
            nextValue = sum;
        }

        if (fibonacci.equals(""))
            System.out.println("\nNo fibonacci numbers found between " + start + " and " + end + ".");
        else
            System.out.print("\nFibonacci series between " + start + " and " + end + " : " + fibonacci);
    }

    public static void woodallNum(int start, int end) {
        String woodallNumbers = "";

        for (int i = 1; end >= (int) ((Math.pow(2, i) * i) - 1); i++) {
            int woodall = (int) ((Math.pow(2, i) * i) - 1);
            if (woodall >= start)
                woodallNumbers += woodall + " ";
        }

        if (woodallNumbers.equals(""))
            System.out.println("\nNo woodall numbers found between " + start + " and " + end + ".");
        else
            System.out.print("\nWoodall numbers between " + start + " and " + end + " : " + woodallNumbers);
    }

    public static void tauNum(int start, int end) {
        String tauNumbers = "";

        for (int i = start; i <= end; i++) {
            int counter = 0;
            for (int num = i; num >= 1; num--) {
                if (i % num == 0)
                    counter++;
            }

            if (i % counter == 0)
                tauNumbers += i + " ";
        }

        if (tauNumbers.equals(""))
            System.out.println("\nNo tau numbers found between " + start + " and " + end + ".");
        else
            System.out.print("\nTau numbers between " + start + " and " + end + " : " + tauNumbers);
    }

    public static void smithNum(int start, int end) {
        String smithNumbers = "";

        for (int i = start; i <= end; i++) {
            int divisor = 0;
            int sum = 0;
            int temp;

            if (isPrime(i) || i <= 1)
                continue;

            while (divisor < i) {
                temp = i;
                if (!isPrime(divisor)) {
                    divisor++;
                    continue;
                }

                while (temp % divisor == 0) {
                    sum += sumOfDigits(divisor);
                    temp /= divisor;
                }
                divisor++;
            }

            if (sum == sumOfDigits(i))
                smithNumbers += i + " ";
        }

        if (smithNumbers.equals(""))
            System.out.println("\nNo smith numbers found between " + start + " and " + end + ".");
        else
            System.out.print("\nSmith numbers between " + start + " and " + end + " : " + smithNumbers);
    }

    public static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static int sumOfDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
