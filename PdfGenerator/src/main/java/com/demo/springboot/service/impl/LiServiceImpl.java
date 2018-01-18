package com.demo.springboot.service.impl;

import com.demo.springboot.domain.dto.LiDto;
import com.demo.springboot.service.LiService;
import org.springframework.stereotype.Service;

@Service
public class LiServiceImpl implements LiService {

    @Override
    public LiDto liczenie(String tekst, char character) {
       /* String[] temp = tekst.split(","); //temp[0],temp[1],....
        double srednia = 0;
        int i;
        for( i = 0; i < temp.length; i++) {
            srednia += Double.parseDouble(temp[i]);
        }
        srednia /= i;
*/
       //double srednia=tekst.length();

        //Arrays.sort(temp); sortowanie
        //Arrays.sort(temp, Collections.reverseOrder()); sortowanie odwrotne
        //String nowyStringOdwrotny = new StringBuilder(staryString).reverse().toString() wspak


        String s = tekst;
        int counter = 0;
        for( int i=0; i<s.length(); i++ ) {
            if( s.charAt(i) == character ) {
                counter++;
            }
        }




        final LiDto wynik = new LiDto( Integer.toString(counter) );
        return wynik;
    }
}