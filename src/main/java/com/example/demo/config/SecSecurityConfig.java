package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecSecurityConfig{} /*extends WebSecurityConfigurerAdapter {

  //CustomBasicAuthenticationEntryPoint authenticationEntryPoint = new CustomBasicAuthenticationEntryPoint();

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("admin").password(encoder().encode("adminPass")).roles("ADMIN")
        .and()
        .withUser("user").password(encoder().encode("userPass")).roles("USER");
  }

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .exceptionHandling()
        // .authenticationEntryPoint(authenticationEntryPoint)
        .and()
        .authorizeRequests()
        //.anyRequest().authenticated()
        //.antMatchers("/teacher/findAll").hasRole("ADMIN")
        .antMatchers("/course/findOne/*").authenticated()
        .antMatchers("/course/findAll").anonymous()

        .and().httpBasic()
        //.successHandler()
        //.failureHandler()
        .and()
        .logout();
  }
}*/
