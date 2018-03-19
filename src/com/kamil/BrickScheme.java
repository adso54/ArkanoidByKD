package com.kamil;

import java.util.ArrayList;

import com.kamil.AnimationPanel.BrickRunnable;

public class BrickScheme {
	
	public static void buildSchema(ArrayList brickList, ThreadGroup threadGroup) {
		private Thread thread;
		private schema =1;
		brickList.add(new Brick());
		thread = new Thread(threadGroup, new BrickRunnable((Brick)(brickList.get(brickList.size()-1))));
		thread .start();
	}
	
public static void buildSchema(ArrayList brickList, ThreadGroup threadGroup, int schema) {
		private Thread thread;
		private schema =1;
		brickList.add(new Brick());
		thread = new Thread(threadGroup, new BrickRunnable((Brick)(brickList.get(brickList.size()-1))));
		thread.start();
	}
	
}
