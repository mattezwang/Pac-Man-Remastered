//Author: Matthew Wang
import java.awt.Graphics;

public abstract class Screen {

    //abstract class for screens

    /*
     * renders
     * @param g graphics
     */
    public abstract void render(Graphics g);

    /*
     * updates the screens
     * @return screen for next tick/render (usually the same screen as before)
     */
    public abstract void tick();

}
