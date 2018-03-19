package com.kamil;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Brick extends GameObject {
	public int positionX;
	public int positionY;
	public int width;
	public int height;
	private Image image; 
	public final static int BLACK_BRICK = 1; 
	//TODO public final static int RED_BRICK = 2; 
	private int type; 

	public Brick(int positionX, int positionY, int type) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.type = type;
		pickTypeOfBrickAndSetSize();
	}
	
	public Brick() {
		this(100, 100, BLACK_BRICK);
	}
	
	private void pickTypeOfBrickAndSetSize() {
		switch(type) {
		case 1:
			setBlackBrick();
			break;
		}
		setSizeOfBrick();
	}

	private void setBlackBrick() {
		image = new ImageIcon("BrickBlack.png").getImage();
	}
	
	private void setSizeOfBrick() {
		this.width = image.getWidth(null);
		this.height = image.getHeight(null);
	}
	
	public Image getBrick() {
		return image;
	}
}
