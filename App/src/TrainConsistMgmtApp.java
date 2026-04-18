/**
 * =========================================================================
 * MAIN CLASS - TrainConsistMgmtApp
 * =========================================================================
 *
 * Use Case 9: Group Bogies by Type
 *
 * Description:
 * This class groups similar bogies together using
 * Java Stream Collectors.groupingBy().
 *
 * At this stage, the application:
 * - Creates a list of bogies
 * - Streams the list
 * - Groups bogies by name
 * - Stores grouped data in a Map
 * - Displays grouped structure
 *
 * This maps classification logic using groupingBy.
 *
 * @author Vishalini P G
 * @version 9.0
 */

import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistMgmtApp {

    // Reusing Bogie model from UC7 / UC8
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("========================================================\n");

        // Create List of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        // Display input bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ---- GROUP USING COLLECTORS, GROUPINGBY ----
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        // Display grouped structure
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {

            System.out.println("Bogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("Capacity -> " + b.capacity);
            }
            System.out.println();
        }

        System.out.println("UC9 grouping completed....");
    }
}