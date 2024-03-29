import java.util.Random;
import java.util.Scanner;

public class Lottery_Application {
	public static void main(String[] args) {
		
		/*
		 *  Lottery Application Assignment
		 *  By: Alvin Long
		 *  Packages: Random, Scanner 
		 *  Description: Lottery game where user inputs 5 numbers against
		 *  5 randomly generated numbers in an array. Second option for
		 *  custom defined game parameters. Game outputs user lottery
		 *  picks, random lottery picks, and number of matches. Matching
		 *  all random lottery picks generates the grand prize message.
		 */
		
		int selection;
		int loop = 1;
		
		//Loop menu until user chooses exit or invalid
		while (loop == 1) {
			
		System.out.println("<  Game Menu  >\n"
				+ "1: Standard Lottery\n"
				+ "2: Custom Lottery\n"
				+ "3: Exit\n");
		selection = getSelectionMenu();

			switch(selection){
			
			case 1:

				System.out.printf("\n1. Standard Lottery"
						+ "\nDraw Size: 5"
						+ "\nDraw Range: 10\n");
				LotteryGame(5,10);
				break;
			case 2:
				System.out.printf("\n2. Custom Lottery"
						+ "\nDraw Size: User Defined"
						+ "\nDraw Range: User Defined\n\n");
				LotteryGame(getDrawSize(),getDrawRange());
				break;
			case 3:
				System.out.print("Exit\n\nGame Over");
				System.exit(0);
			default:
				break;
			}
		System.out.println();
		}
		
	} // end main
	
	public static void LotteryGame(int x, int y) {
		int drawsize = x;
		int drawrange = y;
		int[] array = new int[drawsize];
		int[] userarray = new int[drawsize];
		
		// Generate Lottery Array
		array = BubbleSort(LotteryArray(array, drawrange));

		// Get User Lottery Picks
		System.out.printf("\n---- CIS144 Lottery ----"
				+ "\nTo Play Guess " + drawsize + " Numbers in Range 0-" + (drawrange-1)
				+ "\nGuess All " + drawsize + " Correctly for Grand Prize!"
				+ "\n\nGuesses:\n");
		for (int i=0; i <userarray.length; i++) {
			int breakwhile = 0;
			while (breakwhile == 0) { // Loop Selection Until User Input Valid
				userarray[i] = getSelection(i); // Call function to get user array
				breakwhile = 1;
				if (userarray[i]  > drawrange-1 | userarray[i] < 0) {
					breakwhile = 0;
				}
				else {
					for (int j=0; j<i; j++) {
						if (userarray[i] == userarray[j]) {
							breakwhile = 0;
							break;
						}
					}
				}
			}
		}
		
		// System Output Results of Lottery
		System.out.println("\n\n----------RESULTS----------");
		// Print Lottery Numbers
		System.out.println("\nLottery Numbers:");
		for (int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		// Print User Array
		System.out.println("\nUser Picks:");
		userarray = BubbleSort(userarray);
		for (int i=0;i<userarray.length;i++) {
			System.out.print(userarray[i]+" ");
		}
		// Print Matching Lottery Elements
		System.out.println("\nMatching Lottery Elements:");
		for (int i=0;i<array.length;i++) {
			for (int j=0;j<userarray.length;j++) {
				if (array[i] == userarray[j]) {
					System.out.print(i+" ");;
				}
			}
		}
		// Print Matching User ArrayElements
		System.out.println("\nMatching User Pick Elements:");
		for (int i=0;i<array.length;i++) {
			for (int j=0;j<userarray.length;j++) {
				if (array[i] == userarray[j]) {
					System.out.print(j+" ");;
				}
			}
		}
		// Print Matching Numbers
		int count = 0;
		System.out.println("\nMatching Numbers:");
		for (int i=0;i<array.length;i++) {
			for (int j=0;j<userarray.length;j++) {
				if (array[i] == userarray[j]) {
					System.out.print(array[i]+" ");;
					count +=1;
				}
			}
		}
		// Print Number of Matches
		System.out.println("\nNumber of Matches: "+count);
		// Prompt Grand Prize Winner
		if (count == drawsize) {
			System.out.println("\nGRAND PRIZE WINNER!!!"
					+"\n🏆👑✨🎉💯❤️🙌😁🔥🍪"
					+"\n100% For The Semester"
					+"\n💯👍🎈🎊🎉✨👑🏆💯🥇");
		}
		System.out.print("\n"+"-".repeat(27)+"\n".repeat(2));
	}// End Lottery Game
	
	public static int getSelectionMenu() {
		int selection;
		System.out.printf("Enter Menu Selection: ");
		Scanner myint = new Scanner(System.in);
		try {	
			selection = myint.nextInt();
		}
		catch (Exception e){
			selection = getSelectionMenu();
		}
		return selection;
	}
	
	public static int getSelection(int i) {
		int selection;
		System.out.print(i+1+". ");
		Scanner myint = new Scanner(System.in);
		try {	
			selection = myint.nextInt();
		}
		catch (Exception e){
			selection = getSelection(i);
		}
		return selection;
	}
	
	public static int getDrawSize() {
		// scan in user input for number of drawings
		int num;
		System.out.print("Enter Lottery Draw Size: ");
		Scanner myint = new Scanner(System.in);
		try {	
			num = myint.nextInt();
		}
		catch (Exception e){
			num = getDrawSize();
		}
		return num;
	}
	
	public static int getDrawRange() {
		// scan in user input for range of draw numbers
		int num;
		System.out.print("Enter Lottery Draw Range: ");
		Scanner myint = new Scanner(System.in);
		try {	
			num = myint.nextInt();
		}
		catch (Exception e){
			num = getDrawRange();
		}
		return num;
	}
	
	public static int[] LotteryArray(int array[], int drawrange) {
		Random rand = new Random();
		for (int i=0;i<array.length;i++) {
			array[i] = rand.nextInt(drawrange);
			for (int j=0; j<i; j++) {
				if (array[i] == array[j]) {
					i = -1;	// Restart randomizer if duplicate exists
				}			
			}
		}
		return array;
	}
	
	public static int[] BubbleSort(int array[]) {
		// Bubble sort array
		for (int i=0;i<array.length-1;i++) {
			for (int j=0; j < array.length-1-i;j++) {
				if (array[j] > array[j+1]) {
					int tmp = array[j+1];
					array[j+1] = array[j];
					array[j] = tmp;
				}
			}	
		}
		return array;
	}
}