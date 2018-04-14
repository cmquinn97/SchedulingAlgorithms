import java.util.Random;
import java.util.Scanner;


public class Main {
	 static char[] pattern = Table.CreatePattern();

	public static void main(String[] args) {
		LRU lru = new LRU(pattern);
		lru.MainLru();
		FIFO fifo = new FIFO(pattern);
		fifo.MainFifo();

	}
	

}
