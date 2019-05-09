package com.czuluaga.poc.sb.rs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.czuluaga.poc.sb.model.BaseResponse;
import com.czuluaga.poc.sb.model.Book;

@RestController
@RequestMapping(path = "/library")
public class SimpleRest {
	
	@GetMapping("/books")
	public ResponseEntity<BaseResponse<List<Book>>> getAllBooks() {
		
		BaseResponse<List<Book>> response = new BaseResponse<>();
		response.setData(this.get());
		return ResponseEntity.ok(response);
	}
	
	private List<Book> get(){
		List<Book> books = new ArrayList<>();
		Book book = new Book();
		book.setAuthor("Anne Rice");
		book.setName("Entrevista con el Vampiro");
		book.setIsbn("asdf-lkqwe-1203");
		book.setStars(5);
		
		Book book1 = new Book();
		book1.setAuthor("J.R.R Tolkien");
		book1.setName("The Fellowship of the ring");
		book1.setIsbn("asdf-lkqwe-1203");
		book1.setStars(5);
		
		Book book2 = new Book();
		book2.setAuthor("George R.R Martin");
		book2.setName("Game of Thrones");
		book2.setIsbn("oijkl-87hgf-ytt67");
		book2.setStars(5);
		return Arrays.asList(book,book1,book2);
	}
}
