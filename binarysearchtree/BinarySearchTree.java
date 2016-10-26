/*
 * Binary Search Tree Application
 * created for CSCI 211
 * last modified December 17, 2015
 *@author Jefferson
 */
package binarysearchtree;

/**
 *
 * @author Jefferson
 */
public class BinarySearchTree {

    /*
     //The main method prints a descrition of the program
     //creates an array named numTest
     //creates a binary tree object for the number test array
     //for loops the array to print the original data 
     //with a enhanced for loop, we insert all the elements to the tree
     //then it traverses the tree to check the elements 
     //finally, the program generates different exercises to check the binary tree
     //1. 100 elements in correct order, reverse order, and random order
     //2. finds the height of each exersive 
     //3. compares the data
     */
    public static void main(String[] args) {
        //welcome statement
        System.out.println("Hello! Welcome.");
        //description statement
        System.out.println("This is a binary search tree composed of intergers! ");
        //creates a binary tree for the numTest array
        BinaryTree newTreeOperationTest = new BinaryTree();
        //creates a binary tree for the 100 elements added in the correct order
        BinaryTree newTreeOne = new BinaryTree();
        //creates a binary tree for the 100 elements added in reverse order
        BinaryTree newTreeTwo = new BinaryTree();
        //creates a binary tree for the 100 elements added in random order
        BinaryTree newTreeThree = new BinaryTree();

        //create an array of numbers for the tree 
        int[] numTest = {50, 76, 21, 4, 32, 64, 15, 52, 14, 100, 83, 2, 3, 70, 87, 80};

        //Prints the original array data using an enhanced for loop
        System.out.println("Original array data: ");
        for (int p : numTest) {
            System.out.println(p); //prints data
        }//end for()

        //Inserts the array numbers in the tree using an enhanced for loop
        for (int p : numTest) {
            newTreeOperationTest.insert(p); //insert data
        }//end for()
        
        //block of code below prints all the operations simultaneously
        System.out.println("******************");
        //Empty operation()
        System.out.println("Binary tree empty: " + newTreeOperationTest.isEmpty());
        //Size operation()
        System.out.println("Binary tree size: " + newTreeOperationTest.size());
        //returns the maximum value in the tree
        System.out.println("Maximum number in the tree: " + newTreeOperationTest.max());
        //return the minimum value in the tree
        System.out.println("Minimum number in the tree: " + newTreeOperationTest.min());
        //checks if the given data is in the tree
        System.out.println("45 interger in tree: " + newTreeOperationTest.lookup(45));
        //return the depth of any given node
        System.out.println("What is the depth of 76: " + newTreeOperationTest.getDepth(76));

        //TRAVERSING OPERATIONS
        System.out.println("******************");
        System.out.println("Traversing operations.... ");
        System.out.println("in-Order: ");
        newTreeOperationTest.inOrder(); //inOrder()
        System.out.println("post-Order: ");
        newTreeOperationTest.postOrder(); //postOrder()
        System.out.println("pre-Order: ");
        newTreeOperationTest.preOrder(); //preOrder()

        //DELETING CASES
        //Case 1: deleting leaf node
        //Case 2: deleting one child
        //Case 3: deleting two children
        System.out.println("\n******************");
        System.out.println("Deleting cases.... ");
        System.out.println("Case 1: ");
        newTreeOperationTest.delete(32);//-32 is a leaf
        System.out.println("Case 2: ");
        newTreeOperationTest.delete(2); //-2 has one child
        System.out.println("Case 3: ");
        newTreeOperationTest.delete(83);//-83 has two children 

        //TRAVERSING AFTER DELETION OF CASES
        System.out.println("******************");
        System.out.println("After deletion of cases.... ");
        System.out.println("in-Order: ");
        newTreeOperationTest.inOrder(); //inOrder()
        System.out.println("post-Order: ");
        newTreeOperationTest.postOrder(); //postOrder()
        System.out.println("pre-Order: ");
        newTreeOperationTest.preOrder(); //preOrder()

        //----------------------------------------------------------------------
        //block of node prints 100 elements added in the correct order
        System.out.println("\n******************");
        int k = 100; //end point for the loop
        for (int i = 1; i <= k; i++) //loops from 1-100
        {
            newTreeOne.insert(i); //inserts numbers from 1-100 in the tree
        }//end for()
        System.out.println("100 elements added in the correct order. ");
        //Prints the height of the tree
        System.out.println("The height is: " + newTreeOne.findHeight());

        //----------------------------------------------------------------------
        //block of node prints 100 elements added in reverse order
        System.out.println("******************");
        int z = 100; //starting point for the loop
        for (int i = z; i >= 1; i--) //loops from 100-1
        {
            newTreeTwo.insert(i); //inserts numbers from 100-1 in the tree
        }//end for()
        System.out.println("100 elements added in reverse order. ");
        //Prints the height of the tree 
        System.out.println("The height is: " + newTreeTwo.findHeight());

        //----------------------------------------------------------------------
        //block of node prints 100 elements added in random order
        System.out.println("*************");
        int size = 100;     // change this number to change the size of the random array
        int[] a = new int[size]; //creates an array a
        for (int i = 0; i < a.length; i++) //loops the array 
        {
            a[i] = (int) (Math.random() * 100 + 1); //randomly genarate numbers 
            newTreeThree.insert(a[i]); //insert random numbers in the tree
        }//end for()
        System.out.println("100 elements added in random order. ");
        //Prints the height of the tree 
        System.out.println("The height is: " + newTreeThree.findHeight());

        //----------------------------------------------------------------------
        //block of node prints 1000 elements added in random order
        //it then repeats this process 100 times
        System.out.println("*************");
        System.out.println("Prints 1000 random intergers 100 times.");
        for (int p = 1; p <= 100; p++) //loop multiplier 
        {
            BinaryTree newTreeFour = new BinaryTree(); //creating binary tree
            int maxInteger = 1000; //interger size
            int[] h = new int[maxInteger]; //create an array of intergers
            for (int i = 0; i < h.length; i++) //for loop the random interges
            {
                h[i] = (int) (Math.random() * 100 + 1); //creates the random intergers 

                newTreeFour.insert(h[i]); //inserts in the tree
                System.out.print(p+ ": " + h[i] + ", "); //displays the tree input
            }//end for
            //prints the height of each tree input 
            System.out.println("\nheight: " + newTreeFour.findHeight());
        }//end for

    }//end main()
}//end BinarySearchTree()
