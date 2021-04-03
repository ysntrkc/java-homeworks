import java.util.Scanner;

//This program prints a random list and controls the users input if it is in the table or not.

public class hw8_keyword_puzzle {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        //With these lines user enters the number of rows and columns of list.
        System.out.print("Enter the number of rows: ");
        int rows = scr.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scr.nextInt();

        //Here I create the two dimensional array with the user's parameters.
        char[][] list = new char[rows][columns];

        //With this method the program fills the array randomly with capital letters and numbers.
        printTable(rows, columns, list);

        //Everything starts from here. The program get a keyword from user.
        System.out.print("\nEnter the keyword: ");
        String keyword = scr.next().toUpperCase();

        //With these methods the program scans the table to find a match with user's keyword.
        leftToRight(rows, columns, list, keyword);
        rightToLeft(rows, columns, list, keyword);
        topToBottom(rows, columns, list, keyword);
        bottomToTop(rows, columns, list, keyword);
        topLeftToRightBottom(rows, columns, list, keyword);
        rightBottomToTopLeft(rows, columns, list, keyword);
        topRightToBottomLeft(rows, columns, list, keyword);
        leftBottomToTopRight(rows, columns, list, keyword);

        //If there is no match than the program prints false.
        System.out.println("\nFALSE");

    }

    // This block of if statement is same for all methods.
    private static int commonCondition(char[][] list, String keyword, int k, int a, int b) {

        //This if statement checks the all characters in keyword one by one.
        if (list[a][b] == keyword.charAt(k)) {

            //If all of them are same the program prints the message and closes.
            if (k == keyword.length() - 1) {
                System.out.println("\nTRUE");
                System.exit(0);
            } else k++;
        } else k = 0;
        return k;
    }

    //With this method I check the diagonal axis left-down to right-up.
    private static void leftBottomToTopRight(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = rows - 1; i >= keyword.length() - 1; i--) {
            for (int j = 0; j <= columns - keyword.length(); j++) {
                for (int a = i, b = j; a >= 0 && b < columns; a--, b++) {
                    k = commonCondition(list, keyword, k, a, b);
                }
            }
        }
    }

    //With this method I check the diagonal axis right-up to left-down.
    private static void topRightToBottomLeft(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = 0; i <= rows - keyword.length(); i++) {
            for (int j = columns - 1; j >= keyword.length() - 1; j--) {
                for (int a = i, b = j; a < rows && b >= 0; a++, b--) {
                    k = commonCondition(list, keyword, k, a, b);
                }
            }
        }
    }

    //With this method I check the diagonal axis right-down to left-up.
    private static void rightBottomToTopLeft(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = rows - 1; i >= keyword.length() - 1; i--) {
            for (int j = columns - 1; j >= keyword.length() - 1; j--) {
                for (int a = i, b = j; a >= 0 && b >= 0; a--, b--) {
                    k = commonCondition(list, keyword, k, a, b);
                }
            }
        }
    }

    //With this method I check the diagonal axis left-up to right-down.
    private static void topLeftToRightBottom(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = 0; i <= rows - keyword.length(); i++) {
            for (int j = 0; j <= columns - keyword.length(); j++) {
                for (int a = i, b = j; a < rows && b < columns; a++, b++) {
                    k = commonCondition(list, keyword, k, a, b);
                }
            }
        }
    }

    //With this method I check the vertical axis down to up.
    private static void bottomToTop(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = rows - 1; j >= 0; j--) {
                k = commonCondition(list, keyword, k, j, i);
            }
        }
    }

    //With this method I check the vertical axis down to up.
    private static void topToBottom(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                k = commonCondition(list, keyword, k, j, i);
            }
        }
    }

    //With this method I check the vertical axis up to down.
    private static void rightToLeft(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = columns - 1; j >= 0; j--) {
                k = commonCondition(list, keyword, k, i, j);
            }
        }
    }

    //With this method I check the horizontal axis right to left.
    private static void leftToRight(int rows, int columns, char[][] list, String keyword) {
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                k = commonCondition(list, keyword, k, i, j);
            }
        }
    }

    // This method fills the array and prints.
    private static void printTable(int rows, int columns, char[][] list) {

        //With this nested loop the program fills the array randomly with capital letters and numbers.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char character = (char) (Math.random() * 36);
                if (character <= 9)
                    character += 48;
                else if (character <= 35)
                    character += 55;
                list[i][j] = character;
            }
        }

        System.out.println();

        //With this nested loop the program prints the two dimensional array like a table.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++)
                System.out.print(list[i][j] + " ");
            System.out.println();
        }
    }
}
