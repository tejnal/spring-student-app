package com.springdemoapp.controller;

import com.springdemoapp.data.entity.Student;
import com.springdemoapp.domain.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student/")
@Slf4j
public class StudentController {

  @Autowired private StudentService studentService;

  @PostMapping
  public Student addStudent(@Valid @RequestBody Student student) {
    return studentService.addStudent(student);
  }

  @GetMapping
  public List<Student> getAllStudent() {
    return studentService.getAllStudent();
  }

  @GetMapping("/{student-id}")
  public Student getStudentById(@PathVariable("student-id") Integer id) {
    return studentService.getStudentById(id);
  }

  @PutMapping("/{student-id}")
  public Student updateStudentById(
      @Valid @RequestBody Student student, @PathVariable("student-id") Integer id) {
    return studentService.updateStudentById(student, id);
  }

  @DeleteMapping("/{student-id}")
  public Student deleteStudentById(@PathVariable("student-id") Integer id) {
    return studentService.deleteStudentById(id);
  }

  @GetMapping("/name/{student-name}")
  public List<Student> getStudentByName(@PathVariable("student-name") String name) {
    return studentService.getStudentByName(name);
  }
}
