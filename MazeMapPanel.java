//Author: Mike Tran
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class MazeMapPanel extends JPanel implements KeyListener {

    //creates all screens
    GameScreen gameScreen = new GameScreen();

    //input info
    private static int direction = 0;


    /*
     * creates the games frame
     */
    public MazeMapPanel() {
        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
 //makes the game stop for 8 milliseconds
       try {
            Thread.sleep(8);
        } catch (InterruptedException e) {
        }

        /*
         * deals with the different screens
         */

                gameScreen.tick();
                gameScreen.render(g);

        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //gets the most recent direction player has typed
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            direction = 0;
        }
        else if (key == KeyEvent.VK_D) {
            direction = 1;
        }
        else if (key == KeyEvent.VK_S) {
            direction = 2;
        }
        else if (key == KeyEvent.VK_A) {
            direction = 3;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static int getDirection() {
        return direction;
    }



}