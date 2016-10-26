/* GreatestCommonDenominator Application
 * created for CSCI 112 Summer 2015
 * last edited July 12, 2015 by Jefferson Zhumi
 * @author Jefferson
 */
package greatestcommondenominator;

public class GreatestCommonDenominator {

    /*
     * 
     * The main method prints a description of the program 
     * Then loops to print three sets of GCD of two random numbers
     * Within the loop, two numbers are generated randomly by the methods randomNum()
     * finally, it prints the GCD recursively and interating of the the two random numbers
     *
     */
    public static void main(String[] args) {
        
        //description of the application 
        System.out.println("Welcome!");
        System.out.println("This application will find the GCD of two random numbers");
        System.out.println("Loading...\n");
        
        //Loops and prints three sets of randon intergers to find the GCD
        int i;
        for (i = 1; i < 4; i++) {

            //Methods A and B generate two random numbers--Number 1 & 2
            int Num1 = randomNumA();
            int Num2 = randomNumB();

            //Prints number of sets
            //Prints the first and second random number 
            System.out.println("Set:" + i);
            System.out.println("The first number is " + Num1);
            System.out.println("The second number is " + Num2);

            //prints recursive method to finding the GCD
            System.out.println("Recursive method");
            System.out.println("The GCD of the two numbers " +Num1 + " and " 
                    +Num2+" is: " + recursiveGCD(Num1, Num2));

            //prints iterative method to finding the GCD
            System.out.println("Iterative method");
            System.out.println("The GCD of the two numbers " + Num1 + " and " + 
                    Num2+" is: " + iterativeGCD(Num1, Num2));
            
            //skips a line
            System.out.println("");
        }//ends loop for the three sets 
    }//ends main()
 /*****************************************************************************/

    // method to find the GCD recursively 
    public static int recursiveGCD(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return recursiveGCD(b, (a % b));
        }
    }//recursive()
/******************************************************************************/
    // method to find the GCD interating 
    public static int iterativeGCD(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }//end iterative()
/******************************************************************************/
    //method to generate random number A
    public static int randomNumA() {
        int a;
        a = (int) ((Math.random() * 4000) + 1000);
        return a;
    }//end randomA()
    //method to generate random number B
    public static int randomNumB() {
        int b;
        b = (int) ((Math.random() * 4000) + 1000);
        return b;
    }//end randomB()
}//end class
