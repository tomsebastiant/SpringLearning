package com.tomsebastiant.hibernatedemo;

import com.tomsebastiant.hibernatedemo.dao.StudentDAO;
import com.tomsebastiant.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryByFirstName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
//			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println("Deleteing all students");
		int rows=studentDAO.deleteAll();
		System.out.println("Deletes rows :"+rows);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student with id "+studentId);
		studentDAO.delete(3);
	}

	private void updateStudent(StudentDAO studentDAO) {
//	retrieve student using primary key
		int studentid=1;
		System.out.println("Getting student with id: "+studentid);
		Student myStudent = studentDAO.findById(studentid);
//	change first name
		System.out.println("Changing name");
		myStudent.setFirstName("Scooby");
//	Update student
		studentDAO.update(myStudent);
//	display updated student
		System.out.println("Updated student is "+myStudent);
	}

	private void queryByFirstName(StudentDAO studentDAO) {
//	get the filtered list of students
		List<Student> myStudents = studentDAO.findByFirstName("Apple");

//	display the list of students
		for(Student temp:myStudents){
			System.out.println(temp);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
//	get a list of students
		List<Student> myStudents = studentDAO.findAll();

//	display the list of students
		for(Student temp:myStudents){
			System.out.println(temp);
		}
	}


	private void readStudent(StudentDAO studentDAO) {
	//	create student object
		System.out.println("Creating the student object");
		Student tempStudent = new Student("Bugs","Bunny","bugs@gmail.com");

//	save the student object
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent);

//	display the id of the student object
		int tempId= tempStudent.getId();
		System.out.println("Student saved. Generated id:"+tempId);

//	retrieve student based on the id: primary key
		System.out.println("Retrieving student with id "+tempId);
		Student foundStudent=studentDAO.findById(tempId);

//	display student
		System.out.println("Found student is "+foundStudent);

	}



	private void createMultipleStudents(StudentDAO studentDAO) {
//	create student object
		System.out.println("Creating multiple student object");
		Student tempStudent1 = new Student("Apple","Doe","apple@gmail.com");
		Student tempStudent2 = new Student("Ball","Doe","ball@gmail.com");
		Student tempStudent3 = new Student("John","Cat","cat@gmail.com");

//	save the student object
		System.out.println("Saving multiple student object");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

//	create student object
		System.out.println("Creating the student object");
		Student tempStudent = new Student("John","Doe","johndoe@gmail.com");

//	save the student object
		System.out.println("Saving the student object");
		studentDAO.save(tempStudent);

//	display the id of the student object
		System.out.println("Student saved. Generated id:"+tempStudent.getId());

	}
}
