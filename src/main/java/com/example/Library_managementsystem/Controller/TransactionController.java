package com.example.Library_managementsystem.Controller;

import com.example.Library_managementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.IssueBookResponseDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    public IssueBookResponseDto issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto){

    }
}
