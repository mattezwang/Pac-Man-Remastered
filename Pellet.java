//Author: Mike Tran
import java.awt.*;
public class Pellet {

    protected int x, y;
    protected int radius = 8;


    /*
     * creates a food piece
     * @param x position
     * @param y position
     */
    public Pellet(int x, int y) {

        this.x = x;
        this.y = y;
    }

    /*
     * renders
     * @param g graphics
     */
    public void render(Graphics g) {

        g.setColor(Color.yellow);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        g.setColor(Color.white);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    /*
     * @param pacMan the player
     * @return if this food has been "eaten"
     */
    public boolean eaten(PacMan pacMan) {

        return Math.abs(x - pacMan.getX()) + Math.abs(y - pacMan.getY()) < (pacMan.getRadius() + radius);

    }

}