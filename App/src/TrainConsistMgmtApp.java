/**
 * ====================================================================
 * MAIN CLASS - TrainConsistMgmtApp
 * ====================================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 *
 * At this stage, the application:
 * - Adds bogies in sequence
 * - Inserts bogies at specific positions
 * - Removes bogies from front and rear
 * - Displays updated train structure
 *
 * This maps positional operations using LinkedList.
 *
 * @author Vishalini P G
 * @version 4.0
 */

import java.util.LinkedList;
import java.util.List;

public class TrainConsistMgmtApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("=====================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts
        List<String> trainConsist = new LinkedList<>();

        // ---- ADD INITIAL BOGIES ----
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);

        // ---- INSERT AT POSITION ----
        // Insert "Pantry Car" at index 2 (3rd position)
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        // ---- REMOVE FIRST AND LAST ----
        // Since we used List reference, we cast to LinkedList
        LinkedList<String> ll = (LinkedList<String>) trainConsist;
        ll.removeFirst();
        ll.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}