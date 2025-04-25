package dev.dt.pickspot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Container {
	@JsonProperty String id;
	@JsonProperty String size;
	@JsonProperty boolean needsCold;
	@JsonProperty int x;
	@JsonProperty int y;

	public Container(String id, String size, boolean needsCold, int x, int y) {
		this.id = id;
		this.size = size;
		this.needsCold = needsCold;
		this.x = x;
		this.y = y;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public void setNeedsCold(boolean needsCold) {
		this.needsCold = needsCold;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String id() {
		return this.id;
	}

	public String size() {
		return this.size;
	}

	public boolean needsCold() {
		return this.needsCold;
	}
	
	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}
}
