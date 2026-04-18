/**
 * =====================================================================
 * MAIN CLASS - TrainConsistMgmtApp
 * =====================================================================
 *
 * Use Case 19: Binary Search for Bogie ID
 *
 * Description:
 * This class demonstrates searching for a specific bogie ID
 * using the Binary Search algorithm on sorted data.
 *
 * At this stage, the application:
 * - Creates sorted bogie ID array
 * - Applies binary search logic
 * - Narrows search range each iteration
 * - Displays result
 *
 * This maps optimized searching logic using divide-and-conquer.
 *
 * @author Vishalini P G
 * @version 19.0
 */

import java.util.Arrays;

public class TrainConsistMgmtApp {

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("==============================================\n");

        // Create sorted array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure data is sorted before binary search (precondition)
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display available bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        // ---- BINARY SEARCH LOGIC ----
        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                found = true;
                break;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // ---- DISPLAY RESULT ----
        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}