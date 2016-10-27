/* Monopoly.java
 * 
 * CSCI 111 Spring 2015
 * last edited March 28, 2013 by Jefferson Zhumi
 * 
 * This package contains code that can be used as the basis of a monopoly game
 * It has a class of BoardSquares for the board squares in a Monopoly game,
 * and a main program that puts the squares into an array.
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images used in Monopoly are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */
package monopoly;

import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author cherbert
 */
public class Monopoly {

    /**
     * The main method sets an array of 40 monopoly squares then creates a loop
     * counter and calls the method loadArray then test the program by printing
     * the data from the array In addition, it sets another player object then
     * it calls the turn method last, the while boolean loops the player until
     * the balance is 0
     *
     */
    public static void main(String[] args) throws Exception {

        BoardSquare[] square = new BoardSquare[40]; // array of 40 monopoly squares

        int i; // a loop counter

        // call the method to load the array
        loadArray(square);

        // test the code by printing the data for each square
        System.out.println("Greetings Player!");
        System.out.println("Data from the array of Monopoly board squares. Each line has:\n");
        System.out.println("   name of the square, type, rent, price, color\n");
        for (i = 0; i < 40; i++) {
            System.out.println(i + ". " + square[i].toString());

        }

        //player object 
        Player playerOne = new Player();
        
        //the game begins!
        System.out.println("\n...Begins!");
        //call the method to enable player to move 
        turn(playerOne, square);

        // loops the player until the balance is 0
        while (playerOne.getBalance() > 0) {
            turn(playerOne, square);
        }

        //when the loop finishes a "game over" statement is shown 
        System.out.println("Game over. Please play again!");

    } // main()
    //***********************************************************************

    // method to load the BoardSquare array from a data file
    public static void loadArray(BoardSquare[] square) throws Exception {
        int i; // a loop counter

        // declare temporary variables to hold BoardSquare properties read from a file
        String inName;
        String inType;
        int inPrice;
        int inRent;
        String inColor;

        // Create a File class object linked to the name of the file to be read
        java.io.File squareFile = new java.io.File("squares.txt");

        // Create a Scanner named infile to read the input stream from the file
        Scanner infile = new Scanner(squareFile);

        /* This loop reads data into the square array.
         * Each item of data is a separate line in the file.
         * There are 40 sets of data for the 40 squares.
         */
        for (i = 0; i < 40; i++) {
            // read data from the file into temporary variables
            // read Strings directly; parse integers
            inName = infile.nextLine();
            inType = infile.nextLine();
            inPrice = Integer.parseInt(infile.nextLine());
            inRent = Integer.parseInt(infile.nextLine());;
            inColor = infile.nextLine();

            // intialze each square with the BoardSquare constructor
            square[i] = new BoardSquare(inName, inType, inPrice, inRent, inColor);
        } // end for
        infile.close();

    } // endLoadArray
    //***********************************************************************

    //method to move the player around the board
    public static void turn(Player playerOne, BoardSquare[] square) {

        //set local variable loc to players location at start of turn
        int loc = playerOne.getLocation();
        //set local variable bal to players balance at start of turn
        int bal = playerOne.getBalance();
        //calls method dice()
        int roll = rollDice();

        //gets the name from the Player class
        String name = playerOne.getName();

        //gets the token from the Player class
        String token = playerOne.getToken();

        //update location
        loc = loc + roll;
        if (loc > 39) {
            loc = loc - 40;
        }

        //update balance
        bal = bal - square[loc].getRent();

        //update player object's properties 
        playerOne.setLocation(loc);
        playerOne.setBalance(bal);

        //Summary of the game process 
        System.out.println();
        System.out.println(name + " rolled a " + roll);
        System.out.println(name + "'s " + token + " is now on " + square[loc].getName());
        System.out.println("The rent is $" + square[loc].getRent());
        System.out.println(name + "'s" + " new balance is $" + bal);
        JOptionPane.showMessageDialog(null, "Please click Ok to contunie"); //box panel appears

    }//end turn() method

//****************************************************************************
    //roll dice method -- generate two random number 1-6 and add them together 
    public static int rollDice() {
        int diceOne;
        int diceTwo;
        int total;
        diceOne = 1 + (int) (Math.random() * 6);
        diceTwo = 1 + (int) (Math.random() * 6);
        total = diceOne + diceTwo;
        return total;

    }
} // end rollDice()
//***************************************************************************


/* code for a class of Monopoly squares
 * 
 * CSCI 111 Fall 2013 
 * last edited November 2, 2013 by C. Herbert
 * Each object in this class is a square for the board game Monopoly.
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images in the game are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */
class BoardSquare {

    private String name;    // the name of the square
    private String type;    // property, railroad, utility, plain, tax, or  toJail 
    private int price;      // cost to buy the square; zero means not for sale
    private int rent;       // rent paid by a player who lands on the square 
    private String color;   // many are null; this is not the Java Color class

    // constructors
    public BoardSquare() {
        name = "";
        type = "";
        price = 0;
        rent = 0;
        color = "";
    } // end Square()

    public BoardSquare(String name, String type, int price, int rent, String color) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.rent = rent;
        this.color = color;
    } // end Square((String name, String type, int price, int rent, String color)

    // accesors for each property
    public String getName() {
        return name;
    } //end  getName()

    public String getType() {
        return type;
    } //end  getType()

    public int getPrice() {
        return price;
    } //end  getPrice()

    public int getRent() {
        return rent;
    } //end  getRent()

    public String getColor() {
        return color;
    } //end  getColor()

    // a method to return the BoardSquare's data as a String
    public String toString() {
        String info;
        info = (name + ", " + type + ", " + price + ", " + rent + ", " + color);
        return info;
    } //end  toString()

} // end class BoardSquare
//***************************************************************************//

/* code for a class of Monopoly squares
 * 
 * CSCI 111 Spring 2015
 * last edited March 28, 2015 by J. Zhumi
 * Each object in this class is a property for the board game Monopoly.
 * 
 * This is for teaching purposes only. 
 * Monopoly and the names and images in the game are 
 * registered trademarks of Parker Brothers, Hasbro, and others.
 */
class Player {

    private String name;    // the name of the player
    private String token;    // token name
    private int location;      // the number of the square the player is on; 0
    private int balance;       //  the player's current bank balance; 1500

    // constructors
    public Player() {
        name = "Jefferson";
        token = "battleship";
        location = 0;
        balance = 1500;

    }//end player()

    public Player(String name, String token, int location, int balance) {
        this.name = name;
        this.token = token;
        this.location = location;
        this.balance = balance;

    } // end player((String name, String token, int location, int balance)

    public void setName(String name) {
        this.name = name;
    }//end setName()

    public String getName() {
        return name;
    } //end  getName()

    public void setToken(String token) {
        this.token = token;
    }//end setToken()

    public String getToken() {
        return token;
    } //end  getType()

    public void setLocation(int location) {
        this.location = location;
    }//end setLocation

    public int getLocation() {
        return location;
    } //end  getPrice()

    public void setBalance(int balance) {
        this.balance = balance;
    }//end setBalance()

    public int getBalance() {
        return balance;
    }//end getBalce()

    public String playerInfo() {
        String info = (name + ", " + token + ", " + location + ", " + balance);
        return info;
    } //end toString()

}//end Player class()
