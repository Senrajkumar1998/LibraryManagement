package com.example.Library_managementsystem.Controller;

import com.example.Library_managementsystem.Entity.Book;
import com.example.Library_managementsystem.Service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) throws Exception {
        return bookService.addBook(book);
    }
}
