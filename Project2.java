import java.util.Scanner;
import java.util.Timer;
import java.util.Random;
import java.util.TimerTask;

public class Project2 {
	public static void main(String[] args) {
		/*
		Game where player guesses a number between 0 and 20
		7 second time limit
		Uses Scanner, Timer, Random, TimerTask
		*/
		
		// Initialize game parameters
		int i, guess = 0;
		Random rand = new Random();
		int randnum = rand.nextInt(21); // Random number from 0 to 20
		int attempts = (rand.nextInt(2)+1) * 5; // 5 or 10 guesses
		
		// Opening statement
		System.out.printf("Player has %d attempts to guess a number ranged 0 to 20 within 7 seconds.\n", attempts);
		Scanner myint = new Scanner(System.in);
		
		// Exit program after 7 seconds with closing remarks and results
		Timer t = new Timer();
		t.schedule(new TimerTask() {
			public void run() {
				System.out.println("Time's Up! You Lose!!!");
				System.out.printf("\nGame Over.\nRandom number is: %d", randnum);
				System.exit(0);
			}
		 }, 7000);		
		
		// Begin game
		for (i=0;i<attempts;i++){
			
			// Try-Catch block to exit loop if invalid entry
			try {
				System.out.println("Enter User Guess: ");
				guess = myint.nextInt();
			}
			catch (Exception e) {
				System.out.println("Expected integer.");
				System.out.println("\nYOU LOSE!");
				t.cancel();
				break;
			}
			
			// Winning statement and break out from loop
			if(guess == randnum) {
				System.out.println("\nWINNER!!!");
				t.cancel();
				break;
			}
			// Wrong number within attempts
			else {
				System.out.println("Wrong!");
				// Help player find number higher or lower
				if (guess > randnum) {
					System.out.println("Lower");
				}
				else {
					System.out.println("Higher");
				}
			}
		}
		
		// Player exhausts attempts within time limit
		if (attempts == i) {
			System.out.println("\nYOU LOSE!!!");
			t.cancel();
		}
		// Game prints random number regardless of result
		System.out.printf("\nGame Over.\nRandom number is: %d", randnum);
		
	}
}
