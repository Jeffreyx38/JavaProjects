/*
 *Jefferson Node Class
 *This is the node class of the binary tree as an outer class
 *This class has access to the array data
 *This class acts as a data holder 
 *Both left, right nodes are set to private for security risks 
 *Accesors and mutators are set to retrive data
 *This class works simultaneously with the binaty tree class
 *
 */
package binarysearchtree;

/**
 *
 * @author Jefferson
 */
public class Node {

    private Node left, right; //left & right child 
    private int data; //stores data for the binary tree
    //node constructor 

    public Node() {
        left = null;
        right = null;
        data = 0;

    }//end node()
    //node constructor 

    public Node(int n) {
        left = null;
        right = null;
        data = n;
    }//node()

    public void setLeft(Node n) {
        this.left = n;
    }//end setLeft()

    public Node getLeft() {
        return left;
    }//end getLeft()

    public void setRight(Node n) {
        this.right = n;
    }//end setLeft()

    public Node getRight() {
        return right;
    }//end getLeft()

    public void setData(int d) {
        this.data = d;
    }//end setLeft()

    public int getData() {
        return data;
    }//end getData()

}//end node()
