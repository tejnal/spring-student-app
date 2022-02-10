package com.springdemoapp.domain.service;

import com.springdemoapp.data.entity.Student;
import com.springdemoapp.data.repository.StudentRepository;
import com.springdemoapp.exception.StudentNotFoundException;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired private StudentRepository studentRepository;

  @Override
  public Student addStudent(Student student) {
    return studentRepository.save(student);
  }

  @Override
  public List<Student> getAllStudent() {
    return studentRepository.findAll();
  }

  @Override
  public Student getStudentById(Integer id) {
    Optional<Student> studentOpt = studentRepository.findById(id);
    if (!studentOpt.isPresent()) {
      throw new StudentNotFoundException("Student with id : " + id + " doesn't exist.");
    }
    return studentOpt.get();
  }

  @Override
  public Student updateStudentById(@Valid Student student, Integer id) {

    Optional<Student> studentOpt = studentRepository.findById(id);
    if (!studentOpt.isPresent()) {
      throw new StudentNotFoundException("Student with id : " + id + " doesn't exist.");
    }
    Student studentEntity = studentOpt.get();
    if (StringUtils.isNotEmpty(student.getName())) {
      studentEntity.setName(student.getName());
    }
    if (StringUtils.isNotEmpty(student.getAddress())) {
      studentEntity.setAddress(student.getAddress());
    }
    if (ObjectUtils.isNotEmpty(student.getRollNo())) {
      studentEntity.setRollNo(student.getRollNo());
    }
    return studentRepository.save(studentEntity);
  }

  @Override
  public Student deleteStudentById(Integer id) {
    Optional<Student> studentOpt = studentRepository.findById(id);
    if (!studentOpt.isPresent()) {
      throw new StudentNotFoundException("Student with id : " + id + " doesn't exist.");
    }
    studentRepository.delete(studentOpt.get());
    return null;
  }

  @Override
  public List<Student> getStudentByName(String name) {
    return studentRepository.findByName(name);
  }
}
