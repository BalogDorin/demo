package com.example.demo.controller;

import com.example.demo.model.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

  @Autowired
  private StudentService studentService;

  @PostMapping("/info")
  public void createStudent(@RequestBody StudentDto studentDto) {
    studentService.save(studentDto);
  }

  @GetMapping("/findOne/{externalId}")
  public StudentDto findOne(@PathVariable("externalId") String externalId) {
    return studentService.findOne(externalId);
  }

  @PutMapping("/SetCourse/{studentId}/{courseId}")
  public void SetCourse(@PathVariable("studentId") String studentId,
      @PathVariable("courseId") String courseId) {
     studentService.setCourse(courseId, studentId);
  }

  @PutMapping("/SetUniversity/{studentId}/{universityId}")
  public void SetUniversity(@PathVariable("studentId") String studentId,
      @PathVariable("universityId") String universityId) {
     studentService.setUniversity(universityId, studentId);
  }

  @GetMapping("/findAll")
  public Page<StudentDto> findAll(Pageable pageable) {
    return studentService.findAll(pageable);
  }

  @DeleteMapping("/delete/{exernalId}")
  public void delete(@PathVariable("externalId") String externalId) {
    studentService.delete(externalId);
  }

}
