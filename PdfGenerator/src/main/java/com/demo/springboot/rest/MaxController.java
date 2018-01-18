package com.demo.springboot.rest;


import com.demo.springboot.domain.dto.AverageDto;
import com.demo.springboot.domain.dto.MaxDto;
import com.demo.springboot.service.MaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")

public class MaxController {

    @Autowired
    private MaxService maxService;

    @RequestMapping(value = "/math/getMax/{numbers}", method = RequestMethod.GET)
    public ResponseEntity<MaxDto> max(@PathVariable("numbers") String numbers){

        final MaxDto result = maxService.max(numbers);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
