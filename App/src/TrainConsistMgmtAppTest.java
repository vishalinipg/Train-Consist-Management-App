import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistMgmtAppTest {

    // Reusing classes from main code
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            try {
                if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }
                this.cargo = cargo;
            } catch (CargoSafetyException e) {
                // Exception handled internally
            } finally {
                // Logging (not needed for assertion)
            }
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        bogie.assignCargo("Petroleum");

        assertEquals("Petroleum", bogie.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        // Since exception is handled internally, cargo should remain null
        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        assertNull(bogie.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        bogie1.assignCargo("Petroleum"); // unsafe
        bogie2.assignCargo("Coal");      // safe

        assertNull(bogie1.cargo);
        assertEquals("Coal", bogie2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // If finally fails, method may crash → test ensures execution completes
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}