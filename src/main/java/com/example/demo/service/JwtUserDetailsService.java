package com.example.demo.service;

import com.example.demo.entity.UserRequest;
import com.example.demo.repository.JwtRepository;

import java.util.ArrayList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  JwtRepository jwtRepository;
  @Autowired
  private ModelMapper modelMapper;

  public UserRequest getUser(){

    return jwtRepository.findByUserName("test1");

  }

  @Override
   public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
   // return jwtRepository.findByUsername(s);
   //  jwtRepository.save(new UserRequest(1L,"test1","$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6") );
     return new User(jwtRepository.findByUserName(s).getUserName(),
         jwtRepository.findByUserName(s).getPassword(),new ArrayList<>());
    // return modelMapper.map(jwtRepository.findByUserName("test1"),UserDetails.class);
   }
  /*@Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if ("javainuse".equals(username)) {
      return new User("2", "javainuse",
          "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6");
    } else {
      throw new UsernameNotFoundException("User not found with username: " + username);
    }
  }*/
}
