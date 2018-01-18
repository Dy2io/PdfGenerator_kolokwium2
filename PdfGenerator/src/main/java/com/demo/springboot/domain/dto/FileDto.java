package com.demo.springboot.domain.dto;

/**
 * Created by tomaszgadek on 13.10.2017.
 */
public class FileDto {

    private String filename;
    private Long size;

    public FileDto(String filename, Long size) {
        this.filename = filename;
        this.size = size;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return filename + ";" + size;
    }
}
