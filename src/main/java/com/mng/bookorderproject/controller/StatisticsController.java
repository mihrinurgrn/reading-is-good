package com.mng.bookorderproject.controller;

import com.mng.bookorderproject.dto.BaseResponse;
import com.mng.bookorderproject.dto.res.MonthlyStatisticsResponseDto;
import com.mng.bookorderproject.dto.res.OrderResponseDto;
import com.mng.bookorderproject.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
@Api(value = "Statistics Api documentation")
public class StatisticsController {
    private final StatisticsService statisticsService;
    @ApiOperation(value = "Get Customers Order Statistics")
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    public BaseResponse<List<MonthlyStatisticsResponseDto>> getMonthlyStatistics(@PathVariable long customerId) {
        return BaseResponse.fromData(statisticsService.getCustomersOrderMonthlyStatistics(customerId));
    }
}
