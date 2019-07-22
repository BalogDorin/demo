package com.example.demo.service;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.University;
import com.example.demo.model.TeacherDto;
import com.example.demo.repository.TeacherRepository;
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
public class TeacherService {

  @Autowired
  private TeacherRepository teacherRepository;

  @Autowired
  private UniversityRepository universityRepository;

  @Autowired
  private ModelMapper modelMapper;

  public void delete(String externalId) {

    teacherRepository.deleteByExternalId(externalId);

  }


  public void setUniversity(String universityExternId, String teacherExternId) {
    University university = universityRepository.findByExternalIds(universityExternId)
        .orElseThrow(RuntimeException::new);
    Teacher teacher = teacherRepository.findByExternalIds(teacherExternId)
        .orElseThrow(RuntimeException::new);
    teacher.setUniversity(university);
    teacherRepository.save(teacher);

  }

  public Page<TeacherDto> findAll(Pageable pageable) {

    return teacherRepository.findAll(pageable)
        .map(teacher -> modelMapper.map(teacher, TeacherDto.class));
  }

  public TeacherDto findOne(String externalId) {
    Teacher teacher = teacherRepository.findByExternalIds(externalId)
        .orElseThrow(() -> new RuntimeException("Cannot find teacher"));
    TeacherDto teacherDto = modelMapper.map(teacher, TeacherDto.class);
    return teacherDto;

  }

  public Teacher save(TeacherDto persisted) {

    Teacher teacher = modelMapper.map(persisted, Teacher.class);
    teacher.setExternalId(UUID.randomUUID().toString());
    return teacherRepository.save(teacher);
  }
}
