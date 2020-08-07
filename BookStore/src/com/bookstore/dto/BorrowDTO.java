package com.bookstore.dto;


public class BorrowDTO {
	private int borrowId;
	private int studentId;
	private int bookId;
	private String borrowDate;
	private int quantity;
	
	
	
	
	
	public BorrowDTO(int studentId, int bookId, String borrowDate, int quantity) {
		super();
		this.studentId = studentId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.quantity = quantity;
	}

	public BorrowDTO(int borrowId, int studentId, int bookId, String borrowDate, int quantity) {
		super();
		this.borrowId = borrowId;
		this.studentId = studentId;
		this.bookId = bookId;
		this.borrowDate = borrowDate;
		this.quantity = quantity;
	}

	public int getBorrowId() {
		return borrowId;
	}
	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
