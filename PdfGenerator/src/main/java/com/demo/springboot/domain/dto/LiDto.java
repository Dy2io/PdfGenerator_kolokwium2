package com.demo.springboot.domain.dto;

public class LiDto {
    private String liczenie;

    public LiDto( String liczenie )
    {
        this.liczenie = liczenie;
    }

    public String getLiczenie()
    {
        return liczenie;
    }

    public void setLiczenie( String liczenie )
    {
        this.liczenie = liczenie;
    }


    @Override
    public String toString() {
        return liczenie;
    }

}