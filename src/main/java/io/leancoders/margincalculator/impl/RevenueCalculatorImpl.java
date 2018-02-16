package io.leancoders.margincalculator.impl;

import io.leancoders.margincalculator.RevenueCalculator;

import java.math.BigDecimal;

public class RevenueCalculatorImpl implements RevenueCalculator {
    public BigDecimal calculateRevenue(BigDecimal marginPercentage, BigDecimal costOfGoods) {
        if(isBooundaryCheckFailed(marginPercentage,costOfGoods))
            throw  new IllegalArgumentException();
        BigDecimal margin = costOfGoods.multiply(marginPercentage).divide(new BigDecimal(100));
        BigDecimal revenue = costOfGoods.subtract(margin);
        return revenue;
    }

    private boolean isBooundaryCheckFailed(BigDecimal marginPercentage, BigDecimal costOfGoods) {
        return ( null == marginPercentage ||
                 null == costOfGoods ||
                 marginPercentage.compareTo(new BigDecimal(0)) < 0 ||
                 marginPercentage.compareTo(new BigDecimal(200)) > 0 ||
                 costOfGoods.compareTo(new BigDecimal(1)) < 0);

    }
}
