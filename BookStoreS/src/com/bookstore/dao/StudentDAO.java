package com.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookstore.dto.StudentDTO;

public interface StudentDAO {
	List<StudentDTO> getAllStudent() throws SQLException;
	void addNewStudent(StudentDTO student) throws SQLException;
	boolean deleteStudent(int id) throws SQLException;
	boolean updateStudent(StudentDTO student) throws SQLException;
	StudentDTO getStudentById(int studentId) throws SQLException;
}
