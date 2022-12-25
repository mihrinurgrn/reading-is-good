package com.mng.bookorderproject.dto.req;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class OrderFilterRequestDto {
    LocalDate startDate;
    LocalDate endDate;
}
