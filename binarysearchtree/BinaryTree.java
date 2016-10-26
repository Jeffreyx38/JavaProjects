/*
 //Jefferson Binary Tree
 //This class links all the node data together with pointers 
 //It has only a root, left and right property
 //within this class, we have the add method which 
 //appends a new incoming node to the tree
 //this class also has all the operations that make a binary tree effient
 //It has the following operations: insert (), delete(), search(), preorder(),
 // inorder(), postorder(), maxValue(), minValue(), depth(), height()
 */
package binarysearchtree;

/**
 *
 * @author Jefferson
 */
public class BinaryTree {
    
private Node root; //root pointer 

    public BinaryTree() {
        root = null; //setting tree as empty
    }//end binaryTree()
/**
     * *************************************************************
     * This operation returns a boolean value if the list is empty *
     * ************************************************************* 
     * @return
     */
    
    public boolean isEmpty() {
        return root == null; //return if root is null
    }//end isEmpty ()
/**
     * ****************************************
     * This operation adds a node to the tree *
     * It uses the binary tree property       *
     * ****************************************
     * @param data
     */
    public void insert(int data) {
        Node newNode = new Node(data); //creates a new Node
        if (root == null) { //if tree empty 
            root = newNode; //set new root to new node
        } //end if
        else { //otherwise 
            Node parentNode = null; //set parent node as null
            Node currentNode = root; //create a pointer current node
            while (currentNode != null) { //while current not null
                parentNode = currentNode; //make current point to parent
                if (data < currentNode.getData()) { //if data is less than current data
                    currentNode = currentNode.getLeft();

                } //enf if
                //otherwise if data is greather than current data
                else {
                    currentNode = currentNode.getRight();
                }//end else
            }//end while
            //if data is less parent node data 
            if (data < parentNode.getData()) {
                //set left to the new node
                parentNode.setLeft(newNode);
            }//end if 
            //othewise
            else {
                //set right to the new node
                parentNode.setRight(newNode);
            }//end else
        }//end else
    }//end insert()
/**
     * *****************************************************************
     * This operation access all nodes in the tree in order            *
     * Visits left child first, then parent and finally the right child*
     * *****************************************************************
     */
    public void inOrder() {
        inOrder(root); //pass root pointer
        System.out.println(" ");
    }//end inOrder()

    private void inOrder(Node root) {
        //base condition for recursion
        //if tree/sub-tree is empty, return and exit
        if (root != null) {
            inOrder(root.getLeft()); //recursively traverse left subtree
            System.out.print("\t" + root.getData() + " "); //display the data of current element
            inOrder(root.getRight()); //recursively travese right subtree

        }//end if

    }//end inOrder()
/**
     * *******************************************************************************
     * This operation access all nodes in the tree-- preOrder                          *
     * Visits the parent child first, then the left child and finally the right child*
     * *******************************************************************************
     */
    //method to call from main
    public void preOrder() {
        preOrder(root); //pass root pointer 
    }//end preOrder()

    //method to visit nodes in preOrder
    private void preOrder(Node root) {
        //base condition for recursion
        //if tree/sub-tree is empty, return and exit
        if (root != null) {
            System.out.print("\t" + root.getData() + " ");//display the data of current element
            preOrder(root.getLeft()); //recursively traverse left subtree
            preOrder(root.getRight());//recursively travese right subtree
        }//end if
    }//end preOrder()
    /**
     * **************************************************************************
     * This operation access all nodes in the tree--postOrder                   *
     * Visits left child first, then the right child and finally the parent node*
     * **************************************************************************
     */
    public void postOrder() {
        postOrder(root);//pass root pointer

    }//end postOrder()

    private void postOrder(Node root) {
        //base condition for recursion
        //if tree/sub-tree is empty, return and exit
        if (root != null) {
            inOrder(root.getLeft());//recursively traverse left subtree
            inOrder(root.getRight()); //recursively travese right subtree
            System.out.println("\t" + root.getData() + " ");//display the data of current element
        }//end if
    }//end postOrder()

    //method call from main()
    //returns recursively true if the given target is in the binary tree
    public boolean lookup(int data) {
        //return the boolean true or false
        //and exit
        return (lookup(root, data));
    }//end looup()

    //recursive lookup
    //checks if the target is in the tree
    private boolean lookup(Node root, int data) {
        //base condition for recursion
        //if tree/sub-tree is empty, return false and exit
        if (root == null) {
            return false;
        }//end if()
        //base condition for recursion
        //if tree/sub-tree is empty, return true and exit
        if (data == root.getData()) {
            return true;
        } //enf if()
        else if (data < root.getData()) {//if target is less than current root daa
            return lookup(root.getLeft(), data); //recursively return root left data
        } //end else if()
        else { //otherwise
            return lookup(root.getRight(), data); // recursively return root right data
        }//end else()
    }//end lookup()

    /*************************************************************
    *call from main                                              *
    *if tree is empty print: tree empty                          *
    *if target does not exist in the tree print: not in tree     *
    *otherwise; pass data and call delete method to delete target*
    **************************************************************
    * @param data
    */
    public void delete(int data) {
        //if root is empty
        if (isEmpty()) {
            System.out.println("The tree is empty."); //tree is empty
            //if target not in tree
        }//end if
        else if (lookup(data) == false) {
            //comment that target not found in the tree
            System.out.println("Sorry " + data + " is not in the tree.");
            //otherwise; call delete method and print deleted target
        }//else if
        else {
            root = delete(root, data);
            //deleted target
            System.out.println(data + " deleted from the tree.");
        }//end else

    }//end delete

    /********************************************
    *recursive delete method                    *
    *three cases to delete the target;          *
    *case 1. The node to delete is a leaf       *
    *case 2. The node to delete has one child.  *
    *case 3. The node to delete has two children*
    * *******************************************
    */
    private Node delete(Node node, int data) {
        //if node empty return null
        if (node == null) {
            return null;
        }//end if
        //if current target equals current data
        //(Case 3: the node has two childrens)
        if (data == (node.getData())) {
            // if both children are null; return null
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }//end if
            //if left children is null return right child
            if (node.getLeft() == null) {
                return node.getRight();
            }//end if
            //if right children is nulll return left child
            if (node.getRight() == null) {
                return node.getLeft();
            }//end if

            //creates a temp key from smallest value from left subtree
            //calls mind method to find the smallest value of left subtree
            Node tmp = minFind(node.getRight());
            // copies the key field from tmp to target node
            node.setData(tmp.getData());

            // now delete tmp from node's right subtree and return
            node.setRight(delete(node.getRight(), tmp.getData()));
            //return node
            return node;

        }//end if
        //if data is less than current data, continue left 
        else if (data < (node.getData())) {
            //delete node
            node.setLeft(delete(node.getLeft(), data));
            return node;

        }//end if
        //if data is greater than current data, continue right   
        else {
            //delete right node
            node.setRight(delete(node.getRight(), data));
            return node;
        }//end else
    }//end delete()

    //finds the left smallest node of a parent node with two children
    //method for the case 3 to delete a node
    private Node minFind(Node node) {
        if (node.getLeft() == null) {
            return node;
        }//end if
        return minFind(node.getLeft());
    }//end mindFind()
/**
     * ****************************************************
     * This operation returns the max element in the tree *
     * ****************************************************
     * @return
     */
    public int max() {
        if (root != null)  //if root is not null
        {
            Node loopNode = root; //create a pointer loop node
            while (loopNode.getRight() != null) //while right child not null
            {
                loopNode = loopNode.getRight();
            }//end while()
            return loopNode.getData(); //return data
        }//end if()
        else //otherwise
        {
            return 0;
        }//end else()
    }//end max()
/**
     * ****************************************************
     * This operation returns the min element in the tree *
     * ****************************************************
     * @return
     */
    public int min() {
        if (root != null) //if root is not null
        {
            Node loopNode = root; //create a pointer loop node
            while (loopNode.getLeft() != null) //while right child not null
            {
                loopNode = loopNode.getLeft();
            }//end while
            return loopNode.getData(); //return data
        }//end if
        else {
            return 0;
        }//end else
    }//end min()
/**
     * ************************************************************
     * This operation returns the number of elements in the tree  *
     * ************************************************************
     * @return
     */
    public int size() {
        return size(root); //returns size
    }//end size()

    private int size(Node root) {
        if (root == null) { //if root empty return 0
            return 0;
        }//end if
        //else return size
        return 1 + size(root.getLeft()) + size(root.getRight());
    }
/**
     * ***********************************************************
     * First method calls from main                              *
     * Second method returns the height of the tree recursively  *
     * ***********************************************************
     * @return
     */
    public int findHeight() {
        if (this.isEmpty()) {
            System.out.println("The tree is empty."); //tree is empty
        } //end if
        
        else //else 
        {
            Node node = root; //create node pointer
            return findHeight(node); //return the height
        }//end else
        return 0;
    }//end findHeight()
    
    //recursive method
    private int findHeight(Node node) {
        if (node == null) //base case
        { 
            return -1;
        }//end if
        int left = findHeight(node.getLeft());
        int right = findHeight(node.getRight());
        if (left > right) {
            return left + 1;
        }//end if
        else {
            return right + 1;
        }//end else
    }//end findHeight()
/**
     * **************************************************
     * First method calls from main                     *
     * Second method returns the depth of a given node  *
     * **************************************************
     * @param value
     * @return
     */
    public int getDepth(int value) {
        return getdepth(root, value);
    }//end getdepth()

    private int getdepth(Node root, int value) {
        if (root == null) //if root empty return 0
        {
            return 0;
        }//end if
        //else if value equals return 0
        else if (value == root.getData()) {
            return 0;
        }//end else if
        //else if value less than root 
        else if (value < root.getData()) {
            //return depth 
            return 1 + getdepth(root.getLeft(), value);
        }//end else if
        //else if value greater than root
        else {
            //return depth
            return 1 + getdepth(root.getRight(), value);
        }//end else

    }//end depth
}//end binaryTree()