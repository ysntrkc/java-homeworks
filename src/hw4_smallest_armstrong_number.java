public class hw4_smallest_armstrong_number {
    public static void main(String[] args) {
        int number, temp;

        for (number = 2; ; number++) {   // Firstly, i define the number = 2 because i want to exclude 1.
            temp = number;             // I equalize temp to number because I don't want to lose number's value.
            int cubeDigits = 0;
            while (temp >= 1) {             // When the temp is smaller than 1 the loop has to be end.
                int digit = temp % 10;   // In this loop i separate the digits and i find their cubes.
                temp /= 10;
                cubeDigits += Math.pow(digit, 3);
            }

            if (number == cubeDigits) {  //Here I check the condition and print the output.
                System.out.println("The smallest number whose sum of cubes of digits equal to that number is " + number + ".");
                break;
            }
        }
    }
}
