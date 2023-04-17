package com.example.Library_managementsystem.DTO.ResponseDto;

import com.example.Library_managementsystem.Entity.Transaction;
import com.example.Library_managementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IssueBookResponseDto {

    private String transactionNumber;
    private TransactionStatus transactionStatus;
    private String bookName;
}
