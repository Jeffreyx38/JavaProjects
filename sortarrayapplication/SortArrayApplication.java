
/* Sorting Application
 * created for CSCI 112 Summer 2015
 * last edited August 1, 2015 by Jefferson Zhumi
 * @author Jefferson
 *
 * This program reads data from a text file, sort the data,
 * then writes the data back to another text file.
 * For this to work, the file "unsorted.txt" must be in the project folder
 * warning -- this will overwrite the file "BubbleSort.txt", "SelectionSort.txt" 
 * and "insertionSort.txt" 
 * 
 * This program has methods to read lines from a text from a file into an array, 
 * display a text array on screen line-by-line, sort a text array, and write 
 * a text array to a data file line by line.
 * 
 * The program is limited to a file with 100 lines.  
 * To change this, change the size of the array declared in the main mwthod.
 * 
 */
package sortarrayapplication;

import java.util.Scanner;

public class SortArrayApplication {

    // the main method call methods to perform each part of the program
    //and prints a description of the program
    public static void main(String[] args) throws Exception {
        //descrition of the application 
        System.out.println("Welcome!");
        System.out.println("This program sorts a set of array in three different techniques." + "\n");
        
        //creates an object tutorial array
        String[] tutorials = new String[100];     // an array to hold a list of tutorials
        int count;		// the number of elements in the that are used

        // read data into tutorials[] line by line and return count
        count = readLines(tutorials); //count 20

        // print the array on the screen
        System.out.println("The original array:\n");
        displayLines(tutorials, count);

        //bubble sort to sort the array
        bubbleSort(tutorials, count);
        System.out.println("\nBubble sorted array:\n"); //print the array
        displayLines(tutorials, count); //print the array
        writeLinesBubble(tutorials, count); //write the array to data file

        //selection sort to sort the array
        selSort(tutorials, count);
        System.out.println("\nSelection sorted array:\n"); //print the array
        displayLines(tutorials, count); //print the array
        writeLinesSelec(tutorials, count);  //write the array to data file

        //insertion sort to sort the array
        inSort(tutorials, count);
        System.out.println("\nInsertion sorted array:\n");  //print the array
        displayLines(tutorials, count); //print the array
        writeLinesInser(tutorials, count);  //write the array to data file

    } // end main()    

    /* This method reads data from the file into the array. 
     * We want our array to work with up to 100 elements  
     * Each line from the file will be one element in the array.
     * The parameter refers to the array in the main method.  
     * The method returns the number of elements it uses.
     */
    public static int readLines(String[] lines) throws Exception {
        int count = 0; // number of array elements with data

        // Create a File class object linked to the name of the file to read
        java.io.File unsorted = new java.io.File("unsorted.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(unsorted);

        /* This while loop reads lines of text into an array. it uses a Scanner class 
         * boolean function hasNextLine() to see if there another line in the file.
         */
        while (infile.hasNextLine()) {
            // read a line and put it in an array element
            lines[count] = infile.nextLine();
            count++;  // increment the number of array elements with data

        } // end while

        infile.close();
        return count;    // returns the number of items used in the array.

    } //end readList()

    /* This method sorts an array of Strings line by line 
     * using a simple bubble sort. 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */
    public static void bubbleSort(String[] a, int count) {
        boolean swapped;    //  keeps track of when array values are swapped 
        int i;              // a loop counter
        String temp;         // catalyst variable for String swapping

        // Each iteration of the outer do loop is is one pass through the loop. 
        // If anything was swapped, it makes another pass
        do {
            // set swapped to false before each pass
            swapped = false;

            // the for loop is a pass through the array to the second to last element
            for (i = 0; (i < count - 1); i++) {
                // if the two items are out of order  see page 16 for String compareTo() 
                if (a[i + 1].compareTo(a[i]) < 0) {
                    // swap the two items ans set swapped to true    
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;

                    swapped = true;

                }  // end if
            } // end for

            // the outer loop will repeat if a swap was made  – another passs
        } while (swapped);

    } // end sortStringArray

    /* This method sorts an array of Strings line by line 
     * using a selection sort. 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */
    public static void selSort(String[] a, int count) {
        int min; //location of the minimum value in the remainder of the list
        
        //the for loop is a pass through the array to the second to last element
        for (int spot = 0; spot < count; spot++) { //the outer loop
            min = spot; //initialize the minimum to be rhe first value in the remainder of the list
            
            //i iterates from spot to the end of list-one pass
            for (int i = spot + 1; i < count; i++) {
                
                //compares a.array to min location
                if (a[i].compareTo(a[min]) < 0) { 
                    min = i; //
                }//end if
            }//end for
            
            //swap the value in spot with the pass minimum 
            String temp = a[min];
            a[min] = a[spot];
            a[spot] = temp;

        }//end spot
    }// end selSort()
    
    /* This method sorts an array of Strings line by line 
     * using an insertion sort. 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */

    public static void inSort(String[] a, int count) {
        String value; //variable from the unsorted list to be inserted into the sorted list

        int j;//j is a pointer to an item in the sorted list
        
        //iterate the entire list       
        for (int i = 1; i < count; i++) {
            value = a[i]; //next item from the original list, will be added to newlist
            j = i - 1; //set the pointer to the beginning of the unsorted list
            //checks if the items of j are >= than 0
            while (j >= 0) {
                if (value.compareTo(a[j]) > 0) { //compares the string lexicographally 
                    break;//leaves the loop
                }
                a[j + 1] = a[j];//moves the current item to the right
                j--;//moves left to the next item in the array
            }
            //insert the correct value in the spot
            a[j + 1] = value;
        }

    }//end inSort

    /*This method prints an array of Strings on the screen.  
     * The first parameter refers to the array in the main method.  The second 
     * parameter is the number of elements in the array that actually contain data
     */
    public static void displayLines(String[] lines, int count) {
        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            System.out.println(lines[i]);
        }

    } //end displayLines()

    /* This method writes an array of Strings to a text data file.  
     * The first parameter refers to the array in the main method. The second parameter
     * is the number of elements in the array that actually contain data
     */
    public static void writeLinesBubble(String[] lines, int count) throws Exception {
        // create a File class object and give the file the name BubbleSortText.txt
        java.io.File tut = new java.io.File("BubbleSortText.txt");
        // Create a PrintWriter text output stream and link it to the file x
        java.io.PrintWriter outfile = new java.io.PrintWriter(tut);

        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            outfile.println(lines[i]);
        }

        outfile.close();

    }//end writeLinesBubble()

    /* This method writes an array of Strings to a text data file.  
     * The first parameter refers to the array in the main method. The second parameter
     * is the number of elements in the array that actually contain data
     */
    public static void writeLinesSelec(String[] lines, int count) throws Exception {
        // create a File class object and give the file the name selectionSortText.txt
        java.io.File tut = new java.io.File("SelectionSortText.txt");
        // Create a PrintWriter text output stream and link it to the file x
        java.io.PrintWriter outfile = new java.io.PrintWriter(tut);

        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            outfile.println(lines[i]);
        }

        outfile.close();

    }//end writeLinesSelec
    /* This method writes an array of Strings to a text data file.  
     * The first parameter refers to the array in the main method. The second parameter
     * is the number of elements in the array that actually contain data
     */

    public static void writeLinesInser(String[] lines, int count) throws Exception {
        // create a File class object and give the file the name insertionSortText.txt
        java.io.File tut = new java.io.File("InsertionSortText.txt");
        // Create a PrintWriter text output stream and link it to the file x
        java.io.PrintWriter outfile = new java.io.PrintWriter(tut);

        int i;  // loop counter

        // iterate the elements actually used
        for (i = 0; i < count; i++) {
            outfile.println(lines[i]);
        }

        outfile.close();//close

    }//end writeLinesInser
}//end class
