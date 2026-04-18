import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    // Utility: Loop filtering
    private List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Utility: Stream filtering
    private List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 72));
        list.add(new Bogie("B", 50));

        List<Bogie> result = filterUsingLoop(list);

        assertEquals(1, result.size());
        assertTrue(result.get(0).capacity > 60);
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 80));
        list.add(new Bogie("B", 40));

        List<Bogie> result = filterUsingStream(list);

        assertEquals(1, result.size());
        assertTrue(result.get(0).capacity > 60);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = new ArrayList<>();
        list.add(new Bogie("A", 72));
        list.add(new Bogie("B", 56));
        list.add(new Bogie("C", 90));

        List<Bogie> loopResult = filterUsingLoop(list);
        List<Bogie> streamResult = filterUsingStream(list);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("A", 70));
        }

        long start = System.nanoTime();
        filterUsingLoop(list);
        long end = System.nanoTime();

        long elapsed = end - start;

        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new Bogie("Sleeper", 72));
            list.add(new Bogie("AC", 50));
        }

        List<Bogie> result = filterUsingStream(list);

        // Only capacity > 60 should be counted
        assertEquals(10000, result.size());
    }
}