import java.util.Date;

public class prob4 
{
	
	public static void main( String[] args) 
	{
		int numbers = Integer.parseInt(args[0]);
		Date currentDay = new Date();
		long milliseconds = currentDay.getTime();

		switch (numbers) 
		{
			case 0:
				System.out.println("milliseconds since January 1,1970:  " + milliseconds);
				break;
			case 1:
				System.out.println("seconds since January 1, 1970:  " + milliseconds/1000);
				break;
			case 2:
				int days = (int)(milliseconds / (1000*60*60*24));
				System.out.println("days since January 1, 1970:  " + days);
				break;
			case 3:
				System.out.println("current date and time:  " + currentDay.toString());
				break;
		}
	}
}
