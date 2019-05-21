package com.test.bean;

import java.sql.Timestamp;

public class Article {

	private Integer id;

	private String title;

	private String content;

	private String auther;

	private Timestamp createDate;

	private Integer like;

	private Integer look;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setAuther(String auther) {
		this.auther = auther;
	}

	public String getAuther() {
		return auther;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getLike() {
		return like;
	}

	public void setLook(Integer look) {
		this.look = look;
	}

	public Integer getLook() {
		return look;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id='" + id + '\'' +
				", title='" + title +'\''+
				", content='" + content +'\''+
				", auther='" + auther +'\''+
				", createDate='" + createDate +'\''+
				", like='" + like +'\''+
				", look='" + look +'\''+
				'}';
	}

}