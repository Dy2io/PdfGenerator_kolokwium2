//wypisywanie imienia i nazwiska zadanego w argumentach
package com.demo.springboot.rest;


import com.demo.springboot.domain.dto.ImDto;
import com.demo.springboot.service.ImService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api")

public class ImController {

    @Autowired
    private ImService imService;


    @RequestMapping(value = "/math/wypisz/imie", method = RequestMethod.GET)
    public ResponseEntity<ImDto> wypisz(@RequestParam(value= "firstName", required = false) String firstName,
                                        @RequestParam(value= "lastName", required = false) String lastName){


        final ImDto result= imService.wypisz(firstName,lastName);
        return new ResponseEntity<>(result, HttpStatus.OK);

    }

}
