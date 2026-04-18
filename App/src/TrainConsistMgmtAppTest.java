import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Helper method (Linear Search logic)
    boolean linearSearch(String[] arr, String key) {
        for (String id : arr) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(input, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(linearSearch(input, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(input, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(linearSearch(input, "BG550"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] input = {"BG101"};

        assertTrue(linearSearch(input, "BG101"));
    }
}