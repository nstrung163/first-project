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

import com.bookstore.dao.BookDAOImpl;
import com.bookstore.dto.BookDTO;

/**
 * Servlet implementation class BookController
 */
//@WebServlet( name = "BookController", urlPatterns ="/BookController")
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDAOImpl bookDAO;   

    public void init() {
    	bookDAO = new BookDAOImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getServletPath();
		String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		switch (action) {
		case "newBook":
			showNewFormBook(request, response);
			break;
		case "insertBook":
			insertBook(request, response);
			break;
		case "updateBook":
			updateBook(request, response);
			break;
		case "deleteBook":
			deleteBook(request, response);
			break;
		case "editBook":
			showEditFormBook(request,response);
			break;
		default:
			listBooks(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listBooks(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		List<BookDTO> books = new ArrayList<>();
		books = bookDAO.getAllBook();
		request.setAttribute("listBook", books);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book-list.jsp");
		dispatcher.forward(request, response);
	}
	private void showNewFormBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book-form-sign-up.jsp");
		dispatcher.forward(request, response);
	}
	private void insertBook(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		int bookId	= Integer.parseInt(request.getParameter("bookId"));
		String name = request.getParameter("name");
		int totalPage = Integer.parseInt(request.getParameter("totalPage"));
		String type	= request.getParameter("type");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		bookDAO.addNewBook(new BookDTO(bookId, name, totalPage, type, quantity));
		response.sendRedirect("book");
	}
	private void showEditFormBook(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookDTO existingBook = bookDAO.getBookById(bookId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/book-form-edit.jsp");
		request.setAttribute("book", existingBook);
		dispatcher.forward(request, response);
	}
	private void updateBook(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String name = request.getParameter("name");
		int totalPage = Integer.parseInt(request.getParameter("totalPage"));
		String type = request.getParameter("type");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		bookDAO.updateBook(new BookDTO(bookId, name, totalPage, type, quantity));
		response.sendRedirect("book");
	}
	private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws  IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		bookDAO.deleteBook(bookId);
		response.sendRedirect("book");
	}
	

}
