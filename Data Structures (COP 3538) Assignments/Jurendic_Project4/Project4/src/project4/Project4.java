package project4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Project4 {

	public static void main(String[] args) {
		String line = null;
		Scanner scanner = null;
		String stateName;
		int statePopulation;
        int n_lines = 0;
        int records = 0;
        String file="";
        Scanner input = new Scanner(System.in);

        BinarySearchTree BST = new BinarySearchTree();
        
        
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
                    BST.insert(TempState, TempPopulation);
                    }
            	
                n_lines++;
                }

            
            System.out.println("There were " + records + " state records put on the binary search tree.");
            
            BST.printInorder(BST.root);
            
            System.out.println("");
            
            BST.find("Michigan");
            BST.find("Guam");
            BST.find("Florida");
            
            System.out.println("");
            
            BST.printPreorder(BST.root);
            
            System.out.println("");
            
            BST.printPostorder(BST.root);
            
            
            } catch (FileNotFoundException e) {
            	e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

	}

}
