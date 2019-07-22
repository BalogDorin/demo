package com.example.demo.controller;

import com.example.demo.model.UniversityDto;
import com.example.demo.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/university")

public class UniversityController {

  @Autowired
  private UniversityService universityService;

  @PostMapping("/info")
  public void createTeacher(@RequestBody UniversityDto universityDto) {
    universityService.save(universityDto);
  }

  @GetMapping("/findOne/{externalId}")
  public UniversityDto findOne(@PathVariable("externalId") String externalId) {
    return universityService.findOne(externalId);
  }

  @GetMapping("/findAll")
  public Page<UniversityDto> findAll(Pageable pageable) {
    return universityService.findAll(pageable);
  }

  @DeleteMapping("/delete/{externalId}")
  public void delete(@PathVariable("externalId") String externalId) {
    universityService.delete(externalId);
  }
}
