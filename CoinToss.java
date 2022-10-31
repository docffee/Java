import java.util.Random;
import java.util.Scanner;

public class CoinToss {
	private int heads;
	private int tails;
	
	// class constructor Coin initialize heads and tails to 0
	CoinToss() {
		heads = 0;
		tails = 0;
	}
	
	public static void main(String[] args) {
		/* 
		 * Coin Toss game to output winning total heads or tails
		 * Alvin Long
		 * uses Random and Scanner packages
		 */
		
		CoinToss coin = new CoinToss();			// new coin instance of class CoinToss
		int tosses = getTosses();			// call getTosses to get user input
		coin.heads = countTosses(tosses);	// set heads attribute
		coin.tails = tosses - coin.heads;	// set tails attribute
		checkWin(coin);
	}

	public static int getTosses() {
		// scan in user input for number of coin flips
		int tosses;
		// Scan user input 
		System.out.printf("Enter Number of Tosses:\n");
		Scanner myint = new Scanner(System.in);
		// Try-Catch block to set default for type error
		try {	
			tosses = myint.nextInt();
		}
		catch (Exception e){
			System.out.printf("Type Error! Number of Tosses Set to Default: 10\n");
			tosses = 10;
		}
		myint.close();
		return tosses;
	}
	
	public static int countTosses(int num) {
		// executes random coin flip by number of tosses returns heads count
		int tmp = 0, count = 0; 
		Random rand = new Random();
		for (int i=1;i<num+1;i++) {
			tmp = rand.nextInt(2)+1;
			if (tmp == 1) {
				count+=1;
				System.out.println("Heads");
			}
			else {
				System.out.println("Tails");
			}
		}
		return count;
	}
	
	public static void checkWin(CoinToss coin) {
		// print winning toss
		System.out.printf("HEADS: %d, TAILS: %d\n", coin.heads, coin.tails);
		if (coin.heads > coin.tails) {
			System.out.println("Winner is HEADS");
		}
		else if (coin.heads == coin.tails) {
			System.out.println("No Winner TIE");
		}
		else {
			System.out.println("Winner is TAILS");
		}
	
	}
}
