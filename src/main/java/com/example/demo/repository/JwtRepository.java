package com.example.demo.repository;

import com.example.demo.entity.UserRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface JwtRepository extends PagingAndSortingRepository<UserRequest, Long> {

  @Query("SELECT c FROM UserRequest c WHERE c.userName = :userName")
  UserRequest findByUserName(@Param("userName")String userName);
}

