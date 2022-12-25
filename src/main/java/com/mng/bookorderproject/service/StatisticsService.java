package com.mng.bookorderproject.service;

import com.mng.bookorderproject.dto.res.MonthlyStatisticsResponseDto;

import java.util.List;

public interface StatisticsService {
    List<MonthlyStatisticsResponseDto> getCustomersOrderMonthlyStatistics(Long customerId);
}
