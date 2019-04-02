package org.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Data;

@Entity(name="t_user")
@Data 

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3423363034791718842L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String userName; 
	private String password; 
	
	@Transient
	private String email; 
	
	public User() {
		
	}
	public User(String userName, String password) {
		this.userName = userName; 
		this.password = password; 
	}
	
	public User(Long id, String userName, String password) {
		this.id = id; 
		this.userName = userName; 
		this.password = password; 
	}
	
}
