package com.demo.springboot.rest;

import com.demo.springboot.domain.dto.ErrorDto;
import com.demo.springboot.domain.dto.FileDto;
import com.demo.springboot.domain.dto.FileMetadata;
import com.demo.springboot.domain.dto.UserDataDto;
import com.demo.springboot.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

/**
 * Created by tomaszgadek on 09.10.2017.
 */

@Controller
@RequestMapping("/api")
public class PdfGeneratorApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfGeneratorApiController.class);

    //private static final String PATH = "D:\\"; // dla windows

    private static final String PATH = "/home/"; // dla linux / unix

    @Autowired
    private FileService fileService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("TOMCAT RUN! :-)", HttpStatus.OK);
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public ResponseEntity<List<FileDto>> findAllFiles() {

        LOGGER.info("--- find all files");

        final List<FileDto> files = fileService.findAll();

        return files.isEmpty() ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(files, HttpStatus.OK);
    }

    @RequestMapping(value = "/file/{filename}", method = RequestMethod.GET)
    public ResponseEntity<FileDto> findFile(@PathVariable("filename") String filename) {

        LOGGER.info("--- find file");

        final FileDto file = fileService.findFile(filename);

        return file != null ?
                new ResponseEntity<>(file, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    public ResponseEntity<?> createFile(@RequestBody UserDataDto userDataDto) {

        LOGGER.info("Creating pdf file for user: {}", userDataDto.getFirstName());

        final FileMetadata fileMetadata = fileService.createFile(userDataDto, PATH);

        return fileMetadata != null ?
                new ResponseEntity<>(fileMetadata, HttpStatus.CREATED) :
                new ResponseEntity<>(
                        new ErrorDto("Niepoprawana lokalizacja (PATH)"),
                        HttpStatus.NOT_FOUND);
    }
}
