package com.mng.bookorderproject.controller;

import com.mng.bookorderproject.dto.BaseResponse;
import com.mng.bookorderproject.dto.req.CustomerRequestDto;
import com.mng.bookorderproject.dto.res.BookResponseDto;
import com.mng.bookorderproject.dto.res.OrderResponseDto;
import com.mng.bookorderproject.model.Customer;
import com.mng.bookorderproject.model.Order;
import com.mng.bookorderproject.service.CustomerService;
import com.mng.bookorderproject.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Api(value = "Customer Api documentation")
public class CustomerController {
    private final CustomerService customerService;
    private final OrderService orderService;

    @ApiOperation(value = "New customer adding method")
    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody CustomerRequestDto customer) {
        customerService.save(customer);
    }

    @ApiOperation(value = "Get Orders for given customer Id")
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public BaseResponse<List<OrderResponseDto>> getCustomerOrders(@PathVariable Long id) {
        return BaseResponse.fromData(orderService.getCustomersOrders(id).stream()
                .map(OrderResponseDto::fromOrderEntity).collect(Collectors.toList()));
    }
}
