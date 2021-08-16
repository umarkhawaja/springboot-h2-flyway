package com.springboot.crud.springbooth2flyway.service;

import com.springboot.crud.springbooth2flyway.dao.StudentsDao;
import com.springboot.crud.springbooth2flyway.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentsDao studentsDao;
    @Autowired
    public StudentService(@Qualifier("studentDao") StudentsDao studentsDao) {
        this.studentsDao = studentsDao;
    }


    public int addStudent(Students students){
        return studentsDao.insertStudent(students);
    }

    public List<Students> getAllStudents(){

        return studentsDao.getAllStudents();
    }
    public Students selectStudentById(int id) {
        return studentsDao.selectStudentById(id);
    }
    public int deleteStudent(int id){
        return studentsDao.deleteStudentById(id);
    }

    public void updateStudent(int id,Students newStudent){
        studentsDao.updateStudentById(id,newStudent);
    }
}
