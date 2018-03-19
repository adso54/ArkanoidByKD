package com.kamil;

import javax.swing.*;
import java.awt.*;

public  class Ball{
    private Image ball = new ImageIcon("ball.gif").getImage();
    public int x = 0;
    public int y = 0;
    public Delta delta = new Delta();
    
    private int znak = 1;
    public int xBall = ball.getWidth(null);
    public int yBall = ball.getHeight(null);
    public Image getBall() {
        return ball;
    }

    public boolean moveBall(JPanel panel, Shield shield){
        Rectangle granicePanelu = panel.getBounds();

        x += delta.getDeltaX();
        y += delta.getDeltaY();

        //down
        if(y+yBall >= granicePanelu.getMaxY()){
            y = (int)(granicePanelu.getMaxY()-yBall);
            return false;
        }

        // right
        if(x+xBall >= granicePanelu.getMaxX()){
            x = (int)(granicePanelu.getMaxX() - xBall);
            delta.setDeltaX(- delta.getDeltaX());
        }

        // up
        if(y <= granicePanelu.getMinY()){
            y = (int)(granicePanelu.getMinY());
            delta.setDeltaY(- delta.getDeltaY());
            
        }
        // left
        if(x <= granicePanelu.getMinX()){
            x = (int)(granicePanelu.getMinX());
            delta.setDeltaX(- delta.getDeltaX());
        }
        
        //shield
        if(y >=  shield.polozenieY
                && y <= shield.polozenieY + shield.wysokosc
                && x >= shield.polozenieX
                && x <= shield.polozenieX + shield.szerokosc){
            y = shield.polozenieY ;
            
            setDeltas(shield.getPartOfShield(x));
        }
        return true;
    }
    
    private void setDeltas(int switcher) {
    	switch(switcher) {
    	case 0:
    		delta.setDelta((-znak) * 10, -1);
    		break;
    	case 1:
    		delta.setDelta((-znak) * 8, -2);
    		break;
    	case 2:
    		delta.setDelta((-znak) * 6, -3);
    		break;
    	case 3:
    		delta.setDelta((-znak) * 4, -4);
    		break;
    	case 4:
    		delta.setDelta((-znak) * 2, -5);
    		break;
    	case 5:
    		delta.setDelta(0, -6);
    		break;
    	case 6:
    		delta.setDelta((znak) * 2, -5);
    		break;
    	case 7:
    		delta.setDelta((znak) * 4, -4);
    		break;
    	case 8:
    		delta.setDelta((znak) * 6, -3);
    		break;
    	case 9:
    		delta.setDelta((znak) * 8, -2);
    		break;
    	case 10:
    		delta.setDelta((znak) * 10, -1);

    		break;
    	}
    	
    }


  
    
}

