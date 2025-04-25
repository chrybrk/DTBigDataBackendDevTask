package dev.dt.pickspot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Slot {
	@JsonProperty int x;
	@JsonProperty int y;
	@JsonProperty String sizeCap;
	@JsonProperty boolean hasColdUnit;
	@JsonProperty boolean occupied;

	public Slot(int x, int y, String sizeCap, boolean hasColdUnit, boolean occupied) {
		this.x = x;
		this.y = y;
		this.sizeCap = sizeCap;
		this.hasColdUnit = hasColdUnit;
		this.occupied = occupied;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSizeCap(String sizeCap) {
		this.sizeCap = sizeCap;
	}

	public void setHasColdUnit(boolean hasColdUnit) {
		this.hasColdUnit = hasColdUnit;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public int x() {
		return this.x;
	}

	public int y() {
		return this.y;
	}

	public String sizeCap() {
		return this.sizeCap;
	}

	public boolean hasColdUnit() {
		return this.hasColdUnit;
	}

	public boolean occupied() {
		return this.occupied;
	}
}
