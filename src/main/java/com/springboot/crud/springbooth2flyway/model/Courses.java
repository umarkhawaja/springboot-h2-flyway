package com.springboot.crud.springbooth2flyway.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {



    @Id
    @Column(name="id",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "C_ID")
    @SequenceGenerator(name="C_ID", sequenceName="COURSES_ID_SEQ", initialValue = 100,allocationSize=1)
    private int id;

    @Column(name = "name",unique = true,nullable = false)
    private String name;

    @ManyToOne
    private Students student = new Students();

    public Courses() {
    }

    public Courses(String name) {
        this.name = name;
    }

    public Courses(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Students getStudents() {
        return student;
    }


}
