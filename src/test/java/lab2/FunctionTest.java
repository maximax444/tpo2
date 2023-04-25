package lab2;

import lab2.logariphmic.LnCalculator;
import lab2.logariphmic.LogBaseCalculator;
import lab2.logariphmic.LogMocks;
import lab2.trigonometric.*;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(value = PER_CLASS)
public class FunctionTest {
    private static final double DELTA = 0.05;
    private static final double ACCURACY = 0.00001;

    private final SinCalculator sinMock = TrigonometryMocks.getSinMock();
    private final CosCalculator cosMock = TrigonometryMocks.getCosMock();
    private final SecCalculator secMock = TrigonometryMocks.getSecMock();
    private final CosecCalculator cosecMock = TrigonometryMocks.getCosecMock();
    private final TanCalculator tanMock = TrigonometryMocks.getTanMock();
    private final CotCalculator cotMock = TrigonometryMocks.getCotMock();
    private final LnCalculator lnMock = LogMocks.getLnMock();
    private final LogBaseCalculator log2Mock = LogMocks.getLog2Mock();
    private final LogBaseCalculator log3Mock = LogMocks.getLog3Mock();
    private final LogBaseCalculator log10Mock = LogMocks.getLog10Mock();
    private final SinCalculator sin = new SinCalculator(ACCURACY);
    private final CosCalculator cos = new CosCalculator(ACCURACY, sin);
    private final CosecCalculator cosec = new CosecCalculator(ACCURACY, sin);
    private final SecCalculator sec = new SecCalculator(ACCURACY, cos);
    private final CotCalculator cot = new CotCalculator(ACCURACY, sin, cos);
    private final TanCalculator tan = new TanCalculator(ACCURACY, sin, cos);
    private final LnCalculator ln = new LnCalculator(ACCURACY);
    private final LogBaseCalculator log2 = new LogBaseCalculator(ACCURACY, 2, ln);
    private final LogBaseCalculator log3 = new LogBaseCalculator(ACCURACY, 3, ln);
    private final LogBaseCalculator log10 = new LogBaseCalculator(ACCURACY, 10, ln);

    private Function function;


    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void allMockTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tanMock, lnMock, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void sinStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sin, cosecMock, secMock, cotMock, tanMock, lnMock, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void cosecStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosec, secMock, cotMock, tanMock, lnMock, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void secStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, sec, cotMock, tanMock, lnMock, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void cotStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cot, tanMock, lnMock, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void tanStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tan, lnMock, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void lnStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tanMock, ln, cosMock, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void cosStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tanMock, lnMock, cos, log2Mock, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void log2StubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tanMock, lnMock, cosMock, log2, log3Mock, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void log3StubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tanMock, lnMock, cosMock, log2Mock, log3, log10Mock
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void log10StubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sinMock, cosecMock, secMock, cotMock, tanMock, lnMock, cosMock, log2Mock, log3Mock, log10
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/function_test_data.csv")
    public void allStubTest(double expected, double num, double den) {
        function = new Function(ACCURACY,
                sin, cosec, sec, cot, tan, ln, cos, log2, log3, log10
        );
        double actual = function.calculate(num * PI / den);
        assertEquals(expected, actual, DELTA);
    }
}
