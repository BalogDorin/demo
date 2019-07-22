package com.example.demo.model;

public class StudentDto {

    private String lastName;

    private String firstName;

    private String adress;

    private String externalId;

    private CourseDto course;

    private UniversityDto university;

    public StudentDto() {

    }

    public StudentDto(String firstName, String lastName, String adress, String externalId, CourseDto course, UniversityDto university) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.externalId = externalId;
        this.course = course;
        this.university = university;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public void setUniversity(UniversityDto university) {
        this.university = university;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdress() {
        return adress;
    }

    public String getExternalId() {
        return externalId;
    }

    public CourseDto getCourse() {
        return course;
    }

    public UniversityDto getUniversity() {
        return university;
    }

}
