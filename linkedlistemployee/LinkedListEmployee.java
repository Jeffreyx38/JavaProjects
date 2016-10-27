/*
 * Linked List Application
 * created for CSCI 211
 * last modified October 28, 2015
 *@author Jefferson
 */
package linkedlistemployee;
//ListList.java
//Node.java
//Employee.java

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Jefferson
 */
public class LinkedListEmployee {

    /*
     //The main method prints a descrition of the program
     //Calls Scanner class to read a data file --employemnt 
     //then loops into file data to retrive the data
     //it then instantiates the data to the object Employee 
     //within the loop it call the operation append method to add the data to the list
     //it then prints the 15 operations 
     */
    public static void main(String[] args) {
        //welcome statement
        System.out.println("Hello! Welcome.");
        //description statement
        System.out.println("This is a linked list program of the object employee!");

        // Create a File class object linked to the name of the file to be read
        java.io.File fileIn = new java.io.File("Employee.txt");

        try {
            try ( // Create a Scanner named infile to read the input stream from the file
                    Scanner infile = new Scanner(fileIn)) {
                //creates a linked list for the Employee object
                LinkedList newList = new LinkedList();
                //while loop to iterate through the file data--5 times
                while (infile.hasNext()) {
                    //create an employee reference object
                    Employee person = new Employee();
                    //instantiate seven employees in the list
                    person.setKeyId(infile.nextLine()); //keyID of the employee
                    person.setFirstName(infile.nextLine()); //firstName of the emp.
                    person.setLastName(infile.nextLine()); //lastName of the emp.
                    person.setCity(infile.nextLine()); //city of the employee
                    person.setState(infile.nextLine()); //stata of the employee
                    person.setZipCode(Integer.parseInt(infile.nextLine())); //zip code
                    person.setSpecialty(infile.nextLine()); //employee's specialty
                    person.setPhoneNum(infile.nextLine()); //emplooyee's phone num
                    newList.addNewNode(person); //adds the object to the node append operation 
                }
                
                ///block of code below prints all the operations simultaneously
                System.out.println("Original Data: ");
                newList.traverseList(); //traverse operation()
                System.out.println("Linked list empty: " + newList.isEmpty() + "."); //empty boolean operation()
                System.out.println("Returns employee data from employee id 3333:" + newList.getData("3333")); //getData operation()
                System.out.println("Employee linked list size: " + newList.size());//size operation()
                System.out.println("******************");
                System.out.println("TestPerson():" + testPerson()); //display testPerson()
                System.out.println("******************");
                System.out.println("Inserts TestPerson() node after employee id 3333: ");
                newList.insertAfter("3333", testPerson()); //insert after operation ()
                newList.traverseList(); //traverse list
                System.out.println("******************");
                System.out.println("Deletes TestPerson()node after employee id 3333: ");
                newList.deleteAfter("3333"); //delete after operation()
                newList.traverseList(); //traverse the list
                System.out.println("******************");
                System.out.println("Inserts TestPerson() node before employee id 5555: ");
                newList.insertBefore("5555", testPerson()); //insert before operation ()
                newList.traverseList(); //traberse the list
                System.out.println("******************");
                System.out.println("Deletes TestPerson() node before employee id 5555: ");
                newList.deleteBefore("5555"); //delete before operation ()
                newList.traverseList(); //traverse the list
                System.out.println("******************");
                System.out.println("Appends TestPerson() node to the first list: ");
                newList.addFirst(testPerson()); //add first operation ()
                newList.traverseList(); //traverse the list
                System.out.println("******************");
                System.out.println("Deletes the head node of the list: ");
                newList.deleteHead(); //delete head operation()
                newList.traverseList();//traverse the list
                System.out.println("******************");
                System.out.println("Appends TestPerson() node to the last list: ");
                newList.addtoLast(testPerson()); //add to last operation ()
                newList.traverseList(); //traverse the list
                System.out.println("******************");
                System.out.println("Deletes the last node of the list: ");
                newList.deleteLast(); //delete to last operation ()
                newList.traverseList(); //traverse the list
                System.out.println("******************");
                System.out.println("Shallow cloning (Employee object):");
                LinkedList cloned = (LinkedList) newList.clone(newList); //shallow cloning operation()
                cloned.traverseList(); //traverse shallow clone
                System.out.println("******************");
                System.out.println("Deep cloning (Employee Object): "); 
                LinkedList deepClonedList = (LinkedList) newList.deepClone(); //deep cloning method()
                //newList.deleteHead(); 
                deepClonedList.traverseList(); //traverse deep cloning
                System.out.println("******************");
                System.out.println("The CompareTo() method that compares the original "
                        + "list to the deepCloned List");
                System.out.println("Returns true or false: "); //compareTo() operation 
                System.out.println("\tLList.head = deepClonedList.head: " 
                        + newList.compareToList(newList, deepClonedList) + ".");

            }//end try
        } catch (FileNotFoundException e) {
            System.out.println("Text file has not been found. Please try again.");
        }//end catch
    }//end main()
    
    /**
     * @return **************************************************************
     ************************************************************************/
    //This is test person method()
    //It returns a new person object data to test our operations 
    public static Employee testPerson() {
        //created testPerson object
        Employee TestPerson = new Employee();
        TestPerson.setKeyId("*xxxx"); //xxxx keyNUm
        TestPerson.setFirstName("Steve"); //fName
        TestPerson.setLastName("Zhumi"); //lName
        TestPerson.setCity("Philadelphia"); //cityName
        TestPerson.setState("Pennsylvania"); //stateName
        TestPerson.setZipCode(1443); //zipCode
        TestPerson.setSpecialty("Nurse"); //Specialty
        TestPerson.setPhoneNum("2675756006"); //phone number
        return TestPerson; //returns testPerson object
    }//end testPerson()

}//end LinkedListEmployee()

