package com.springboot.crud.springbooth2flyway.api;


import com.springboot.crud.springbooth2flyway.model.Courses;
import com.springboot.crud.springbooth2flyway.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
@RestController
public class CoursesController {
    private CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public void addCourse(@RequestBody Courses course){
        courseService.addCourse(course);
    }

    @GetMapping
    public List<Courses> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping(path = "{id}")
    public Courses getCourseById(@PathVariable("id") int id){
        return courseService.selectCourseById(id);

    }

    @DeleteMapping(path ="{id}")
    public void deleteCourseById(@PathVariable("id") int id){
        courseService.deleteCourse(id);
    }

    @PutMapping(path = "{id}")
    public void updateCourse(@PathVariable("id") int id,@RequestBody Courses course){
        courseService.updateCourse(id,course);
    }


}
