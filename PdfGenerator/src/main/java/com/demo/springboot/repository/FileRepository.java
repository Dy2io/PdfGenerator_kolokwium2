package com.demo.springboot.repository;

import com.demo.springboot.domain.dto.FileDto;
import com.demo.springboot.domain.entity.File;
import java.util.List;

/**
 * Created by tomaszgadek on 09.10.2017.
 */

public interface FileRepository {

    void saveFile(File file);

    List<FileDto> findAll();

    FileDto findFile(String filename);
}
