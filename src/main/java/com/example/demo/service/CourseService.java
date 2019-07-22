package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Exceptions.CourseNotFound;
import com.example.demo.entity.Teacher;
import com.example.demo.model.CourseDto;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.TeacherRepository;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseService {

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private ModelMapper modelMapper;

  public CourseService() {
  }

  public void delete(String externalId) {

    courseRepository.deleteByExternalId(externalId);
  }

  public Page<CourseDto> findAll(Pageable pageable) {

     //Set<StudentDto> students = new HashSet<>();

    // courseRepository.findAll(pageable).map(course -> modelMapper.map(course.getStudents(),StudentDto.class));
    return courseRepository.findAll(pageable)
        .map(course -> modelMapper.map(course, CourseDto.class));
  }

  public Page<CourseDto> findAllByCourseName(String courseName, Pageable page) {

    return courseRepository.findAllByCourseName(courseName, page)
        .map(course -> modelMapper.map(course, CourseDto.class));
  }

  public void setTeacher(String courseExternId, String teacherExternId) {
    Course course = courseRepository.findByExternalIds(courseExternId)
        .orElseThrow(RuntimeException::new);
    Teacher teacher = teacherRepository.findByExternalIds(teacherExternId)
        .orElseThrow(RuntimeException::new);
      course.setTeacher(teacher);
      courseRepository.save(course);
  }

  public CourseDto findOne(String externalId) {
    return courseRepository.findByExternalIds(externalId)
        .map(course -> modelMapper.map(course, CourseDto.class))
        .orElseThrow(()->new CourseNotFound("Test, nu exista cursul"));
  }



  public Course save(CourseDto persisted) {

    Course course = modelMapper.map(persisted, Course.class);
    course.setExternalId(UUID.randomUUID().toString());
    return courseRepository.save(course);
  }
}
