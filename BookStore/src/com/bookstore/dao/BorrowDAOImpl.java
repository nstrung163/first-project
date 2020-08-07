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
import com.bookstore.dto.BorrowDTO;

public class BorrowDAOImpl {
	private static final String SELECT_ALL_BORROW	= "SELECT * FROM Borrows";
	private static final String SELECT_BORROW_BY_ID	= "SELECT * FROM Borrows WHERE BorrowID = ?";
	private static final String UPDATE_BORROW		= "UPDATE Borrows SET StudentID = ?, BookID = ?, Quantity =? WHERE BorrowID = ? ";
	private static final String DELETE_BORROW		= "DELETE FROM Borrows WHERE BorrowID = ?";
	private static final String SELECT_BORROW_BY_STUDENTID	= "SELECT * FROM Borrows WHERE StudentID = ? ";
	private static final String INSERT_NEW_BORROW	= "INSERT INTO Borrows (StudentID, BookID, BorrowDate, Quantity) VALUES (?, ?, ?, ?)";
//	private static final String UPDATE_QUANTITY_BOOK =  "UPDATE Books SET Quantity = ? ";
	
	public List<BorrowDTO> getAllBorrow() {
		List<BorrowDTO> borrows = new ArrayList<>();
		try (Connection connection = JDBCUtils.getConnection();
				Statement  statement = connection.createStatement()) {
				ResultSet rs = statement.executeQuery(SELECT_ALL_BORROW);
				while(rs.next()) {
					int borrowId	= rs.getInt("borrowId");
					int studentId	= rs.getInt("studentId");
					int bookId		= rs.getInt("bookId");
					String borrowDate = rs.getString("borrowDate");
					int quantity	= rs.getInt("quantity");
					borrows.add(new BorrowDTO(borrowId, studentId, bookId, borrowDate, quantity));
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return borrows;
	}

	public void addNewBorrow(BorrowDTO borrow) {
		try ( Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_BORROW)){
			preparedStatement.setInt(1, borrow.getStudentId());
			preparedStatement.setInt(2, borrow.getBookId());
			preparedStatement.setString(3, borrow.getBorrowDate());
			preparedStatement.setInt(4, borrow.getQuantity());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
		}
		
	}

	public boolean deleteBorrow(int borrowId) {
		boolean rowDeleted = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement pre = connection.prepareStatement(DELETE_BORROW) ) {
			pre.setInt(1, borrowId);
			rowDeleted = pre.executeUpdate() > 0;

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
	}

	public boolean updateBorrow(BorrowDTO borrow)  {
		boolean rowUpdated = false;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement pre = connection.prepareStatement(UPDATE_BORROW)){
			pre.setInt(1, borrow.getStudentId());
			pre.setInt(2, borrow.getBookId());
			pre.setInt(3, borrow.getQuantity());
			pre.setInt(4, borrow.getBorrowId());
			rowUpdated = pre.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public BorrowDTO getBorrowByStudentId(int studentId) {
		BorrowDTO borrow = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BORROW_BY_STUDENTID)) {
				preparedStatement.setInt(1, studentId);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					int borrowId	= resultSet.getInt("borrowId");
					int bookId		= resultSet.getInt("bookId");
					String borrowDate	= resultSet.getString("date");
					int quantity 	= resultSet.getInt("quantity");
					
					borrow = new BorrowDTO(borrowId, studentId, bookId, borrowDate, quantity);
				}
 		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrow;
	}

	public int getQuantityBookAvailabel(int bookId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public BookDTO updateQuantity(BookDTO book) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public BorrowDTO getBorrowByById(int borrowId) {
		BorrowDTO borrow = null;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement pre = connection.prepareStatement(SELECT_BORROW_BY_ID)) {
			pre.setInt(1, borrowId);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				int studentId 	= rs.getInt("studentId");
				int bookId		= rs.getInt("bookId");
				String borrowDate = rs.getString("borrowDate");
				int quantity	= rs.getInt("quantity");
				
				borrow = new BorrowDTO(borrowId, studentId, bookId, borrowDate, quantity);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return borrow;
	}
	


}
