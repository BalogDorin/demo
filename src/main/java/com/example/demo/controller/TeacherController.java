package com.example.demo.controller;

import com.example.demo.model.TeacherDto;
import com.example.demo.service.TeacherService;
import javax.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

  @Autowired
  private TeacherService teacherService;

  @PostMapping("/info")
  public void createTeacher(@RequestBody TeacherDto teacherDto) {
    teacherService.save(teacherDto);
  }

  @GetMapping("/findOne/{externalId}")
  public TeacherDto findOne(@PathVariable("externalId") String externalId) {
    return teacherService.findOne(externalId);
  }
  //@Secured("ADMIN")
  @RolesAllowed("ADMIN")
  //@PreAuthorize("hasRole('ADMIN')")
  @GetMapping("/findAll")
  public Page<TeacherDto> findAll(Pageable pageable) {
    return teacherService.findAll(pageable);
  }

  @PutMapping("/SetUniversity/{teacherId}/{universityId}")
  public void SetUniversity(@PathVariable("universityId") String universityId,
      @PathVariable("teacherId") String teacherId) {
     teacherService.setUniversity(universityId, teacherId);
  }

  @DeleteMapping("/delete/{exernalId}")
  public void delete(@PathVariable("externalId") String externalId) {
    teacherService.delete(externalId);
  }
}
