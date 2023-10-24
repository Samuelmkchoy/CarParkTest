import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarParkTest {

    @Test
    public void testRateCalculation() {
        ArrayList<Period> normalPeriods = new ArrayList<>();
        normalPeriods.add(new Period(2, 5));
        ArrayList<Period> reducedPeriods = new ArrayList<>();
        reducedPeriods.add(new Period(5, 8));

        Rate rate = new Rate(CarParkKind.SOME_KIND, BigDecimal.valueOf(5), BigDecimal.valueOf(2), normalPeriods, reducedPeriods);
        Period periodStay = new Period(1, 6);
        assertEquals(BigDecimal.valueOf(17), rate.calculate(periodStay));
    }

    @Test
    public void testInvalidRateCreation() {
        // Test for creating invalid rate instances
        assertThrows(IllegalArgumentException.class, () -> new Rate(CarParkKind.SOME_KIND, BigDecimal.valueOf(-1), BigDecimal.valueOf(2), new ArrayList<>(), new ArrayList<>()));
        assertThrows(IllegalArgumentException.class, () -> new Rate(CarParkKind.SOME_KIND, BigDecimal.valueOf(5), BigDecimal.valueOf(6), new ArrayList<>(), new ArrayList<>()));
    }

    @Test
    public void testInvalidPeriodCreation() {
        // Test for creating invalid period instances
        assertThrows(IllegalArgumentException.class, () -> new Period(10, 5));
    }
}
