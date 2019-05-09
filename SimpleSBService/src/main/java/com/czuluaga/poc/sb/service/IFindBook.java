package com.czuluaga.poc.sb.service;

import java.util.Collection;

@FunctionalInterface
public interface IFindBook<T,U> {
	
	U find( Collection<T> toFilter, String filter );
}
