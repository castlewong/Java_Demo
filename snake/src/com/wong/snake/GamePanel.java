package com.wong.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// INHERIT JPanel
public class GamePanel extends JPanel implements KeyListener, ActionListener {
    int length;
    int [] snakeX = new int[600];
    int [] snakeY = new int[500];
    String fx; // R: RIGHT

    boolean isStart = false; // IS GAME STARTED

    int score = 0; // SCORE SYSTEM

    Timer timer = new Timer(100,this); // TIMER

    // DEFINE A FOOD
    int foodX;
    int foodY;
    Random random = new Random();

    // DECIDE DIED OR NOT
    boolean isFail = false;

    // 构造器
    public GamePanel(){
        init();
        // GET THE LISTEN EVENT OF KEYBOARD
        this.setFocusable(true); // GET THE KEYBOARD FOCUS
        this.addKeyListener(this); // ADD A LISTENER
        timer.start(); // LET THE TIMER START
    }

    // INIT 初始化
    public void init(){
        length = 3;
        snakeX[0] = 100; snakeY[0] = 100; // LOCATION OF HEAD
        snakeX[1] = 75; snakeY[1] = 100;
        snakeX[2] = 50;snakeY[2] = 100;
        fx = "R";
        foodX = 25 + 25*random.nextInt(34);
        foodY = 75 + 25*random.nextInt(24);
        score = 0;
    }

    // CANVAS  DRAW  SNAKE INTERFACE  GRAPHICS THE BRUSH
    // SELECT METHODS TO OVERRIDE CTRL+O
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // CLEAR THE SCREEN
        this.setBackground(Color.WHITE); // SET BG COLOR
        Data.header.paintIcon(this,g,25,11); // DRAW HEADER AREA
        g.fillRect(25, 75,850,600); // DRAW GAME AREA

        // DRAW A STATIC SNAKE
        if (fx.equals("R")){
            Data.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("L")){
            Data.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("U")){
            Data.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if(fx.equals("D")){
            Data.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }

        for (int i = 1; i< length; i++){
            Data.body.paintIcon(this,g,snakeX[i],snakeY[i]); // THE LENGTH OF SNAKE CONTROL BY length
        }

        // DRAW SCORE
        g.setColor(Color.WHITE);
        g.setFont(new Font("微软雅黑", Font.BOLD, 18));
        g.drawString("长度："+length,750,30);

        g.drawString("分数："+score,750,50);

        // DRAW A FOOD
        Data.food.paintIcon(this,g,foodX,foodY);

        // GAME TIP IS ON OR NOT
        if (isStart==false){
            // DRAW A WORD STRING
            g.setColor(Color.WHITE);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("PRESS TO START GAME",300,300);
        }

        // DRAW A FAILED NOTICE
        if (isFail){
            // DRAW A STRING
            g.setFont(new Font("黑体",Font.BOLD,20));
            g.setColor(Color.CYAN);
            g.drawString("YOU'VE FAILED, PRESS SPACE TO START ALL OVER AGAIN",50,300);
        }
    }


    // LISTEN THE INPUT OF KEYBOARD
    @Override
    public void keyPressed(KeyEvent e) {
        // KEY PRESSED not RELEASE YET
        int keyCode = e.getKeyCode(); // a shortcut to add int

        if (keyCode == KeyEvent.VK_SPACE) { // IF THE SPACE KEY IS PRESSED
            if (isFail) {
                // FAILED START AGAIN
                isFail = false;
                init(); // INIT GAME AGAIN
            } else {
                isStart = !isStart;
            }
            repaint(); // REFRESH THE PAINT
        }

        // KEYBOARD CONTROL THE DIRECTION
        if (keyCode == KeyEvent.VK_LEFT){
            fx=("L");
        }else if (keyCode == KeyEvent.VK_RIGHT){
            fx=("R");
        }else if (keyCode == KeyEvent.VK_UP){
            fx=("U");
        }else if (keyCode == KeyEvent.VK_DOWN){
            fx=("D");
        }
    }

    // TIMER listen time FRAME 执行定时操作
    @Override
    public void actionPerformed(ActionEvent e) {
        // IF THE GAME IS ON AND THE GAME IS NOT OVER
        if (isStart && isFail==false) {
            // MOVE TO THE RIGHT
            for (int i = length - 1; i > 0; i--) { // WHOLE BODY MOVE FORWARD EXCEPT THE HEAD
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            // MOVE THE HEAD BY CTRL DIRECTION
            if (fx.equals("R")){
                snakeX[0] = snakeX[0] + 25; // MOVE THE HEAD
                // JUDGE THE BOUNDARY
                if (snakeX[0]>850) snakeX[0] = 25;
            } else if (fx.equals("L")){
                snakeX[0] = snakeX[0] - 25; // MOVE THE HEAD
                if (snakeX[0]<25) snakeX[0] = 850;
            } else if (fx.equals("U")){
                snakeY[0] = snakeY[0] - 25; // MOVE THE HEAD
                if (snakeY[0]<75) snakeY[0] = 650;
            } else if (fx.equals("D")){
                snakeY[0] = snakeY[0] + 25; // MOVE THE HEAD
                if (snakeY[0]>650) snakeY[0] = 75;
            }

            // IF THE HEAD OF SNAKE OVER THE FOOD
            if (snakeX[0] == foodX && snakeY[0] == foodY){
                length ++;
//                length+=length; // 不断翻倍 有趣
                score = score + 10;
                // REGENERATE THE FOOD
                foodX = 25 + 25*random.nextInt(34);
                foodY = 75 + 25*random.nextInt(24);
            }

            // END THE DECISION
            for (int i =1;i<length;i++){
                if (snakeX[0]==snakeX[i] && snakeY[0]==snakeY[i]){
                    isFail = true;
                    break;
                }
            }

            // REFRESH THE SCREEN
            repaint();
        }
            timer.start(); // LET THE TIMER START
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // RELEASE SOME KEY
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // KEY 按下 弹起 敲击
    }

}
