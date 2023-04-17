package com.example.Library_managementsystem.Service.impl;

import com.example.Library_managementsystem.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
