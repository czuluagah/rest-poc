package com.czuluaga.poc.sb.model;

import java.util.Calendar;

public class Book {
	
	private String name;
	private String author;
	private Calendar publishDate;
	private String isbn;
	private int stars;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Calendar getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Calendar publishDate) {
		this.publishDate = publishDate;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getStars() {
		return stars;
	}
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	
	
}
