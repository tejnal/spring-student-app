package com.springdemoapp.domain.service;

import com.springdemoapp.data.entity.Student;

import javax.validation.Valid;
import java.util.List;

public interface StudentService {


    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Integer id);

    Student updateStudentById(@Valid Student student, Integer id);

    Student deleteStudentById(Integer id);

    List<Student> getStudentByName(String name);

}
