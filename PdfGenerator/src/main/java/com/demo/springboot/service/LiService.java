package com.demo.springboot.service;

import com.demo.springboot.domain.dto.LiDto;

public interface LiService {
    LiDto liczenie(String tekst, char character);
}