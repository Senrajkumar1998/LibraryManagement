package com.example.Library_managementsystem.Service.impl;

import com.example.Library_managementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_managementsystem.Entity.Author;
import com.example.Library_managementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {

        authorRepository.save(author);
        return "Author has been Added";

        //delete a author by id;
        //update the author by id;
        //find a author by id;
        //find all the author;
    }

    @Override
    public AuthorResponseDto getByEmail(String email) {
        Author author=authorRepository.findByEmail(email);

        //prepare response dto
        AuthorResponseDto authorResponseDto=new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());

        return authorResponseDto;
    }
}
