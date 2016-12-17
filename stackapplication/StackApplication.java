/*
 * Stack Application
 * created for CSCI 211
 * last modified November 09, 2015
 *@author Jefferson
 */
package stackapplication;

/**
 *
 * @author Jefferson
 */
public class StackApplication {

    /*
     //The main method prints a descrition of the program
     //creates an array named carBrand
     //creates a stack object for the car brand array
     //for loops the array to print the data 
     //with a enhanced for loop, we push all the elements to the stack
     //then it traverses the stack to check the elements 
     //finally, we pop the elements to a new array car--LIFO
     */
    public static void main(String[] args) {
        //welcome statement
        System.out.println("Hello! Welcome.");

        //description statement
        System.out.println("This is a stack program of the array cars.");
        System.out.println("****************");

        //creates a stack for the car brand array
        Stack newStack = new Stack();

        //array of cars--lexus, chery, nissan, bmw, acura, honda
        String[] carBrands = {"Lexus", "Chery", "Nissan", "BMW", "Acura", "Honda"};

        //comment for the user 
        System.out.println("Original array of carBrands: ");

        //loop the car array and prints it 
        for (int i = 0; i < carBrands.length; i++) {
            System.out.println(i + ": " + carBrands[i]);
        }//end for ()

        //stars that seperates different operations 
        System.out.println("****************");
        
        //enhanced for loop to push all the elements
        for (String arrayCar : carBrands) { 
            newStack.pushElement(arrayCar); //pushes all the cars to the stack
        }//end for ()

        //prints the size of the stack
        //checks if the stack is empty
        //comment that leds the user know that the push elements has been succesful
        System.out.println("Stack empty: " + newStack.isEmpty());
        System.out.println("Elements in the stack: " + newStack.size() + ".");
        System.out.println("Push elements completed: "); 
        
        //traverse the stack in order --LIFO
        newStack.traverseStack();

        //stars that seperate operations 
        //comment telling the user that the stack has popped the elements 
        System.out.println("****************");
        System.out.println("Pop elements: ");

        //creates a new array of cars
        String newArrayOfCars[];

        //gets the length of old array to set to the new array
        newArrayOfCars = new String[carBrands.length];

        //for loop to pop the elements of the stack
        for (int i = 0; i < carBrands.length; i++) {
            //pops the elements while setting to the new array car
            newArrayOfCars[i] = newStack.popElement();
            //prints the new array of cars
            System.out.println("\tPop " + i + ": " + newArrayOfCars[i]);
        }//end for()

        //prints the size of the stack after the push
        //checks if the stack is empty after the push
        System.out.println("Elements in the stack after pop: " + newStack.size() + ".");
        System.out.println("Stack empty: " + newStack.isEmpty());
    }//end main()

}//end StackApplication()

