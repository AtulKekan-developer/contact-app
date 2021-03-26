package com.atul.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=11)
	private Integer userId;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String phone;
	@Column(length=50)
	private String email;
	@Column(length=150)
	private String address;
	@Column(length=20,nullable=false,unique=true)
	private String loginName;
	@Column(length=50,nullable=false)
	private String password;
	@Column(length=1,nullable=false)
	private Integer role = 2;
	@Column(length=1,nullable=false)
	private Integer loginStatus = 1;
	
	@OneToMany(mappedBy="user")
	private List<Contact> contactList;
}
