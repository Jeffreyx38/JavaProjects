/*
 *Jefferson StackElement Class
 *This is the StackElement class of the stacks class as an outer class
 *This class acts as a data holder 
 *Both data and next are set to private for security risks 
 *Accesors and mutators are set to retrive data
 *This class works simultaneously witht the stacks class
 *
 */
package stackapplication;

/**
 *
 * @Jefferson
 */
public class StackElement {

    //data carried by the the node
    private String data;
    //reference to the next node in the list
    private StackElement next;

    //node constructor 
    public StackElement() {

    }//end StackElement()
    // StackElement constructor

    public StackElement(String dataValue) {
        this.next = null;
        this.data = dataValue;
    }//end StackElement()

    public StackElement(String dataValue, StackElement nextValue) {
        this.data = dataValue;
        this.next = nextValue;
    }//end StackElement()

    public void setData(String dataValue) {
        data = dataValue;
    }//end setData()

    public String getData() {
        return data;
    }//getData()

    public void setNext(StackElement nextValue) {
        next = nextValue;
    }//end setNext()

    public StackElement getNext() {
        return next;
    }//end getNext()
}//end StackElement()
