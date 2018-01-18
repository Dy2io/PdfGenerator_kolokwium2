package com.demo.springboot.service.impl;

import com.demo.springboot.domain.dto.FileDto;
import com.demo.springboot.domain.dto.FileMetadata;
import com.demo.springboot.domain.dto.UserDataDto;
import com.demo.springboot.domain.entity.File;
import com.demo.springboot.domain.mapper.FileMapper;
import com.demo.springboot.repository.FileRepository;
import com.demo.springboot.service.FileService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by tomaszgadek on 09.10.2017.
 */

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileMapper fileMapper;

    private FileMetadata getMetadata(String fileDestination) throws IOException {

        final Path filePath = Paths.get(fileDestination);
        BasicFileAttributes fileAttributes = Files.readAttributes(filePath, BasicFileAttributes.class);

        final FileMetadata fileMetadata = new FileMetadata();

        fileMetadata.setPath(fileDestination);
        fileMetadata.setCreationTime(fileAttributes.creationTime().toString());
        fileMetadata.setLastAccessTime(fileAttributes.lastAccessTime().toString());
        fileMetadata.setLastModifiedTime(fileAttributes.lastModifiedTime().toString());
        fileMetadata.setSize(fileAttributes.size());

        return fileMetadata;
    }

    @Override
    public FileMetadata createFile(UserDataDto userDataDto, String path) {

        final String fileDestination = path +
                userDataDto.getFirstName() +
                userDataDto.getLastName() +
                "_" +
                ZonedDateTime.now().toEpochSecond() +
                ".pdf";

        try {

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileDestination));
            document.open();
            BaseFont base = BaseFont.createFont("static/arial.ttf",  BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font chapterFont = new Font(base, 16, Font.NORMAL);
            Font paragraphFont = new Font(base, 12, Font.NORMAL);
            Chunk chunk = new Chunk(userDataDto.getFirstName() + " " + userDataDto.getLastName(), chapterFont);
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(2);
            chapter.add(new Paragraph(userDataDto.getDescription(), paragraphFont));
            document.add(chapter);
            document.close();

            final File file = new File();
            file.setName(userDataDto.getFirstName() + userDataDto.getLastName());
            file.setSize(getMetadata(fileDestination).getSize());

            fileRepository.saveFile(file);

            return getMetadata(fileDestination);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<FileDto> findAll() {
        // TODO: po wstrzyknieciu fileMapper mamy dostep od razu do metod komponentu
        fileMapper.runComponent();

        return fileRepository.findAll();
    }

    @Override
    public FileDto findFile(String filename) {
        return fileRepository.findFile(filename);
    }
}
