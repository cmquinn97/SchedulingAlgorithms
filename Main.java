


public class Main {
	 static char[] pattern = Table.CreatePattern();

	public static void main(String[] args) {
		FIFO fifo = new FIFO(pattern);
		fifo.MainFifo();
		LRU lru = new LRU(pattern);
		lru.MainLru();
		MIN min = new MIN(pattern);
		min.MainMin();
		RAND rand = new RAND(pattern);
		rand.MainRand();

	}
	

}
