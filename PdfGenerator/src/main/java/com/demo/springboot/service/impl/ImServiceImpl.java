package com.demo.springboot.service.impl;


import com.demo.springboot.domain.dto.ImDto;
import com.demo.springboot.service.ImService;
import org.springframework.stereotype.Service;

@Service

public class ImServiceImpl implements ImService{

    @Override
    public ImDto wypisz(String firstName, String lastName){

     String imię=firstName;
     String nazwisko=lastName;


        final ImDto wynik=new ImDto(imię, nazwisko);
        return wynik;
    }
}
