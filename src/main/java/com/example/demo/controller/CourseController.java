package com.example.demo.controller;

import com.example.demo.model.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@RequestMapping("/course")
@CrossOrigin
public class CourseController {

  @Autowired
  private CourseService courseService;
  @PostMapping("/info")
  public void createCourse(@RequestBody CourseDto course) {
    courseService.save(course);
  }

  @GetMapping("/findAllByCourseName/{courseName}")
  public Page<CourseDto> findAllByCourseName(@PathVariable("courseName") String courseName,
      Pageable page) {
    return courseService.findAllByCourseName(courseName, page);
  }

  @GetMapping("/findAll")
  public Page<CourseDto> findAll(Pageable pageable) {
    return courseService.findAll(pageable);
  }

  @GetMapping("/findOne/{externalId}")
  public CourseDto findOne(@PathVariable("externalId") String externalId) {
    return courseService.findOne(externalId);
  }

  @PutMapping("/SetTeacher/{courseId}/{teacherId}")
  public void SetTeacher(@PathVariable("courseId") String courseId,
      @PathVariable("teacherId") String teacherId) {
     courseService.setTeacher(courseId, teacherId);
  }

  @DeleteMapping("/delete/{externalId}")
  public void delete(@PathVariable("externalId") String externalId) {
    courseService.delete(externalId);
  }


}
