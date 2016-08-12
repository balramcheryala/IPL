package com.bridgelabz.bridgembass.database.dao;

import java.util.List;

import com.bridgelabz.bridgembass.database.model.Student;

public interface StudentDao {
	
	public void addStudent(Student student);

	public List<Student> listStudents();
	
	public Student getStudent(int id);
	
	public void deleteStudent(Student student);
}
