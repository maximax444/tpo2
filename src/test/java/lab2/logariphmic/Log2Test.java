package lab2.logariphmic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value=PER_CLASS)
public class Log2Test {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.001;

    private final LogBaseCalculator log2 = new LogBaseCalculator(ACCURACY, 2, LogMocks.getLnMock());

    @ParameterizedTest
    @CsvFileSource(resources = "/log2_test_data.csv")
    public void tableValuesStubsTest(double expected, double num, double den) {
        double actual = log2.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void nanStubsTest() {
        double expected = Double.NaN;
        double actual = log2.calculate(Double.NaN);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void positiveInfinityStubsTest() {
        double expected = Double.POSITIVE_INFINITY;
        double actual = log2.calculate(Double.POSITIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void negativeInfinityStubsTest() {
        double expected = Double.NaN;
        double actual = log2.calculate(Double.NEGATIVE_INFINITY);
        assertEquals(expected, actual, DELTA);
    }
}
