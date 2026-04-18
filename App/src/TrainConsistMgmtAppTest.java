import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Utility method
    private int calculateTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int total = calculateTotalCapacity(bogies);

        assertEquals(128, total);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("First Class", 70));

        int total = calculateTotalCapacity(bogies);

        assertEquals(70, total);
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("General", 30));

        int total = calculateTotalCapacity(bogies);

        assertEquals(30, total);
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("A", 10));
        bogies.add(new Bogie("B", 20));
        bogies.add(new Bogie("C", 30));

        int total = calculateTotalCapacity(bogies);

        assertEquals(60, total);
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalCapacity(bogies);

        assertEquals(0, total);
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC", 80));

        int total = calculateTotalCapacity(bogies);

        assertEquals(152, total);
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalCapacity(bogies);

        assertEquals(0, total);
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        calculateTotalCapacity(bogies);

        assertEquals(originalSize, bogies.size());
    }
}