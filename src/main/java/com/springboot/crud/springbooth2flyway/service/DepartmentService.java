package com.springboot.crud.springbooth2flyway.service;

import com.springboot.crud.springbooth2flyway.dao.DepartmentsDao;
import com.springboot.crud.springbooth2flyway.model.Departments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentsDao departmentsDao;

    @Autowired
    public DepartmentService(DepartmentsDao departmentsDao) {
        this.departmentsDao = departmentsDao;
    }

    public int addDepartment(Departments department){
        return departmentsDao.insertDepartment(department);
    }

    public List<Departments> getAllDepartments(){
        return departmentsDao.selectAllDepartments();
    }

    public Departments selectDepartmentById(int id) {
        return departmentsDao.selectDepartmentById(id);
    }
    public int deleteDepartment(int id){
        return departmentsDao.deleteDepartmentById(id);
    }

    public void updateDepartment(int id,Departments  newDepartment){
        departmentsDao.updateDepartmentById(id,newDepartment);
    }


}
