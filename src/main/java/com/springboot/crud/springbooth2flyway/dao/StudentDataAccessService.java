package com.springboot.crud.springbooth2flyway.dao;

import com.springboot.crud.springbooth2flyway.model.Students;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("studentDao")
@Transactional
public class StudentDataAccessService implements StudentsDao{

    EntityManager entityManager;

    public StudentDataAccessService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static List<Students> studentsList = new ArrayList<>();

    public static void setStudentsList(List<Students> studentsList) {
        StudentDataAccessService.studentsList = studentsList;
    }

    @Override
    public int insertStudent(Students student) {

        entityManager.persist(student);
        return 1;
    }

    @Override
    public List<Students> getAllStudents() {
        setStudentsList(entityManager.createQuery("SELECT a FROM Students a", Students.class).getResultList());
        return entityManager.createQuery("SELECT a FROM Students a", Students.class).getResultList();
    }

    @Override
    public Students selectStudentById(int id) {
        setStudentsList(entityManager.createQuery("SELECT a FROM Students a", Students.class).getResultList());
        Students student = entityManager.find(Students.class,id);
        return student;
    }

    @Override
    public int deleteStudentById(int id) {

        Students studentMaybe = selectStudentById(id);
        if(studentMaybe==null){
            return 0;
        }
        entityManager.remove(studentMaybe);
        studentsList.remove(studentMaybe);
        return 1;
    }

    @Override
    public void updateStudentById(int id, Students students) {

        Query q=entityManager.createQuery("update Students s set s.firstName='"+students.getFirstName()+
                "' , s.age ="+students.getAge()+", s.dateOfBirth ='"+students.getDateOfBirth()+"' where s.id ="+id+" ");
        q.executeUpdate();


    }
}
