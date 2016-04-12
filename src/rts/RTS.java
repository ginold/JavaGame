/*  
 * To change this template, choose Tools | Templates  
 * and open the template in the editor.  
 */
package rts;

import com.sun.java.accessibility.util.AWTEventMonitor;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * @author panos
 */
public class RTS extends BasicGame {

    private TileMap tilemap;
    public static final int width = 810;
    public static final int height = 600;

    public Player player;
    public int tween = 50;
    
    public CollisionManager collisions;

    public RTS() {
        super("Wizard game");
    }

    public static void main(String[] arguments) {
        try {
            AppGameContainer app = new AppGameContainer(new RTS());
            app.setDisplayMode(width, height, false);
            app.setTargetFrameRate(60);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        player = new Player(RTS.width/2 - 32, RTS.height/2 - 32); //position
        tilemap = new TileMap("C:\\Users\\ginold\\Documents\\NetBeansProjects\\JavaGame\\src\\rts\\map.txt");
        collisions = new CollisionManager(tilemap, player);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_LEFT)) {
            if (!collisions.checkCollisions()) {
                tilemap.setPosition(tilemap.x + tween +2, tilemap.y);
            } else {
                tilemap.setPosition(tilemap.x - tween, tilemap.y);
            }
        } 
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            if (!collisions.checkCollisions()) {
                 tilemap.setPosition(tilemap.x - tween +2, tilemap.y);
            } else {
                 tilemap.setPosition(tilemap.x + tween, tilemap.y);
            }
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            if (!collisions.checkCollisions()) {
                tilemap.setPosition(tilemap.x, tilemap.y + tween +2);
            } else {
                tilemap.setPosition(tilemap.x, tilemap.y - tween +2);
            }
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            if (!collisions.checkCollisions()) {
                tilemap.setPosition(tilemap.x, tilemap.y - tween +2);
            } else {
                tilemap.setPosition(tilemap.x, tilemap.y + tween +2);
            }
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        tilemap.render(g);
        player.render(g);
    }
}
