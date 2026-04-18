import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Reusing Bogie model
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Helper method for filtering (same logic as main class)
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 70)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = List.of(
                new Bogie("AC Chair", 50)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("First Class", 24),
                new Bogie("AC Chair", 50)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = List.of(
                new Bogie("Sleeper", 72),
                new Bogie("General", 90)
        );

        List<Bogie> result = filterBogies(bogies, 60);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 60);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        filterBogies(bogies, 60);

        assertEquals(1, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
    }
}