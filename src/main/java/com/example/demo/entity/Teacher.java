package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @Column(nullable = false,unique = true)
    private String externalId;

    private String lastName;

    private String faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany
    private Set<Course> courses = new HashSet<>();

    public Teacher() {

    }

    public Teacher(Long id, String externalId, String lastName, String faculty, University university, Set<Course> courses) {
        this.id = id;
        this.externalId = externalId;
        this.lastName = lastName;
        this.faculty = faculty;
        this.university = university;
        this.courses = courses;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    public Long getId() {
        return id;
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

    public University getUniversity() {
        return university;
    }

    public Set<Course> getCourses() {
        return courses;
    }

}
