import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Regex patterns (same as main class)
    private final String TRAIN_REGEX = "TRN-\\d{4}";
    private final String CARGO_REGEX = "PET-[A-Z]{2}";

    // Utility methods
    private boolean isValidTrainId(String trainId) {
        return Pattern.matches(TRAIN_REGEX, trainId);
    }

    private boolean isValidCargoCode(String cargoCode) {
        return Pattern.matches(CARGO_REGEX, cargoCode);
    }

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(isValidTrainId("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(isValidTrainId("TRAIN12"));
        assertFalse(isValidTrainId("TRN12A"));
        assertFalse(isValidTrainId("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(isValidCargoCode("PET-ab"));
        assertFalse(isValidCargoCode("PET123"));
        assertFalse(isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(isValidTrainId("TRN-123"));   // 3 digits
        assertFalse(isValidTrainId("TRN-12345")); // 5 digits
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(isValidCargoCode("PET-ab")); // lowercase not allowed
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(isValidTrainId(""));
        assertFalse(isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(isValidTrainId("TRN-1234X")); // extra char
        assertFalse(isValidCargoCode("PET-ABC")); // extra char
    }
}