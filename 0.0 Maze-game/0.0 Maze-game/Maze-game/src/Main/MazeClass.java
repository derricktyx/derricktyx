package Main;

public class MazeClass
{
    public static void showmaze(int lmp2184b[][],int length)
    {
        for(int x=0; x<length;x++)
        {
            for(int y=0 ; y<length; y++)
            {
                System.out.print(lmp2184b[x][y] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void findway(int lmpuse[][], int lmpshow[][], int length,int sx, int sy)
    {
        int nos=0;
        boolean sensor=true;
        int use_x = sx;
        int use_y = sy;
        while(sensor != false)
        {
            // check down
            if (use_x+1 <= length-1 && lmpuse[use_x+1][use_y] == 0)
            {
                //System.out.println("down");
                lmpuse[use_x+1][use_y] = 4;
                lmpshow[use_x+1][use_y] = 4;
                use_x=use_x+1;
                showmaze(lmpshow,length);
            }

            //check right
            else if (use_y+1 <= length-1 && lmpuse[use_x][use_y+1] == 0)
            {
                //System.out.println("right");
                lmpuse[use_x][use_y+1] = 4;
                lmpshow[use_x][use_y+1] = 4;
                use_y=use_y+1;
                showmaze(lmpshow,length);
            }

            //check up
            else if (use_x-1 >=0 && lmpuse[use_x-1][use_y] == 0)
            {
                //System.out.println("up");
                lmpuse[use_x-1][use_y] = 4;
                lmpshow[use_x-1][use_y] = 4;
                use_x=use_x-1;
                showmaze(lmpshow,length);
            }

            //check right
            else if (use_y+1 <= length-1 && lmpuse[use_x][use_y+1] == 0)
            {
                //System.out.println("right");
                lmpuse[use_x][use_y+1] = 4;
                lmpshow[use_x][use_y+1] = 4;
                use_y=use_y+1;
                showmaze(lmpshow,length);
            }

            //check left
            else if (use_y-1 >=0 && lmpuse[use_x][use_y-1] == 0)
            {
                //System.out.println("left");
                lmpuse[use_x][use_y-1] = 4;
                lmpshow[use_x][use_y-1] = 4;
                use_y=use_y-1;
                showmaze(lmpshow,length);
            }
            else if (   (use_x+1 <=length-1 && lmpuse[use_x+1][use_y]==3)
                    || (use_x-1 >=0 && lmpuse[use_x-1][use_y]==3)
                    || (use_y+1 <=length-1 && lmpuse[use_x][use_y+1]==3)
                    || (use_y-1 >=0 && lmpuse[use_x][use_y-1]==3)  )
            {
                sensor=false;
                for(int i =0 ; i < length ; i++)
                {
                    for(int j =0; j < length ; j++)
                    {
                        if (lmpuse[i][j] == 5)
                        {
                            lmpuse[i][j] = 0;
                            lmpshow[i][j] = 0;
                        }
                    }
                }
                showmaze(lmpshow,length);
                System.out.println("Maze Solved !");
            }
            else
            {
                lmpuse[use_x][use_y] = 5;    // 5 means no empty
                lmpshow[use_x][use_y] = 0;
                use_x=sx;
                use_y=sy;
                nos++;
                //System.out.println("block");
                System.out.println("fail : " + nos + "\n");

                for(int i =0 ; i < length ; i++)
                {
                    for(int j =0; j < length ; j++)
                    {
                        if (lmpuse[i][j] == 4)
                        {
                            lmpuse[i][j] = 0;
                            lmpshow[i][j] = 0;
                        }
                    }
                }
                showmaze(lmpshow,length);
            }
        }
    }

    public static void rmaze_create(int lmp[][], int checking[][], int wall[][], int length,int sx_1, int sy_1)
    {
        int sx = sx_1;
        int sy = sy_1;
        while (checking[sx + 1][sy] != 3 && checking[sx][sy + 1] != 3) {
            //check down
            if (checking[sx + 1][sy] >= 1) {
                checking[sx + 1][sy] = 1;
            } else if (checking[sx + 1][sy] == 2) {
                checking[sx + 1][sy] = 2;
            } else {
                int random = (int) (Math.random() * 2);
                if (random < 1) {
                    checking[sx + 1][sy] = 0;
                } else {
                    checking[sx + 1][sy] = 1;
                    //System.out.println("wall below");
                }
            }

            //check right
            if (checking[sx][sy + 1] >= 1) {
                checking[sx][sy + 1] = 1;
            } else if (checking[sx][sy + 1] == 2) {
                checking[sx][sy + 1] = 2;
            } else {
                int random = (int) (Math.random() * 2);
                if (random < 1) {
                    checking[sx][sy + 1] = 0;
                } else {
                    checking[sx][sy + 1] = 1;
                    //System.out.println("wall right");
                }
            }

            //checking
            //move to down ?
            if (checking[sx + 1][sy] == 0) {
                wall[sx + 1][sy] = 2;
                sx = sx + 1;
                sy = sy;
                //System.out.println("move down ");
            }
            //move to down ?
            else if (checking[sx][sy + 1] == 0) {
                wall[sx][sy + 1] = 2;
                sx = sx;
                sy = sy + 1;
                //System.out.println("move right ");
            }
            //no move
            else {
                //System.out.println("no more");
                checking[sx + 1][sy] = lmp[sx + 1][sy];
                checking[sx][sy + 1] = lmp[sx][sy + 1];
                sx = sx;
                sy = sy;
            }

            lmp[sx + 1][sy] = checking[sx + 1][sy];
            lmp[sx][sy + 1] = checking[sx][sy + 1];
        }

        wall[1][1] = 2;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (wall[i][j] == 0) {
                    int random = (int) (Math.random() * 2);
                    if (random < 1) {
                        checking[i][j] = 0;
                        lmp[i][j] = 0;
                    } else {
                        checking[i][j] = 1;
                        lmp[i][j] = 1;
                    }
                } else if (wall[i][j] == 2) {
                    checking[i][j] = 0;
                    lmp[i][j] = 0;
                } else {
                    wall[i][j] = checking[i][j];
                    wall[i][j] = lmp[i][j];
                }
            }
        }
    }
}
