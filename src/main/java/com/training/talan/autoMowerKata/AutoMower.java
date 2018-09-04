package com.training.talan.autoMowerKata;

import com.training.talan.types.Orientation;

public class AutoMower {
	
	private int x;
	private int y;
	private Orientation o;
	
	public AutoMower(int x, int y, Orientation o) {
		this.x = x;
		this.y = y;
		this.o = o;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Orientation getO() {
		return o;
	}

	public void setO(Orientation o) {
		this.o = o;
	}


	public String getFinalPosition() {
		return this.getX() + " "+ this.getY() + " "+ this.getO();
	}
	
	
	
}