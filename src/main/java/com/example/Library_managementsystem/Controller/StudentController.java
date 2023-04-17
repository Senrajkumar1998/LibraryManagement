package com.example.Library_managementsystem.Controller;

import com.example.Library_managementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.Library_managementsystem.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.Library_managementsystem.Entity.Student;
import com.example.Library_managementsystem.Exception.StudentNotFoundException;
import com.example.Library_managementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);

    }

    @PutMapping("/update_mobile")
    public UpdateStudentMobileResponseDto updateStudentMobileResponseDto(@RequestBody UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException {

       return  studentService.updateMobNo(updateStudentMobileRequestDto);
    }

    //Get student by id
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam("id") int id){
        return studentService.getStudentById(id);
    }
}
