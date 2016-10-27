/*
 *Jefferson QueueElement Class
 *This is the QueueElement class of the queue class as an outer class
 *This class acts as a data holder 
 *Both data and next are set to private for security risks 
 *Accesors and mutators are set to retrive data
 *This class works simultaneously witht the queue class
 *
 */

package queueimplementation;

/**
 *
 * @author Jefferson
 */
public class QueueElement {

    //data carried by the the node
    private Employee data;
    //reference to the next node in the list
    private QueueElement next;

    //node constructor 
    public QueueElement() {

    }//end QueueElement()
    // QueueElement constructor

    public QueueElement(Employee dataValue) {
        this.next = null;
        this.data = dataValue;
    }//end QueueElement()

    public QueueElement(Employee dataValue, QueueElement nextValue) {
        this.data = dataValue;
        this.next = nextValue;
    }//end QueueElement()

    public void setData(Employee dataValue) {
        data = dataValue;
    }//end setData()

    public Employee getData() {
        return data;
    }//end getData

    public void setNext(QueueElement nextValue) {
        next = nextValue;
    }//end setNext

    public QueueElement getNext() {
        return next;
    }//end getNext
}//End QueueElement()
