import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistMgmtAppTest {

    // Helper method (Binary Search with sorting precondition)
    boolean binarySearch(String[] arr, String key) {

        if (arr.length == 0) return false;

        Arrays.sort(arr); // ensure sorted

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int result = key.compareTo(arr[mid]);

            if (result == 0) {
                return true;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(binarySearch(input, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(binarySearch(input, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(binarySearch(input, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] input = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(binarySearch(input, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] input = {"BG101"};

        assertTrue(binarySearch(input, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] input = {};

        assertFalse(binarySearch(input, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] input = {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(binarySearch(input, "BG205"));
    }
}