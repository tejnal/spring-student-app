package com.springdemoapp.data.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Integer id;

  @NotBlank(message = "Please add student name.")
  @Column(name = "NAME")
  private String name;

  @Column(name = "ROLL_NUMBER")
  private Integer rollNo;

  @Column(name = "ADDRESS")
  private String address;
}
