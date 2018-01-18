//srednia
package com.demo.springboot.service.impl;

import com.demo.springboot.domain.dto.AverageDto;
import com.demo.springboot.service.AverageService;
import org.springframework.stereotype.Service;

@Service
public class AverageServiceImpl implements AverageService {

    @Override
    public AverageDto average(String numbers) {
        String[] temp = numbers.split(","); //temp[0],temp[1],....
        double srednia = 0;
        int i;
        for( i = 0; i < temp.length; i++) {
            srednia += Double.parseDouble(temp[i]);
        }
        srednia /= i;

        final AverageDto wynik = new AverageDto( Double.toString(srednia) );
        return wynik;
    }
}