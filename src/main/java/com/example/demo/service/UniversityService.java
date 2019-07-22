package com.example.demo.service;

import com.example.demo.entity.University;
import com.example.demo.model.UniversityDto;
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

public class UniversityService {

  @Autowired
  UniversityRepository universityRepository;

  @Autowired
  private ModelMapper modelMapper;

  public void delete(String externalId) {
    universityRepository.deleteByExternalId(externalId);

  }

  public Page<UniversityDto> findAll(Pageable pageable) {

    return universityRepository.findAll(pageable)
        .map(university -> modelMapper.map(university, UniversityDto.class));
  }

  public UniversityDto findOne(String externalId) {
    University university = universityRepository.findByExternalIds(externalId)
        .orElseThrow(() -> new RuntimeException("Cannot find student"));
    UniversityDto universityDto = modelMapper.map(university, UniversityDto.class);
    return universityDto;
  }

  public University save(UniversityDto persisted) {

    University university = modelMapper.map(persisted, University.class);
    university.setExternalId(UUID.randomUUID().toString());
    return universityRepository.save(university);
  }
}
