package com.demo.springboot.domain.dto;

/**
 * Created by tomaszgadek on 16.10.2017.
 */
public class ErrorDto {

    private String errorMessage;

    public ErrorDto(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
