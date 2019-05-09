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
		//response.setData(this.get());
		return null; //ResponseEntity.ok(response);
	}
	
	
}
