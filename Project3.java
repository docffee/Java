import java.util.Scanner;

public class Project3 {
	public static void main(String[] args) {
		/*
		Create triangle patterns for project 3
		Extra credit attempt: ask user for number of layers
		Uses Scanner package
		*/
		
		// Initialize variables
		int i,j,k, layers =0;
		int space = 5;	// arbitrary 5 spaces between triangles
		
		// Scan in user input for # of layers
		System.out.printf("Enter Number of Layers:\n");
		Scanner myint = new Scanner(System.in);
		// Try-Catch block to set default for type error
		try {	
			layers = myint.nextInt();
		}
		catch (Exception e){
			System.out.printf("Type Error! Number of Layers Set to Default: 10\n");
			layers= 10;
		}
		myint.close();
		
		// For loop performs output triangle using outer for rows and inner for columns
		System.out.printf("\nPattern A:" + " ".repeat(layers*2) + "Pattern B:" + "\n" + "-".repeat(layers*4+5)+"\n");
		for(i=1;i<layers+1;i++) {		// i tracks # of rows. Initialize as 1 and +1 so at least one prints
			for(j=1;j<i+1;j++) {		// j tracks # of columns. j limited by i for 45-45-90 triangle
				System.out.print("+ "); // print only prints specified output j times
			}
			
			// format space set at layers*2 so B starts at end of A
			// add space to maintain separation between shapes
			// subtract to make shape left bound by subtracting i*2 to account 2 chars in "+ " 
			// subtracting by i*1 makes isosceles triangle
			System.out.print(" ".repeat(layers*2+space-i*2)); 
			
			// k tracks inverse triangle columns starting from size of layers down to 1
			for(k = layers+1-i; k>0; k--) {
				System.out.print("+ ");
			}
			System.out.println(); 		// println adds new line after each row 
		}
		// multiply space by 4 to account 2 printed chars in "+ " and 2 shapes
		System.out.printf("-".repeat(layers*4+space)+"\n"); 
	}

}

/*

System.out.print("\nPattern B:\n");

// For loop performs output large top triangle
for(i=layers;i>0;i--) {			// flip to negative for loop
	for(j=i;j>0;j--) {
		System.out.print("+ "); 
	}
	System.out.println(); 		// println adds new line after each row
}
*/

