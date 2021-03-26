package com.atul.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Contact {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(length=11)
	private Integer contactId;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String phone;
	@Column(length=50)
	private String email;
	@Column(length=150)
	private String address;
	@Column(length=150)
	private String remark;
	
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="userId")
	private User user;
}
