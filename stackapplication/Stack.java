/*
 //Jefferson Stack
 //This class links all the stack nodes together with pointers
 //The stack uses head and next as it's only properties 
 //It has the push method to insert new elements to the stack
 //It has the pop method to take of the elements from stack--FIFO
 //The class also has methods the prints the size of the stack and
 //that prints the boolean value if the stack is empty or not
 */
package stackapplication;

/**
 *
 * @Jefferson
 */
public class Stack {

    private StackElement head; //node head
    private int listCount; //variable for size count
    
    //stack contructor 
    Stack() {
        this.head = null; //head is set to null
        listCount = 0; //starting listCount
    }//end LinkedList()

    /**
     * *************************************************************
     * This operation returns a boolean value if the list is empty *
     * ************************************************************* 
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }//end isEmpty()

    /**
     * ************************************************************
     * This operation returns the number of elements in the list  *
     * ************************************************************ 
     * @return
     * size
     */
    public int size() {
        return listCount;
    } // end size()

    /**
     * ***********************************************
     * This operation pushes the array data -Last In *
     * ***********************************************
     *
     * @param data
     */
    public void pushElement(String data) {
        head = new StackElement(data, head); //prepens new stack
        
        //increment the number of elements in the list
        listCount++;
    }//end pushElement()

    /**
     * *************************************************
     * This operation pops the array data of the queue *
     * *************************************************
     * @return 
     */
    public String popElement() {
        //sets head pointer to currentStack
        StackElement currentStack = head;
        //head is set to current stack next pointer
        head = currentStack.getNext();
        //decrement the number of elements in the list
        listCount--;
        //returns the popped elements from the stack
        return currentStack.getData();
    }

    /**
     * ******************************************************
     * This operation access all nodes in the queue in order* It traverses the
     * data for each element-LIFO *
     * ******************************************************
     */
    public void traverseStack() {
        StackElement currentStack = head; //sets a starting point from head

        //traverse through the list until null is reach
        while (currentStack != null) { //check if the given node is empty 
            System.out.println("\tPush: " + currentStack.getData());//print the traversed data
            currentStack = currentStack.getNext();

        }//end while()

    }//end traverseStack()
}//end stack()
