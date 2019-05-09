package com.czuluaga.poc.sb.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.czuluaga.poc.sb.model.Book;

public class LibraryService {
	
	private static LibraryService instance = null;
	
	private LibraryService () {}
	private final static List<Book> books = new ArrayList<>();
	
	private static LibraryService getInstance() {
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
		
		Book book2 = new Book();
		book2.setAuthor("George R.R Martin");
		book2.setName("Game of Thrones");
		book2.setIsbn("oijkl-87hgf-ytt67");
		book2.setStars(5);
		
		books.add(book);
		books.add(book1);
		books.add(book2);
	}
	
	
	public List<Book> findBooksByStarts(int starts){
		return this.getInstance().getBooks().stream().filter( (qualification) -> (qualification.getStars() >= starts))
											  .collect(Collectors.toList());
	}
	
	public Book findByIsbn(String isbn, IFindBook<Book,Optional<Book>> functional) {
		Optional<Book> book = functional.find(this.getInstance().getBooks(), isbn);
		return book.get();
	}
}
