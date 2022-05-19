/**
 * Name: Nicholas Kalargyros
 * Date: 05/03/2022
 * Program Description: Write user input to a string and int array, display the corresponding values and determine the lowest and highest int value within the array.
 */

import java.util.Scanner; // Scanner will be needed

public class Asgn6 {

    public static void main(String[] args) {

        Scanner scanint = new Scanner(System.in); // Scanner will be needed for user input
        Scanner scanstr = new Scanner(System.in);

        System.out.println("\nHow many teams do you want to enter: ");
        int selection = scanint.nextInt(); // this number determines how many times the for loop below will loop
        String[] names = new String [selection]; // establish String array: names
        int[] scores = new int[selection]; // establish int array: scores

        for (int i = 0; i <= selection - 1; i++ ) {

            // Begin prompting user for array elements
            System.out.println("Team " + (i+1) + ":"); // i+1 so the user doesn't get prompted with "Team 0"
            System.out.println("\tEnter Team's Name: ");
            String name = scanstr.nextLine();
            names[i] = name; // writes user inputted string values into the names array
            System.out.println("\tEnter Team's Score (400-1000): ");
            int score = scanint.nextInt();
            if (score >= 400 && score <= 1000){
                scores[i] = score; // writes user inputted int values into the scores array
            }
            else {
                    error(); // calls method that kills program if user is out of range
            }
        } // end of for loop

        System.out.println("\n"); // formatting

        for (int i = 0; i <= selection - 1; i++ ) { // will loop for however many i there are
            System.out.println(names[i] + "\t" + scores[i]); // for loop to display all team names and matching scores
        }

        // print return values of greatest and least methods within a sentence
        // the array calls the i value from the greatest and least methods, these i values correspond with the maximum and minimum values in the scores array
        System.out.println("\nThe " + names[least(scores)] + " team have the lowest score => " + scores[least(scores)]  + " and the " + names[greatest(scores)] + " team have the highest score => " + scores[greatest(scores)]);

        scanint.close(); // close Scanner
        scanstr.close();
            }

    // establish error method
    public static void error() {
        System.out.println("\nInvalid input. Must be within 400-1000.");
        System.exit(0); // kill program if user is not within range
    }

    // establish the 'greatest' method to determine the maximum value found in the scores array
    public static int greatest(int[] G){
        int max = 200; // set max value to a value the user cannot reach
        int max2 = -1;

        for (int i = 0; i < G.length; i++) {
            if (G[i] > max){ // this will grab the largest number greater than 200 (max variable)
                max = G[i];
                max2 = i;
            }
        }
        return max2; // return the i value of the highest array element
    }

    // establish the 'least' method to determine the minimum value found in the scores array
    public static int least(int[] L){
        int min = 2000; // set min value to a value the user cannot reach
        int min2 = -1;
        for (int i = 0; i < L.length; i++) {
            if (L[i] < min){ // this will grab the smallest number less than 2000 (min variable)
                min = L[i];
                min2 = i;
            }
        }
            return min2; // return the i value of the lowest array element
    }

        }

