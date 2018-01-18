package com.demo.springboot.repository.impl;

import com.demo.springboot.domain.dto.FileDto;
import com.demo.springboot.domain.entity.File;
import com.demo.springboot.repository.FileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by tomaszgadek on 09.10.2017.
 */

@Repository
public class FileRepositoryImpl implements FileRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileRepositoryImpl.class);

    @Value("classpath:files.data")
    private Resource resource;

    private List<FileDto> findAllFiles() {

        final List<FileDto> files = new ArrayList<>();

        try {
            final List<String> lines = Files.readAllLines(Paths.get(resource.getURI()), StandardCharsets.UTF_8);

            for (final String line: lines) {

                final String[] fileData = line.split(";");
                final FileDto fileDto = prepareFile(fileData);

                files.add(fileDto);
            }


        } catch (IOException e) {
            LOGGER.error("--- Error reading data file");
        }

        return files;
    }

    private FileDto prepareFile(final String[] fileData) {

        final String name = fileData[0];
        final Long size = Long.valueOf(fileData[1]);

        return new FileDto(name, size);
    }

    private void saveDataToFile(final List<String> lines) {

        try {

            Files.write(Paths.get(resource.getURI()), lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            LOGGER.error("--- Error writing file");
        }
    }

    @Override
    public void saveFile(File file) {

        final List<FileDto> filesDto = findAllFiles();

        final FileDto fileDto = new FileDto(file.getName(), file.getSize());
        filesDto.add(fileDto);

        // TODO: strumienie
        final List<String> lines = filesDto
                .stream()
                .map(FileDto::toString)
                .collect(Collectors.toList());

/*
        //TODO: inne rozwiazanie, przy pomocy petli
        final List<String> lines = new ArrayList<>();

        for (final FileDto currentFile: filesDto) {
            lines.add(currentFile.toString());
        }
*/

        saveDataToFile(lines);
    }

    @Override
    public List<FileDto> findAll() {
        return findAllFiles();
    }

    @Override
    public FileDto findFile(String filename) {

        final List<FileDto> files = findAllFiles();

        for (final FileDto fileDto: files) {

            if (fileDto.getFilename().contains(filename)) {
                return fileDto;
            }
        }

        return null;
    }
}
