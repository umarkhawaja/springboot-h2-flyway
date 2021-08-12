package com.springboot.crud.springbooth2flyway.dao;

import com.springboot.crud.springbooth2flyway.model.Courses;

import java.util.List;
import java.util.Optional;

public interface CoursesDao {

    int insertCourse( Courses courses);

    List<Courses> getAllCourses();

    Courses selectCourseById(int id);

    int deleteCourseById(int id);

    void updateCourseById(int id,Courses courses);



}
