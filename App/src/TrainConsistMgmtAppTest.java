import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class TrainConsistMgmtAppTest {

    // Helper method
    String[] sortNames(String[] arr) {
        String[] result = Arrays.copyOf(arr, arr.length); // keep original safe
        Arrays.sort(result);
        return result;
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }

    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, sortNames(input));
    }
}