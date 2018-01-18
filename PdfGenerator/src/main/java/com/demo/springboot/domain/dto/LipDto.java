package com.demo.springboot.domain.dto;

public class LipDto {
    private String prime;

    public LipDto(String prime){
        this.prime=prime;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime){
        this.prime=prime;
    }

    @Override
    public String toString(){return prime;}
}
