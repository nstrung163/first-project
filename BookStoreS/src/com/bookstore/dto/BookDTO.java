package com.bookstore.dto;

public class BookDTO {
	private int bookId;
	private String name;
	private int totalPage;
	private String type;
	private int quantity;
	
	
	
	public BookDTO(int bookId, String name, int totalPage, String type, int quantity) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.totalPage = totalPage;
		this.type = type;
		this.quantity = quantity;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
