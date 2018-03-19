package com.kamil;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main  extends JFrame {

    Main(){

    	this.setIconImage(new ImageIcon("Lucky.png").getImage());
        this.setBounds(200,200,1000,800);
        this.setTitle("Lucky Arcanoid");

    	
        JTextField pole = (JTextField)buttonPanel.add(new JTextField(""));
        pole.setFocusable(true);
        pole.requestFocus();
        
        pole.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(keyEvent.getKeyCode() ==39){
                    animationPanel.shield.ruszShield(animationPanel,1);
                    repaint();
                }else if(keyEvent.getKeyCode() ==37){
                    animationPanel.shield.ruszShield(animationPanel,-1);
                    repaint();
                }else if(keyEvent.getKeyCode() ==32){
                	startAnimation();
                }
            }
            @Override
            public void keyReleased(KeyEvent keyEvent) {

            }
            @Override
            public void keyTyped(KeyEvent keyEvent) {

            }
        });   	
        JButton bStart = (JButton)buttonPanel.add(new JButton("Start"));

        bStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pole.setFocusable(true);
                pole.requestFocus();
                startAnimation();
            }
        });

        JButton bStop = (JButton)buttonPanel.add(new JButton("Stop"));

        bStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                pole.setFocusable(true);
                pole.requestFocus();
            	stopAnimation();
            }
        });

        animationPanel.setBackground(Color.GRAY);
        this.getContentPane().add(animationPanel);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    private JPanel buttonPanel = new JPanel();
    private AnimationPanel animationPanel = new AnimationPanel();

    public static void main(String[] args) {
       new Main().setVisible(true);
    }


    public void startAnimation(){
        animationPanel.addBall();
        animationPanel.addShield();
       // animationPanel.addBrick();
    }
    public void stopAnimation(){
        animationPanel.deleteBall();
    }




}



