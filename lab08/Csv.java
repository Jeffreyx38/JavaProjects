import java.util.*;
import java.io.*;

public class Csv{

	private String word;
	private static String line;
	public static List<String> fields;
	private String separator;
	private BufferedReader br;

	public Csv(String f, String sep){
		try{
			word = "";
			separator = sep;
			br = new BufferedReader(new FileReader(f));
			line = "";
			//fields = new ArrayList<String>();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}


	public boolean getline(){
		try{
			fields = new ArrayList<String>();
			line = br.readLine();
			//System.out.println(line);
			if (line == null) {
				return false;
			}else {
				int n = split(line);
				ArrayList<String> remcomfields = new ArrayList<String>();
				for (String str : fields){
					if (str != ""){
						if (str.substring(str.length()-1).equals(",")){
							str = str.substring(0,str.length()-1);
							remcomfields.add(str);
						}else{
							remcomfields.add(str);
						}
					}
				}
				fields = new ArrayList<String>(remcomfields);	
				return true;
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}

	public int split(String linec){
        	int i;
		int j = 0;
        
        	int nfield = 0;
        	if (linec.length() == 0){
            		return 0;
        	}	
        	i = 0;
        	do{
            		if (i < linec.length() && linec.charAt(i) == '"'){
				j = advquoted(linec, ++i);
            		}else if (i < linec.length()){
                		j = advplain(linec, i);
            		}
            	            		nfield++;
            		i = j + 1;
        	}while (j < linec.length() - 1);
        	//System.out.println(j);
        	return nfield;
        
        
        

	}

	private int advquoted(String lin, int count){
        

        	int j;
		int k = lin.length() - 2;
        	word = "";
        	for ( j = count; j < lin.length() - 1; j++ ){
			if (String.valueOf(lin.charAt(j)).equals("\n")){
				return j;
			}
            		if (lin.charAt(j) == '"' && lin.charAt(j + 1) != '"'){
                		char[] c = lin.toCharArray();
                		for (int i = j; i < c.length; i++){
					//System.out.println(String.valueOf(c[i]));
                    			if (String.valueOf(c[i]).equals(separator)){
                        			k = i;
						//System.out.println("Value of K:" + k);
                        			break;
                    			}
                		}
                		if (k > lin.length()){
                    			k = lin.length();
                		}
				//System.out.println(k);
				//System.out.println(j);
                		for (k = k - j; k > 0; k--){
					//System.out.println(j);
                    			word += lin.charAt(++j);
					//System.out.println(word);
                		}
				//System.out.println(word);
                		break;
            		}
			word += lin.charAt(j);
			//System.out.println(word);
        	} 
		fields.add(word);
        	return j;
		}
    
    private int advplain(String lin, int k){
        int j = 0;
        char[] c = lin.toCharArray();
        for (int i = k; i < c.length; i++){
            if (String.valueOf(c[i]).equals(separator)){
		//System.out.println(i);
                j = i;
                break;
            }
        }
        if (j > lin.length() || j == 0){
            j = lin.length();
        }
        word = lin.substring(k,j);
	fields.add(word);
        return j;
    }

	public int nooffields(){
		return fields.size();
	}

	public String getfield(int n){
		return fields.get(n);
	}

	public static void main(String[] args){
		Csv csv = new Csv("test.csv", ",");
		while (csv.getline() == true){
			System.out.println(line);
			//System.out.println(csv.nooffields());
			for (String str: fields){
				System.out.println(str);
			}
		}

	}
}

