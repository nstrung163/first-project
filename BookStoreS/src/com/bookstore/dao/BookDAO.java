package com.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookstore.dto.BookDTO;

public interface BookDAO {
	List<BookDTO> getAllBook() throws SQLException;
	void addNewBook(BookDTO book) throws SQLException;
	boolean deleteBook(int bookId) throws SQLException;
	boolean updateBook(BookDTO book) throws SQLException;
	BookDTO getBookById(int bookId) throws SQLException;
}
