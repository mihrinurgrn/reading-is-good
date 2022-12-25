package com.mng.bookorderproject.dto.res;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Map;

@Getter
@Setter
@Builder
public class MonthlyStatisticsResponseDto {

    private BigDecimal totalPurchasedAmount;

    private String month;

    private Long totalOrderCount;

    private Long totalBookCount;


}
