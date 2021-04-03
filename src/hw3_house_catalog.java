import java.util.Scanner;

// This program helps those who want to buy a house.
public class hw3_house_catalog {
    public static void main(String[] args) {
        Scanner scr = new Scanner(System.in);

        System.out.println("--- Buy a House ---");
        System.out.println("(A) Block A \n(B) Block B\n(C) Block C\n(D) Block D");
        System.out.print("Which block you prefer? (A, B, C, D): ");
        char block = scr.nextLine().toLowerCase().charAt(0);

        int houseType, storey;
        double basePrice, storeyValue, price, kdvCost, totalPrice;
        char ans;

        int furnished1 = 13000;
        int furnished2 = 19000;
        int furnished3 = 26000;

        switch (block) {
            case ('a') -> {
                System.out.println("(1) 1+1 \n(2) 2+1");
                System.out.print("Which house type you prefer? (1, 2): ");
                houseType = scr.nextInt();
                if (houseType == 1) {
                    System.out.print("Select storey? (max10): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 10) {
                        basePrice = 45000;
                        storeyValue = 0.0165;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        if (price < 100000) {
                            kdvCost = price * 0.01;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price: " + price);
                            System.out.println("1% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 1+1 type on floor " + storey + " house with total cost: " + totalPrice);
                        } else if (price >= 100000) {
                            kdvCost = price * 0.08;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price: " + price);
                            System.out.println("8% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 1+1 type on floor " + storey + " house with total cost: " + totalPrice);
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else if (houseType == 2) {
                    System.out.print("Select storey? (max10): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 10) {
                        basePrice = 65000;
                        storeyValue = 0.0174;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        price += furnished2;
                        if (price < 100000) {
                            kdvCost = price * 0.01;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price with furnished: " + price);
                            System.out.println("1% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 2+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                        } else if (price >= 100000) {
                            kdvCost = price * 0.08;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price with furnished: " + price);
                            System.out.println("8% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 2+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else
                    System.out.println("Invalid house type !");
            }
            case ('b') -> {
                System.out.println("(1) 1+1 \n(2) 2+1 \n(3) 3+1");
                System.out.print("Which house type you prefer? (1, 2, 3): ");
                houseType = scr.nextInt();
                if (houseType == 1) {
                    System.out.print("Select storey? (max8): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 8) {
                        basePrice = 50000;
                        storeyValue = 0.02;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        price += furnished1;
                        if (price < 100000) {
                            kdvCost = price * 0.01;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price with furnished: " + price);
                            System.out.println("1% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 1+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                        } else if (price >= 100000) {
                            kdvCost = price * 0.08;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price with furnished: " + price);
                            System.out.println("8% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 1+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else if (houseType == 2) {
                    System.out.print("Select storey? (max8): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 8) {
                        basePrice = 72000;
                        storeyValue = 0.017;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        if (price < 100000) {
                            kdvCost = price * 0.01;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price: " + price);
                            System.out.println("1% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 2+1 type on floor " + storey + " house with total cost: " + totalPrice);
                        } else if (price >= 100000) {
                            kdvCost = price * 0.08;
                            totalPrice = price + kdvCost;
                            System.out.println("Your house price: " + price);
                            System.out.println("8% KDV costs: " + kdvCost);
                            System.out.println("You select block A, 2+1 type on floor " + storey + " house with total cost: " + totalPrice);
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else if (houseType == 3) {
                    System.out.print("Select storey? (max8): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 8) {
                        basePrice = 97500;
                        storeyValue = 0.0175;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        System.out.print("Do you want furnitured house? (Y, N): ");
                        ans = scr.next().toLowerCase().charAt(0);
                        switch (ans) {
                            case ('y'):
                                price += furnished3;
                                kdvCost = price * 0.08;
                                totalPrice = price + kdvCost;
                                System.out.println("Your house price with furnished: " + price);
                                System.out.println("8% KDV costs: " + kdvCost);
                                System.out.println("You select block A, 3+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                                break;

                            case ('n'):
                                if (price < 100000) {
                                    kdvCost = price * 0.01;
                                    totalPrice = price + kdvCost;
                                    System.out.println("Your house price without furnished: " + price);
                                    System.out.println("1% KDV costs: " + kdvCost);
                                    System.out.println("You select block A, 3+1 type on floor " + storey + " house with total cost: " + totalPrice);
                                } else if (price >= 100000) {
                                    kdvCost = price * 0.08;
                                    totalPrice = price + kdvCost;
                                    System.out.println("Your house price without furnished: " + price);
                                    System.out.println("8% KDV costs: " + kdvCost);
                                    System.out.println("You select block A, 3+1 type on floor " + storey + " house with total cost: " + totalPrice);
                                }
                                break;

                            default:
                                System.out.println("Invalid answer !");
                                break;
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else
                    System.out.println("Invalid house type !");
            }
            case ('c') -> {
                System.out.println("(2) 2+1 \n(3) 3+1 \n(4) 4+1");
                System.out.print("Which house type you prefer? (2, 3, 4): ");
                houseType = scr.nextInt();
                if (houseType == 2) {
                    System.out.print("Select storey? (max10): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 10) {
                        basePrice = 80000;
                        storeyValue = 0.016;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        System.out.print("Do you want furnitured house? (Y, N): ");
                        ans = scr.next().toLowerCase().charAt(0);
                        switch (ans) {
                            case ('y'):
                                price += furnished2;
                                if (price < 100000) {
                                    kdvCost = price * 0.01;
                                    totalPrice = price + kdvCost;
                                    System.out.println("Your house price with furnished: " + price);
                                    System.out.println("1% KDV costs: " + kdvCost);
                                    System.out.println("You select block A, 2+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                                } else if (price >= 100000) {
                                    kdvCost = price * 0.08;
                                    totalPrice = price + kdvCost;
                                    System.out.println("Your house price with furnished: " + price);
                                    System.out.println("8% KDV costs: " + kdvCost);
                                    System.out.println("You select block A, 2+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                                }
                                break;

                            case ('n'):
                                if (price < 100000) {
                                    kdvCost = price * 0.01;
                                    totalPrice = price + kdvCost;
                                    System.out.println("Your house price without furnished: " + price);
                                    System.out.println("1% KDV costs: " + kdvCost);
                                    System.out.println("You select block A, 2+1 type on floor " + storey + " house with total cost: " + totalPrice);
                                } else if (price >= 100000) {
                                    kdvCost = price * 0.08;
                                    totalPrice = price + kdvCost;
                                    System.out.println("Your house price without furnished: " + price);
                                    System.out.println("8% KDV costs: " + kdvCost);
                                    System.out.println("You select block A, 2+1 type on floor " + storey + " house with total cost: " + totalPrice);
                                }
                                break;

                            default:
                                System.out.println("Invalid answer !");
                                break;
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else if (houseType == 3) {
                    System.out.print("Select storey? (max10): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 10) {
                        basePrice = 102400;
                        storeyValue = 0.0185;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        price += furnished3;
                        kdvCost = price * 0.08;
                        totalPrice = price + kdvCost;
                        System.out.println("Your house price with furnished: " + price);
                        System.out.println("8% KDV costs: " + kdvCost);
                        System.out.println("You select block A, 3+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                    }
                } else if (houseType == 4) {
                    System.out.print("Select storey? (max10): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 10) {
                        basePrice = 137000;
                        storeyValue = 0.021;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        kdvCost = price * 0.08;
                        totalPrice = price + kdvCost;
                        System.out.println("Your house price: " + price);
                        System.out.println("8% KDV costs: " + kdvCost);
                        System.out.println("You select block A, 4+1 type on floor " + storey + " house with total cost: " + totalPrice);
                    } else
                        System.out.println("Invalid storey !");
                } else
                    System.out.println("Invalid house type !");
            }
            case ('d') -> {
                System.out.println("(3) 3+1 \n(4) 4+1");
                System.out.print("Which house type you prefer? (3, 4): ");
                houseType = scr.nextInt();
                if (houseType == 3) {
                    System.out.print("Select storey? (max8): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 8) {
                        basePrice = 119900;
                        storeyValue = 0.019;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        System.out.print("Do you want furnitured house? (Y, N): ");
                        ans = scr.next().toLowerCase().charAt(0);
                        switch (ans) {
                            case ('y'):
                                price += furnished3;
                                kdvCost = price * 0.08;
                                totalPrice = price + kdvCost;
                                System.out.println("Your house price with furnished: " + price);
                                System.out.println("8% KDV costs: " + kdvCost);
                                System.out.println("You select block A, 3+1 type on floor " + storey + " furnitured house with total cost: " + totalPrice);
                                break;

                            case ('n'):
                                kdvCost = price * 0.08;
                                totalPrice = price + kdvCost;
                                System.out.println("Your house price without furnished: " + price);
                                System.out.println("8% KDV costs: " + kdvCost);
                                System.out.println("You select block A, 3+1 type on floor " + storey + " house with total cost: " + totalPrice);
                                break;

                            default:
                                System.out.println("Invalid answer !");
                                break;
                        }
                    } else
                        System.out.println("Invalid storey !");
                } else if (houseType == 4) {
                    System.out.print("Select storey? (max8): ");
                    storey = scr.nextInt();
                    if (storey >= 1 && storey <= 8) {
                        basePrice = 165000;
                        storeyValue = 0.02;
                        price = basePrice + basePrice * (storeyValue * (storey - 1));
                        kdvCost = price * 0.08;
                        totalPrice = price + kdvCost;
                        System.out.println("Your house price: " + price);
                        System.out.println("8% KDV costs: " + kdvCost);
                        System.out.println("You select block A, 4+1 type on floor " + storey + " house with total cost: " + totalPrice);
                    } else
                        System.out.println("Invalid storey !");
                } else
                    System.out.println("Invalid house type !");
            }
            default -> System.out.println("Invalid block !");
        }
    }
}
