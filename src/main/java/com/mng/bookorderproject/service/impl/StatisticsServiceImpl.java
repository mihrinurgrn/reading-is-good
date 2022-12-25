package com.mng.bookorderproject.service.impl;

import com.mng.bookorderproject.BookorderprojectApplication;
import com.mng.bookorderproject.dto.res.MonthlyStatisticsResponseDto;
import com.mng.bookorderproject.repository.OrderRepository;
import com.mng.bookorderproject.repository.mapping.MonthlyStatistics;
import com.mng.bookorderproject.service.StatisticsService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StatisticsServiceImpl implements StatisticsService {
    private static final Logger LOGGER = LogManager.getLogger(BookorderprojectApplication.class);
    private final OrderRepository orderRepository;
    @Override
    public List<MonthlyStatisticsResponseDto> getCustomersOrderMonthlyStatistics(Long customerId) {
        List<MonthlyStatistics> statisticsResponse = orderRepository.getOrdersStatistics(customerId);
        List<MonthlyStatisticsResponseDto> responseDtoList = new ArrayList<>();
        for(MonthlyStatistics statistics : statisticsResponse)
        {
            MonthlyStatisticsResponseDto dto = MonthlyStatisticsResponseDto.builder()
                    .totalBookCount(statistics.getTotalBookCount())
                    .month(statistics.getMonth())
                    .totalOrderCount(statistics.getTotalOrderCount())
                    .totalPurchasedAmount(statistics.getTotalPurchasedAmount())
                    .build();
            responseDtoList.add(dto);
        }
        LOGGER.info("Monthly statistics" + responseDtoList);
        return responseDtoList;
    }
}
