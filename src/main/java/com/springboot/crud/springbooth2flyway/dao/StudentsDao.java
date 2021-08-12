package com.springboot.crud.springbooth2flyway.dao;

import com.springboot.crud.springbooth2flyway.model.Students;

import java.util.List;

public interface StudentsDao {

    int insertStudent( Students student);

    List<Students> getAllStudents();

    Students selectStudentById(int id);

    int deleteStudentById(int id);

    void updateStudentById(int id,Students students);

}
