package com.example.demo.repository;

import com.example.demo.entity.University;
import org.springframework.data.domain.Pageable;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends PagingAndSortingRepository<University, Long> {

  Page<University> findAll(Pageable pageable);

  void deleteByExternalId(String externalId);

  Page<University> findAllByName(String name, Pageable pageable);

  @Query("SELECT u FROM University u WHERE u.externalId = :externalId")
  Optional<University> findByExternalIds(@Param("externalId") String externalId);

}
