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


public class BookDAOImpl implements BookDAO{
	private static final String SELECT_ALL_BOOK		= "SELECT * FROM Books";
	private static final String SELECT_BOOK_BY_ID	= "SELECT * FROM Books WHERE BookID = ?";
	private static final String INSERT_NEW_BOOK		= "INSERT INTO Books (BookID, Name,TotalPage, Type, Quantity) VALUES (?, ?, ?, ?, ?)";
	private static final String UPDATE_BOOK_SQL		= "UPDATE Books SET Name = ?, TotalPage = ?, Type = ?, Quantity = ? WHERE BookID = ?";
	private static final String DELETE_BOOK_SQL		= "DELETE FROM Books WHERE BookID = ?";
	
	
	@Override
	public List<BookDTO> getAllBook()  {
		List<BookDTO> books = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
				Statement statement = connection.createStatement()) {
			ResultSet rs = statement.executeQuery(SELECT_ALL_BOOK);
			while(rs.next()) {
				int bookId		= rs.getInt("bookId");
				String name		= rs.getString("name");
				int totalPage	= rs.getInt("totalPage");
				String type		= rs.getString("type");
				int quantity	= rs.getInt("quantity");
				books.add(new BookDTO(bookId, name, totalPage, type, quantity));			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void addNewBook(BookDTO book) {
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BOOK)) {
			preparedStatement.setInt(1, book.getBookId());
			preparedStatement.setString(2, book.getName());
			preparedStatement.setInt(3, book.getTotalPage());
			preparedStatement.setString(4, book.getType());
			preparedStatement.setInt(5, book.getQuantity());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
	}

	@Override
	public boolean deleteBook(int bookId)  {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement pre = connection.prepareStatement(DELETE_BOOK_SQL)) {
			pre.setInt(1, bookId);
			rowDeleted = pre.executeUpdate() > 0;;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	@Override
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
			e.printStackTrace();
		}
		return rowUpdated;
	}

	@Override
	public BookDTO getBookById(int bookId)  {
		BookDTO book = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement pre = connection.prepareStatement(SELECT_BOOK_BY_ID)) {
			pre.setInt(1, bookId);
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()) {
				String name		= rs.getString("name");
				int	totalPage	= rs.getInt("totalPage");
				String type		= rs.getString("type");
				int	quantity	= rs.getInt("quantity");
				
				book = new BookDTO(bookId, name, totalPage, type, quantity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

}
