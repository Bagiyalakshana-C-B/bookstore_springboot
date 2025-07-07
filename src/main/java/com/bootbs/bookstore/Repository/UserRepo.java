package com.bootbs.bookstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootbs.bookstore.Model.UserModel;

public interface UserRepo extends JpaRepository<UserModel,String> {
	UserModel findByUsername(String username);
}
