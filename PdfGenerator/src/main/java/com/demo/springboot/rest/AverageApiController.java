//srednia
package com.demo.springboot.rest;

import com.demo.springboot.domain.dto.AverageDto;
import com.demo.springboot.service.AverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class AverageApiController {

    @Autowired
    private AverageService averageService;

    @RequestMapping(value = "/math/digits/{numbers}", method = RequestMethod.GET)
    public ResponseEntity<AverageDto> average(@PathVariable("numbers") String numbers) {


        final AverageDto result = averageService.average(numbers); //metoda average i zmiena
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
//http://127.0.0.1:8080/api/

//ddddddddddddddd