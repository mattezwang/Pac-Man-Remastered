//John Calma

//Date: 06/07/21
import java.awt.*;


public class PacMan extends MoveObject {


    /*
     * creates a player
     * @param x position
     * @param y position
     */
    public PacMan(int x, int y)
    {

        speed = 3f;
        this.x = x / 48;
        this.y = y / 48;
        this.subX = x;
        this.subY = y;
        direction = MazeMapPanel.getDirection();
    }

    @Override
    /*
     * @param int[][] map
     *
     *  @return n/a
     */
    public void tick(int[][] map)
    {

        super.tick(map);

        if ((subY - 24) % 48 < speed && (subX - 24) % 48 < speed && canGo(map, MazeMapPanel.getDirection()))
            direction = MazeMapPanel.getDirection();

    }
    /*
     * draws the pacman object
     * @param Graphics g
     * @return n/a
     */

    public void render(Graphics g)
    {
            g.setColor(Color.orange);
            g.fillOval((int)subX - radius, (int)subY - radius, radius * 2, radius * 2);
    }

}