//czy liczba jest liczba pierwszą
package com.demo.springboot.rest;


import com.demo.springboot.domain.dto.LipDto;
import com.demo.springboot.service.LipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")

public class lipController {

    @Autowired
    private LipService lipService;

    @RequestMapping(value = "/math/prime/{numbers}", method = RequestMethod.GET)
    public ResponseEntity<LipDto>  pierwsza(@PathVariable("numbers") int numbers){


        final LipDto result= lipService.prime(numbers);
        //return new ResponseEntity<>(result, HttpStatus.OK);

        if (result.getPrime().equals("false")) {

            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(result, HttpStatus.OK);

        }
    }

}
