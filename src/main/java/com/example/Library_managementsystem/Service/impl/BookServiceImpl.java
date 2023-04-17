package com.example.Library_managementsystem.Service.impl;

import com.example.Library_managementsystem.Entity.Author;
import com.example.Library_managementsystem.Entity.Book;
import com.example.Library_managementsystem.Repository.AuthorRepository;
import com.example.Library_managementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addBook(Book book) throws Exception {

        Author author;
        try {
            author=authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            throw new Exception("Author not present");
        }

        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book has been Added";

        //find all the book
        //find all the book of a particular author id;
        //find the no. of book return by author
    }
}
