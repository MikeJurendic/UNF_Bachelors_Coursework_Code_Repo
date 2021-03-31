package project1;

/*
 *  COP 3538: Project 1–Array Searches and Sorts* 
 * @author Mike Jurendic, N01181088*
 * @version  2/1/2019 10:48 PM
 */



import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Project1 {

	private static Scanner selection;

	public static void main(String[] args) {
		
		ReadCSV();
		MainMenu();
		
		
	}
	// >>> END MAIN; FUNCTIONS (OR METHODS) BELOW <<<
	
	
	
	public static void ReadCSV(){
		
	}
	
	
	// MAIN MENU FUNCTION 
	public static void MainMenu(){
		int choice = 0;
		
		System.out.println("1. Print a State Report");
		System.out.println("2. Sort by State Name");
		System.out.println("3. Sort by Population");
		System.out.println("4. Sort by Region");
		System.out.println("5. Find and Print a Given State");
		System.out.println("6. Quit");
		
		
		System.out.println("Enter your choice: ");
		
	
		for(;;){
		
			
		try{	
		selection = new Scanner(System.in);	
		choice = selection.nextInt();
		}
		catch(java.util.InputMismatchException e){
			
		}
			
			switch (choice){
			
			case 1:
				System.out.println("Function #1 Invoked");
				break; 
			case 2:
				System.out.println("Function #2 Invoked");
				break;
			case 3:
				System.out.println("Function #3 Invoked");
				break;
			case 4:
				System.out.println("Function #4 Invoked");
				break;
			case 5:
				System.out.println("Function #5 Invoked");
				break;
			case 6:
				System.out.println("Have a good day!");
				System.exit(0);
			default:
				System.out.println("Invalid choice enter 1-6: ");
				break;
				
			} 

			
		}
		
	} // END MAIN MENU 
	
	// >>> END CLASS; DO NOT EDIT BELOW THIS BRACKET <<<
}
