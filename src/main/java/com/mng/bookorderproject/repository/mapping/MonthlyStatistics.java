package com.mng.bookorderproject.repository.mapping;

import java.math.BigDecimal;

public interface MonthlyStatistics {
    BigDecimal getTotalPurchasedAmount();

    String getMonth();

    Long getTotalOrderCount();

    Long getTotalBookCount();
}
