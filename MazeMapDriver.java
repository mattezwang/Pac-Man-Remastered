//Author: Sam Parsa
import javax.swing.*;


public class MazeMapDriver {

    public static void main(String[] args) {


            //creates a pacman game
            var frame = new JFrame("PacMan");
            frame.setSize(910, 910);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new MazeMapPanel());
            frame.setVisible(true);

    }
}