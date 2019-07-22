package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

public class CourseDto {

    private String externalId;

    private String courseName;

    private Set<StudentDto> students = new HashSet<>();

    private String courseNumber;


    private TeacherDto teacher;

    public CourseDto() {

    }

    public CourseDto(String externalId, String courseName, String courseNumber, Set<StudentDto> students, TeacherDto teacher) {
        this.externalId = externalId;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.students = students;
        this.teacher = teacher;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public void setStudents(Set<StudentDto> students) {
        this.students = students;
    }

    public void setTeacher(TeacherDto teacher) {
        this.teacher = teacher;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public Set<StudentDto> getStudents() {
        return students;
    }

    public TeacherDto getTeacher() {
        return teacher;
    }

}
