import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RAND {
	char[] arr;
	private int rows = Table.pubRows;
	private int length = Table.pubLength;
	char[][] tableSlots = new char[rows][length];
	List<Character> active = new ArrayList<Character>(); //the current pages that are active [0] would be the first in
	Map<String, String> map = new HashMap<String, String>(); //keeps track of what row the active pages are in
	
	public RAND(char[] arr){
		this.arr = arr;
	}
	public void MainRand(){
		int x = 0;
		for(int i = 0; i<arr.length; i++,x++){
						
			if(x > rows - 1){x = 0;} //x is keeping track of the rows
			
			
			if(!map.containsKey(Character.toString(arr[i]))) //if this is a new page
			{
				newPage(arr, i, x);				
				continue;
			}
			else if(map.containsKey(Character.toString(arr[i]))){ // not a new page ( page hit)
				String newtemp = map.get(Character.toString(arr[i]));
				tableSlots[Integer.valueOf(newtemp)][i] = "+".charAt(0);
				x--;
				
				
			}
			
		}
		
		System.out.println( "Ref Str: " + Table.pattern);
		int n = 1;
		for(char[] row : tableSlots) {
			System.out.print("RAND " + n + ": ");
			n++;
            printRow(row);
        }
	}
	
	//so i can search hash map by value
	public static Object getKeyFromValue(Map<String, String> hm, Object value) {
	    for (Object o : hm.keySet()) {
	      if (hm.get(o).equals(value)) {
	        return o;
	      }
	    }
	    return null;
	  }
	
	public void newPage(char[] arr, int i, int x){
		//if there is now row which has not been filled yet
		if(active.size() > (rows - 1)){ 

			//randomly selects a number which will choose random letter from active list
			Random rand = new Random();
			int  n = rand.nextInt(rows);
			
			String temp = (String) getKeyFromValue(map,map.get(Character.toString((char) active.get(n))));
			map.put(Character.toString(arr[i]) , map.get(temp));
			map.remove(temp);
			active.remove(n);
			active.add(arr[i]);
			String newtemp = map.get(Character.toString(arr[i]));
			tableSlots[Integer.valueOf(newtemp)][i] = arr[i];
		//if there is still an empty row	
		}else{
			tableSlots[x][i] = arr[i];
			active.add(arr[i]); 
			map.put(Character.toString(arr[i]), Integer.toString(x));
		}	
	}
	
	 public static void printRow(char[] row) { //format printing
	        for (char i : row) {
	        	if(i == 0){
	        		System.out.print("*");
	        		System.out.print("\t");
	        	}else{
	        		System.out.print(i);
		            System.out.print("\t");
	        	}
	            
	        }
	        System.out.println();
	    }
	
	
}

