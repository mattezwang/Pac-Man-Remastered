//Author: Sam Parsa
public class Clyde extends Ghost {

    private int savedDirection = 0;


    /*
     * makes a clyde ghost
     *
     * @param x position
     * @param y position
     */
    public Clyde(int x, int y) {
        super(x, y);
    }

    @Override
    public int whichDirection(int[][] map, PacMan PacMan) {

        if (atTurn(map) || atDeadEnd(map))
            savedDirection = availableDirection(map);

        return savedDirection;
    }


        /*
         * @param map int map
         * @return if the ghost is at a turn
         */
        private boolean atTurn ( int[][] map){

            return !((map[y - 1][x] == 1 && map[y + 1][x] == 1) || (map[y][x - 1] == 1 && map[y][x + 1] == 1));

        }


        /*
         * @param map int map
         * @return if the ghost is at a dead end
         */
        private boolean atDeadEnd ( int[][] map){

            int walls = 0;

            walls += map[y - 1][x] == 1 ? 1 : 0;
            walls += map[y + 1][x] == 1 ? 1 : 0;
            walls += map[y][x - 1] == 1 ? 1 : 0;
            walls += map[y][x + 1] == 1 ? 1 : 0;

            return walls == 3;
        }

        /*
         * finds all available directions of the ghosts position
         * @param map int map
         * @return a random available direction
         */
        private int availableDirection ( int[][] map){

            while (true) {
                int tempDirection = (int) (Math.random() * 4);

                if ((tempDirection == 0 && map[y - 1][x] != 1) ||
                        (tempDirection == 1 && map[y][x + 1] != 1) ||
                        (tempDirection == 2 && map[y + 1][x] != 1) ||
                        (tempDirection == 3 && map[y][x - 1] != 1)) {
                    return tempDirection;
                }
            }

        }

    }
