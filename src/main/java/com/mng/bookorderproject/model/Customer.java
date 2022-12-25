package com.mng.bookorderproject.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ApiModel(value = "Customer Api model documentation", description = "Model")
public class Customer extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Unique id field of customerData object")
    private Long customerId;

    @ApiModelProperty(value = "Book name field of customerData object")
    private String customerName;

    @ApiModelProperty(value = "File path of customerData object")
    private String customerSurname;

    @ApiModelProperty(value = "User name field of customer object")
    @Column(unique = true)
    private String username;

    @ApiModelProperty(value = "Password field of customer object")
    private String password;

    @OneToMany(mappedBy="customer")
    private List<Order> orderList;

}
