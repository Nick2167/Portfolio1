/**
 * Name: Nicholas Kalargyros
 * Date: 04/25/2022
 * Program Description: Given a list of choices, the user will select to convert cubic feet to U.S. Bushels, convert miles to kilometers, and/or determine graduation with honors title.
 */

import java.util.Scanner; // Scanner will be needed

public class Asgn5 {

    public static void main(String[] args) {

        Scanner scanint = new Scanner(System.in);

        int selection = 0;
        do { // start do/while loop

            displayMenu(); // call menu method to display options to user

            System.out.println("\nEnter your selection: ");
            selection = scanint.nextInt();

            switch (selection) { // switch statement allows user to pick which method to use
                case 1:
                    cubicConversion(); // call cubic conversion method
                    break;
                case 2:
                    milesConversion(); // call miles conversion method
                    break;
                case 3:
                    gpaHonors(); // call gpa honors method
                    break;
                case 9:
                    exitProgram(); // call exit program method
                    break;
                default:
                    System.out.println("Invalid Selection, Please Try Again.");
            }
        } while (selection != 9) ; // while condition allows do block of code to keep looping until the user picks 9

        scanint.close(); // close Scanner
    }


    public static void displayMenu() { // establish displayMenu method, which will be called at the beginning of the main method to display the menu options to the user

        System.out.println("\nWelcome to the Unit Conversion/Graduation Title Program!");
        System.out.println("\n1: Convert Cubic Feet to U.S. Bushels");
        System.out.println("2: Convert Miles to Kilometers");
        System.out.println("3: Determine Graduation Title with Honors");
        System.out.println("9: Exit Program");

    }

    public static void cubicConversion() { // establish cubicConversion method, which will be called when the user selects the method from the menu
        Scanner scanint = new Scanner(System.in);
        double bushels = 0.803564; // value from given equation

        System.out.println("\nEnter Cubic Feet: ");
        double feet = scanint.nextDouble();
        double convert = (feet * bushels); // conversion equation
        System.out.println("\n" + feet + " Cubic Feet equals " + convert + " U.S. Bushels.");
        System.out.println("\nThank you for testing my program!");


    }

    public static void milesConversion() { // establish milesConversion method, which will be called when the user selects the method from the menu
        Scanner scanint = new Scanner(System.in);
        double kilometers = 1.60934; // value from given equation

        System.out.println("Enter Miles: ");
        double miles = scanint.nextDouble();
        double convert = (miles * kilometers); // conversion equation
        System.out.println("\n" + miles + " Miles equals " + convert + " Kilometers.");
        System.out.println("\nThank you for testing my program!");


    }

    public static void gpaHonors() { // establish gpaHonors method, which will be called when the user selects the method from the menu
        Scanner scanint = new Scanner(System.in); // Scanner is needed

        System.out.println("Enter GPA: ");  // prompt user for gpa
        double gpa = scanint.nextDouble(); // gpa is usually a double value

        switch((gpa >= 4.0) ? 1 : (gpa >= 3.8 && gpa <= 3.9) ? 2 : (gpa >= 3.5 && gpa <= 3.7) ? 3 : (gpa < 3.5) ? 4 : 5) { // because switch statement can't use boolean or double values, we assign the conditions to case numbers using ternary operators

            case 1: {
                System.out.println("Congratulations, You Graduated Summa Cum Laude!");
                break;
            }
            case 2: {
                System.out.println("Congratulations, You Graduated Magna Cum Laude!");
                break;
            }
            case 3: {
                System.out.println("Congratulations, You Graduated Cum Laude!");
                break;
            }
            case 4: {
                System.out.println("Congratulations, You Graduated!"); // no title, just graduated.
                break;
            }

        }

    }

    public static void exitProgram() { // establish exitProgram method, which will be called when the user selects the method from the menu
        System.out.println("\nThank you for Testing my Program!");
    }

}