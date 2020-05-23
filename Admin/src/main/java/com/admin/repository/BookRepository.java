package com.admin.repository;

import org.springframework.data.repository.CrudRepository;

import com.admin.domain.Book;

public interface BookRepository extends  CrudRepository<Book,Long>{

	
}
