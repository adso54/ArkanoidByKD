package com.kamil;

import javax.swing.*;
import java.awt.*;

public class Shield {

    Shield(){
        this.polozenieX = 450;//panel.getWidth()/2 - szerokosc / 2;
        this.polozenieY = 700;//panel.getHeight()/2 - wysokosc / 2;

    }

    private Image tarcza = new ImageIcon("Tarcza.png").getImage();
    public int szerokosc = tarcza.getWidth(null);
    public int wysokosc = tarcza.getHeight(null);
    public int polozenieX;
    public int polozenieY;
    public Delta delta = new Delta(20,0);
    
    
    public int getPartOfShield(int point) {
    	System.out.println("punkt: " + point + " szeorkosc: " + szerokosc + " polozenieX " + polozenieX);
    	
    	return (int)(( ((double)point - (double)polozenieX)/(double)szerokosc)*10);
    }


    public Image getShield() {
        return tarcza;
    }

    public void ruszShield(JPanel panel, int kierunek){
        Rectangle granicePanelu = panel.getBounds();
        if (kierunek == -1){
            wLewo(granicePanelu);
        } else if (kierunek == 1){
            wPrawo(granicePanelu);
        }
    }

    private void wLewo(Rectangle granicePanelu){

        if(polozenieX - delta.getDeltaX() <= granicePanelu.getMinX()){
            polozenieX = (int)granicePanelu.getMinX();
        }else{
            polozenieX -= delta.getDeltaX();
        }
    }

    private void wPrawo(Rectangle granicePanelu){

        if(polozenieX + delta.getDeltaX() + szerokosc >= (int)granicePanelu.getMaxX()){
            polozenieX = (int)granicePanelu.getMaxX() - szerokosc;
        }else{
            polozenieX += delta.getDeltaX();
        }

    }
}
