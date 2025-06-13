package com.tomsebastiant.springrestdemo.rest;

import com.tomsebastiant.springrestdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadData(){
        students = new ArrayList<>();
        students.add(new Student("Alpha","Delta"));
        students.add(new Student("Bravo","Echo"));
        students.add(new Student("Charlie","Foxtrot"));
    }

//  Define endpoint for /students - return list of students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

// Define endpoint for "/student/{studentId}" - return a student at index
    @GetMapping("/students/{studentId}")
    public Student getById(@PathVariable int studentId){


        if(studentId <0 || studentId >=students.size()){
            throw new StudentNotFoundException("Student id "+studentId+" doesnt exist");
        }
        return students.get(studentId);
    }

//  Add exception handler class for specific error. This will applicable for apis entering StudentRestController only

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//
//        StudentErrorResponse ser = new StudentErrorResponse();
//        ser.setStatus(HttpStatus.NOT_FOUND.value());
//        ser.setMessage(exc.getMessage());
//        ser.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(ser,HttpStatus.NOT_FOUND);
//    }

//  Add exception handler class as catch all. This will applicable for apis entering StudentRestController only

//    @ExceptionHandler
//    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//
//        StudentErrorResponse ser = new StudentErrorResponse();
//        ser.setStatus(HttpStatus.BAD_REQUEST.value());
//        ser.setMessage(exc.getMessage());
//        ser.setTimeStamp(System.currentTimeMillis());
//
//        return new ResponseEntity<>(ser,HttpStatus.BAD_REQUEST);
//    }

}
