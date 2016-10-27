/*
//Jefferson
//this class is the implemenation of the employee object
//It contains: keyId, FirstName, LastName, State, City, ZipCode, Specialty, and phoneNum
//all the fields are set to private 
//it uses accesors and mutators to retrive data that is private
 */
package linkedlistemployee;

/**
 *
 * @author Jefferson
 */
public class Employee {
    //employee fields 
    private String keyId;
    private String firstName; //the first name of the employee
    private String lastName; //the last name of the employee
    private String state; //the state where the employee is residing 
    private String city; //the city where the employee is residing
    private int zipCode; //the zip node of the employee
    private String specialty; // field of study
    private String phoneNum; //phone number of the employee

    //employee constructor 
    public Employee() {
    }//end employee

    //accesors and mutators for each property
    public String getKeyId() {
        return keyId;
    }//end getFirstName

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }//end setFirstName

    public String getFirstName() {
        return firstName;
    }//end getFirstName

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }//end setFirstName

    public String getLastName() {
        return lastName;
    }//end getLastName

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }//end setLastName

    public String getState() {
        return state;
    }//end getState

    public void setState(String state) {
        this.state = state;
    }//end setState()

    public String getCity() {
        return city;
    }//end getCity()

    public void setCity(String city) {
        this.city = city;
    }//end setCity()

    public int getZipCode() {
        return zipCode;
    }//end getZipCode()

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }//end setZipCode()

    public String getSpecialty() {
        return specialty;
    }//end getSpecialty()

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }//end setSpecialty()

    public String getPhoneNum() {
        return phoneNum;
    }//end getPhoneNum()

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }//end setPhoneNum()

    //Overriding toString to be able to print out the object in a readable way
    //toString to append the list as one object
    @Override
    public String toString() {
        //creates a object buffer
        StringBuilder buffer = new StringBuilder();
        buffer.append("\t");
        buffer.append(keyId);
        buffer.append(" ");
        buffer.append(firstName);
        buffer.append(" ");
        buffer.append(lastName);
        buffer.append(" ");
        buffer.append(city);
        buffer.append(", ");
        buffer.append(state);
        buffer.append(" ");
        buffer.append(zipCode);
        buffer.append(" Spt: ");
        buffer.append(specialty);
        buffer.append(" Tel: ");
        buffer.append(phoneNum);
        buffer.append(" ");
        //returns buffer
        return buffer.toString();
    }//end toString()

}//end employee()
