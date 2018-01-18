package com.demo.springboot.domain.dto;

public class MaxDto {

    private String max;

    public MaxDto(String max)
    {
        this.max=max;
    }

    public String getMax()
    {
        return max;
    }

    public void setMax(String max)
    {
        this.max=max;
    }

}
