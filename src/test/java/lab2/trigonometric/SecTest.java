package lab2.trigonometric;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value = PER_CLASS)
public class SecTest {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.001;

    private final SecCalculator cosec = new SecCalculator(ACCURACY, TrigonometryMocks.getCosMock());

    @ParameterizedTest
    @CsvFileSource(resources = "/sec_test_data.csv")
    public void tableValuesStubsTest(double expected, double num, double den) {
        double actual = cosec.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = cosec.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = cosec.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = cosec.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }
}

