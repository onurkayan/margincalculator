package io.leancoders.margincalculator;

import java.math.BigDecimal;

public interface RevenueCalculator {

    BigDecimal calculateRevenue(
            BigDecimal marginPercentage,
            BigDecimal costOfGoods
    );
}
