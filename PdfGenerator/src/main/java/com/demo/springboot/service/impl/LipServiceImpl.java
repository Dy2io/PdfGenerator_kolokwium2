package com.demo.springboot.service.impl;


import com.demo.springboot.domain.dto.LipDto;
import com.demo.springboot.service.LipService;
import org.springframework.stereotype.Service;


@Service
public class LipServiceImpl implements LipService {
    String napis;
@Override
    public LipDto prime(int numbers){

    double liczba = numbers;

   /* if(liczba%2==0){
        napis="true";
    }
    else{
        napis="false";
    }
*/
   if(liczba<2){
       napis="false";
   }
else{
       int i;
     for(i=2;i*i<=liczba;++i){
         if(liczba%i==0){
             napis="false";
         }
         else{
             napis="true";
         }
     }
   }



final LipDto wynik = new LipDto(napis);
return wynik;
}

}
