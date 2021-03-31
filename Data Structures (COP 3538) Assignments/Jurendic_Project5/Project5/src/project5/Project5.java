package project5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Project5 {

	public static void main(String[] args) {
		
		String line = null;
		Scanner scanner = null;
		String stateName;
		int statePopulation;
		int n_lines = 0;
	    int records = 0;
        String file="";
        Scanner input = new Scanner(System.in);

	       	HashTable HashData = new HashTable();
	        
	        System.out.print("Enter file name to read : ");
	        file = input.nextLine();
	        try {
	            BufferedReader reader = new BufferedReader(new FileReader(file)); //open the csv file
	  
	            while ((line = reader.readLine()) != null) {
	                // Ignore the first line containing headers
	            	String TempState = null;
	            	int TempPopulation = 0;
	            	
	                if (n_lines != 0) {
	                    scanner = new Scanner(line);
	                    scanner.useDelimiter(",");
	                    records++;
	                    TempState = scanner.next();
	                    scanner.next();
	                    scanner.next();
	                    TempPopulation = Integer.parseInt(scanner.next());
	               	    HashData.insert(TempState, TempPopulation);
	                    }
	            	
	                n_lines++;
	                }
	            
	            System.out.println("There were " + records + " state records read into the Hash Table.");
	            
	            HashData.display();
	            
	            System.out.println();
	            
	            HashData.delete("Vermont");
	            HashData.delete("Kansas");
	            HashData.delete("South Carolina");
	            
	            System.out.println();
	            
	            HashData.find("Florida");
	            HashData.find("Rhode Island");
	            HashData.find("Kansas");
	            
	            System.out.println();
	            
	            HashData.delete("Kentucky");
	            HashData.delete("Minnesota");
	            HashData.delete("Puerto Rico");
	            HashData.delete("Ohio");
	            
	            System.out.println();
	            
	            HashData.display();
	            
	            HashData.PrintFreeandCollisions();

	            
		    // Make use of functions to be create here 



	            } catch (FileNotFoundException e) {
	            	e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
		
	} // End of Main 
	
} // End of Class (Project5)
