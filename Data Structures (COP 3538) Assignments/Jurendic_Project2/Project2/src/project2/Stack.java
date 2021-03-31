
package project2;

public class Stack {
    
    private int maxSize; // size of the stack
    private State[] stackArray;
    private int top; // top of the stack

    public Stack(){
        
    }
    
    public Stack(int s) { // The main constructor for the class
        maxSize = s; // For setting the array size to its maximum
        stackArray = new State[s];
        top = -1; // One behind the first array index, 0, because no items yet
    }

    public void push(State j) { // Places an item on top of the stack
        if(!isFull()){
            stackArray[++top] = j; // Increment the top
        }
    }

    public State pop() { // Take item from top of stack
        if(!isEmpty()){
            return stackArray[top--]; // Access the item then decrement the top
        }
        return null;
    }

    public State peek() { // Look at the top of the stack, does not remove anything
        return stackArray[top];
    }

    public boolean isEmpty() { // This will come out as true (1) if empty
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }
    
    public int size(){
        return top;
    }
    
    public void printStack(){
        System.out.println("State Name\t Capital City\t State Abbr\t State Population\t Region\t US House Seats\t");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        for(int i = 0; i < top-1; i++){
            System.out.println(stackArray[i]);
        }
    }
}
