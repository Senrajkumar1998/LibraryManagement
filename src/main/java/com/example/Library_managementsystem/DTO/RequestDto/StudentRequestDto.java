package com.example.Library_managementsystem.DTO.RequestDto;

import com.example.Library_managementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class StudentRequestDto {

    private String name;
    private int age;
    private String mobNo;

    private Department department;
}
