package com.tomsebastiant.hibernatedemo.dao;

import com.tomsebastiant.hibernatedemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByFirstName(String theFirstName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();
}
