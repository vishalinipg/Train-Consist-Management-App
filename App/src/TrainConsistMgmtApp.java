/**
 * ====================================================================
 * MAIN CLASS - TrainConsistMgmtApp
 * ====================================================================
 *
 * Use Case 3: Track Unique Bogie IDs
 *
 * Description:
 * This class ensures that duplicate bogie IDs are not
 * added into the train formation using HashSet.
 *
 * At this stage, the application:
 * - Stores bogie IDs
 * - Prevents duplicates automatically
 * - Displays unique bogie identifiers
 *
 * This maps uniqueness validation using Set.
 *
 * @author Vishalini P G
 * @version 3.0
 */

import java.util.HashSet;
import java.util.Set;

public class TrainConsistMgmtApp {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("==================================");

        // Create a Set to store unique bogie IDs
        Set<String> bogies = new HashSet<>();

        // ---- ADD IDs (including duplicates) ----
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries (will be ignored automatically)
        bogies.add("BG101");
        bogies.add("BG102");

        // ---- DISPLAY RESULT ----
        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogies);

        // ---- NOTE ----
        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("UC3 uniqueness validation completed....");
    }
}