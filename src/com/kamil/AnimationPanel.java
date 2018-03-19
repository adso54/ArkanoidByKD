package com.kamil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class AnimationPanel extends JPanel implements KeyListener{

    JPanel tenPanel = this;
    ArrayList ballsList = new ArrayList();
    ArrayList brickList = new ArrayList();
    ThreadGroup threadGroup = new ThreadGroup("Arcanoid group");
    Shield shield = new Shield();
    Thread thread;
    Object lock = new Object();
    

    public void addShield(){
        thread = new Thread(threadGroup, new ShieldRunnable(shield));
        thread.start();
    }
    
//    public void addBrickSchema() {
//    	BrickSchema.buildSchema(brickList, threadGroup );
//    	
//    }

    public void addBall()  {
        ballsList.add(new Ball());
        thread = new Thread(threadGroup, new BallRunnable((Ball)(ballsList.get(ballsList.size()-1))));
        thread.start();
        //threadGroup.list();
    }

    public void deleteBall(){
        threadGroup.interrupt();
        
    }
    public void deleteBall(Thread th) {
    	th.interrupt();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for (int i =0; i<ballsList.size();i++){
            g.drawImage(((Ball)ballsList.get(i)).getBall(), ((Ball)ballsList.get(i)).x, ((Ball)ballsList.get(i)).y, null);
        }
        for (int j=0; j<brickList.size();j++) {
        	g.drawImage(((Brick)brickList.get(j)).getBrick(), ((Brick)brickList.get(j)).positionX, ((Brick)brickList.get(j)).positionY, null);
        }

        g.drawImage(shield.getShield(), shield.polozenieX, shield.polozenieY, null);
        
    }


    public class BallRunnable implements Runnable{
        public BallRunnable(Ball ball){
            this.ball = ball;
        }
        @Override
        public void run() {
            try {
                while(!Thread.currentThread().isInterrupted())
                {
                    if(this.ball.moveBall(tenPanel, shield)) {
	                    repaint();
	                    Thread.sleep(8);
                    }else {
                    	Thread.interrupted();
                    }
                    
                }
            } catch (InterruptedException e) {
                ballsList.clear();
                repaint();
            }
        }
        Ball ball;
    }

    public class ShieldRunnable implements Runnable{
        public ShieldRunnable(Shield shield){
            this.shield = shield;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    this.shield.ruszShield(tenPanel, 0);
                    repaint();
                    Thread.sleep(0, 100);
                }

            } catch (InterruptedException e) {
                repaint();
            }
        }
        Shield shield;
        int kierunek;
    }
    
    public class BrickRunnable implements Runnable{
    	Brick brick;
    	
    	public BrickRunnable(Brick brick) {
    		this.brick = brick;
    	}
    		
		@Override
		public void run() {
			try {
				while(!Thread.currentThread().isInterrupted()) {
					// TODO checking if brick was hit
					repaint();
					Thread.sleep(0, 100);
				}
			}catch(InterruptedException e) {
				repaint();
			}
			
		}
    	
    }

	@Override
	public void keyPressed(KeyEvent e) {
		  if(e.getKeyCode() ==39){
              this.shield.ruszShield(this,1);
              repaint();
          }else if(e.getKeyCode() ==37){
              this.shield.ruszShield(this,-1);
              repaint();
          }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
}