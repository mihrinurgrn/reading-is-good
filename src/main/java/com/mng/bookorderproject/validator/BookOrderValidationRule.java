package com.mng.bookorderproject.validator;

import com.mng.bookorderproject.domain.BusinessValidationRule;

public enum BookOrderValidationRule implements BusinessValidationRule {
    INSUFFICIENT_STOCK_EXCEPTION("INSUFFICIENT_STOCK_EXCEPTION",
            "insufficient book stock"),
    ALREADY_USED_USERNAME("ALREADY_USED_USERNAME",
                                         "This username already used"),

    ALREADY_EXIST_BOOK("ALREADY_EXIST_BOOK",
            "This book already exist"),

    INVALID_BOOK_ID("INVALID_BOOK_ID",
                                  "There is no book with this book id"),
    INVALID_ORDER_ID("INVALID_ORDER_ID",
                            "There is no order with this book id"),
    INVALID_CUSTOMER_ID("INVALID_CUSTOMER_ID",
                            "There is no customer with this customer id");


    private final String code;
    private final String description;

    BookOrderValidationRule(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
