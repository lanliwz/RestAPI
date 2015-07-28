package com.amex.cornerstone.service;

import java.util.List;

import com.amex.cornerstone.model.Student;
import com.amex.cornerstone.vo.Register;

public interface StudentService {
	void insertStudent(Student student);
	boolean getStudentByLogin(String userName, String password);
	boolean getStudentByUserName(String userName);
	Student getStudent(String userName);
	List<Student> getAllStudents();
	void InsertRegisterInfo(Register register);
	
}
