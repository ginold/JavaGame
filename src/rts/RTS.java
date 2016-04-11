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
        player = new Player(10, 30);
        tilemap = new TileMap("C:\\Users\\_ginold_\\Documents\\NetBeansProjects\\RTS\\src\\rts\\map.txt");
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();
        if (input.isKeyDown(Input.KEY_LEFT)) {
            player.move("left");
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            player.move("right");
        }
        if (input.isKeyDown(Input.KEY_UP)) {
            player.move("up");
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            player.move("down");
        }

        tilemap.setPosition(RTS.width / 5 - player.getX(), RTS.height/ 5- player.getY());
        player.update();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        tilemap.render(g);
        player.render(g);
    }
}
