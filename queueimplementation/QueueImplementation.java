/*
 * Queue implementation
 * created for CSCI 211
 * last modified November 08, 2015
 *@author Jefferson
 */
package queueimplementation;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jefferson
 */
public class QueueImplementation {

    /*
     //The main method prints a description of the program
     //Calls Scanner class to read a data file --employement 
     //then it while loops into file data to retrive the data
     //it then instantiates the data to the object Employee 
     //then within the loop the program enqueues the data to the Queue
     //finally it dequeues the object data from queue using a while loop
     */
    public static void main(String[] args) {
        //welcome statement
        System.out.println("Hello! Welcome.");
        //description statement
        System.out.println("This is a queue program of the object employee!");

        // Create a File class object linked to the name of the file to be read
        java.io.File fileIn = new java.io.File("Employee.txt");
        
        //try-catch to check if the file exist
        try {
            //Create a Scanner named infile to read the input stream from the file
            Scanner infile = new Scanner(fileIn);
            
            //creates a queue for the Employee object
            Queue newQueue = new Queue();

            //while loop that enqueues the person object from the text file
            while (infile.hasNext()) {
                //create an employee reference object
                Employee person = new Employee();
                //instantiate seven employees in the list with the while loop
                person.setKeyId(infile.nextLine()); //keyID of the employee
                person.setFirstName(infile.nextLine()); //firstName of the emp.
                person.setLastName(infile.nextLine()); //lastName of the emp.
                person.setCity(infile.nextLine()); //city of the employee
                person.setState(infile.nextLine()); //stata of the employee
                person.setZipCode(Integer.parseInt(infile.nextLine())); //zip code
                person.setSpecialty(infile.nextLine()); //employee's specialty
                person.setPhoneNum(infile.nextLine()); //emplooyee's phone num
                newQueue.enqueue(person); //enqueues the object to the queue
            }//end while()

            //stars that seperates different operations 
            //prints the size of the queue
            //checks if the queue is empty
            //comment that lets the user know that the enqueue has been succesful 
            System.out.println("****************");
            System.out.println("Queue empty: " + newQueue.isEmpty());
            System.out.println("Elements in the queue: " + newQueue.size() + ".");
            System.out.println("Enqueue completed... ");

            //traverses the queue printing the data in queue
            newQueue.traverseQueue();

            //stars that seperates different operations 
            //comment that lets the user know that the dequeue has been succesful 
            System.out.println("****************");
            System.out.println("Dequeue elements... ");

            //dequeues the queue until the queue is empty
            while (!newQueue.isEmpty()) {
                System.out.println("\t" + newQueue.dequeue());
            }//end while()

            //prints the size of the queue after the dequeue
            //checks if the queue is empty
            System.out.println("Size after dequeue: " + newQueue.size());
            System.out.println("Queue empty: " + newQueue.isEmpty());
            
        //catch if the file has not been found 
        } catch (FileNotFoundException e) {
            System.out.println("Text file has not been found. Please try again.");
        }//end catch

    }//end main()

}// queueImplication()


