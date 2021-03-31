package project5;

import java.lang.reflect.Array;

public class HashTable {
	Node[] Cell = new Node[113];
	
	
	private class Node {
		String stateName;
		int statePopulation;
		Node nextNode;
		Node lastNode;
		
		public Node(String state, int population) {
			stateName = state;
			statePopulation = population; 
		}
		
		public void printNode() {
			System.out.printf("%-25s%,10d\n", stateName, statePopulation);
		}
		
	} // End Node Class
	
	public HashTable(){
		
	} // End of constructor Method
	
	public void insert(String state, int population){
		int CelltoAssign = 0; 
		Node newNode = new Node(state, population);
		
		CelltoAssign = HashFunction(state);
		
		if(Cell[CelltoAssign] == null){ // If the Table Cell is empty, it sets the node as
			Cell[CelltoAssign] = newNode;
			Cell[CelltoAssign].lastNode = newNode;
		} 
		else {
			Cell[CelltoAssign].lastNode.nextNode = newNode;
			Cell[CelltoAssign].lastNode = newNode;
		}
		
	} // End Insert Method
	
	public int HashFunction(String state){
		int ASCIIValue = 0; 
		
		for(int iterator = 0; iterator < state.length(); iterator++){
			char TempChar = state.charAt(iterator);
			ASCIIValue += TempChar;
		}
		
		ASCIIValue %= 113;
		
		return ASCIIValue;
	} // End of HashFunction Method
	
	public void display(){
		Node current = null;
		
		for(int CurrentCell = 0; CurrentCell < 113; CurrentCell++){
			System.out.print(CurrentCell + ".    ");
			if(Cell[CurrentCell] == null){
				System.out.println("Empty");
				continue;
			} 
			else if(Cell[CurrentCell] != null){
				current = Cell[CurrentCell];
				current.printNode();
				
				while(current.nextNode != null){
					current = current.nextNode;
					System.out.print("       ");
					current.printNode();
				}	
			}
		}	
	} // End Display Method
	
	public void delete(String state){
		Node current = null;
		int CelltoDeleteFrom = 0;
		
		CelltoDeleteFrom = HashFunction(state);
		
		if(Cell[CelltoDeleteFrom] == null){
			System.out.println("ERROR: Could not find specified state"); // This if the proper cell even has any nodes. 
			return; 
		} // End of empty cell case
		else if(Cell[CelltoDeleteFrom] != null){
			if(Cell[CelltoDeleteFrom].stateName.equals(state)){ // Handles case of first Node being the one to be deleted 
				if(Cell[CelltoDeleteFrom].nextNode == null){
					Cell[CelltoDeleteFrom] = null;
					System.out.println(state + " has been deleted from the hash table.");
					return;
				} 
				else if(Cell[CelltoDeleteFrom].nextNode != null){ // Handles cases of a node being after first  
					Cell[CelltoDeleteFrom].nextNode.lastNode = Cell[CelltoDeleteFrom].lastNode; // Sets next double-end to last to the next node
					Cell[CelltoDeleteFrom] = Cell[CelltoDeleteFrom].nextNode; // Cut the former first element from the last, the first is now the next
					System.out.println(state + " has been deleted from the hash table."); 
					return;
				}
			} // End of first node being the one to be deleted case
			else if(Cell[CelltoDeleteFrom].stateName != state){ // Handles case of a node other than the first to be deleted. 
				current = Cell[CelltoDeleteFrom]; 
				while(current.nextNode != null){
					if(current.nextNode.stateName.equals(state)){ // Checks if the next node is the state to delete
						current.nextNode = current.nextNode.nextNode; // This cuts the next node (the state to delete) from the list. 
						System.out.println(state + " has been deleted from the hash table.");
						return;
					} 
					else if (current.nextNode.stateName != state){ // If not, the current will iterate, and the loop will check if there is a next node to even check
						current = current.nextNode;
						continue;
					}
				}
			} // End of node other than first case 
			
		} // End of non-empty list case 
		
	} // End of Delete Method
	
	public int find(String state){
		Node current = null;
		int CelltoIndex = 0;
		int TempPop = -1;
		
		CelltoIndex = HashFunction(state);
		
		if(Cell[CelltoIndex] == null){
			System.out.println(state + " is not found.");
			return TempPop;
		} 
		else if(Cell[CelltoIndex] != null){
			current = Cell[CelltoIndex];
		}
		
		while(true){
			if(current.stateName.equals(state)){
				TempPop = current.statePopulation;
				System.out.println(state + " is found with a population of " + TempPop);
				return TempPop;
			} 
			else {
				if(current.nextNode != null){
				current = current.nextNode;
				continue;
				}
				
				System.out.println(state + " is not found.");
				return TempPop;
			}
		}
		
	} // End Find method
	
	public void PrintFreeandCollisions(){
		int EmptySpaces = 0;
		int Collisions = 0;
		
		for(int CurrentCell = 0; CurrentCell < 113; CurrentCell++){
			if(Cell[CurrentCell] == null){
				EmptySpaces++;
			} 
			if(Cell[CurrentCell] != null){
				if(Cell[CurrentCell].nextNode != null){
					Collisions++;
				}
			}	
		}
		
		System.out.println("Hash Table has " + EmptySpaces + " Empty Spaces and " + Collisions + " Collisions.");

	} // End of PrintFreeandCollisions Method 
	
} // End of Class HashTable
