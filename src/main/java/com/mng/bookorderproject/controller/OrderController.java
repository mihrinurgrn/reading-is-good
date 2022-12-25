package com.mng.bookorderproject.controller;

import com.mng.bookorderproject.dto.BaseResponse;
import com.mng.bookorderproject.dto.req.OrderFilterRequestDto;
import com.mng.bookorderproject.dto.req.OrderRequestDto;
import com.mng.bookorderproject.dto.res.OrderResponseDto;
import com.mng.bookorderproject.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Api(value = "Order Api documentation")
public class OrderController {
    private final OrderService orderService;
    @ApiOperation(value = "New order adding method")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public BaseResponse<OrderResponseDto> addOrder(@RequestBody OrderRequestDto order) {
        return BaseResponse.fromData(OrderResponseDto.fromOrderEntity(orderService.doOrder(order)));
    }

    @ApiOperation(value = "Get Order by OrderId")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BaseResponse<OrderResponseDto> getOrderById(@PathVariable long id) {
        return BaseResponse.fromData(OrderResponseDto.fromOrderEntity(orderService.getOrderByOrderId(id)));
    }

    @ApiOperation(value = "Get orders in date interval")
    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public BaseResponse<List<OrderResponseDto>> getOrdersInDateInterval(@RequestBody OrderFilterRequestDto requestDto) {
        return BaseResponse.fromData(orderService.getOrdersInDateInterval(requestDto)
                .stream().map(OrderResponseDto::fromOrderEntity).collect(Collectors.toList()));
    }
}
