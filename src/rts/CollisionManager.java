/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rts;

import java.awt.Rectangle;

/**
 *
 * @author _ginold_
 */
public class CollisionManager {
    
    private TileMap map;
    private Player player;
    private int tilesize;
    
    private int x;
    private int y;
    
    public CollisionManager (TileMap map, Player player) {
        this.map = map;
        this.player = player;
        this.tilesize = map.tilesize;
    }
    
    public boolean checkCollisions() {
        for (int row = map.rowOffset; row < map.rowOffset + map.numRowsToDraw; row++) {
            // nothing else to draw, out of bounds
            if (row >= map.numRows) {
                break;
            }
            if (row <= 0) {
                row = 1;
            }
            for (int col = map.colOffset; col < map.colOffset + map.numColsToDraw; col++) {
                if (col <= 0) {
                    col = 1;
                }
             //   System.out.println(player.getBBox());
                // nothing else to draw, out of bounds
                if (col >= map.numCols) {
                    break;
                }

                int rowcol = map.map[row][col];

                if (rowcol == 5) {
                    int y = map.y + row * tilesize;
                    int x = map.x + col * tilesize;
                 //   System.out.println("row col " + row + " " +col);
//                    System.out.println("player x " +player.getX());
//                    System.out.println("player y " + player.getY());
//                
//                    System.out.println("x " + x);
//                    System.out.println("y " + y);
                    Rectangle collisionBox = new Rectangle(x, y ,  tilesize, tilesize);
                   
                    if (collisionBox.intersects(player.getBBox())) {
                        return true;
                    }
                 
                }
            }
        }
          return false;
    }


}
