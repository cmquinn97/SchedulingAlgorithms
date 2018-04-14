import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FIFO {
	char[] arr = Table.CreatePattern();
	private int rows = Table.pubRows;
	private int length = Table.pubLength;
	char[][] tableSlots = new char[rows][length];
	List<Character> active = new ArrayList<Character>(); //the current pages that are active [0] would be the first in
	Map<String, String> map = new HashMap<String, String>(); //keeps track of what row the active pages are in
	
	public void MainFifo(){
		int x = 0;
		for(int i = 0; i<arr.length; i++,x++){
			
			
			if(x > 2){x = 0;} //x is keeping track of the rows
			
			
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
		System.out.println(Arrays.deepToString(tableSlots).replace("], ", "]\n"));
	}
	
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
		if(active.size() > 2){ 
			String temp = (String) getKeyFromValue(map,map.get(Character.toString((char) active.get(0))));
			map.put(Character.toString(arr[i]) , map.get(temp));
			map.remove(temp);
			active.remove(0);
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
	
	
}
