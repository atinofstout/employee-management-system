package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class User implements Serializable{

	@Id
	@Column(name = "userid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column(name = "password")
	  private String password;


	@Column(name = "username")
	  private String username;

	@Column(name = "mail")
	  private String mail;

	@Column(name = "phone")
	  private String phone;

	@Column(name = "date")
	  private Date date;


//	public long getUserid() {
//		return userid;
//	}
//	public void setUserid(long userid) {
//		this.userid = userid;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//	public void setUserid(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getMail() {
//		return mail;
//	}
//	public void setMail(String mail) {
//		this.mail = mail;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//	public void setDate(Date date) {
//		this.date = date;
//	}
}
