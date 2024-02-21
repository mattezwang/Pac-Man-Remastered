//Author: Matthew Wang
import java.awt.*;
import java.util.ArrayList;


public class GameScreen extends Screen {

    public static int WALL = 1, PLAYER = 2, CLYDE = 3, POWERFOOD = 5, CLYDE2 = 6, CLYDE3 = 7;

    //invincibility timer after eating power food
    private static final int timerCap = 500;
    private int timer = 0;

    //level and its map
    private int currentLevel = 1;
    private int[][] map;

    //map converted into objects
    private ArrayList<Wall> walls;
    private ArrayList<Pellet> pellet;
    private ArrayList<Kabob> kabob;
    private PacMan pacMan;
    private Clyde clyde;
    private Clyde clyde2;
    private Clyde clyde3;
    private boolean lose = false;
    private int counter = 0;
    private boolean win = false;

    /*
     * creates the actual pacman game
     */
    public GameScreen() {

        map = Maps.getLevel(currentLevel);
        walls = new ArrayList<Wall>();
        pellet = new ArrayList<Pellet>();
        kabob = new ArrayList<Kabob>();

        //adds map objects to array lists
        convert();

    }

    @Override
    /*
     * renders walls, kabobs, pellets, ghosts, and pacman
     * @param g graphics
     */
    public void render(Graphics g) {

        g.setColor(Color.black);
        g.fillRect(0, 0, 900, 900);

        Graphics2D g2d = (Graphics2D) g;


        for (Wall wall: walls) {
            wall.render(g);
        }
        for (Pellet pellet : this.pellet) {
            pellet.render(g);
        }
        for (Kabob food: kabob) {
            food.render(g);
        }

        boolean isInvincible = (timer>0);
        clyde.render(g, isInvincible);
        clyde2.render(g,isInvincible);
        clyde3.render(g,isInvincible);
        drawInfo(g2d);

        pacMan.render(g);

        if(lose)
            clyde.gameOver(g);

        if(win)
            clyde.winGame(g);

    }

    @Override
    public void tick()
    {
        //if the player has won the level
        if (pellet.size() == 0 && kabob.size() == 0)
        {
            if (currentLevel == 3)
                win = true;
            else {
                currentLevel++;
                map = Maps.getLevel(currentLevel);
                timer = 0;
                convert();
            }
        }

        //normal game states
        else if(!lose){

            //entity updates
            pacMan.tick(map);
            clyde.tick(map, pacMan);
            clyde2.tick(map, pacMan);
            clyde3.tick(map, pacMan);


            //if the ghost hits player
            if ((clyde.hitPlayer(pacMan)) && timer == 0)
                lose = true;
            if ((clyde2.hitPlayer(pacMan)) && timer == 0)
                lose = true;
            if ((clyde3.hitPlayer(pacMan)) && timer == 0)
                lose = true;



            //checks for player eating food
            //implementation is poorly optimized but whatever
            for (int x = 0; x < pellet.size(); x++) {
                if (pellet.get(x).eaten(pacMan)) {
                    pellet.remove(x);
                    x -= 1;
                    counter++;
                }

            }

            //same but with power food
            //also power food dosn't allow the player to eat ghosts but rather be invincible
            for (int x = 0; x < kabob.size(); x++) {
                if (kabob.get(x).eaten(pacMan)) {
                    kabob.remove(x);
                    x -= 1;
                    timer = timerCap;
                    counter += 5;

                }
            }
            timer = Math.max(0, timer - 1);
        }

    }


    /*
     * draws the score and level
     * @param g graphics2D
     */
    private void drawInfo(Graphics2D g) {
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.white);
        String s = "Score: " + (counter-1);
        g.drawString(s, 50, 850);

        g.drawString("Level: " + currentLevel, 300, 850);
    }

    /*
     * converts int map into objects
     * also resets the lists
     */
    private void convert() {

        //clears lists
        walls.clear();
        pellet.clear();
        kabob.clear();
        counter++;


        //iterates through the map
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {

                if (map[y][x] != WALL && map[y][x] != POWERFOOD)
                    pellet.add(new Pellet(x * 48 + 24, y * 48 + 24));

                if (map[y][x] == WALL)
                    walls.add(new Wall(x * 48 + 24, y * 48 + 24, 48, 48));
                else if (map[y][x] == PLAYER)
                    pacMan = new PacMan(x * 48 + 24, y * 48 + 24);

                else if (map[y][x] == CLYDE)
                    clyde = new Clyde(x * 48 + 24, y * 48 + 24);

                else if (map[y][x] == CLYDE2)
                    clyde2 = new Clyde(x * 48 + 24, y * 48 + 24);

                else if (map[y][x] == CLYDE3)
                    clyde3 = new Clyde(x * 48 + 24, y * 48 + 24);

                else if (map[y][x] == POWERFOOD)
                    kabob.add(new Kabob(x * 48 + 24, y * 48 + 24));
            }
        }

    }



}