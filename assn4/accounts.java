/**
 * Jefferson
 * Last edited: 12/12
 *
 * Notes:
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 * class to help us sort by name
 */
class SortByName implements Comparator<customer> {
    @Override
    public int compare(customer o1, customer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

/**
 * Class to help us sort by account name
 */
class SortById implements Comparator<customer> {
    @Override
    public int compare(customer o1, customer o2) {
        return o1.getaccNum().compareTo(o2.getaccNum());
    }
}

public class accounts {
    private static String input;
    //private static String first_line;
    //private static  ArrayList<customer> unique_cus = new ArrayList<customer>();

    /**
     * This method reads from file and creates user account for each line of entry
     * @param line
     * @param fileReader
     * @return
     */
    public static List<customer> createCustomer(String line, BufferedReader fileReader) {
        List<customer> list = new ArrayList<>();
        try {
            //read until line is null
            //split each line and pass to new customer object(id, account, data, type, amount)
            while (line != null) {
                String[] words = line.split(":");
                customer temp = new customer(words[0], words[1], words[2], words[3], Float.parseFloat(words[4]));
                list.add(temp);
                line = fileReader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e);
        }
        //return list
        return list;
    }//end createCustomer

    /**
     * Print the info for user
     * -Account #
     * -Name
     * -Balance
     * @param userInput
     * @param sortedList
     * @param sortedByName
     */
    public static void printInfo(int userInput, List<customer> sortedList, List<customer> sortedByName){

        //print details
        String info = sortedList.get(userInput-1).getaccNum();
        String name = sortedList.get(userInput-1).getName();
        System.out.println("\n \t account #:  " + info);
        System.out.println("\t      name:  " + name);
        //calls palance method to print current balance
        printBalance(info, sortedByName);
        System.out.println();


    }//end info

    /**
     * Prints the balance of each account
     * @param accNum
     * @param sortedByName
     */
    public static void printBalance(String accNum, List<customer> sortedByName)
    {
        float balance= (float) 0.00;
        for(int i=0; i<sortedByName.size(); i++)
        {
            if(sortedByName.get(i).getaccNum().equals(accNum))
            {
                if(sortedByName.get(i).gettype().equals("D") ||
                        sortedByName.get(i).gettype().equals("d"))
                {
                    balance+=sortedByName.get(i).getamount();
                }
                else if(sortedByName.get(i).gettype().equals("W") || sortedByName.get(i).gettype().equals("w"))
                {
                    balance-=sortedByName.get(i).getamount();
                }
            }
        }
        System.out.println("\t   balance:  $" + balance + "\n");
    }//End printBalance

    /**
     * Display an enumerated, alphabetical list of account holders†, followed by the account number
     * @param sortedList
     * @param sortedByName
     */
    public static void userInfo(List<customer> sortedList, List<customer> sortedByName)
    {

        int userInput = 0;

        String quit = "";

        //loop until user enters q
        //Displays list of account details
        while( !(quit.equals("q")))
        {

            for(int i=0; i<sortedList.size(); i++)
            {
                System.out.print(i+1 + ") ");
                sortedList.get(i).printinfo();
            }
            System.out.println("q)uit");

            System.out.print("\nEnter choice => ");

            Scanner sc2 = new Scanner(System.in);

            quit = sc2.nextLine();

            //do not enter if user input is "q"
            if (!(quit.equals("q"))){
                    //if an integer, call print method
                    //method prints balance, accout name, and account id
                    userInput = Integer.parseInt(quit);
                    printInfo(userInput, sortedList, sortedByName);
            }


        }


    }

    /**
     * List all the transactions for a picked account,
     * in chronological order
     * Prints, on one line, the date, the type (deposit or withdrawal), and the amount
     * @param userInput
     * @param sortedList
     * @param sortedByName
     */

    public static void printHistory(int userInput, List<customer> sortedList, List<customer> sortedByName){


        String accNum =sortedList.get(userInput-1).getaccNum();

        for(int i=0 ; i< sortedByName.size(); i++)
        {
            if(sortedByName.get(i).getaccNum().equals(accNum))
            {
                sortedByName.get(i).printhistory();
            }
        }
        System.out.print("\n");
    }

    /**
     * Display an enumerated, alphabetical list of account holders†, followed by the account number
     * @param sortedList
     * @param sortedByNameList
     */
    public static void userHistory(List<customer> sortedList, List<customer> sortedByNameList)
    {

        int userInput = 0;

        String quit = "";

        while( !(quit.equals("q")))
        {

            for(int i=0; i<sortedList.size(); i++)
            {
                System.out.print(i+1 + ") ");
                sortedList.get(i).printinfo();
            }
            System.out.println("q)uit");

            System.out.print("\nEnter choice => ");

            Scanner sc2 = new Scanner(System.in);

            quit = sc2.nextLine();

            if (!(quit.equals("q"))){
                userInput = Integer.parseInt(quit);
                printHistory(userInput, sortedList, sortedByNameList);
            }

        }

    }

    /**
     * Simple usage message for the user
     */
    public static void usageMsg()
    {
        System.out.println("Usage info:");
        System.out.println("-i : Displays information account menu.");
        System.out.println("-h : Displays history account menu. ");
        System.out.println("-t : Displays transaction account menu.");
        System.out.println("-? : Displays the usage message.\n");
        System.exit(0);
    }//End mesageMsg()


    /**
     * user Transaction needed to be complete
     */
    public static void userTransaction(){
        System.out.println("This method needs implementation :( !");
    }

    /**
     * Switch method for user preferance
     * @param argv
     * @param sortedList
     * @param sortedByNameList
     */
    public static void userSwitch(String[] argv, List<customer> sortedList, List<customer> sortedByNameList){

        switch (argv[0])
        {
            case "-i" : userInfo(sortedList, sortedByNameList);
                break;
            case "-h" : userHistory(sortedList, sortedByNameList);
                break;
            case "-t" : userTransaction();
                break;
            case "-?" : usageMsg();
                break;
            default : System.out.println("Invalid Argument");
                System.exit(0);
        }
    }

    /**
     * Reads from file to a list, sort the list by name,
     * then by account name, and then eliminate repeated elements
     * Finally pass user argument, sorted list and sorted list by name to user switch
     * @param argv
     */
    public static void main (String[] argv){

        try {

	    String file = System.getenv().get("ACCT_LIST");
            //reads from file
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String line = fileReader.readLine();

            //unsorted list from  file
            List<customer> unsortedList = createCustomer(line, fileReader);

            List<customer> sortedByNameList;


            //sorted by name
            Collections.sort(unsortedList, new SortByName());
            sortedByNameList = unsortedList;

            //sort by id
            Collections.sort(sortedByNameList, new SortById());
            List<customer> sortedList = new ArrayList<>(sortedByNameList);

            //map used to delete duplicates element based on user ID
            Map<String, customer> map = new LinkedHashMap<>();
            for(customer id: sortedList){
                map.put(id.getaccNum(), id);
            }
            sortedList.clear();
            sortedList.addAll(map.values());

            //if no argument print usagemsg
            if(argv.length==0)
            {
                usageMsg();
                System.exit(0);
            }
            //call user switch
            userSwitch(argv, sortedList, sortedByNameList);



        } catch (IOException e) {
            System.out.println(e);
        }


    }//end main()
}

