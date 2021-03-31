
/* 
 * ** This class is intended to be used to create an object for each of the 56 US States / Territories
 * Mentioned for the assignment. Each variable of the class utilizes a set and get method and attempts
 * to follow the best programming practices possible. ----  **
 * @author Mike Jurendic, N01181088* 
 * @version 2/18/2019 11:34 AM 
 * */

package project2;

public class Priority {
    private State[] objState;
    private int current;
    
    public Priority(){
        
    }
    
    public Priority(int s) 
    {
        objState = new State[s];
        current = 0;
    }
    
    public void insert(State state)
    {
        //Check if the queue is full, if not insert value
        if(!isFull())
        {
            //find the place where to insert new state in to queue
            int location = 0;
            while(location < current)
            {
                //highest population is at highest priority
                if(state.getPopulation() <= objState[location].getPopulation()){
                    location++;
                }
                else {
                    break;
                }
            }
            //move element one place right, starting from location because we have to insert at location.
            for(int i = current - 1; i >= location; i--)
                objState[i+1] = objState[i];
                //inserting new state at location
                objState[location] = state;
                current++;
            
        }
    }
    
    public State remove()
    {
        State toRemove = null;
        if(!isEmpty())
        {
            toRemove = objState[0]; //get the 1st element
            //to pop 1st element, move all others one place left
            for(int i = 1; i < current; i++)
                objState[i-1] = objState[i];
                current--;
            
        }
        return toRemove;
    }
    
    public boolean isEmpty()
    {
        return current == 0;
    }
    
    public boolean isFull()
    {
        //current is the element at current index, if it equals to length, it means queue is full
        return current == objState.length;
    }
    
    public int size()
    {
        return current;
    }
   
    public void printQueue()
    {
        System.out.println("State Name\t Capital City\t State Abbr\t State Population\t Region\t US House Seats\t");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for(int i = 0; i < current; i++)
            System.out.println(objState[i]);
    }
}

