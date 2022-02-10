package com.springdemoapp.controller;

import com.springdemoapp.data.entity.Student;
import com.springdemoapp.domain.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setup() {
        student = new Student(1, "abc", 101, "hyd");
    }

    @Test
    void testSaveStudent() throws Exception {
        Student studentEntity = new Student(1, "abc", 101, "hyd");
        Mockito.when(studentService.addStudent(studentEntity)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\r\n" +
                        "  \"id\": 1,\r\n" +
                        "  \"name\": \"abc\",\r\n" +
                        "  \"rollNo\": 101,\r\n" +
                        "  \"address\": \"hyd\"\r\n" +
                        "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
