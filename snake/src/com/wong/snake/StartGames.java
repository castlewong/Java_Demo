package com.wong.snake;

import javax.swing.*;

public class StartGames {
    public static void main(String[] args) {
        // 1 DRAW STATIC WINDOW JFrame
        JFrame jFrame = new JFrame("castle learn Java-SnakeGame"); // SET THE AREA OF INTERFACE
        jFrame.setBounds(10, 10, 900, 720);
        jFrame.setResizable(false); // THE AREA CANNOT BE CHANGED
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE); // SET CLOSE EVENT THE GAME CAN BE CLOSED
        // 2 画板 JPanel ABLE TO ADD TO JFRAME

        jFrame.add(new GamePanel());

        jFrame.setVisible(true); // SHOW THE WINDOW
    }
}
