package com.bootbs.bookstore.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookstore")
public class BookStoreModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String book;
	@Column
	private String author;
	@Column
	private int quantity;
	@Column
	private double price;
	
	public BookStoreModel(int id, String book, String author, int quantity,double price) {
        this.id = id;
        this.book = book;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
    }
	
	public BookStoreModel() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
