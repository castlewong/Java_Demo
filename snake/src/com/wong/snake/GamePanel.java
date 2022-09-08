package com.wong.snake;

import javax.swing.*;
import java.awt.*;

// INHERIT JPanel
public class GamePanel extends JPanel {

    // CANVAS DRAW  SNAKE INTERFACE
    // SELECT METHODS TO OVERRIDE CTRL+O

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // CLEAR THE SCREEN
        this.setBackground(Color.WHITE); // SET BG COLOR
        Data.header.paintIcon(this,g,25,11); // DRAW HEADER AREA
        g.fillRect(25, 75,850,600); // DRAW GAME AREA

    }
}
