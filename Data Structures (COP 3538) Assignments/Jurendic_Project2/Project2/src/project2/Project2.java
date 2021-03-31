
package project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {

    private static State addNewState(String state)
    {
        //to split each state from the rest
        String stateArray[] = state.split(",");
        //initialize state
        State objState = new State();
        objState.setName(stateArray[0]);
        objState.setCaptialCity(stateArray[1]);
        objState.setAbbr(stateArray[2]);
        objState.setPopulation(Integer.parseInt(stateArray[3]));
        objState.setRegion(stateArray[4]);
        objState.setUSHouseSeats(Integer.parseInt(stateArray[5]));
        return objState;
    }
    
    public static void main(String[] args) {
        String file="";
        Scanner input = new Scanner(System.in);
        System.out.println("Stacks and Priority Queues");
        System.out.print("Enter file name to read : ");
        file = input.nextLine();
        
        /*
        creating  a single stack of state objects which
        containing states from regions South, West, and Midwest
        */ 
        Stack stateStack = new Stack(60);
        
        //Creating three priority queues, one for each region.
        Priority south = new Priority(50);
        Priority west = new Priority(50);
        Priority midwest = new Priority(50);

        try {
            Scanner readFile = new Scanner(new File(file));
            readFile.nextLine(); //Ist line is heading, so skip it
            //push south, west, and midwest states to stack
            while(readFile.hasNextLine())
            {
                String record = readFile.nextLine().trim();//trim use to remove extra spaces
                if(record.isEmpty())
                    continue;
                State newState = addNewState(record);
                //process states from south , west and midwest only
                if(newState.getRegion().equalsIgnoreCase("South") || 
                newState.getRegion().equalsIgnoreCase("West") || 
                newState.getRegion().equalsIgnoreCase("Midwest")){
                    //if it is either south, west or midwest
                    stateStack.push(newState);
                }  
            }
            readFile.close();
            //display stack size
            System.out.println("There were " + stateStack.size() + " state records put on stack");
            System.out.println("Stack contents : ");
            stateStack.printStack();
            
            //pop from stack and add to queues
            while(!stateStack.isEmpty())
            {
                State s = stateStack.pop();
                if(s.getRegion().equalsIgnoreCase("South"))
                    south.insert(s);//adding to south queue
                else if(s.getRegion().equalsIgnoreCase("West"))
                    west.insert(s);//adding to West queue
                else if(s.getRegion().equalsIgnoreCase("Midwest"))
                    midwest.insert(s);//adding to MidWest queue
            }
            //printing all the Queues
            System.out.println("\nSouth Priority Queue contents");
            south.printQueue();
            System.out.println("\nWest Priority Queue contents");
            west.printQueue();
            System.out.println("\nMidwest Priority Queue contents");
            midwest.printQueue();
            
            //remove from south Queue and put on stack
            while(!south.isEmpty())
                stateStack.push(south.remove());
            //remove from west queue and put on stack
            while(!west.isEmpty())
                stateStack.push(west.remove());
            //remove from midwest queue and put on stack
            while(!midwest.isEmpty())
                stateStack.push(midwest.remove());
            //now contents of stack will be
            System.out.println("");
            System.out.println("Stack contents:");
            stateStack.printStack();
        } catch (FileNotFoundException e) {
            System.out.println("Exception" + e);
        }
    }
}
        