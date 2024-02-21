//John Calma

//Date: 06/07/21

import java.awt.Color;
import java.awt.Graphics;
import java.awt.*;


public abstract class Ghost extends MoveObject {


    /*
     * gives a ghost
     * @param x position
     * @param y position
     */
    public Ghost(int x, int y) {
        this.x = x / 48;
        this.y = y / 48;
        this.subX = x;
        this.subY = y;
        this.direction = 0;
    }

    /*
     * adds "AI" logic to the ghost
     * @param map int map
     * @param pacMan the player
     * @return n/a
     */
    public void tick(int[][] map, PacMan pacMan) {

        super.tick(map);


        if ((subY - 24) % 48 < speed && (subX - 24) % 48 < speed)
            direction = whichDirection(map, pacMan);

    }

    /*
     * renders ghost and changes color if kabob is eaten
     * @param g graphics
     */
    public void render(Graphics g, boolean isInvincible) {

        if(isInvincible)
        {
            g.setColor(Color.CYAN);
        }
        else
            {
            g.setColor(Color.RED);
        }

        g.fillOval((int) subX - radius, (int) subY - radius, radius * 2, radius * 2);
        g.fillRect((int)subX - radius,(int)subY, radius * 2, radius);
        g.setColor(Color.WHITE);
        g.fillOval((int)(subX - radius) + 6, (int)subY - radius + 12, 6, 6);
        g.fillOval((int)(subX - radius) + 18, (int)subY - radius + 12, 6, 6);
    }

    /*
     * draws the "game over" when PacMan is hit by a ghost
     * @param Graphics g
     * @return n/a
     */
    public static void gameOver(Graphics g)
    {
            g.setFont(new Font("Permanent Marker", Font.BOLD, 100));
            g.setColor(Color.red.brighter());
            g.drawString("GAME OVER!", 90, 400);
    }
    /*
     * draws the "congratulations"and "you won" when all three levels are completed
     * @param Graphics g
     * @return n/a
     */

    public static void winGame(Graphics g)
    {
        g.setColor(Color.green);
        g.setFont(new Font("Permanent Marker", Font.BOLD, 75));
        g.drawString("CONGRATULATIONS!", 10, 350);
        g.drawString("YOU WON!", 200, 450);
    }

    /*
     * @param pacMan the player
     * @return if the ghost has hit the player
     */
    public boolean hitPlayer(PacMan pacMan)
    {
        return Math.abs(subX - pacMan.getX()) + Math.abs(subY - pacMan.getY()) < (pacMan.getRadius() + radius);
    }

    /*
     * specific ghosts "AI"
     * @param map int map
     * @param PacMan the player
     * @return direction ghost should go
     */
    public abstract int whichDirection(int[][] map, PacMan PacMan);
}
