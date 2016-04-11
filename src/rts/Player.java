/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rts;

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
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
            
        try {
            this.sprite = new Image("C:\\Users\\_ginold_\\Documents\\NetBeansProjects\\RTS\\src\\rts\\resources\\player.png");

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
    }

    void update() {
    }
    
    void move(String direction) {
        if (direction == "left") {
            this.x = this.x - tween;
        }
        if (direction == "right") {
            this.x = this.x + tween;
        }
        
        if (direction == "up") {
            this.y = this.y - tween;
        }
        if (direction == "down") {
            this.y = this.y + tween;
        }
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
}
