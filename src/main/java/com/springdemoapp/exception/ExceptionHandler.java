package com.springdemoapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@ResponseStatus
public class ExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<ErrorMessage> handleStudentNotFoundException(
      StudentNotFoundException ex, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
  }
}
