import java.util.Scanner;

public class MenuShapes {
	public static void main(String[] args) {
		/*
		 * Menu Project
		 * Alvin Long
		 * Create menu for creating shapes: triangle, inverted triangle, square, bowtie
		 * uses Scanner package
		 */

		int layers;
		int selection;
		
		//Loop menu until user chooses exit or invalid
		while (true) {
			
		System.out.println("Menu\n"
				+ "1: Filled Triangle\n"
				+ "2: Inverted Filled Triangle\n"
				+ "3: Square\n"
				+ "4: Bowtie\n"
				+ "5: Exit\n");
		selection = getSelection();

			switch(selection){
			
			case 1:
				layers = getLayers();
				System.out.printf("Filled Triangle size " + layers+":\n\n");
				filledTriangle(layers);
				break;
			case 2:
				layers = getLayers();
				System.out.printf("Inverted Filled Triangle size " + layers+":\n\n");
				invertedFilledTriangle(layers);
				break;
			case 3:
				layers = getLayers();
				System.out.print("Square size "+layers+":\n\n");
				Square(layers);
				break;
			case 4:
				layers = getLayers();
				System.out.printf("Bowtie size " + layers + ":\n\n");
				Bowtie(layers);
				break;
			case 5:
				System.out.print("Exit\n");
				System.exit(0);
			default:
				System.out.print("Selection Error!\nExit\n");
				System.exit(0);
	
			}
		System.out.println();
		}
	}
		
		
	public static int getSelection() {
		// scan in user input for number of coin flips
		int selection;
		// Scan user input 
		System.out.printf("Enter Selection Number:\n");
		Scanner myint = new Scanner(System.in);
		// Try-Catch block to set default for type error
		try {	
			selection = myint.nextInt();
		}
		catch (Exception e){
			System.out.printf("Type Error! Exit Menu!\n");
			selection = 5;
		}
		return selection;
	}
		
		
	public static int getLayers() {
		// scan in user input for number of coin flips
		int layers;
		// Scan user input 
		System.out.printf("Enter Number of Layers:\n");
		Scanner myint = new Scanner(System.in);
		// Try-Catch block to set default for type error
		try {	
			layers = myint.nextInt();
		}
		catch (Exception e){
			System.out.printf("Type Error! Number of Layers Set to Default: 10\n");
			layers = 10;
		}
		return layers;
	}
	
	
	public static void filledTriangle(int layers) {
		int i,j = 0;
		for(i=1;i<layers+1;i++) {		
			for(j=1;j<i+1;j++) {		
				System.out.print("+ "); 
			}
		System.out.println();
		}
	}

	
	public static void invertedFilledTriangle(int layers) {
		int i,j = 0;
		for(i=0;i<layers+1;i++) {	
			for(j=layers-i;j>0;j--) {		
				System.out.print("+ "); 
			}
		System.out.println();
		}
	}
	
	
	
	public static void Square(int layers) {
		int i,j = 0;
		for(i=1;i<layers+1;i++) {		
			for(j=1;j<layers+1;j++) {		
				System.out.print("+ "); 
			}
		System.out.println();
		}
	}
	
	public static void Bowtie(int layers) {	
		int i,j,k,z = 0;
		int space = 6;
		//print top half of bowtie
		for(i=1;i<layers+1;i++) {		
			for(j=1;j<i+1;j++) {		
				System.out.print("+ "); 
			}
			System.out.print(" ".repeat(layers*2+space-i*2)); 
			for (z = layers-i; z>0;z--) {
				System.out.print("  ");
			}
			for(k = 1; k<i+1; k++) {
				System.out.print("+ ");
			}
			System.out.println(); 		
		}
		
		//print middle of bowtie
		for (j=1; j<space/2;j++) {
			for (i=1;i< (layers-1)*2+space;i++) {
				System.out.print("+ ");
			}
			System.out.println();
		}
		
		//print bottom half of bowtie
		for(i=layers;i>0;i--) {	
			for(j=1;j<i+1;j++) {		
				System.out.print("+ "); 
			}
			System.out.print(" ".repeat(layers*2+space-i*2)); 
			for (z = layers-i; z>0;z--) {
				System.out.print("  ");
			}
			for(k = 1; k<i+1; k++) {
				System.out.print("+ ");
			}
			System.out.println(); 		
		}
	
	}
}
