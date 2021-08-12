package com.springboot.crud.springbooth2flyway.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "departments")
public class Departments {

    @Id
    @Column(name="id",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "D_ID")
    @SequenceGenerator(name="D_ID", sequenceName="DEPARTMENTS_ID_SEQ", initialValue = 100,allocationSize=1)
    private int id;

    @Column(name="name",unique = true,nullable = false)
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="departments_name",unique = true,nullable = false)
    private List<Students> students= new ArrayList<>();


    public Departments() {
    }

    public Departments(@JsonProperty("name") String depName) {
        this.name = depName;
    }

    public Departments(String name, List<Students> students) {
        this.name = name;
        this.students = students;
    }

    public Departments(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void addStudents(List<Students> students) {

        this.students=students;
    }
}
