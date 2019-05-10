package com.czuluaga.poc.sb.rs;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.czuluaga.poc.sb.model.BaseResponse;
import com.czuluaga.poc.sb.model.Book;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


public interface ISwaggerRestDoc {
	
	@ApiOperation(value = "View a list of available books", response = ResponseEntity.class)
	public ResponseEntity<BaseResponse<List<Book>>> getAllBooks();
	
	@ApiOperation(value = "View a list of books filter by the numer of stars", response = ResponseEntity.class)
	public ResponseEntity<BaseResponse<List<Book>>> getBooksByStars( @ApiParam(value = "Number of starts to filter the list of books", required = true) String starts);
	
	@ApiOperation(value = "View a book that acomplish the isbn given", response = ResponseEntity.class)
	public ResponseEntity<BaseResponse<Book>> getBooksByIsbn(@ApiParam(value = "Isbn id of the book", required = true) String isbn);
	
	@ApiOperation(value = "View a list of books of the author selected", response = ResponseEntity.class)
	public ResponseEntity<BaseResponse<List<Book>>> getBooksByAuthor(@ApiParam(value = "Name of the author", required = true) String author);
	
	@ApiOperation(value = "Search for a specifc book filter by name", response = ResponseEntity.class)
	public ResponseEntity<BaseResponse<Book>> getBooksByName(@ApiParam(value = "name of the book", required = true) String name);
}
