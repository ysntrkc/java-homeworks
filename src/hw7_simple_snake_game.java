import java.util.Scanner;

//This program creates a grid game like a snake game.

public class hw7_simple_snake_game {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.println("WELCOME TO THE SNAKE GAME\n");

        //In this line user enter a number for assign the grid's size.
        System.out.print("Please enter the grid size: ");
        int size = scr.nextInt();

        //This loop check the answer because if size is smaller than 3 grid game won't work correctly.
        while (size < 3) {
            System.out.println("Please enter the grid size (bigger than 2): ");
            size = scr.nextInt();
        }

        System.out.println("\n");

        //In these lines a assign some variables for program.
        String[][] grid = new String[size][size];
        int moveCount = (int) (size * 2.5) - 1;
        boolean check = false;
        char direction;
        int x = 0, y = 0;

        //With this loop I create a grid which have only spaces.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                grid[i][j] = " ";
        }

        //And this loop creates some items in the grid.
        for (int i = 0; i < size / 2; i++) {
            grid[(int) (Math.random() * size)][(int) (Math.random() * size)] = "*";

            //With this if statement I check the first grid cell because there is going to be X.
            if (grid[0][0].equals("*"))
                i--;
        }

        //'X' starts at first grid.
        grid[y][x] = "X";

        //These for loops print the grid's first shape with items and X.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                //With these if statements I create the walls.
                if (j == 0)
                    System.out.print("|" + grid[i][j]);
                else if (j == grid.length - 1)
                    System.out.print(grid[i][j] + "|");
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        //This line prints the X's case and we have how many moves.
        System.out.println("Moves: " + (moveCount + 1) + "\tCurrent Cell: (" + y + ", " + x + ")");

        //The game plays with these loop.
        for (; moveCount >= 0; moveCount--) {

            //This line asks the user where user wants to go.
            System.out.print("Choose your direction (R, L, U, D (X for exit)): ");
            direction = scr.next().toLowerCase().charAt(0);

            //With this switch case statement program move the X to users want way.
            switch (direction) {
                case 'r':

                    //This if statement controls if user try to go outside of the grid it give an error message and
                    //asks again where user wants to go. In the other cases this is same.
                    if (x + 1 == size) {
                        System.out.println("\n** !! You cannot go there!! **\n");
                        moveCount++;
                        continue;
                    } else {

                        //This if statement controls if user try to go over the X's tail it give an error message and
                        // asks again where user wants to go. In the other cases this is same.
                        if (grid[y][x + 1].equals("+")) {
                            System.out.println("\n** You cannot go there!! **\n");
                            moveCount++;
                            continue;
                        }

                        // This else statement moves the 'X' to where user wants it. This is also same for the other cases.
                        else {
                            grid[y][x] = "+";
                            grid[y][x += 1] = "X";
                        }
                    }
                    break;
                case 'l':
                    if (x == 0) {
                        System.out.println();
                        System.out.println("\n** !! You cannot go there!! **\n");
                        moveCount++;
                    } else {
                        if (grid[y][x - 1].equals("+")) {
                            System.out.println("\n** !! You cannot go there!! **\n");
                            moveCount++;
                            continue;
                        } else {
                            grid[y][x] = "+";
                            grid[y][x -= 1] = "X";
                        }
                    }
                    break;
                case 'u':
                    if (y == 0) {
                        System.out.println();
                        System.out.println("\n** !! You cannot go there!! **\n");
                        moveCount++;
                    } else {
                        if (grid[y - 1][x].equals("+")) {
                            System.out.println("\n** !! You cannot go there!! **\n");
                            moveCount++;
                            continue;
                        } else {
                            grid[y][x] = "+";
                            grid[y -= 1][x] = "X";
                        }
                    }
                    break;
                case 'd':
                    if (y + 1 == size) {
                        System.out.println();
                        System.out.println("\n** !! You cannot go there!! **\n");
                        moveCount++;
                    } else {
                        if (grid[y + 1][x].equals("+")) {
                            System.out.println("\n** !! You cannot go there!! **\n");
                            moveCount++;
                            continue;
                        } else {
                            grid[y][x] = "+";
                            grid[y += 1][x] = "X";
                        }
                    }
                    break;

                //With this case user can exit the program.
                case 'x':
                    System.exit(0);
                default:
                    //If user enters an invalid value, program prints an error message and asks again where user wants to go.
                    System.out.println("Invalid input!\n");
                    moveCount++;
                    continue;
            }
            System.out.println("\n");

            //This loop prints the latest version of grid.
            for (int a = 0; a < size; a++) {
                for (int b = 0; b < size; b++) {
                    if (b == 0)
                        System.out.print("|" + grid[a][b]);
                    else if (b == grid.length - 1)
                        System.out.print(grid[a][b] + "|");
                    else
                        System.out.print(grid[a][b]);
                }
                System.out.println();
            }
            System.out.println("Moves: " + moveCount + "\tCurrent Cell: (" + y + ", " + x + ")");

            //This loop checks if there are no items in the grid user wins the game.
            for (int c = 0; c < size; c++) {
                for (int d = 0; d < size; d++) {
                    if (!grid[c][d].equals("*"))
                        check = true;
                    else {
                        check = false;
                        break;
                    }
                }
                if (!check)
                    break;
            }

            if (check) {
                System.out.println("\n+++ YOU WIN +++");
                break;
            }

            //If there is no move chance the user loses the game.
            if (moveCount == 0)
                System.out.println("\n--- GAME OVER ---");
        }
    }
}
