package com.test.bean;

public class User {

	/** id*/
	private Integer id;

	/** 账号*/
	private String username;

	/** 密码*/
	private String password;

	/** 昵称*/
	private String nickname;

	/** 邮箱*/
	private String email;

	/** 头像*/
	private String picture;

	/** 简介*/
	private String introduction;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return introduction;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username +'\''+
				", password='" + password +'\''+
				", nickname='" + nickname +'\''+
				", email='" + email +'\''+
				", picture='" + picture +'\''+
				", introduction='" + introduction +'\''+
				'}';
	}
}