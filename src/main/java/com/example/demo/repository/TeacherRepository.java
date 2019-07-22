package com.example.demo.repository;

import com.example.demo.entity.Teacher;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends PagingAndSortingRepository<Teacher, Long> {

  Page<Teacher> findAll(Pageable pageable);

  void deleteByExternalId(String externalId);

  Page<Teacher> findAllByLastName(String lastName, Pageable pageable);

  @Query("SELECT t FROM Teacher t WHERE t.externalId = :externalId")
  Optional<Teacher> findByExternalIds(@Param("externalId") String externalId);

}
