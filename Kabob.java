//Author: Sam Parsa
import java.awt.*;

public class Kabob extends Pellet {


    /*
     * makes a power food "kabob"
     * @param x position
     * @param y position
     */
    public Kabob(int x, int y) {
        super(x, y);
        radius = 16;

    }

    /*
     * renders wall
     * @param g graphics
     */
    @Override
    public void render(Graphics g) {
        g.setColor(new Color(128, 57, 30));
            g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
            g.setColor(Color.white);
            g.drawOval(x - radius, y - radius, radius * 2, radius * 2);

    }


}