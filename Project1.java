import java.util.Scanner;
import java.lang.Math;

public class Project1 {
	/* Create a payroll system to output earnings */
	public static void main(String[] args) {
		String FirstName, LastName;
		Double HoursWorked = -1.0, Biweekly, Monthly, Yearly;
		int SSN = 0;
		final Double Payrate = 33.35;
		
		Scanner mystring1 = new Scanner(System.in);
		Scanner mystring2 = new Scanner(System.in);
		Scanner myint1 = new Scanner(System.in);
		Scanner mydouble2 = new Scanner(System.in);
	
		System.out.println("Enter First Name: ");
		FirstName = mystring1.nextLine();
		System.out.println("Enter Last Name: ");
		LastName = mystring2.nextLine();
		
		while(String.valueOf(SSN).length() != 9) {
			System.out.println("Enter 9-digit Social Security Number(SSN): ");
			SSN = myint1.nextInt();
			if(String.valueOf(SSN).length() == 9) {
				break;
			}
		}
		
		while(HoursWorked > 12 || HoursWorked < 0) {
			System.out.println("Calculations Based on 5 Day Work Week.\nEnter Hours Worked per Day: ");
			HoursWorked = mydouble2.nextDouble();
			if(HoursWorked > 12 || HoursWorked < 0 )
				System.out.println("Invalid. Hours must be between 0 and 12.");
		}
		
		mystring1.close();
		mystring2.close();
		myint1.close();
		mydouble2.close();
		
		
		Biweekly =  Math.round(Payrate * HoursWorked * 5.0 * 2.0 * 100.0)/100.0;
		Monthly = Math.round(Payrate * HoursWorked * 5.0 * 4.0 * 100.0) / 100.0;
		Yearly = Math.round(Payrate * HoursWorked * 5.0 * 52.0 * 100.0) / 100.0;
		
		System.out.printf("Name: " + FirstName+ " " + LastName 
				+"\nSSN: " + SSN
				+"\nPayrate: $%.2f\nBiweekly: $%.2f\nMonthly: $%.2f\nYearly: $%.2f",
				Payrate, Biweekly, Monthly, Yearly);
	}
	
}

