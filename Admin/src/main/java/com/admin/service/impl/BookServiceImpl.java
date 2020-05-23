package com.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.domain.Book;
import com.admin.repository.BookRepository;
import com.admin.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookRepository bookRepository;
	
	public Book save(Book book) {
		return bookRepository.save(book);
	}
	public List<Book> findAll(){
		return (List<Book>)bookRepository.findAll();
	}
	
	public Book findOne(Long id) {
		// TODO Auto-generated method stub
		return bookRepository.findById(id).orElse(null);
	}
	
	public void removeOne(Long id) {
		bookRepository.deleteById(id);
	}

	
	
	
	

}
