package com.springboot.crud.springbooth2flyway.api;

import com.springboot.crud.springbooth2flyway.model.Students;
import com.springboot.crud.springbooth2flyway.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentsController {
    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public void addStudent(@RequestBody Students student){
        studentService.addStudent(student);
    }


    @GetMapping
    public List<Students> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Students getStudentById(@PathVariable("id") int id){
        return studentService.selectStudentById(id);
    }

    @DeleteMapping(path ="{id}")
    public void deleteStudentById(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(@PathVariable("id") int id,@RequestBody Students student){
        studentService.updateStudent(id,student);
    }

}
