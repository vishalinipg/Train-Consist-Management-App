/**
 * =========================================================
 * MAIN CLASS - TrainConsistMgmtApp
 * =========================================================
 *
 * Use Case 16: Sort Passenger Bogies by Capacity
 *
 * Description:
 * This class demonstrates manual sorting of passenger
 * bogie capacities using the Bubble Sort algorithm
 * instead of built-in sorting utilities.
 *
 * At this stage, the application:
 * - Creates an array of capacities
 * - Compares adjacent values
 * - Swaps values when required
 * - Repeats passes until sorted
 * - Displays sorted result
 *
 * This maps algorithmic sorting logic using Bubble Sort.
 *
 * @author Vishalini P G
 * @version 16.0
 */

public class TrainConsistMgmtApp {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("============================================\n");

        // Create array of passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        // Display original order
        System.out.println("Original Capacities:");
        for (int c : capacities) {
            System.out.print(c + " ");
        }
        System.out.println();

        // ---- BUBBLE SORT LOGIC ----
        for (int i = 0; i < capacities.length - 1; i++) {
            for (int j = 0; j < capacities.length - 1 - i; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }

        // Display sorted result
        System.out.println("\nSorted Capacities (Ascending):");
        for (int c : capacities) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nUC16 sorting completed...");
    }
}