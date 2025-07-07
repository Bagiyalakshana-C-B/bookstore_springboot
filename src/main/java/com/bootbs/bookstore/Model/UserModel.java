package com.bootbs.bookstore.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class UserModel {
	
	public UserModel(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserModel() {
		
	}
	
	@Id
	private String username;
	@Column
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUser_name(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
