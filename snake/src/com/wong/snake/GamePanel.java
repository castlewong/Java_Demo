package com.wong.snake;

import javax.swing.*;
import java.awt.*;

// INHERIT JPanel
public class GamePanel extends JPanel {
    int length;
    int [] snakeX = new int[600];
    int [] snakeY = new int[500];

    // 构造器
    public GamePanel(){
        init();
    }

    // INIT
    public void init(){
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100; // LOCATION OF HEAD
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50;snakeY[2] = 100;
    }
    // CANVAS DRAW  SNAKE INTERFACE
    // SELECT METHODS TO OVERRIDE CTRL+O
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // CLEAR THE SCREEN
        this.setBackground(Color.WHITE); // SET BG COLOR
        Data.header.paintIcon(this,g,25,11); // DRAW HEADER AREA
        g.fillRect(25, 75,850,600); // DRAW GAME AREA

        // DRAW A STATIC SNAKE
        for (int i = 1; i< length; i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }
    }
}
