package com.test.bean;

import java.sql.Timestamp;

public class Article {

	/** id*/
	private Integer id;

	/** 标题*/
	private String title;

	/** 内容*/
	private byte[] content;

	/** 作者*/
	private Integer auther;

	/** 创建时间*/
	private Timestamp create_date;

	/** 点赞数*/
	private Integer like;

	/** 阅读数*/
	private Integer look;

	/** 系统分类*/
	private Integer type;

	/** 原创*/
	private Byte original;

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

	public void setContent(byte[] content) {
		this.content = content;
	}

	public byte[] getContent() {
		return content;
	}

	public void setAuther(Integer auther) {
		this.auther = auther;
	}

	public Integer getAuther() {
		return auther;
	}

	public void setCreateDate(Timestamp createDate) {
		this.create_date = createDate;
	}

	public Timestamp getCreateDate() {
		return create_date;
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

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getType() {
		return type;
	}

	public void setOriginal(Byte original) {
		this.original = original;
	}

	public Byte getOriginal() {
		return original;
	}

	@Override
	public String toString() {
		return "Article{" +
				"id='" + id + '\'' +
				", title='" + title +'\''+
				", content='" + content +'\''+
				", auther='" + auther +'\''+
				", createDate='" + create_date +'\''+
				", like='" + like +'\''+
				", look='" + look +'\''+
				", type='" + type +'\''+
				", original='" + original +'\''+
				'}';
	}
}