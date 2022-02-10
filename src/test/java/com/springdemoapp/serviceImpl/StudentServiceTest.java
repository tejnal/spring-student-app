package com.springdemoapp.serviceImpl;

import com.springdemoapp.data.entity.Student;
import com.springdemoapp.data.repository.StudentRepository;
import com.springdemoapp.domain.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @MockBean
    private StudentRepository studentRepository;


    @BeforeEach
    void setup() {
        Optional<Student> student = Optional.of(new Student(1, "abc", 100, "dlh"));
        Mockito.when(studentRepository.findById(1)).thenReturn(student);
    }

    @Test
    public void testGetStudentById() {
        var student_name = "abc";
        Student student = studentService.getStudentById(1);
        assertEquals(student_name, student.getName());
    }
}
