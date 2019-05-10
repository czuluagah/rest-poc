package com.czuluaga.poc.sb.rs;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czuluaga.poc.sb.model.BaseResponse;
import com.czuluaga.poc.sb.model.Book;
import com.czuluaga.poc.sb.service.FindBooksStrategy;
import com.czuluaga.poc.sb.service.LibraryService;

@RestController
@RequestMapping(path = "/library")
public class SimpleRest implements ISwaggerRestDoc{
	
	@Override
	@GetMapping("/books")
	public ResponseEntity<BaseResponse<List<Book>>> getAllBooks() {
		BaseResponse<List<Book>> response = new BaseResponse<>();
		response.setData(LibraryService.getInstance().getBooks());
		return ResponseEntity.ok(response);
	}
	
	@Override
	@GetMapping("/books/stars/{starts}")
	public ResponseEntity<BaseResponse<List<Book>>> getBooksByStars(@PathVariable(name ="starts") String starts) {
		BaseResponse<List<Book>> response = new BaseResponse<>();
		response.setData(LibraryService.getInstance().find( starts , FindBooksStrategy.byStars));
		return ResponseEntity.ok(response);
	}
	
	@Override
	@GetMapping("/books/isbn/{isbn}")
	public ResponseEntity<BaseResponse<Book>> getBooksByIsbn(@PathVariable(name ="isbn") String isbn) {
		BaseResponse<Book> response = new BaseResponse<>();
		response.setData(LibraryService.getInstance().findOne( isbn , FindBooksStrategy.byIsbn));
		return ResponseEntity.ok(response);
	}
	
	@Override
	@GetMapping("/books/author/{author}")
	public ResponseEntity<BaseResponse<List<Book>>> getBooksByAuthor(@PathVariable(name ="author") String author) {
		BaseResponse<List<Book>> response = new BaseResponse<>();
		response.setData(LibraryService.getInstance().find( author , FindBooksStrategy.byAuthor));
		return ResponseEntity.ok(response);
	}
	
	@Override
	@GetMapping("/books/name/{name}")
	public ResponseEntity<BaseResponse<Book>> getBooksByName(@PathVariable(name ="name") String name) {
		BaseResponse<Book> response = new BaseResponse<>();
		response.setData(LibraryService.getInstance().findOne( name , FindBooksStrategy.byName));
		return ResponseEntity.ok(response);
	}
}
