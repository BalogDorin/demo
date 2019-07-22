package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // @Column(nullable = false,unique = true)
    private String externalId;

    private String name;

    private String adress;

    @OneToMany
    private Set<Teacher> teachers = new HashSet();

    @OneToMany
    private Set<Student> students = new HashSet();

    public University() {

    }

    public University(Long id, String externalId, String name, String adress, Set<Teacher> teachers, Set<Student> students) {
        this.id = id;
        this.externalId = externalId;
        this.name = name;
        this.adress = adress;
        this.teachers = teachers;
        this.students = students;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    public Long getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public Set<Student> getStudents() {
        return students;
    }

}
