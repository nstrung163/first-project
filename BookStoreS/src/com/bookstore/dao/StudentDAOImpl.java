package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.JDBCUtils.JDBCUtils;
import com.bookstore.dto.StudentDTO;

public class StudentDAOImpl implements StudentDAO {
	private static final String INSERT_STUDENT_SQL	 = "INSERT INTO Students (StudentID, Name, Age, Gender) VALUES (?, ?, ?, ?)";
	private static final String SELECT_ALL_STUDENT	 = "SELECT * FROM Students";
	private static final String DELETE_STUDENT_SQL	 = "DELETE FROM Students WHERE StudentID = ?";
	private static final String UPDATE_STUDENT_SQL	 = "UPDATE Students SET Name = ?, Age = ?, Gender = ? WHERE StudentID = ? ";
	private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM Students WHERE StudentID = ?";
	

	@Override
	public List<StudentDTO> getAllStudent() {
		List<StudentDTO> students = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int studentId	= rs.getInt("studentId");
				String name		= rs.getString("name");
				int age			= rs.getInt("age");
				boolean	gender	= rs.getBoolean("gender");
				students.add(new StudentDTO(studentId, name, age, gender));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}

	@Override
	public void addNewStudent(StudentDTO student) {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			statement.setInt(1, student.getStudentId());
			statement.setString(2, student.getName());
			statement.setInt(3, student.getAge());
			statement.setBoolean(4, student.isGender());
			
			statement.executeUpdate();
			
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		
	}

	@Override
	public boolean deleteStudent(int studentId)  {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL)){
				statement.setInt(1, studentId);
				rowDeleted = statement.executeUpdate() > 0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
	public boolean updateStudent(StudentDTO student) {
		boolean rowUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STUDENT_SQL)){
			
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setBoolean(3, student.isGender());
			statement.setInt(4, student.getStudentId());
			
			rowUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rowUpdated;
	}

	@Override
	public StudentDTO getStudentById(int studentId) {
		StudentDTO student = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID)) {
			preparedStatement.setInt(1, studentId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String name	= resultSet.getString("name");
				int	age		= resultSet.getInt("age");
				boolean gender	= resultSet.getBoolean("gender");
				
				student = new StudentDTO(studentId, name, age, gender);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

}
