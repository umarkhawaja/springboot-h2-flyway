package com.springboot.crud.springbooth2flyway.dao;


import com.springboot.crud.springbooth2flyway.model.Departments;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("departmentDao")
@Transactional
public class DepartmentDataAccessService implements  DepartmentsDao{
    EntityManager entityManager;

    public DepartmentDataAccessService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static List<Departments> departmentsList = new ArrayList<>();

    public static void setDepartmentsList(List<Departments> departmentsList) {
        DepartmentDataAccessService.departmentsList = departmentsList;
    }

    @Override
    public int insertDepartment(Departments departments) {
        entityManager.persist(departments);

        return 1;
    }

    @Override
    public List<Departments> selectAllDepartments() {
            setDepartmentsList(entityManager.createQuery("SELECT a FROM Departments a", Departments.class).getResultList());
            return entityManager.createQuery("SELECT a FROM Departments a", Departments.class).getResultList();

    }

    @Override
    public Departments selectDepartmentById(int id) {
        setDepartmentsList(entityManager.createQuery("SELECT a FROM Departments a", Departments.class).getResultList());
        Departments department = entityManager.find(Departments.class,id);
        return department;
    }

    @Override
    public int deleteDepartmentById(int id) {
        Departments departmentMaybe = selectDepartmentById(id);
        if(departmentMaybe==null){
            return 0;
        }
        entityManager.remove(departmentMaybe);
        departmentsList.remove(departmentMaybe);
        return 1;    }

    @Override
    public void updateDepartmentById(int id, Departments departments) {
        Query q=entityManager.createQuery("update Departments d set d.name='"+departments.getName()+ "' where d.id ="+id+" ");
        q.executeUpdate();
    }
}
