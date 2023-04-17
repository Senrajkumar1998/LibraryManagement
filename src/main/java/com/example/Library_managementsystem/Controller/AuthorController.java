package com.example.Library_managementsystem.Controller;

import com.example.Library_managementsystem.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_managementsystem.Entity.Author;
import com.example.Library_managementsystem.Service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
         return authorService.addAuthor(author);
    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email){

        return authorService.getByEmail(email);
    }

    //delete  a student by id
    //update student by id
    //find student by id
    //find all the student
    //get all the author of particular age
}
