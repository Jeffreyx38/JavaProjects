/* Recursive directory Application
 * created for CSCI 112 Summer 2015
 * last edited July 23, 2015 by Jefferson Zhumi
 * @author Jefferson
 */
package recursivedirectory;

import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Jefferson
 */
public class RecursiveDirectory {

    /**
     * The main method prints a description of the program
     * Then creates a scanner object to ask user for input source and destination
     * Finally, it calls the method folderPath to copy and paste the files 
     * and directories
     */
    public static void main(String[] args) throws Exception {
        
        //welcome statement 
        //descrition of the application
        System.out.println("Welcome!");
        System.out.print("This application will copy existent directories or files,");
        System.out.println(" and all its contents to a new location." + "\n");

        //create a new instance of scanner to get user input
        Scanner kb = new Scanner(System.in);

        //ask user for a source to copy
        System.out.println("Please enter the source that you wish to copy:");
        String source = kb.nextLine();
        
        //ask user for a new location of the source
        System.out.println("Please enter the destination of the copied source:");
        String destination = kb.nextLine();
        
        //skips a line
        System.out.println("");

        //method to determine and  if it is a directory or file
        folderPath(source, destination);

    }//end main

    /*
     *This method passes a source to a new destination 
     *Then it will check whetever the item exist or not,
     *if the item exists the program will then check whetever is a file or directory,
     *for a directory it will work recursivetly, 
     *and for a file source, it will work using buffered streams
     */
    public static void folderPath(String source, String destination) throws Exception {

        //create File object for the source and destination files
        File sourcePath = new File(source);
        File destinationPath = new File(destination);

        //if the identified item exists 
        if (sourcePath.exists()) {//if file or directory exist

            //if the sourcePath is a directory
            if (sourcePath.isDirectory()) {//if directory 

                //creates a new file or make a new directory
                destinationPath.mkdir();

                {
                    //create an array for the entries in the sourcepath directory
                    String[] entries = sourcePath.list();

                    //iterate the array using an alternate for statement
                    for (String file : entries) {

                        //copy files to destinationPath
                        File srcFile = new File(sourcePath, file);
                        File destFile = new File(destinationPath, file);

                        //recurse the function
                        folderPath(srcFile.getAbsolutePath(), destFile.getAbsolutePath());
                    }//end for

                }//end block

                //a summary of the files that have been copy to the new distination
                System.out.println("Directory copied from " + sourcePath
                        + "  to " + destinationPath + " correctly.");

                //if the sourPath is a file 
            } else if (sourcePath.isFile()) {
                copyFile(source, destination); //calls copyFile method
            }//end else if

            //output if the source doesn't exist 
        } else {
            System.out.println("The item you asked about - " + source + " - does not exist.");
        }//end else
    }//end folderPath()

    /*This method copies a file. The parameters are strings with the names
     *of the source and destination files.
     *This method also checks to see if the destination file exists.
     *It will not overwrite existing files but it ask the user to try again
     */
    public static void copyFile(String source, String dest) throws Exception {
        //create File object for the destination file
        File destinationPath = new File(dest);

        //if file exists do not overwrite the existing file
        if (destinationPath.exists()) {
            System.out.println("The file - " + destinationPath + " - exists already. Please try another file.");

            //create a new file 
        } else {
            //declare Files
            File sourceFile = null;
            File destFile = null;

            //declare stream variables
            FileInputStream sourceStream = null;
            FileOutputStream destStream = null;

            //declare buffering variables
            BufferedInputStream bufferedSource = null;
            BufferedOutputStream bufferedDest = null;

            try {
                //Create File objects for source and destination files
                sourceFile = new File(source);
                destFile = new File(dest);

                //Create file streams for the source and destination
                sourceStream = new FileInputStream(sourceFile);
                destStream = new FileOutputStream(destFile);

                //Buffer the file streams with a buffer size of 8k
                bufferedSource = new BufferedInputStream(sourceStream, 8182);
                bufferedDest = new BufferedOutputStream(destStream, 8182);

                //Use an integer to transfer data between files
                int transfer;

                //Alert user as to what is happening
                System.out.println("Beginning file copy:");
                System.out.println("\tCopying " + source);
                System.out.println("\tTo      " + dest);

                //Read a byte while checking for End of File (EOF)
                while ((transfer = bufferedSource.read()) != -1) {

                    //Write a byte
                    bufferedDest.write(transfer);
                }//end while

            }//end try
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("An unexpected I/O error occurred.");
            }//end catch
            finally {
                //close file streams
                if (bufferedSource != null) {
                    bufferedSource.close();
                }//end if

                if (bufferedDest != null) {
                    bufferedDest.close();
                }//end if

                System.out.println("Your files have been copied correctly and "
                        + "closed.");
            }//end finally
        }//end copyDir
    }//end copyFile()
}//end recursiveDirectory()
