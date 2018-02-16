package io.leancoders.margincalculator.impl;

import io.leancoders.margincalculator.RevenueCalculator;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class RevenueCalculatorImplTest {

    RevenueCalculator revenueCalculator;

    @Before
    public void setUp() throws Exception {
        revenueCalculator = new RevenueCalculatorImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRevenueOfNullMarginPercentage() {
        revenueCalculator.calculateRevenue(null,new BigDecimal(10));

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRevenueOfNullCostofGoods() {
        revenueCalculator.calculateRevenue(new BigDecimal(10),null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRevenueOfNegativeMargin() {
        revenueCalculator.calculateRevenue(new BigDecimal(-10),new BigDecimal(500));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRevenueOfCostofGodsShouldBePositiveNumber() {
        revenueCalculator.calculateRevenue(new BigDecimal(10),new BigDecimal(0));
    }

    @Test
    public void calculateRevenueOf_20_and_500() {
        assertEquals(new BigDecimal(400),
                revenueCalculator.calculateRevenue(new BigDecimal(20),new BigDecimal(500)));
    }

    @Test
    public void calculateRevenueOf_0_and_500() {
        assertEquals(new BigDecimal(500),
                revenueCalculator.calculateRevenue(new BigDecimal(0),new BigDecimal(500)));
    }

    @Test
    public void calculateRevenueOf_33_and_500() {
        assertEquals(new BigDecimal(335),
                revenueCalculator.calculateRevenue(new BigDecimal(33),new BigDecimal(500)));
    }

    @Test
    public void calculateRevenueOf_100_and_500() {
        assertEquals(new BigDecimal(0),
                revenueCalculator.calculateRevenue(new BigDecimal(100),new BigDecimal(500)));
    }

    @Test
    public void calculateRevenueWithLossOf_150_and_500() {
        assertEquals(new BigDecimal(-250),
                revenueCalculator.calculateRevenue(new BigDecimal(150),new BigDecimal(500)));
    }

    @Test
    public void calculateRevenueWithFullofLoss() {
        assertEquals(new BigDecimal(-500),
            revenueCalculator.calculateRevenue(new BigDecimal(200),new BigDecimal(500)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateRevenueLossShouldNotPassCostOfGoods() {
        revenueCalculator.calculateRevenue(new BigDecimal(201),new BigDecimal(500));
    }

}