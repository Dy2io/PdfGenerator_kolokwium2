package com.demo.springboot.domain.dto;

public class ImDto {
    private String firstName;
    private String lastName;

    public ImDto(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }


    @Override
    public String toString(){return firstName+"\n"+lastName ;}
}
