/*
 *Jefferson Node Class
 *This is the node class of the linkList class as an outer class
 *This class has access to the employee data
 *This class acts as a data holder 
 *Both data and next are set to private for security risks 
 *Accesors and mutators are set to retrive data
 *This class works simultaneously witht the linked list class
 *
*/

package linkedlistemployee;

/**
 *
 * @author Jefferson
 */
public class Node {
    //data carried by the the node
    private Employee data;
    //reference to the next node in the list
    private Node next;

    //node constructor 
    public Node() {

    }//end Node()
    // Node constructor

    public Node(Employee dataValue) {
        this.next = null;
        this.data = dataValue;
    }//end Node()

    public Node(Employee dataValue, Node nextValue) {
        this.data = dataValue;
        this.next = nextValue;
    }//end Node()

    public void setData(Employee dataValue) {
        data = dataValue;
    }//end setData()

    public Employee getData() {
        return data;
    }//end getData()

    public void setNext(Node nextValue) {
        next = nextValue;
    }//end setNext()

    public Node getNext() {
        return next;
    }//end getNext()

}//end Node()