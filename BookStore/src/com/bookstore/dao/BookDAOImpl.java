package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.JDBCUtils.JDBCUtils;
import com.bookstore.dto.BookDTO;

public class BookDAOImpl {
	private static final String SELECT_ALL_BOOK = "SELECT * FROM Books";
	private static final String SELECT_BOOK_BY_ID = "SELECT * FROM Books WHERE BookID = ?";
	private static final String INSERT_NEW_BOOK = "INSERT INTO Books (BookID, Name,TotalPage, Type, Quantity) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_BOOK_SQL = "UPDATE Books SET Name = ?, TotalPage = ?, Type = ?, Quantity = ? WHERE BookID = ?";
	private static final String DELETE_BOOK_SQL = "DELETE FROM Books WHERE BookID = ?";
//	private static final String CHECK_EXIST_BOOKID_SQL = "SELECT COUNT(*) FROM Books WHERE BookID = ?";

//	List of books 
	public List<BookDTO> getAllBook() {
		List<BookDTO> books = new ArrayList<>();

		try (Connection connection = JDBCUtils.getConnection(); Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_BOOK);
			while (rs.next()) {
				int bookId = rs.getInt("bookId");
				String name = rs.getString("name");
				int totalPage = rs.getInt("totalPage");
				String type = rs.getString("type");
				int quantity = rs.getInt("quantity");
				books.add(new BookDTO(bookId, name, totalPage, type, quantity));
			}
		} catch (Exception e) {

			System.out.println("List of books failed!" + e.getMessage());
			e.printStackTrace();
		}
		return books;
	}

	// Search book
	public List<BookDTO> searchBook(String param) {
		List<BookDTO> books = new ArrayList<>();
//		String SEARCH_BOOK_SQL = "SELECT * FROM Books WHERE BookID = ? or Name like '%?%' or Type = '%?%'";
		String data;
		if (param != null) {
			data = "SELECT * FROM Books WHERE  Name like '%" + param + "%' or BookID = '" + param + "'  or Type like '%"
					+ param + "%'";
		} else {
			data = SELECT_ALL_BOOK;
			System.out.println("The book dosen't exist!");
		}
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(data)) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int bookId = rs.getInt("bookId");
				String name = rs.getString("name");
				int totalPage = rs.getInt("totalPage");
				String type = rs.getString("type");
				int quantity = rs.getInt("quantity");
				books.add(new BookDTO(bookId, name, totalPage, type, quantity));
			}
		} catch (Exception e) {
			System.out.println("Search book failed!" + e.getMessage());
			e.printStackTrace();
		}
		return books;
	}

	public boolean checkExistBookId(int bookId) {
		boolean check = false;
		String checkExitsBookId = "SELECT * FROM Books WHERE BookID = " + bookId;
		Connection connection = JDBCUtils.getConnection();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(checkExitsBookId);
			check = !rs.next();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return check;
	}

// Add new book
	public String addNewBook(BookDTO book) {
		String message = "";
		Connection connection = JDBCUtils.getConnection();

		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK)) {
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getName());
			preparedStatement.setInt(3, book.getTotalPage());
			preparedStatement.setString(4, book.getType());
			preparedStatement.setInt(5, book.getQuantity());
			preparedStatement.executeUpdate();
			message = "Add new book successful";
		} catch (Exception e) {
			message = "Add new book faild because" + e.getMessage();
		}
		return message;
	}
// Add new book
	/*
	 * public void addNewBook(BookDTO book) { try (Connection connection =
	 * JDBCUtils.getConnection(); PreparedStatement preparedStatement =
	 * connection.prepareStatement(INSERT_NEW_BOOK)) { preparedStatement.setInt(1,
	 * book.getBookId()); preparedStatement.setString(2, book.getName());
	 * preparedStatement.setInt(3, book.getTotalPage());
	 * preparedStatement.setString(4, book.getType()); preparedStatement.setInt(5,
	 * book.getQuantity()); preparedStatement.executeUpdate(); } catch (Exception e)
	 * { System.out.println("Add new book faild!" + e.getMessage());
	 * System.err.println(e.getLocalizedMessage()); } }
	 */
// Delete book
	public boolean deleteBook(int bookId) {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL)) {
			preparedStatement.setInt(1, bookId);
			rowDeleted = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Delete book failed!" + e.getMessage());
			e.printStackTrace();
		}
		return rowDeleted;
	}

// Update book
	public boolean updateBook(BookDTO book) {
		boolean rowUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOK_SQL)) {
			preparedStatement.setString(1, book.getName());
			preparedStatement.setInt(2, book.getTotalPage());
			preparedStatement.setString(3, book.getType());
			preparedStatement.setInt(4, book.getQuantity());
			preparedStatement.setInt(5, book.getBookId());
			rowUpdated = preparedStatement.executeUpdate() > 0;
		} catch (SQLException e) {
			System.out.println("Update book failed!" + e.getMessage());
			e.printStackTrace();
		}
		return rowUpdated;
	}

//	Get book by bookId
	public BookDTO getBookById(int bookId) {
		BookDTO book = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement pre = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
			pre.setInt(1, bookId);
			ResultSet rs = pre.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int totalPage = rs.getInt("totalPage");
				String type = rs.getString("type");
				int quantity = rs.getInt("quantity");

				book = new BookDTO(bookId, name, totalPage, type, quantity);
			}
		} catch (Exception e) {
			System.out.println("Get book by bookId failed!");
			e.printStackTrace();
		}
		return book;
	}


}
