package com.bookstore.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.StudentDAOImpl;
import com.bookstore.dto.StudentDTO;

/**
 * Servlet implementation class StudentController
 */
@WebServlet( "/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StudentDAOImpl studentDAO;  
    
    public void init() {
    	studentDAO = new StudentDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "newStudent":
			showNewForm(request, response);
			break;
		case "insertStudent":
			insertStudent(request, response);
			break;
		case "updateStudent":
			updateStudent(request, response);
			break;
		case "deleteStudent":
			deleteStudent(request, response);
			break;
		case "editStudent":
			showEditForm(request, response);
			break;
		default:
			listStudent(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		List<StudentDTO> students = new ArrayList<>();
		students = studentDAO.getAllStudent();
		request.setAttribute("listStudent", students);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student-list.jsp");
//		request.setCharacterEncoding("UTF-8");

		dispatcher.forward(request, response);
	}
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student-form-sign-up.jsp");
//		request.setCharacterEncoding("UTF-8");
		dispatcher.forward(request, response);
	}
	private void insertStudent(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		boolean gender = Boolean.parseBoolean(request.getParameter("gender"));

		studentDAO.addNewStudent(new StudentDTO(studentId, name, age, gender));
		
		response.sendRedirect("student");
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		StudentDTO existingStudent = studentDAO.getStudentById(studentId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/student-form-edit.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);
	}
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String name	= request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
		
		studentDAO.updateStudent(new StudentDTO(studentId, name, age, gender));
		response.sendRedirect("student");
	
	}
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		studentDAO.deleteStudent(studentId);
		response.sendRedirect("student");
	}

}
