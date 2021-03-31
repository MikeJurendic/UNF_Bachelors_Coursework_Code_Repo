
import java.util.LinkedList;

public class Stack {

    private LinkedList<State> stateStack; //stack of states
    //Constructor that creates the stack.
    public Stack() {
         stateStack = new LinkedList<State>();
    }

    //method to push a state on the stack - insertion in stacks are done on top so insertion is done in the first position
    public void push(State newState){
         stateStack.addFirst(newState);
    }

    //method to pop a state off the stack and return it - deletion in stacks are done from top so pop the first element
    public State pop(){
         return stateStack.removeFirst();
    }

    // method to print the stack from top to bottom i.e first to last
    public void printStack(){
         for(int i=0;i<stateStack.size();i++)
             System.out.println(stateStack.get(i));
    }

    // method that returns true if the stack is empty, false otherwise
    public boolean isEmpty(){
        if(stateStack.size() == 0)
            return true;
        return false;
    }

    // method that always returns false
    public boolean isFull(){
        return false;
    }
}

// End of Stack class
