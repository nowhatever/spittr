package com.aaron.bo;

import java.io.Serializable;

public class Component implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() {
		Object object = null;
		try {
			object = (Component)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return object;
	}

	private String name;

	public Component(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public String toString() {
		return "DATA: " + id + " " + name;
	}
}