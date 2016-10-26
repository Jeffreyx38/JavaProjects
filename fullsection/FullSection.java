/*
 * Full Section Application
 * created for CSCI 211
 * last modified September 15, 2015
 *@author Jefferson
 */
package fullsection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FullSection {

    /*
     //The main method prints a descrition of the program
     //Calls Scanner class to read a data file --enrollments 
     //then loops into the data with arrays 
     //It then counts & displays the number of full sections and
     //the percentage 
     */
    public static void main(String[] args) {
        
        int[] enrollment = new int[67]; //enrollment array in CIS 103-- max 67

        //name of the file to read
        File enrollments = new File("enrollments.txt");

        //scanner reads the input stream from the file enrollments
        //try and catch exception to handle expected errors 
        try {
            Scanner infile = new Scanner(enrollments);

            //loops into the arrays data line by line 
            for (int i = 0; i < enrollment.length; i++) {
                enrollment[i] = infile.nextInt();
            }//end for

            infile.close(); //closes the input data stream 
        } catch (FileNotFoundException e) {
            System.out.println("Text file has not been found. Please try again.");
        }
        
        //prints a descritive welcome 
        System.out.println("This program is an array application that reads data from a file");
        System.out.println("The data below represents the number of full sections and the percentage \n" );
        //calls the section method
        sectionCheck(enrollment);
        

    }// end main()
    
    /*
     This method reads data from the file enrollment 
     and then loops the values to find the number of full sections from the file
     Then, calculates the percentage of full sections 
     */

    public static void sectionCheck(int enrollment[]) {
        //variables
        int count = 0;
        int i;
        float percentage;

        //loops into the array to find the number of full sections
        for (i = 0; i < enrollment.length; i++) {
            if (enrollment[i] == 36) {
                count += 1;
                //count = count+ 1;
            }//end if
        }//end for
        
        //calculates percentage 
        percentage = ((count * 100) / enrollment.length);
        
        //prints the number of full sections 
        //prints the percentage of the full sections out of 67 
        System.out.println("There are " + count + " full sections.");
        System.out.println("The percentage of the full sections is: " + percentage + "%");

    }//sectionCheck()
} //end fullSection
