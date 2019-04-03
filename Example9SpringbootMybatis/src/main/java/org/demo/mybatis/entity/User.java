package org.demo.mybatis.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7362685658832484312L;

	private Long id; 
	private String userName; 
	private String password; 
	
	public User() {
		
	}
	
	public User(String userName, String password) {
		this.userName = userName; 
		this.password = password; 
	}
	
	public User(Long id, String userName, String password) {
		this(userName, password); 
		this.id = id; 
	}
}
