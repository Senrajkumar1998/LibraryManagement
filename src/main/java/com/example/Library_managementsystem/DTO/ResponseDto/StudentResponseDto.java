package com.example.Library_managementsystem.DTO.ResponseDto;

import com.example.Library_managementsystem.Entity.Card;
import com.example.Library_managementsystem.Enum.Department;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentResponseDto {

    private int id;

    private String name;

    private int age;
    private String  mobNo;

    private Department department;

    CardResponseDto cardResponseDto;

}
