package com.mng.bookorderproject.dto.req;

import com.mng.bookorderproject.model.Order;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
public class CustomerRequestDto {

    @NotNull
    private String customerName;

    @NotNull
    private String customerSurname;

    @NotNull
    private String username;

    @NotNull
    private String password;

}
