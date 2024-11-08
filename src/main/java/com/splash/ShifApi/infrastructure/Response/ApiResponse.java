package com.splash.ShifApi.infrastructure.Response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T>{
    private String message;
    private T content;

    public ApiResponse(String message, T content) {
        this.message = message;
        this.content = content;
    }
}
