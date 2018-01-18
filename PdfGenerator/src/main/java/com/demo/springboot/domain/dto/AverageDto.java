package com.demo.springboot.domain.dto;

public class AverageDto {
    private String average;  //wyświetlana nazwa w przeglądarce

    public AverageDto( String average ) {
        this.average = average;
    }  // konstruktor

    public String getAverage() {
        return average;
    }

    public void setAverage( String average ) {
        this.average = average;
    }

    @Override
    public String toString() {
        return average;
    }
}


 /*public String toString() {
        return average+";"+druga zmiena;  przykład dla 2 zmienych fileDto
  }

*/