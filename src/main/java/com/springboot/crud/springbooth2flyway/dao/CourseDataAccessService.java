package com.springboot.crud.springbooth2flyway.dao;

import com.springboot.crud.springbooth2flyway.model.Courses;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("courseDao")
@Transactional
public class CourseDataAccessService implements CoursesDao{
    EntityManager entityManager;

    public CourseDataAccessService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private static List<Courses> coursesList = new ArrayList<>();

    public static void setCoursesList(List<Courses> coursesList) {
        CourseDataAccessService.coursesList = coursesList;
    }

    @Override
    public int insertCourse(Courses course) {
        entityManager.persist(course);

        return 1;
    }

    @Override
    public List<Courses> getAllCourses() {
        setCoursesList(entityManager.createQuery("SELECT a FROM Courses a", Courses.class).getResultList());
        return entityManager.createQuery("SELECT a FROM Courses a", Courses.class).getResultList();
    }

    @Override
    public Courses selectCourseById(int id) {
        setCoursesList(entityManager.createQuery("SELECT a FROM Courses a", Courses.class).getResultList());
        Courses Course = entityManager.find(Courses.class,id);
        return Course;
    }

    @Override
    public int deleteCourseById(int id) {
        Courses courseMaybe = selectCourseById(id);
        if(courseMaybe==null){
            return 0;
        }
        entityManager.remove(courseMaybe);
        coursesList.remove(courseMaybe);
        return 1;
    }

    @Override
    public void updateCourseById(int id, Courses courses) {
        Query q=entityManager.createQuery("update Courses c set c.name='"+courses.getName()+ "' where c.id ="+id+" ");
        q.executeUpdate();
    }
}
