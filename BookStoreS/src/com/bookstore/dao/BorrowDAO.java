package com.bookstore.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookstore.dto.BookDTO;
import com.bookstore.dto.BorrowDTO;

public interface BorrowDAO {
	List<BorrowDTO> getAllBorrow() throws SQLException;
	void addNewBorrow(BorrowDTO borrow) throws SQLException;
	boolean deleteBorrow(int borrowId) throws SQLException;
	boolean updateBorrow(BorrowDTO borrow) throws SQLException;
	BorrowDTO getBorrowByStudentId(int studentId) throws SQLException;
	BorrowDTO getBorrowByById(int borrowId) throws SQLException;
	int getQuantityBookAvailabel(int bookId) throws SQLException;
	BookDTO updateQuantity(BookDTO book) throws SQLException;
}
