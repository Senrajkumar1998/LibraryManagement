package com.example.Library_managementsystem.Service.impl;

import com.example.Library_managementsystem.DTO.RequestDto.StudentRequestDto;
import com.example.Library_managementsystem.DTO.RequestDto.UpdateStudentMobileRequestDto;
import com.example.Library_managementsystem.DTO.ResponseDto.UpdateStudentMobileResponseDto;
import com.example.Library_managementsystem.Entity.Card;
import com.example.Library_managementsystem.Entity.Student;
import com.example.Library_managementsystem.Enum.CardStatus;
import com.example.Library_managementsystem.Exception.StudentNotFoundException;
import com.example.Library_managementsystem.Repository.StudentRepository;
import com.example.Library_managementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {

        //convert in student object

        Student student=new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());


        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("25-12-2024");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);
        return "Student has been added";

        //generate new  card for the student
       /* Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("12-06-2023");
        card.setStudent(student);

        //set card for student
        student.setCard(card);
        studentRepository.save(student);
        return "Student has been added successfully";*/

        //delete a student by id;
        //update the student by id;
        //find a student by id;
        //find all the student;
    }

    @Override
    public Student getStudentById(int id) {

        return studentRepository.findById(id).get();
    }

    @Override
    public UpdateStudentMobileResponseDto updateMobNo(UpdateStudentMobileRequestDto updateStudentMobileRequestDto) throws StudentNotFoundException {


        try {
             Student student=studentRepository.findById(updateStudentMobileRequestDto.getId()).get();
            student.setMobNo(updateStudentMobileRequestDto.getMobNo());
            Student updateStudent=studentRepository.save(student);

            //prepare responseDto
            UpdateStudentMobileResponseDto updateStudentMobileResponseDto=new UpdateStudentMobileResponseDto();
            updateStudentMobileResponseDto.setName(updateStudent.getName());
            updateStudentMobileResponseDto.setMobNo(updateStudentMobileRequestDto.getMobNo());
            return updateStudentMobileResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid student id");
        }

    }
}
