package com.wong.snake;

import javax.swing.*;
import java.net.URL;

// STORE OUTSIDE DATA
public class Data {

    // IMG OF HEADER URL  LOCATE THE IMG  ImageIcon IMG
    public static URL headerURL = Data.class.getResource("/statics/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    // HEAD
    public static URL upURL = Data.class.getResource("/statics/up.png");
    public static URL downURL = Data.class.getResource("/statics/down.png");
    public static URL leftURL = Data.class.getResource("/statics/left.png");
    public static URL rightURL = Data.class.getResource("/statics/right.png");
    public  static ImageIcon up = new ImageIcon(upURL);
    public  static ImageIcon down = new ImageIcon(downURL);
    public  static ImageIcon left = new ImageIcon(leftURL);
    public  static ImageIcon right = new ImageIcon(rightURL);

    // BODY
    public static URL bodyURL = Data.class.getResource("/statics/body.png"); // JUST DON'T FORGET SLASH
    public static ImageIcon body = new ImageIcon(bodyURL);

    // FOOD
    public static URL foodURL = Data.class.getResource("/statics/food.png");
    public static ImageIcon food = new ImageIcon(foodURL);
}
