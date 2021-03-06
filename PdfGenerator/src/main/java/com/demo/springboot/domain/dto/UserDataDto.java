package com.demo.springboot.domain.dto;

import java.io.Serializable;

/**
 * Created by tomaszgadek on 09.10.2017.
 */
public class UserDataDto implements Serializable {

    private String firstName;
    private String lastName;
    private String description;

    public UserDataDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "UserDataDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
