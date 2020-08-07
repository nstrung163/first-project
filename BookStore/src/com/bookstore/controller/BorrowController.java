package com.bookstore.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.BorrowDAOImpl;
import com.bookstore.dto.BorrowDTO;

/**
 * Servlet implementation class BorrowController
 */
@WebServlet("/BorrowController")
public class BorrowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BorrowDAOImpl borrowDAO;
    
    public void init() {
    	borrowDAO = new BorrowDAOImpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "newBorrow":
			showFormBorrow(request, response);
			break;
		case "insertBorrow":
			insertBorrow(request, response);
			break;
		case "updateBorrow":
			updateBorrow(request, response);
			break;
		case "editBorrow":
			showEditForm(request, response);
			break;
		case "deleteBorrow":
			deleteBorrow(request, response);
			break;
		default:
			listBorrow(request, response);
			break;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listBorrow(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		List<BorrowDTO> borrows = new ArrayList<>();
		borrows = borrowDAO.getAllBorrow();
		request.setAttribute("listBorrow", borrows);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/borrow/borrow-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showFormBorrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/borrow/borrow-form.jsp");
		dispatcher.forward(request, response);
	}
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		int borrowId = Integer.parseInt(request.getParameter("borrowId"));
		BorrowDTO  existingBorrow = borrowDAO.getBorrowByById(borrowId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/borrow/borrow-form.jsp");
		request.setAttribute("borrow", existingBorrow);
		dispatcher.forward(request, response);
	}
	private void insertBorrow(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		int studentId	= Integer.parseInt(request.getParameter("studentId"));
		int bookId		= Integer.parseInt(request.getParameter("bookId"));
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String borrowDate = localDateTime.format(formatter);
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		borrowDAO.addNewBorrow(new BorrowDTO(studentId, bookId, borrowDate, quantity));
		response.sendRedirect("borrow");
	}
	private void updateBorrow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int borrowId	= Integer.parseInt(request.getParameter("borrowId"));
		int studentId	= Integer.parseInt(request.getParameter("studentId"));
		int bookId		= Integer.parseInt(request.getParameter("bookId"));
		String borrowDate = request.getParameter("borrowDate");
		int quantity	= Integer.parseInt(request.getParameter("quantity"));
		
		borrowDAO.updateBorrow(new BorrowDTO(borrowId, studentId, bookId, borrowDate, quantity));
		response.sendRedirect("borrow");
	}
	private void deleteBorrow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int borrowId = Integer.parseInt(request.getParameter("borrowId"));
		borrowDAO.deleteBorrow(borrowId);
		response.sendRedirect("borrow");
	}
}
