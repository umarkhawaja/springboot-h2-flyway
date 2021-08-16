package com.springboot.crud.springbooth2flyway.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name="students")
public class Students {

    @Id
    @Column(name="id",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "S_ID")
    @SequenceGenerator(name="S_ID", sequenceName="STUDENTS_ID_SEQ", initialValue = 100,allocationSize=1)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name="students_first_name"),
            inverseJoinColumns = @JoinColumn(name="courses_name")
    )
    private List<Courses> courses = new ArrayList<>();

    public Students() {
    }

    public Students(@JsonProperty("first_name") String firstName,
                    @JsonProperty("age") int age,
                    @JsonProperty("date_of_birth") Date dateOfBirth
    )
    {
        this.firstName = firstName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;

    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }


    public List<Courses> getCourses() {
        return courses;
    }

    public void addCourse(Courses course){
        courses.add(course);
    }

}
