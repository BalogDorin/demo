package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.University;
import com.example.demo.model.StudentDto;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UniversityRepository;
import java.util.UUID;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class StudentService {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private CourseRepository courseRepository;

  @Autowired
  private UniversityRepository universityRepository;


  public void delete(String externalId) {
    //  Student student = modelMapper.map(studentDto, Student.class);
    studentRepository.deleteByExternalId(externalId);
  }

  public Page<StudentDto> findAll(Pageable pageable) {

    return studentRepository.findAll(pageable)
        .map(student -> modelMapper.map(student, StudentDto.class));
  }

  public StudentDto findOne(String externalId) {
    Student student = studentRepository.findByExternalIds(externalId)
        .orElseThrow(() -> new RuntimeException("Cannot find student"));
    StudentDto studentDto = modelMapper.map(student, StudentDto.class);
    return studentDto;
  }

  public StudentDto findByExternalId(String externalId) {
    Student student = studentRepository.findByExternalIds(externalId)
        .orElseThrow(RuntimeException::new);
    StudentDto studentDto = modelMapper.map(student, StudentDto.class);
    return studentDto;
  }

  public void setCourse(String courseExternId, String studentExternId) {
    Course course = courseRepository.findByExternalIds(courseExternId)
        .orElseThrow(RuntimeException::new);
    Student student = studentRepository.findByExternalIds(studentExternId)
        .orElseThrow(RuntimeException::new);
    student.setCourse(course);
    studentRepository.save(student);


  }

  public void setUniversity(String universityExternId, String studentExternId) {
    University university = universityRepository.findByExternalIds(universityExternId)
        .orElseThrow(RuntimeException::new);
    Student student = studentRepository.findByExternalIds(studentExternId)
        .orElseThrow(RuntimeException::new);
    student.setUniversity(university);
    studentRepository.save(student);


  }

  public Student save(StudentDto persisted) {

    Student student = modelMapper.map(persisted, Student.class);
    student.setExternalId(UUID.randomUUID().toString());
    return studentRepository.save(student);
  }
}
