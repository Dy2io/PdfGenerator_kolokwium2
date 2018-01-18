package com.demo.springboot.domain.entity;

/**
 * Created by tomaszgadek on 09.10.2017.
 */

public class File {

    private String name;
    private Long size;

    public File() {
    }

    public File(String name, Long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return name + ".pdf;" + size;
    }
}
