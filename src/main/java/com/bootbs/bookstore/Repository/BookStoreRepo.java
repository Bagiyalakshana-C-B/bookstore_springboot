package com.bootbs.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootbs.bookstore.Model.BookStoreModel;

public interface BookStoreRepo extends JpaRepository<BookStoreModel,Integer>{
	
	

}
