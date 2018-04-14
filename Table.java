import java.util.Random;
import java.util.Scanner;

public class Table {

	public static int pubLength, pubRows;
	public static String pattern;
	static Scanner kb = new Scanner(System.in);
	
	public static char[] CreatePattern(){
		System.out.println("Enter page reference pattern length: ");
		int length = kb.nextInt();
		pubLength = length;
		System.out.println("Enter number of unique pages: ");
		int unique = kb.nextInt();
		System.out.println("Enter number of rows: ");
		int rows = kb.nextInt();
		pubRows = rows;
		
		return CharString(length, unique);
		
		
	}
	
	
	public static char[] CharString(int length, int unique) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newChars = chars.substring(0, Math.min(chars.length(), unique));
        StringBuilder build = new StringBuilder();
        Random rnd = new Random();
        while (build.length() < length) { 
            int index = (int) (rnd.nextFloat() * newChars.length());
            build.append(newChars.charAt(index));
        }
        String theString = build.toString();
        pattern = theString;
        return theString.toCharArray();

    }
}
