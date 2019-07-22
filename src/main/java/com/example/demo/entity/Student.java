package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String adress;
    //@Column(nullable = false,unique = true)
    private String externalId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    public Student(){

    }
    public Student(Long id, String firstName, String lastName, String adress, String externalId, Course course, University university) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.externalId = externalId;
        this.course = course;
        this.university = university;
    }


    public void setId(Long id) {
        this.id = id;
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

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setUniversity(University university) {
        this.university = university;
    }


    public Long getId() {
        return id;
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

    public Course getCourse() {
        return course;
    }

    public University getUniversity() {
        return university;
    }

}
