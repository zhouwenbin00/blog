package com.test.bean;

public class Type {

	/** id*/
	private Integer id;

	/** 分类名称*/
	private String type_name;

	/** 是否为系统分类*/
	private Byte is_system;

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setTypeName(String typeName) {
		this.type_name = typeName;
	}

	public String getTypeName() {
		return type_name;
	}

	public void setIsSystem(Byte isSystem) {
		this.is_system = isSystem;
	}

	public Byte getIsSystem() {
		return is_system;
	}

	@Override
	public String toString() {
		return "Type{" +
				"id='" + id + '\'' +
				", typeName='" + type_name +'\''+
				", isSystem='" + is_system +'\''+
				'}';
	}
}