package lab2;

import lab2.logariphmic.LnCalculator;
import lab2.logariphmic.LogBaseCalculator;
import lab2.trigonometric.*;

public class Function extends Calculator {
    private final SinCalculator sin;
    private final CosecCalculator cosec;
    private final SecCalculator sec;
    private final CotCalculator cot;
    private final LnCalculator ln;
    private final LogBaseCalculator log2;
    private final LogBaseCalculator log3;
    private final LogBaseCalculator log10;
    private final CosCalculator cos;
    private final TanCalculator tan;

    public Function(double accuracy, SinCalculator sin, CosecCalculator cosec, SecCalculator sec,
                    CotCalculator cot, TanCalculator tan, LnCalculator ln, CosCalculator cos,
                    LogBaseCalculator log2, LogBaseCalculator log3, LogBaseCalculator log10) {
        super(accuracy);
        this.sin = sin;
        this.cosec = cosec;
        this.sec = sec;
        this.cot = cot;
        this.ln = ln;
        this.log2 = log2;
        this.log3 = log3;
        this.log10 = log10;
        this.cos = cos;
        this.tan = tan;
    }

    public double calculate(double x) {
        if (x <= 0)
            return (((Math.pow(Math.pow((sec.calculate(x)), 3), 2) / cos.calculate(x)) * (tan.calculate(x)/ (cot.calculate(x)-cosec.calculate(x)))) * (cot.calculate(x) + sin.calculate(x) + cosec.calculate(x)));
        else
            return ((((((log10.calculate(x)- log2.calculate(x))-(log2.calculate(x)/log3.calculate(x)))-(log2.calculate(x)*ln.calculate(x)))*(log3.calculate(x)- log10.calculate(x))))/(ln.calculate(x)+ log2.calculate(x)));
    }

}
