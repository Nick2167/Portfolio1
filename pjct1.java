/**
 * Name: Nicholas Kalargyros
 * Date: 05/07/2022
 * Program Description: Create a program for the user with a menu of 6 options, each with their own method. Program should loop as many times as the user desires.
 */

import java.util.Scanner; // Scanner will be needed for user input

public class pjct1 {

    static int custQuantity; // defining variable custQuantity to easily keep track of how many customers' data is added

    public static void main(String[] args) {
        Scanner scanint = new Scanner(System.in);
        Scanner scanstr = new Scanner(System.in);

        String[] names = new String [100]; // establish String array: names with 100 potential elements
        int[] fiveNumber = new int[100]; // establish int array fiveNumber with 100 potential elements
        int[] totalSales = new int[100]; // establish int array totalSales with 100 potential elements


        int selection; // this variable will be defined by the user, and it will pick which method they call from the menu
        do { // start do/while loop

            displayMenu(); // call menu method to display options to user

            System.out.println("\nEnter your selection: ");
            selection = scanint.nextInt(); // user selects from menu here

            switch (selection) { // switch statement allows user to pick which method to use
                case 1:
                    loadCustomerData(names, fiveNumber, totalSales); // call load Customer Data method
                    break;
                case 2:
                    addCustomerData(names, fiveNumber, totalSales); // call add Customer Data method
                    break;
                case 3:
                    displayCustomerData(names, fiveNumber, totalSales); // call display Customer Data method
                    break;
                case 4:
                    retrieveCustomerData(names, fiveNumber, totalSales); // call retrieve Customer Data method
                    break;
                case 5:
                    retrieveRangeData(names, fiveNumber, totalSales); // call retrieve Range Data
                    break;
                case 6:
                    exitProgram(); // call exit program method
                    break;
                default:
                    System.out.println("Invalid Selection, Please Try Again."); // error message if user picks outside of the 1-6 range
            }
        } while (selection != 6); // while condition allows do block of code to keep looping until the user picks 6

        scanint.close(); // close Scanner
        scanstr.close();
    }

    public static void loadCustomerData(String[] N , int[] F, int[] T) { // parameters will help write to arrays: names, fiveNumber, and totalSales
        Scanner scanint = new Scanner(System.in); // scanner will be needed for user input
        Scanner scanstr = new Scanner(System.in);

        System.out.println("\nHow many customers do you want to enter: ");
        custQuantity = scanint.nextInt(); // this number determines how many times the for loop below will loop

        for (int i = 0; i <= custQuantity - 1; i++ ) {

            // Begin prompting user for array elements

            System.out.println("\tEnter Customer's Name: ");
            String name = scanstr.nextLine();
            N[i] = name; // writes user inputted string values into the names array

            System.out.println("\tEnter Customer's 5 Digit ID: ");
            int custID = scanint.nextInt();
            if (custID >= 10000 && custID <= 99999){ // range ensures a 5 digit ID
                F[i] = custID; // writes user inputted int values into the fiveNumber array
            }
            else {
                System.out.println("Invalid Input. Must be a 5 Digit ID Number. Please Try Again.");
                exitProgram(); // calls method that kills program if user is out of range
            }

            System.out.println("\tEnter Customer's Total Sales: ");
            int custSales = scanint.nextInt();
            T[i] = custSales; // writes user inputted int values into the totalSales array

            System.out.println("Customer Added!"); // confirms action with user

        } // end of for loop

        System.out.println("Press Enter to return to the menu."); // allows user to see what they have done and leave to the main menu on their own time, instead of getting thrown back into it
        String enter = scanstr.nextLine();
    }

    public static void addCustomerData(String[] N ,int[] F, int[] T) {
        // The most important part of this method is avoiding any overwriting of any previously inputted data
        Scanner scanint = new Scanner(System.in); // scanner will be needed for user input
        Scanner scanstr = new Scanner(System.in);

        if (custQuantity == 0){ // this is a safeguard against an error. this method only works when data from method 1 already exists.
            System.out.println("Use method 1 first!");
            exitProgram();
        }

        int custQuantity2 = 1; // this number determines how many times the for loop below will loop


        for (int i = custQuantity; i < custQuantity2 + custQuantity; i++ ) { // the for-loop conditions take into account the quantity of customer data already stored.
            //i starts where the array left off
            // Begin prompting user for array elements

            System.out.println("\tEnter Customer's Name: ");
            String name = scanstr.nextLine();
            N[i] = name; // writes user inputted string values into the names array

            System.out.println("\tEnter Customer's 5 Digit ID: ");
            int custID = scanint.nextInt();
            if (custID >= 10000 && custID <= 99999){ // range ensures a 5 digit ID
                F[i] = custID; // writes user inputted int values into the fiveNumber array
            }
            else {
                System.out.println("Invalid Input. Must be a 5 Digit ID.");
                exitProgram(); // calls method that kills program if user is out of range
            }
            System.out.println("\tEnter Customer's Total Sales: ");
            int custSales = scanint.nextInt();
            T[i] = custSales; // writes user inputted int values into the totalSales array

            System.out.println("Customer Added!");

        } // end of for loop

        custQuantity = custQuantity + custQuantity2; // updates custQuantity variable

        System.out.println("Press Enter to return to the Main Menu.");
        String enter = scanstr.nextLine();

    }

    public static void displayCustomerData(String[] N ,int[] F, int[] T) {
        Scanner scanstr = new Scanner(System.in);

        if (custQuantity == 0){ // this is a safeguard against an error. this method only works when data from method 1 already exists.
            System.out.println("Use method 1 first!");
            exitProgram();
        }

        System.out.println("\nDisplaying All Customer Data: ");
            for (int i = 0; i <= custQuantity - 1; i++) { // will loop for however many i there are
                System.out.println("Name: " + N[i] + ", " + "Customer ID: " + F[i] + ", " + "Total Sales: $ " + T[i]); // for-loop to display all customers and their matching ID's and sales
            }

            System.out.println("Press Enter to return to the menu.");
            String enter = scanstr.nextLine();

    }

    public static void retrieveCustomerData(String[] N ,int[] F, int[] T) {
        Scanner scanstr = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);

        if (custQuantity == 0){ // this is a safeguard against an error. this method only works when data from method 1 already exists.
            System.out.println("Use method 1 first!");
            exitProgram();
        }

        System.out.println("Enter Customer ID: ");
        int ID = scanint.nextInt();

        for (int i = 0; i <= custQuantity - 1; i++) {
            if (ID == F[i]) {
                System.out.println("Customer Found: ");
                System.out.println("Name: " + N[i] + ", " + "Customer ID: " + F[i] + ", " + "Total Sales: $ " + T[i]);
            }
        }

        System.out.println("\nPress Enter to return to the menu.");
        String enter = scanstr.nextLine();
    }

    public static void retrieveRangeData(String[] N ,int[] F, int[] T) {
        Scanner scanint = new Scanner (System.in); // Scanner will be needed for user input
        Scanner scanstr = new Scanner (System.in);

        if (custQuantity == 0){ // this is a safeguard against an error. this method only works when data from method 1 already exists.
            System.out.println("Use method 1 first!");
            exitProgram();
        }

            System.out.println("Enter Low Sales Range: "); // prompt user for the low part of the range
            int low = scanint.nextInt();

            System.out.println("Enter High Sales Range: "); // prompt user for the high part of the range
            int high = scanint.nextInt();

            for(int i = 0; i < custQuantity; i++){ // this loop will go through every customer's total sales

                if(T[i] >= low  && T[i] <= high){ // the conditions take the total sales for every customer and match up the ones who have sales in the user given range
                    System.out.println("\nCustomer's Found: ");
                    System.out.println("Name: " + N[i] + ", " + "Customer ID: " + F[i] + ", " + "Total Sales: $ " + T[i]);
                }
                else if (T[i] <= low  && T[i] >= high){
                    System.out.println("No Customers Found Within Range."); // if no customers are found to have sales in that range, then the program will notify the user
                }
            }
            System.out.println("Press Enter to return to the Main Menu.");
            String enter = scanstr.nextLine();
        }

    public static void displayMenu() {

        // standard menu options, method called at the beginning of the program and often returned to

        System.out.println("\nMain Menu");
        System.out.println("\n1: Load Customer's Data");
        System.out.println("2: Add New Customer");
        System.out.println("3: Display All Customers");
        System.out.println("4: Retrieve Specific Customer's Data");
        System.out.println("5: Retrieve Customers with Total Sales Based on the Range");
        System.out.println("6: Exit Program");

    }

    public static void exitProgram() { // establish exitProgram method
        System.out.println("\nThank You for Testing my Program!.");
        System.exit(0); // kill program if user is not within range


    }
}
