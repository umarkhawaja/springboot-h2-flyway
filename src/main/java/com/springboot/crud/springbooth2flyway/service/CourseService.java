package com.springboot.crud.springbooth2flyway.service;

import com.springboot.crud.springbooth2flyway.dao.CoursesDao;
import com.springboot.crud.springbooth2flyway.model.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private CoursesDao coursesDao;

    @Autowired
    public CourseService(@Qualifier("courseDao") CoursesDao coursesDao) {
        this.coursesDao = coursesDao;
    }

    public int addCourse(Courses course){
        return coursesDao.insertCourse(course);
    }

    public List<Courses> getAllCourses(){

        return coursesDao.getAllCourses();
    }

    public Courses selectCourseById(int id) {
        return coursesDao.selectCourseById(id);
    }
    public int deleteCourse(int id){
        return coursesDao.deleteCourseById(id);
    }

    public void updateCourse(int id, Courses newCourse){
         coursesDao.updateCourseById(id,newCourse);
    }

}
