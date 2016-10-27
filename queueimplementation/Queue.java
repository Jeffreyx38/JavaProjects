/*
 //Jefferson queue
 //This class links all the queue nodes together with pointers
 //The queue uses head and next as its only properties 
 //It has the enqueue method to insert new elements to the queue
 //It has the dequeue method to take of the elements from queue--LIFO
 //The class also has methods the prints the size of the queue and
 //it also prints the boolean value if the queue is empty
 */

package queueimplementation;

/**
 *
 * @author Jefferson
 */
class Queue {

    private QueueElement head, tail; //node head and tail

    private int listCount; //variable for size count

    /**
     * ******************
     * Queue constructor* 
     * sets head as null* 
     * sets tail as null*
     * @return queue
     */
    Queue() {
        this.head = null; //head is set to null
        this.tail = null; //tail is set to null
        listCount = 0; //starting listCount
    }//end LinkedList()

    /**
     * *************************************************************
     * This operation returns a boolean value if the list is empty
     *
     * ************************************************************* @return
     */
    public boolean isEmpty() {
        return head == null;
    }//end isEmpty()

    /**
     * ************************************************************
     * This operation returns the number of elements in the list
     *
     * ************************************************************ @return
     */
    public int size() {
        return listCount;
    } // end size()

    /**
     * ***********************************************
     * This operation enqueues the object data -tail *
     * ***********************************************
     *
     * @param enqueue
     */
    public void enqueue(Employee data) {
        //creates a new node called current link
        QueueElement currentQueue = new QueueElement(data, null);
        //if tail is null proceed 
        if (tail == null) {
            head = currentQueue; //set current to head 
            tail = currentQueue; //set current to tail
        } else { //else
            tail.setNext(currentQueue); //set next node to current link
            tail = tail.getNext(); //adjust the pointers 
        }
        //increment the number of elements in the list
        listCount++;

    }//end enqueue()

    /**
     * *******************************************************************
     * This operation dequeue the object data from the head of the queue *
     * *******************************************************************
     *
     * @param dequeue
     */
    public Employee dequeue() {
        //checks if the queue is emyty before processing 
        if (isEmpty()) {
            System.out.println("The queue is empty.");
        }
        //sets head pointer to currentQueue
        QueueElement currentQueue = head;
        //head is set to current link next pointer
        head = currentQueue.getNext();
        //if head is null
        if (head == null) {
            tail = null; //tail should be null
        }
        //decrement the number of elements in the list
        listCount--;
        //returns the dequeue data
        return currentQueue.getData();

    }//end dequeue()

    /**
     * ******************************************************
     * This operation access all nodes in the queue in order* 
     * It prints the key data for each element-FIFO         *
     * ******************************************************
     */
    public void traverseQueue() {
        QueueElement currentQueue = head; //sets a starting point from head
        //traverse through the list until null is reach
        while (currentQueue != null) { //check if the given node is empty 
            System.out.println("\tenqueu: " + currentQueue.getData());//print the traversed data
            currentQueue = currentQueue.getNext();

        }//end while()

    }//end traverseList()
}//end Queue()