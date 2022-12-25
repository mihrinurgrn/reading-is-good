package com.mng.bookorderproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private boolean success;

    private ErrorResponse error;

    private T data;

    public static <T> BaseResponse<T> fromData(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.success = true;
        response.data = data;
        return response;
    }

    public static BaseResponse fromError(ErrorResponse errorResponse) {
        BaseResponse<Object> response = new BaseResponse<>();
        response.data = null;
        response.setSuccess(false);
        response.setError(errorResponse);
        return response;
    }
}