/*
 * Enrollments Application
 * created for CSCI 111
 * last modified April 25, 2015
 *@author Jefferson
 */
package enrollmentsapplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author Jefferson
 */
public class EnrollmentsApplication {

    /*
     //The main method prints a descrition of the program
     //Calls Scanner class to read a data file --enrollments 
     //then loops into the data with arrays 
     //also calls three methods --average, maxCalculation, and minCalculation
     //and outputs the results
     */
    public static void main(String[] args) {

        int[] enrollment = new int[67]; //enrollment array in CIS 103-- max 67

        //Name of the file to read
        File enrollments = new File("enrollments.txt");

        //Scanner reads the input stream from the file enrollments
        //try and catch exception to handle expected errors 
        try {
            Scanner infile = new Scanner(enrollments);

            //loops into the arrays data line by line 
            for (int i = 0; i < enrollment.length; i++) {
                enrollment[i] = infile.nextInt();
            }

            infile.close(); //closes the input data stream 
        } catch (FileNotFoundException e) {
            System.out.println("Text file has not been found. Please try again.");
        }
        //calls the average method
        averageCalculation(enrollment);
        //calls the minumum method 
        minCalculation(enrollment);
        //calls the maximum method 
        maxCalculation(enrollment);

        //prints a descritive welcome 
        System.out.println("This program is an array application that reads data from a file");
        System.out.println("The data below represents the enrollment in a section of CIS 103\n");

        //prints the arrays sections(lenght) of the enrollments file 
        System.out.println("There are " + enrollment.length + " sections in total.");
        //prints the average class size from the enrollment file
        System.out.println("The average class size is: " + averageCalculation(enrollment));
        //prints the minumum class size from the enrollment file 
        System.out.println("The minumum class size is: " + minCalculation(enrollment));
        //prints the maximum class size from the enrollment file 
        System.out.println("The maximum class size: " + maxCalculation(enrollment));

    }

    /**
     * **************************************************************
     */
    /*
     This method reads data from the file enrollment 
     and then loops the values to find the average of the file
 
     */
    public static int averageCalculation(int enrollment[]) {
        //variable
        int i;
        int sum = 0;
        int average;
        //Loops into the array to find the Average
        for (i = 0; i < enrollment.length; i++) {
            sum = sum + enrollment[i];
        }
        average = sum / enrollment.length;
        return average; //return the average
    }//ends average method

    /**
     * ***************************************************************
     */
    /*
     This method reads data from the file enrollment 
     and then loops the values to find the average of the file 
    
     */
    public static int minCalculation(int enrollment[]) {
        //variables
        int minimum;
        int i;
        //starts at 0
        minimum = enrollment[0];

        //loops into the array to find the minimum
        for (i = 1; i < enrollment.length; i++) {
            if (enrollment[i] < minimum) {
                minimum = enrollment[i];
            }
        }
        return minimum; //returns the minimum
    }//end min method()

    /**
     * ****************************************************************
     */
    /*
     This method reads data from the file enrollment 
     and then loops the values to find the maximum of the file
     */
    public static int maxCalculation(int enrollment[]) {
        //variables
        int maximum;
        int i;

        //loops into the array to find the maximum
        maximum = enrollment[0]; //starts at 0
        for (i = 1; i < enrollment.length; i++) {
            if (enrollment[i] > maximum) {
                maximum = enrollment[i];
            }
        }
        return maximum; //returns the maximum

    }//ends max method

}//end class
