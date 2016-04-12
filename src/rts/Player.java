/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rts;

import java.awt.Rectangle;
import java.io.File;
import java.net.URL;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;

/**
 *
 * @author _ginold_
 */
public class Player implements KeyListener {

    private int x, y;
    private int tween = 5;
    private Image sprite;
    private Rectangle bBox;
    private int tilesize = 48;
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.bBox = new Rectangle(x, y, tilesize, tilesize);
        
        try {

            this.sprite = new Image("C:\\Users\\ginold\\Documents\\NetBeansProjects\\JavaGame\\src\\rts\\resources\\player.png");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void render(Graphics g) {
        g.drawImage(this.sprite, this.x, this.y);
        g.drawString("x " + Integer.toString(this.x), this.x, this.y);
        g.drawString("y " + Integer.toString(this.y), this.x, this.y + 20);
    }

    
    void move(String direction) {
//        if (direction == "left") {
//            this.x = this.x - 1;
//        }
//        if (direction == "right") {
//            this.x++;
//        }
//        
//        if (direction == "up") {
//            this.y = this.y ;
//        }
//        if (direction == "down") {
//            this.y = this.y ;
//        }
    }
    
    public Rectangle getBBox() {
        this.bBox = new Rectangle(this.x, this.y, tilesize+5, tilesize+5);
        return this.bBox;
    }

    @Override
    public void setInput(Input input) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAcceptingInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputEnded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inputStarted() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(int i, char c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
