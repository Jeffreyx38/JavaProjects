/**
 * Class to create  customer object 
 * @param <customer>
 */


public class customer <customer>{
	private String name;
	private String accNum;
	private String date;
	private String type;
	private float amount;


	/**
	 * Customer constructor
	 * @param accNum
	 * @param name
	 * @param date
	 * @param type
	 * @param amount
	 */
	public customer(String accNum, String name, String date, String type, float amount) {
		super();
		this.accNum = accNum;
		this.name = name;
		this.date = date;
		this.type = type;
		this.amount = amount;
	}
	//history of account
	public void printhistory()
	{
		System.out.print("\t" + date + " " );
		if(type.equals("D"))
		{
			System.out.print("deposit");
		}
		else if(type.equals("W"))
		{
			System.out.print("withdrawal");
		}
		System.out.print(" $" + amount + "\n");
	}


	//helpful methods
	public void printinfo()
	{
		System.out.println(name + " " + accNum);
	}
	public String getName()
	{
		return name;
	}
	public String getaccNum()
	{
		return accNum;
	}
	public String gettype()
	{
		return type;
	}
	public float getamount()
	{
		return amount;
	}
	public String getDate()
	{
		return date;
	}


	/**
	 * tostring
	 * @return
	 */
	@Override
	public String toString() {
		return getaccNum() + " " +  getName() + " "+ getDate() + " " +  gettype() + " " + getamount();
	}//end toString
}//end customer
