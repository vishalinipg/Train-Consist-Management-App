/**
 * =========================================================
 * MAIN CLASS - TrainConsistMgmtApp
 * =========================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Description:
 * This class prevents creation of passenger bogies
 * with invalid seating capacity using a custom exception.
 *
 * At this stage, the application:
 * - Defines a custom exception
 * - Validates capacity inside constructor
 * - Throws exception if capacity <= 0
 * - Prevents invalid bogie creation
 * - Continues execution safely
 *
 * This maps fail-fast validation using checked exceptions.
 *
 * @author Vishalini P G
 * @version 14.0
 */

public class TrainConsistMgmtApp {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- Passenger Bogie model with validation ----
    static class PassengerBogie {
        String name;
        int capacity;

        PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("========================================\n");

        try {
            // Valid bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1.name + " -> " + b1.capacity);

            // Invalid bogie (will throw exception)
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            System.out.println("Created Bogie: " + b2.name + " -> " + b2.capacity);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}