package com.example.Library_managementsystem.Controller;

import com.example.Library_managementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_managementsystem.Service.impl.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @PostMapping("/add")
    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        try {
            return transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e){
            throw new Exception("there is problem");
        }
    }
}
