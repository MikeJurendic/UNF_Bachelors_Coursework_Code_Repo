
// class Queue that implements a queue (double-ended queue, actually) of state objects using a doubly linked list.
import java.util.LinkedList;

public class Queue {
    private LinkedList<State> stateQueue; // queue that stores the states
    // Constructor that creates the queue.
    public Queue(){
          stateQueue = new LinkedList<State>();
     }

    // method to insert a state at the end of the queue.
    public void insertEnd(State newState){
         stateQueue.addLast(newState);
    }

    // method to insert a state at the front of the queue.
    public void insertFront(State newState){
         stateQueue.addFirst(newState);
    }

    // method to remove a state from the front of the queue and return it.
    public State removeFront(){
         return stateQueue.removeFirst();
    }

    // method to remove a state from the end of the queue and return it.
    public State removeEnd(){
         return stateQueue.removeLast();
    }

    // method to find a state in the queue by state name, and delete it from th queue. Return true if it was found and deleted and false otherwise.
    public boolean findDelete(String stateName){
         for(int i=0;i<stateQueue.size();i++){
             if(stateQueue.get(i).getName().equalsIgnoreCase(stateName))// check the input stateName with the element state name
             {
                 stateQueue.remove(i);
                 return true;
             }
         }
         return false;

    }

    // method to print the queue in order front to end
    public void printQueue(){
         for(int i=0;i<stateQueue.size();i++)
             System.out.println(stateQueue.get(i));
    }

    // method that returns true if the queue is empty, false otherwise
    public boolean isEmpty(){
         if(stateQueue.size() == 0)
                return true;
         return false;
    }

    // method that returns false always
    public boolean isFull() {
             return false;
        }
}// End of Queue class
