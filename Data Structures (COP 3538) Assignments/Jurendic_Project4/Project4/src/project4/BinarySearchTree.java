package project4;


public class BinarySearchTree {
	
	Node root = null;
	Node current = null;
	Node parent = null; 
	
	private class Node {
		String stateName;
		int statePopulation;
		Node leftChild;
		Node rightChild;
		
		public Node(String state, int population) {
			stateName = state;
			statePopulation = population; 
		}
		
		public void printNode() {
			System.out.printf("%-25s%,10d\n", stateName, statePopulation);
		}
		
	}
	
	public BinarySearchTree(){
		// No-arg constructor for creating a blank tree  		
	} 
	
	public void insert(String state, int population){ // INSERT METHOD FOR INSERTING NEW NODES USING STATE NAMES AND POPULATIONS
		Node newNode = new Node(state, population);
		int Result = 0;
		
		if (root == null){
			root = newNode;
		} 
		else { 
			current = root; 
			while(true) { // This do-while loop keeps cycling until it fills in a null-space of an address pointer (leftChild or rightChild)  
				Result = newNode.stateName.compareToIgnoreCase(current.stateName);
				
				if(Result <= -1) { // Handles left-path case
		        	if(current.leftChild == null){
		        		current.leftChild = newNode; 
		        		return; // After placing a New Node in a null leftChild, the method is finished. 
		        	}
		        	else if(current.leftChild != null){ // Continues with the loop seeing that the node is occupied 
		        		current = current.leftChild; 
		        	}
				} 
				else if(Result >= 1) { // Handles right-path case
		        	if(current.rightChild == null){
		        		current.rightChild = newNode; 
		        		return; // After placing a New Node in a null rightChild, the method is finished. 
		        	}
		        	else if(current.rightChild != null){ // Continues with the loop seeing that the node is occupied. 
		        		current = current.rightChild;
		        	}
				}
			} 
		}
		
	}
	
	public int find(String state){ // FIND METHOD FOR FINDING STATE NODES IN THE TREE AND THEIR RESPECTIVE POPULATIONS
		int population = -1; 
		int NodesVisited = 0; 
		
		if(root == null){
			System.out.println("Error: Tree is empty");  // Checking if the tree is empty
		}
		else {
			current = root;
			
			while(true){ // This loop keeps going until the state is found or a dead end is reached.
				
				if(state.equals(current.stateName)){ // Checks if the current iterator's statename is equal to the state we're looking for
					population = current.statePopulation;
					System.out.println(state + " is found with a population of " + population);
					System.out.println(NodesVisited + " Nodes Visted");
					break; // The break cases terminate the loop and make the sure the population is returned and the loop doesn't go infinitely
				}  
				else if(state.compareTo(current.stateName) <= -1){ // Checks if we need to go left of the tree   
					if(current.leftChild == null){ // Dead-end case
						if(current.rightChild != null){ // These if-checks in the Dead-end cases make sure that the Node IS a non-leaf node first
							NodesVisited++;
						}
						System.out.println("State " + state + " is not found");
						System.out.println(NodesVisited + " Nodes Visted");
						return population; 
					}
					else if(current.leftChild != null){
						NodesVisited++;
						current = current.leftChild;  // Move further down the left of the list, and compare the next node
						continue; // Jump to the next iteration, as we got the information we need for this one
					}
				}
				else if(state.compareTo(current.stateName) >= 1){ // Checks if we need to go right of the tree   
					if(current.rightChild == null){ // Dead-end case
						if(current.leftChild != null){ // These if-checks in the Dead-end cases make sure that the Node IS a non-leaf node first
							NodesVisited++;
						}
						System.out.println("State " + state + " is not found");
						System.out.println(NodesVisited + " Nodes Visted");
						return population; 
					}
					else if(current.rightChild != null){
						NodesVisited++;
						current = current.rightChild;  // Move further down the right of the list, and compare the next node
						continue; // Jump to the next iteration, as we got the information we need for this one
					}
				}
			}
		}
		
		return population;
	}
	
	public void delete(String state){ // METHOD FOR FINDING AND DELETEING A NODE WITHIN THE TREE
		if(root == null){
			System.out.println("Error: Tree is empty");  // Checking if the tree is empty
		} 
		else {
			current = root;
			if(state.equals(current.stateName)){ 
				if(current.leftChild == null && current.rightChild == null){
					if(current == root){
						root = null;
					}
				}


			}
			
			
			
		}
	}
	
	public void printInorder(Node MatryoshkaNode){ // METHOD FOR PRINTING THE BINARY SEARCH TREE WITH IN-ORDER TRAVERSAL 
		
		if(MatryoshkaNode != null){
			printInorder(MatryoshkaNode.leftChild); // Recursive case, that keeps 'nesting' the left children
			MatryoshkaNode.printNode(); // When the the function reaches the last left node and sees that there are no more left nodes, it moves on to print
			printInorder(MatryoshkaNode.rightChild); // Once done printing, it does the same function for the right node which will check its children and so on
		}
		else if (MatryoshkaNode == null){ // Base case of recursive function
			return;
		}
	}
	
	public void printPreorder(Node MatryoshkaNode){ // METHOD FOR PRINTING THE PREORDER TRAVERSAL
		if(MatryoshkaNode != null){
			MatryoshkaNode.printNode();
			printInorder(MatryoshkaNode.leftChild); // Recursive case, that keeps 'nesting' the left children
			printInorder(MatryoshkaNode.rightChild); // Once done printing, it does the same function for the right node which will check its children and so on
		}
		else if (MatryoshkaNode == null){ // Base case of recursive function
			return;
		}
	}
	
	public void printPostorder(Node MatryoshkaNode){ // METHOD FOR PRINTING THE POST 
		if(MatryoshkaNode != null){
			printInorder(MatryoshkaNode.leftChild); // Recursive case, that keeps 'nesting' the left children
			printInorder(MatryoshkaNode.rightChild); //  Secondary Recursive case 
			MatryoshkaNode.printNode(); // Starts printing nodes from the leaf nodes first
		}
		else if (MatryoshkaNode == null){ // Base case of recursive function
			return;
		}
	}
	
	public void printMinimum(){
		
	}
	
	public void printMaximum(){
		
		
	}
	

	
}
