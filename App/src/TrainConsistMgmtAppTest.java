import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Helper method (same logic as main with fail-fast validation)
    boolean searchWithValidation(String[] bogieIds, String key) {

        // Fail-fast validation
        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        // Linear search logic
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] input = {};

        assertThrows(IllegalStateException.class, () ->
                searchWithValidation(input, "BG101")
        );
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] input = {"BG101", "BG205"};

        assertDoesNotThrow(() ->
                searchWithValidation(input, "BG101")
        );
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] input = {"BG101", "BG205", "BG309"};

        assertTrue(searchWithValidation(input, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] input = {"BG101", "BG205", "BG309"};

        assertFalse(searchWithValidation(input, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] input = {"BG101"};

        assertTrue(searchWithValidation(input, "BG101"));
    }
}