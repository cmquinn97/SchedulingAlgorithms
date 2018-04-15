import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	 static char[] pattern = Table.CreatePattern();
	 static List<Float> hitRate = new ArrayList<Float>();

	public static void main(String[] args) {
		FIFO fifo = new FIFO(pattern);
		fifo.MainFifo();
		LRU lru = new LRU(pattern);
		lru.MainLru();
		MIN min = new MIN(pattern);
		min.MainMin();
		RAND rand = new RAND(pattern);
		rand.MainRand();
		
		System.out.println("\n" + "Cache hit rates: ");
		System.out.println("FIFO: " + fifo.hits + " of " + Table.pubLength + " = " + ((float)fifo.hits/Table.pubLength));
		System.out.println("LRU: " + lru.hits + " of " + Table.pubLength + " = " + ((float)lru.hits/Table.pubLength));
		System.out.println("MIN: " + min.hits + " of " + Table.pubLength + " = " + ((float)min.hits/Table.pubLength));
		System.out.println("RAND: " + rand.hits + " of " + Table.pubLength + " = " + ((float)rand.hits/Table.pubLength));
		
		hitRate.add(((float)fifo.hits/Table.pubLength));
		hitRate.add(((float)lru.hits/Table.pubLength));
		hitRate.add(((float)min.hits/Table.pubLength));
		hitRate.add(((float)rand.hits/Table.pubLength));
		
		hitCalc();

		

	}
	
	//I know this is messy but I wanted to finish it up
	public static void hitCalc(){
		Float largest = (float) 0.0;
		Float smallest = (float) 3.0;
		Map<Integer, String> map = new HashMap<Integer, String>(); 
		Map<Integer, String> mapWorst = new HashMap<Integer, String>(); 
		String best = null;
		String worst = null;
		
		int x = 0;
		for(Float i : hitRate){
			if(i > largest){
				map.clear();
				largest = i;
				if(x == 0){
					best = "FIFO";
				}
				if(x == 1){
					best = "LRU";
				}
				if(x == 2){
					best = "MIN";
				}
				if(x == 3){
					best = "RAND";
				}
				map.put(x, best);
			}
			if(i.equals(largest)){
				largest = i;
				if(x == 0){
					best = "FIFO";
				}
				if(x == 1){
					best = "LRU";
				}
				if(x == 2){
					best = "MIN";
				}
				if(x == 3){
					best = "RAND";
				}
				map.put(x, best);
			}
			if(i < smallest){
				smallest = i;
				mapWorst.clear();
				if(x == 0){
					worst = "FIFO";
				}
				if(x == 1){
					worst = "LRU";
				}
				if(x == 2){
					worst = "MIN";
				}
				if(x == 3){
					worst = "RAND";
				}
				mapWorst.put(x, worst);
			}
			if(i.equals(smallest)){
				if(x == 0){
					worst = "FIFO";
				}
				if(x == 1){
					worst = "LRU";
				}
				if(x == 2){
					worst = "MIN";
				}
				if(x == 3){
					worst = "RAND";
				}
				mapWorst.put(x, worst);
			}
			x++;
		}
		
		
		System.out.println("\n" + "Best: " + map.values());
		System.out.println("\n" + "Worst: " + mapWorst.values());
	}
	

}
