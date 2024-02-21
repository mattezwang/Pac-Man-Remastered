//John Calma

//Date: 06/07/21
public abstract class MoveObject
{


    protected float speed = 3f;
    protected float subY, subX;
    protected int y, x;
    protected int direction;
    protected int radius = 16;

    /*
     * deals with all movement and timers
     * @param map int map
     */
    public void tick(int[][] map)
    {

        //movement for all entities
        //Frame rate
        //the only differences the entities have from player
        //is the direction they choose when they hit a intersection

        /*
         * 0 = up
         * 1 = right
         * 2 = down
         * 3 = left
         */

        if (direction == 0 && canGo(map, 0))
            subY -= speed;

        else if (direction == 1 && canGo(map, 1))
            subX += speed;

        else if (direction == 2 && canGo(map, 2))
            subY += speed;

        else if (direction == 3 && canGo(map, 3))
            subX -= speed;


        if ((subY - 24) % 48 < speed)
            y = (int)((subY - 24) / 48);

        if ((subX - 24) % 48 < speed)
            x = (int)((subX - 24) / 48);


    }

    /*
     * whether or not there is a wall in a certain direction
     * @param map int map
     * @param direction wanted direction
     * @return whether its a valid direction
     */
    protected boolean canGo(int[][] map, int direction)
    {

        if (direction == 0)
            return map[y - 1][x] != 1;

        else if (direction == 1)
            return map[y][x + 1] != 1;

        else if (direction == 2)
            return map[y + 1][x] != 1;

        else if (direction == 3)
            return map[y][x - 1] != 1;


        return false;

    }

    //getters
    public int getRadius()
    {
        return radius;
    }
    public int getX()
    {
        return (int) subX;
    }
    public int getY()
    {
        return (int) subY;
    }

}