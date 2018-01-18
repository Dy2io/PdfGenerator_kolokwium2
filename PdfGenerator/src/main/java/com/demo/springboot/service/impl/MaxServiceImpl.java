package com.demo.springboot.service.impl;

import com.demo.springboot.domain.dto.MaxDto;
import com.demo.springboot.service.MaxService;
import org.springframework.stereotype.Service;


@Service
public class MaxServiceImpl implements MaxService {
    @Override
    public MaxDto max(String numbers) {

        String[] temp = numbers.split(",");
double li= Double.parseDouble(temp[0]);

int i;
for(i=0;i<temp.length;++i)
{
    if(li<Double.parseDouble(temp[i]))
        li=Double.parseDouble(temp[i]);
}

        final MaxDto wynik = new MaxDto(Double.toString(li));
         return wynik;

    }
}
