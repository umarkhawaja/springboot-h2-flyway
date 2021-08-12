package com.springboot.crud.springbooth2flyway.dao;

import com.springboot.crud.springbooth2flyway.model.Departments;

import java.util.List;
import java.util.Optional;


public interface DepartmentsDao {
    int insertDepartment( Departments departments);

    List<Departments> selectAllDepartments();

    Departments selectDepartmentById(int id);

    int deleteDepartmentById(int id);

    void updateDepartmentById(int id,Departments departments);

}
