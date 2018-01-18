//wyszukiwanie zadanej litery w danym napisie i zliczanie ile ich jest
package com.demo.springboot.rest;

import com.demo.springboot.domain.dto.LiDto;
import com.demo.springboot.service.LiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api")

public class LiCon{


    @Autowired
    private LiService liService;



    @RequestMapping(value = "/math/li/length", method = RequestMethod.GET)
    public ResponseEntity<LiDto> liczenie(@RequestParam(value = "text", required = false) String tekst,
                                          @RequestParam(value = "character", required = false) char character) {


        final LiDto result = liService.liczenie(tekst,character);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}