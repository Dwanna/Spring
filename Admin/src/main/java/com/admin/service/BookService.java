package com.admin.service;

import java.util.List;

import com.admin.domain.Book;

public interface BookService {
	
	Book save(Book book);
	
	List<Book> findAll();
	
	Book findOne( Long id);
	void removeOne(Long id);

}
