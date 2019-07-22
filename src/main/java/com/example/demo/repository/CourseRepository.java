package com.example.demo.repository;

import com.example.demo.entity.Course;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends PagingAndSortingRepository<Course, Long> {

  Page<Course> findAll(Pageable pageable);

  void deleteByExternalId(String externalId);

  Page<Course> findAllByCourseName(String courseName, Pageable pageable);

  @Query("SELECT c FROM Course c WHERE c.externalId = :externalId")
  Optional<Course> findByExternalIds(@Param("externalId") String externalId);

}
