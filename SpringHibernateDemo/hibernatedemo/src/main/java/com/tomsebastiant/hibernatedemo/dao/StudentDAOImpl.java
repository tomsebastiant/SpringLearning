package com.tomsebastiant.hibernatedemo.dao;

import com.tomsebastiant.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

// define field for entity manager

    private EntityManager entityManager;

// inject entity manager using constructor

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //  implement the save method

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {

//  Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);

//  return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByFirstName(String theFirstName) {
//  Create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:theData", Student.class);
//  Set the query param
        theQuery.setParameter("theData",theFirstName);

//  return query results
        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
//  retrieve the student
        Student myStudent=entityManager.find(Student.class,id);
//  delete the student
        entityManager.remove(myStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rowsAffected=entityManager.createQuery("DELETE from Student").executeUpdate();
        return rowsAffected;
    }
}
