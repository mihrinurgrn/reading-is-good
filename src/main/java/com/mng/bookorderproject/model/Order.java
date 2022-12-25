package com.mng.bookorderproject.model;

import com.mng.bookorderproject.constant.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;

@Entity
@Getter
@Setter
@Table(name="orders")
@ApiModel(value = "Order Api model documentation", description = "Model")
public class Order extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unique id field of orderData object")
    private long orderId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "BOOK_ID")
    private Book book;

    @ApiModelProperty(value = "Status field of orderData object")
    private OrderStatus status;

    @ApiModelProperty(value = "Book count field of an orderData object")
    private Long bookCount;


    public Month getMonth(Order order)
    {
        return order.getCreatedAt().getMonth();
    }
}
