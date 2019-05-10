package com.czuluaga.poc.sb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.czuluaga.poc.sb.model.Book;

public class LibraryService {
	
	private static LibraryService instance = null;
	
	private LibraryService () {}
	private final static List<Book> books = new ArrayList<>();
	
	public static LibraryService getInstance() {
		if(instance  == null) {
			instance = new LibraryService();
			loadInitialData();
		}
		return instance;
	}
	
	
	
	public List<Book> getBooks() {
		return books;
	}

	private static void loadInitialData() {
		
		Book book = new Book();
		book.setAuthor("Anne Rice");
		book.setName("Entrevista con el Vampiro");
		book.setIsbn("asdf-lkqwe-1203");
		book.setStars(2);
		
		Book book1 = new Book();
		book1.setAuthor("J.R.R Tolkien");
		book1.setName("The Fellowship of the ring");
		book1.setIsbn("asdf-lkqwe-1203");
		book1.setStars(3);
		
		Book book4 = new Book();
		book4.setAuthor("J.R.R Tolkien");
		book4.setName("The Hobbit");
		book4.setIsbn("asdf-lkqwe-1203");
		book4.setStars(4);
		
		Book book3 = new Book();
		book3.setAuthor("J.R.R Tolkien");
		book3.setName("The Fellowship of the ring");
		book3.setIsbn("asdf-lkqwe-1203");
		book3.setStars(5);
		
		Book book5 = new Book();
		book5.setAuthor("J.R.R Tolkien");
		book5.setName("The Silmarillion");
		book5.setIsbn("0-04-823139-8");
		book5.setStars(5);
		
		Book book6 = new Book();
		book6.setAuthor("J.R.R Tolkien");
		book6.setName("Two Towers");
		book6.setIsbn("	936070");
		book6.setStars(5);
		
		Book book2 = new Book();
		book2.setAuthor("George R.R Martin");
		book2.setName("Game of Thrones");
		book2.setIsbn("oijkl-87hgf-ytt67");
		book2.setStars(5);
		
		books.add(book);
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
	}
	
	
	public List<Book> find(String filter, IFindBook<Book,List<Book>> functional){
		return functional.find(this.getInstance().getBooks(), filter);
	}
	
	public Book findOne(String filter, IFindBook<Book,Optional<Book>> functional) {
		Optional<Book> book = functional.find(this.getInstance().getBooks(), filter);
		return book.get();
	}
}
