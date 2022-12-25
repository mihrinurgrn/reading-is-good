package com.mng.bookorderproject.dto;

import com.mng.bookorderproject.constant.StockUpdateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class StockUpdateData {
    public final Long bookId;
    public final Long bookCount;
    public final StockUpdateType stockUpdateType;

}
