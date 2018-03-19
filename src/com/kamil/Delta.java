package com.kamil;

public class Delta {
	private int deltaX;
	private int deltaY;
	private final static int STARTVALUE = 4;
	
	public Delta() {
		this(STARTVALUE, STARTVALUE);
	}
	
	public Delta(int deltaX, int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}
	
	public int getDeltaX() {
		return deltaX;
	}
	
	public int getDeltaY() {
		return deltaY;
	}
	
	public void setDeltaX(int deltaX) {
		this.deltaX = deltaX;
	}
	
	public void setDeltaY(int deltaY) {
		this.deltaY = deltaY;
	}

	public String toString() {
		return "deltaX: " + deltaX + "; deltaY: " + deltaY;
	}
	
	public void setDelta(int deltaX, int deltaY) {
		setDeltaX(deltaX);
		setDeltaY(deltaY);
	}
}
