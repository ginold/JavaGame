/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.net.URL;
import java.util.logging.Logger;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

/**
 *
 * @author _ginold_
 */
public class TileMap {

    public int numCols;
    public int numRows;
    public int map[][];
    public int tilesize = 48;
    private String tokens[];
    private Image grass;
    private Image tree;

    private Input input;
    
    private double tween = 0.07;

    private int ymin, ymax, xmin, xmax;
    
    public int rowOffset, colOffset, numRowsToDraw, numColsToDraw;

    public int x = RTS.width /2;
    public int y = RTS.height /2;

    private int width, height;

    public TileMap(String source) {
        
        // draws +2 tiles more than you can see
        numRowsToDraw = RTS.height / tilesize +2;
        numColsToDraw = RTS.width / tilesize + 2;
        
        try {
            this.tree = new Image("C:\\Users\\ginold\\Documents\\NetBeansProjects\\JavaGame\\src\\rts\\resources\\tree.png");
            this.grass = new Image("C:\\Users\\ginold\\Documents\\NetBeansProjects\\JavaGame\\src\\rts\\resources\\grass.png");
            
            BufferedReader br = new BufferedReader(new FileReader(source));
            String delimiters = " ";

            try {
                String line = br.readLine();

                // get number of lines = mapwidth
                FileInputStream stream = new FileInputStream(source);
                byte[] buffer = new byte[8192];
                int count = 0;
                int n;
                while ((n = stream.read(buffer)) > 0) {
                    for (int i = 0; i < n; i++) {
                        if (buffer[i] == '\n') {
                            count++;
                        }
                    }
                }
                stream.close();

                numRows = count + 1;
                numCols = br.readLine().split(delimiters).length;
                br.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            map = new int[numRows][numCols];

            br = new BufferedReader(new FileReader(source));
            
            for (int row = 0; row < numRows; row++) {
                String theLine = br.readLine();
                tokens = theLine.split(delimiters);
                for (int col = 0; col < numCols; col++) {
                    map[row][col] = Integer.parseInt(tokens[col]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void render(Graphics g) {
        for (int row = rowOffset; row < rowOffset + numRowsToDraw; row++) {
            // nothing else to draw, out of bounds
            if (row >= numRows) {
                break;
            }
            if (row <= 0) {
                row = 0;
            }
            for (int col = colOffset; col < colOffset + numColsToDraw; col++) {
                if (col <= 0) {
                    col = 0;
                }
                // nothing else to draw, out of bounds
                if (col >= numCols) {
                    break;
                }
                
                int rowcol = map[row][col];
                
                if (rowcol == 0) {
                    g.drawImage(tree, this.x + col * tilesize, this.y + row * tilesize);
                }
                if (rowcol == 3) {
                    g.drawImage(grass, this.x + col * tilesize, this.y + row * tilesize);
                }
                if (rowcol == 5) {
                    g.fillRect(this.x + col * tilesize, this.y + row * tilesize, tilesize, tilesize);
                    g.setColor(Color.red);
                    
                }
                g.drawString("x:" + Integer.toString(this.x + col * tilesize), x + col * tilesize , y+ row *tilesize );
                g.drawString( "y:" + Integer.toString(this.y+ row *tilesize), x + col * tilesize , y+ row *tilesize + 20);
                g.setColor(Color.white);
            }
        }
    }

        // player x, player y
    void setPosition(int x, int y) {
        this.x += (x - this.x) * tween;
        this.y += (y - this.y) * tween;
        this.colOffset = (int) -this.x / tilesize;
        this.rowOffset = (int) -this.y /tilesize;
        
        if (rowOffset > numRows-1) {
          rowOffset = numRows;  
        }
        if (colOffset > numCols -1 ) {
          colOffset = numCols;  
        }
        System.out.println(this.x);
        System.out.println(this.y);
    }

}
