package com.example.Library_managementsystem.Service;

import com.example.Library_managementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.Library_managementsystem.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_managementsystem.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.Library_managementsystem.Entity.Student;
import com.example.Library_managementsystem.Exception.StudentNotFoundException;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);
    public StudentResponseDto getStudentById(int id);
    public UpdateStudentMobileResponseDto updateMobNo(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException;
}
