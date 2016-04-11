/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rts;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.logging.Logger;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

/**
 *
 * @author _ginold_
 */
public class TileMap {

    private int numCols;
    private int numRows;
    private int map[][];
    private int tilesize = 48;
    private String tokens[];
    private Image grass;
    private Image tree;

    private Input input;
    
    private double tween = 0.07;

    private int ymin, ymax, xmin, xmax;
    
    private int rowOffset, colOffset, numRowsToDraw, numColsToDraw;

    private int x;
    private int y;

    private int width, height;

    public TileMap(String source) {
        
        // draws +2 tiles more than you can see
        numRowsToDraw = RTS.height / tilesize +2;
        numColsToDraw = RTS.width / tilesize + 2;
        
        System.out.println(numRowsToDraw);
        System.out.println(numColsToDraw);
        try {
            tree = new Image("C:\\Users\\_ginold_\\Documents\\NetBeansProjects\\RTS\\src\\rts\\resources\\tree.png");
            grass = new Image("C:\\Users\\_ginold_\\Documents\\NetBeansProjects\\RTS\\src\\rts\\resources\\grass.png");
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

                width = numRows * tilesize;
                height = numCols * tilesize;

                xmin = RTS.width - width;
                xmax = 0;
                ymin = RTS.height - height;
                ymax = 0;

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
         
            for (int col = colOffset; col < colOffset + numColsToDraw; col++) {
                System.out.println(colOffset+numColsToDraw);
                System.out.println(rowOffset + numRowsToDraw);
                if (col <= 0) {
                    col = 1;
                }
                if (row <= 0) {
                  row = 1;  
                }
                
//                if (row > numRows-1) {
//                    row = numRows -1;
//                }
//                if (col > numCols -1) {
//                  col = numCols -1;  
//                }
    
//                System.out.println("num cols " +numCols);
//                System.out.println("num rows " + numRows);
//                System.out.println("row " + row);
//                System.out.println("col " + col);
               // System.out.println(map[15][31]);
//                if (row > numRows-1) {
//                    row = 4;
//                }
//                if (col > numRows - 1) {
//                    col = 9;
//                }
                int rowcol = map[row][col];
                
                if (rowcol == 0) {
                    g.drawImage(tree, x + col * tilesize, y + row * tilesize);
                }
                if (rowcol == 3) {
                    g.drawImage(grass, x + col * tilesize, y + row * tilesize);
                }
            }
        }
    }


    void setPosition(int x, int y) {
        this.x += (x - this.x) * tween;
        this.y += (y - this.y) * tween;
        
        
        this.colOffset = (int) -this.x / tilesize;
        this.rowOffset = (int) -this.y /tilesize;
        
//            System.out.println(numCols + "  " +numRows);
//        System.out.println(rowOffset + " rowoffset");
//        System.out.println(colOffset + " coloff");
        
        if (rowOffset > numRows-1) {
          rowOffset = numRows;  
        }
        if (colOffset > numCols -1 ) {
          colOffset = numCols;  
        }
    
    }

}
