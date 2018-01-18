package com.demo.springboot.service;

import com.demo.springboot.domain.dto.FileDto;
import com.demo.springboot.domain.dto.FileMetadata;
import com.demo.springboot.domain.dto.UserDataDto;
import java.util.List;

/**
 * Created by tomaszgadek on 09.10.2017.
 */

public interface FileService {

    FileMetadata createFile(UserDataDto userDataDto, String path);

    List<FileDto> findAll();

    FileDto findFile(String filename);
}
