
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Project3 {

    public static void main(String[] args) {
        String line = null;
        String stateName;
        String capitalCity;
        String stateAbbreviation;
        int statePopulation;
        String region;
        int houseSeats;
        Scanner scanner = null;
        int n_lines = 0;
        int records = 0;
        Stack statesStack = new Stack();
        Queue statesQueue = new Queue();
        String file="";
        Scanner input = new Scanner(System.in);
        System.out.println("Linked Lists");
        System.out.print("Enter file name to read : ");
        file = input.nextLine();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file)); //open the csv file
            // loop to read the csv file and create a single stack of state objects containing states from regions New England, Middle Atlantic, and South
            while ((line = reader.readLine()) != null) {
                // Ignore the first line containing headers
                if (n_lines != 0) {
                    scanner = new Scanner(line);
                    scanner.useDelimiter(",");
                    stateName = scanner.next();
                    capitalCity = scanner.next();
                    stateAbbreviation = scanner.next();
                    statePopulation = Integer.parseInt(scanner.next());
                    region = scanner.next();
                    houseSeats = Integer.parseInt(scanner.next());
                    if (region.equalsIgnoreCase("New England") || region.equalsIgnoreCase("Middle Atlantic") || region.equalsIgnoreCase("South")) {
                        statesStack.push(new State(stateName, capitalCity, stateAbbreviation, statePopulation, region, houseSeats));
                        records++;
                    }
                }
                n_lines++;
            }

            // print the stack
            System.out.println("There were " + records + " state records put on the stack.");
            System.out.println("\n Stack Contents: ");
            System.out.println("State Name Capital City State Abbr State Population Region US House Seats");
            System.out.println("---------------------------------------------------------------------------");
            statesStack.printStack();
            /*
                Pop items from the stack, one at a time, and insert them to the queue:
                insert the first popped state in the front, the second popped state at the end, the third
                popped state at the front, the fourth popped state at the end, and so forth.
            */
            records = 0;
            while (!statesStack.isEmpty()) {
                records++;
                if (records % 2 == 0) {
                    statesQueue.insertEnd(statesStack.pop());
                } else {
                    statesQueue.insertFront(statesStack.pop());
                }
            }
            // print the queue
            System.out.println("\n Queue Contents: ");
            System.out.println("State Name Capital City State Abbr State Population Region US House Seats");
            System.out.println("---------------------------------------------------------------------------");
            statesQueue.printQueue();
            /* Delete states Massachusetts, New Hampshire, Rhode Island, Maryland, New Jersey,
            Pennsylvania, Alabama, Kentucky, and North Carolina in the queue*/
            statesQueue.findDelete("Massachusetts");
            statesQueue.findDelete("New Hampshire");
            statesQueue.findDelete("Rhode Island");
            statesQueue.findDelete("Maryland");
            statesQueue.findDelete("New Jersey");
            statesQueue.findDelete("Pennsylvania");
            statesQueue.findDelete("Alabama");
            statesQueue.findDelete("Kentucky");
            statesQueue.findDelete("North Carolina");
            // print the queue
            System.out.println("\n Queue Contents: ");
            System.out.println("State Name Capital City State Abbr State Population Region US House Seats");
            System.out.println("---------------------------------------------------------------------------");
            statesQueue.printQueue();
            /*
            Remove items from the queue, one at a time, and push them on the stack. Remove
            one state from the front, then one from the back, then the front, then the back, and so forth.
             */
            records = 0;
            while (!statesQueue.isEmpty()) {
                records++;
                if (records % 2 == 0) {
                    statesStack.push(statesQueue.removeEnd());
                } else {
                    statesStack.push(statesQueue.removeFront());
                }
            }
            // print the stack
            System.out.println("\n Stack Contents: ");
            System.out.println("State Name Capital City State Abbr State Population Region US House Seats");
            System.out.println("---------------------------------------------------------------------------");
            statesStack.printStack();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
