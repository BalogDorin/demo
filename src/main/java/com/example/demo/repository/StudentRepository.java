package com.example.demo.repository;


import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    Page<Student> findAll(Pageable pageable);

    void deleteByExternalId(String externalId);

    Page<Student> findAllByFirstName(String firstName, Pageable pageable);

    @Query("SELECT s FROM Student s WHERE s.externalId = :externalId")
    Optional<Student> findByExternalIds(@Param("externalId") String externalId);




}
