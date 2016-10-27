/*
 //Jefferson LinedList
 //This class links all the node data together with pointers 
 //It has only a head and next property
 //within this class, we have the add method which 
 //appends a new incoming node to the list
 //this class also has all the operations to add & link nodes respectively
 //It has the following operations: checkEmpty(), getData(), traverse(),
 //findSize(), insertBefore(), insertAfter(), prependHead(), appendLast(), 
 //deleteHead(), deleteLast(), deleteBefore(), deleteAfter(), shallowClone(),
 //deepCloning(), compareToMethod()
 */
package linkedlistemployee;

/**
 *
 * @author Jefferson
 */
public class LinkedList {

    private Node head; //node head
    private int listCount; //variable for size count

    //sets head as null
    LinkedList() {
        this.head = null; //head is set to null
        listCount = 0; //starting listCount
    }//end LinkedList()

    /**
     * ************************************************************
     * This operation returns the number of elements in the list  *
     * ************************************************************
     * @return
     */
    public int size() {
        return listCount;
    } // end size()

    /**
     * *************************************************************
     * This operation returns a boolean value if the list is empty *
     * ************************************************************* 
     * @return
     */
    public boolean isEmpty() {
        return (head == null); //if head is null return boolean value
    }//end isEmpty()

    /**
     * ***********************************************************************
     * This operation adds a node to the list and appends the new object data*
     * **********************************************************************
     * @param data
     */
    //appends the new object node to the end of the list
    public void addNewNode(Employee data) {
        Node tempLink = new Node(data); //creates a new node in the list

        if (head == null) { //checks if head is null
            head = tempLink; //sets head pointer to new node if head is null
        } //end if()
        else {//otherwise; if head is not null
            Node currentLink = head; //create a new pointer set to head

            //traverses through the link list until null is found
            while (currentLink.getNext() != null) {
                //crawls to the end of the list and sets current pointer to getNext()
                currentLink = currentLink.getNext();
            }// end while
            //the last node's "next" reference is set to our new node
            currentLink.setNext(tempLink);
            
        }//end else()
        
        //increment the number of elements in the list
        listCount++;
    }//end addNewNode()

    /**
     * ****************************************************************
     * This operation returns data from a specific node in the list*
     * It uses the key employee ID number to return the underlying data type*
     * **************************************************************** 
     * key
     * @param key
     * @return
     */
    public Object getData(String key) // returns the data at the spesified position
    {
        if (head == null) // if head is null
        {
            return null; //return null
        }//end if()
        //sets currentLink to the pointer after head
        Node currentLink = head.getNext();
        //traverses until key ID is found
        while ((currentLink.getNext().getData().getKeyId().equals(key))) {
            //if currentLink next is null return null
            if (currentLink.getNext() == null) {
                return null;
            }//end if()
            //else get currentLink from currentLink next
            currentLink = currentLink.getNext();
        }//end while()
        //return the target data
        return currentLink.getData();

    } // end getdata()

    /**
     * ******************************************************
     * This operation access all nodes in the list in order * It prints key data
     * for each element * ******************************************************
     */
    public void traverseList() {
        Node currentLink = head; //create another name for head
        //traverse through the list until null is reach
        while (currentLink != null) { //check if the given node is empty 
            System.out.println(currentLink.getData().toString());//print the traversed data
            currentLink = currentLink.getNext();

        }//end while()

    }//end traverseList()

    /**
     * ***************************************************************************
     * This operation inserts a node in the list before a specified element *
     * The operation accepts a person object data and a specific key ID location *
     * ****************************************************************************
     * @param key
     * @param testPerson
     */
    public void insertBefore(String key, Employee testPerson) {
        Node tempLink = new Node(testPerson); //create a new node
        Node currentLink = head; //sets currentLink to head
        Node previous = null; //sets previous to null
        //traverses until to find key Id targer
        while (!((currentLink.getData().getKeyId()).equals(key))) {
            //crawl the list one after another
            previous = currentLink;
            currentLink = currentLink.getNext();
        }
        //correct the right pointers
        //tempLink node pointer is set to currentLink
        tempLink.setNext(currentLink);
        //previous is set to tempLink
        previous.setNext(tempLink);
        //increment count
        listCount++;

    }//end insertBefore()

    /**
     * ****************************************************************************
     * This operation inserts a node in the list after a specified element        *
     * The operation accepts a person object data and a specific key ID location  *
     * ****************************************************************************
     * @param key
     * @param TestPerson
     */
    public void insertAfter(String key, Employee TestPerson) {
        Node tempLink = new Node(TestPerson); //create a new node
        Node currentLink = head; //sets currentLink to head
        //traverses until key ID is found
        while (!((currentLink.getData().getKeyId()).equals(key))) {
            currentLink = currentLink.getNext();
        }
        //sets tempLink reference to currentLink next
        tempLink.setNext(currentLink.getNext());
        //sets currentLink pointer to tempLink
        currentLink.setNext(tempLink);
        //increment count
        listCount++;
    }//end insertBefore()

    /**
     * *****************************************************************
     * This operation appends a node after the last element in the list*
     * ***************************************************************** 
     * 
     * @param data
     */
    public void addtoLast(Employee data) 
    {
        //if the list is empty
        if (head == null) {
            head = new Node(data);

        } //end if
        //else if the list isn't empty
        else {
            //look for the last item of the list
            Node tempLink = new Node(data);
            Node currentLink = head;

            // starting from the head, and moving to the end of the list
            while (currentLink.getNext() != null) {
                currentLink = currentLink.getNext();
            }//end while
            currentLink.setNext(tempLink); //set the last node pointer to the new node
            listCount++; // increment listCount
        }//end else()
    }//end addToLast() 

    /**
     * ******************************************************************
     * This operation appends a node after the first element in the list*
     * ****************************************************************** 
     *
     * @param data
     */
    public void addFirst(Employee data) {
        head = new Node(data, head); //prepens new node 
    }//end addFirst()

    /**
     * ********************************************
     * This operation deletes the head of the list*
     * ********************************************
     */
    public void deleteHead() {
        head = head.getNext();//links the node after first as the new head
        listCount--; //decrement the number of elements variable

    }//end deleteHead()

    /**
     * ****************************************************
     * This operation deletes the last element of the list*
     * ****************************************************
     */
    public void deleteLast() {
        Node currentLink; //create currentLink
        Node previous = null; //previous set to null
        //if head is not null
        if (head != null) {
            //set currentLink to head
            currentLink = head;
            //crawl over the list until is not null
            while (currentLink.getNext() != null) {
                previous = currentLink;
                currentLink = currentLink.getNext();
            }
            //sets previous to next null
            previous.setNext(null);
            listCount--; //decrement the number of elements variable
        }//end if

    }//deleteLast()

    /**
     * *****************************************************************************
     * This operation deletes a node in the list before a specified element        *
     * It uses the key id number of the employee to delete before specified element*
     * *****************************************************************************
     * @param key
     */
    public void deleteBefore(String key) {
        Node currentLink = head;
        //traverses until the key ID target is found
        while (!((currentLink.getNext().getNext().getData().getKeyId().equals(key)))) {
            currentLink = currentLink.getNext();
        }//end while()
        //sets the right pointers to currentLink to after currentLink
        currentLink.setNext(currentLink.getNext().getNext());
        //decrement list count
        listCount--;
    }//end deleteBefore()

    /**
     * ****************************************************************************
     * This operation deletes a node in the list after a specified element        * 
     * It uses the key id number of the employee to delete after specified element*
     * ****************************************************************************
     * @param key
     */
    public void deleteAfter(String key) {
        //currentLink is set to head
        Node currentLink = head;
        //traverses until the key ID target is found
        while (!((currentLink.getData().getKeyId()).equals(key))) {
            currentLink = currentLink.getNext();
        }
        //sets currentLink point to after currentlink link
        currentLink.setNext(currentLink.getNext().getNext());
        listCount--;
    }//end deleteAfter

    /**
     * *******************************************************
     * This operation shallow clones the existing link list  * 
     * It clones the list without cloning the underlying data*
     * ******************************************************* 
     * @param list
     * @return
     */
    public LinkedList clone(LinkedList list) {
        return list; //returns list
    }//end clone

    /**
     * *******************************************************
     * This operation deep clones the existing link list     *
     * It clones the underlying data of the object           *
     * *******************************************************
     * @return
     */
    public Object deepClone() // deep copy method
    {
        LinkedList newList = new LinkedList(); //creates a new link list object
        Node currentLink = head;
        while (currentLink != null) // while head pointer is not null
        {
            newList.addtoLast(currentLink.getData()); // add the data to the last element into the new list
            currentLink = currentLink.getNext(); // do it over
        } // end for
        return newList; //returns new list
    }//end deepClone()

    /**
     * *************************************************************************
     * This operation compares the head of the original list & deep cloned List*
     * It will return a boolean statement if true or false *
     * *************************************************************************
     * @param newList
     * @param clonedList
     * @return
     */
    public boolean compareToList(LinkedList newList, LinkedList clonedList) {
        Node first = newList.head; // set first node as head
        Node second = clonedList.head; // set second node as head
        //if first & second node are not empty contunie 
        while (first != null && second != null) {
            //if the first & second nodes are not the same turn false
            if (first.getData() != second.getData()) {
                return false;
            }//end if
            //else get the next nodes after head
            else {
                first = first.getNext();
                second = second.getNext();
            }//end else()
        }//end while()
        //if first and second are null, therefore they are identical
        return first == null && second == null; // end else
    } // end compareToList()

}//end LinkedList()
