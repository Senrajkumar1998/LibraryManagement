package com.example.Library_managementsystem.Service.impl;

import com.example.Library_managementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_managementsystem.Entity.Author;

public interface AuthorService {

    public String addAuthor(Author author);
    public AuthorResponseDto getByEmail(String email);
}
