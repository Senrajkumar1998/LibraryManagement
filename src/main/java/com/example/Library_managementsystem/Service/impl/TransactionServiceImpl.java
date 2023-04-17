package com.example.Library_managementsystem.Service.impl;

import com.example.Library_managementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_managementsystem.Entity.Book;
import com.example.Library_managementsystem.Entity.Card;
import com.example.Library_managementsystem.Entity.Transaction;
import com.example.Library_managementsystem.Enum.CardStatus;
import com.example.Library_managementsystem.Enum.TransactionStatus;
import com.example.Library_managementsystem.Repository.BookRepository;
import com.example.Library_managementsystem.Repository.CardRepository;
import com.example.Library_managementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction=new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);


        Card card;
        try {
            card=cardRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card Id");
        }
        transaction.setCard(card);

        Book book;
        try {
            book=bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book Id not found");
        }
        transaction.setBook(book);

        if (card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not active");
        }
        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBookList().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card);//save card,book,transaction

        //prepare response dto
        IssueBookResponseDto issueBookResponseDto=new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());

        return issueBookResponseDto;
    }
    //return book Api
}
