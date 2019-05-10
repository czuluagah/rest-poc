package com.czuluaga.poc.sb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.czuluaga.poc.sb.model.Book;

public class FindBooksStrategy {
	
	public static final IFindBook<Book, Optional<Book>> byIsbn = (toFilter, pFilter) -> toFilter.stream()
																				   .filter( object -> pFilter.equals(object.getIsbn() ))
																				   .findFirst();
	
	public static final IFindBook<Book, Optional<Book>> byName = (toFilter, pFilter) -> toFilter.stream()
			   .filter( object -> pFilter.equals(object.getName() ))
			   .findFirst();
	
	
	public static final IFindBook<Book, List<Book>> byAuthor = (toFilter, pFilter) -> toFilter.stream()
			   .filter( object -> pFilter.equals(object.getAuthor() )).collect(Collectors.toList());
	
	public static final IFindBook<Book, List<Book>> byStars = (toFilter, pFilter) -> toFilter.stream()
			   .filter( object -> pFilter.equals(object.getStars() )).collect(Collectors.toList());
}
