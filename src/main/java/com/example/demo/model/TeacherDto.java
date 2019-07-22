package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class TeacherDto {
    private String lastName;

    private String faculty;

    private UniversityDto university;

    private Set<CourseDto> courses = new HashSet<>();

    private String externalId;

    public TeacherDto() {

    }

    public TeacherDto(String externalId, String lastName, String faculty, UniversityDto university, Set<CourseDto> courses) {
        this.externalId = externalId;
        this.lastName = lastName;
        this.faculty = faculty;
        this.university = university;
        this.courses = courses;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setUniversity(UniversityDto university) {
        this.university = university;
    }

    public void setCourses(Set<CourseDto> courses) {
        this.courses = courses;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public UniversityDto getUniversity() {
        return university;
    }

    public Set<CourseDto> getCourses() {
        return courses;
    }

}
