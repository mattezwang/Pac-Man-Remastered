//Author: Matthew Wang
import java.awt.*;

public class Wall {

    private int x;
    private int y;
    private int width;
    private int height;


    /*
     * makes a wall object
     * @param x position
     * @param y position
     * @param width of wall
     * @param height of wall
     */
    public Wall(int x, int y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /*
     * renders wall object
     * @param g graphics
     */
    public void render(Graphics g) {
        g.setColor(Color.BLUE.darker());
        g.fillRect(x - width / 2, y - width / 2, width, height);
        g.setColor(new Color(100, 3, 250));
        g.drawRect(x - width / 2, y - width / 2, width, height);
    }

}