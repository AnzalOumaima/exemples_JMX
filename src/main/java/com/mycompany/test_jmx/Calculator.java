package com.mycompany.test_jmx;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Admin
 */
public class Calculator implements CalculatorMBean {

    private int decimalPlaces = 2;

    public double add(double d1, double d2) {
        BigDecimal bd1 = new BigDecimal(d1);
        BigDecimal bd2 = new BigDecimal(d2);

        BigDecimal sum = bd1.add(bd2);
        return sum.setScale(decimalPlaces, RoundingMode.HALF_UP).doubleValue();
    }

    public void setDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public int getDecimalPlaces() {
        return decimalPlaces;
    }
}
