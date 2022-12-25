package com.mng.bookorderproject.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ApiModel(value = "Book Api model documentation", description = "Model")
public class Book extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unique id field of bookData object")
    private Long bookId;

    @ApiModelProperty(value = "Book name field of bookData object")
    private String bookName;

    @ApiModelProperty(value = "Stock value field of bookData object")
    private Long stock;

    @ApiModelProperty(value = "Amount value field of bookData object")
    private BigDecimal amount;

    @OneToMany(mappedBy="book")
    private List<Order> orderList;

}
