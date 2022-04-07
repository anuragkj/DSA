import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws FileNotFoundException{
		Hashtable<Integer, ArrayList<String>> hash = new Hashtable<Integer, ArrayList<String>>();
		ArrayList<String> mod0 = new ArrayList<String>();
		ArrayList<String> mod1 = new ArrayList<String>();
		ArrayList<String> mod2 = new ArrayList<String>();
		ArrayList<String> mod3 = new ArrayList<String>();
		ArrayList<String> mod4 = new ArrayList<String>();
		ArrayList<String> mod5 = new ArrayList<String>();

		Scanner readMyFile = new Scanner(new File("source.txt"));
		while(readMyFile.hasNext()){
		    String data = readMyFile.next();
		    int digitsum = 0;
		    int alphasum = 0;
		    for(int it = 0; it < data.length(); it++){
		        char ch = data.charAt(it);
		        if (Character.isAlphabetic(ch)) {
		            alphasum += (int) ch;
		        }
		        else if (Character.isDigit(ch)){
		            digitsum += (int) ch;
		        }
		    }
		    int hash_value = ((alphasum + 2 * digitsum) * 17 +5)%6;
		    System.out.println("The Hash value of "+data+" is "+hash_value);
		    if (hash_value == 0){mod0.add(data);}
		    else if (hash_value == 1){mod1.add(data);}
		    else if (hash_value == 2){mod2.add(data);}
		    else if (hash_value == 3){mod3.add(data);}
		    else if (hash_value == 4){mod4.add(data);}
		    else if (hash_value == 5){mod5.add(data);}
		}
		System.out.println("============================================================================================");
		hash.put(0, mod0);
		hash.put(1, mod1);
		hash.put(2, mod2);
		hash.put(3, mod3);
		hash.put(4, mod4);
		hash.put(5, mod5);
		for(int k = 0; k<=5; k++){
		    System.out.println("The subset of " + k +" : "+hash.get(k).toString());
        	}
		readMyFile.close();
	}
}
