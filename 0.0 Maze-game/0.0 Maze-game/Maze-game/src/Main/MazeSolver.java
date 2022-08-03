package Main;

import java.util.Scanner;

public class MazeSolver
{
    public static void main(String[] args) {
        RandomMaze randomMaze = new RandomMaze();
        MazeClass class1 = new MazeClass();
        Scanner S = new Scanner(System.in);
        int random = (int)(Math.random()*2);

        int lai[][]={
                {1,1,1,1,1,1},
                {0,0,0,0,0,1},
                {1,0,1,0,1,0},
                {0,0,0,1,0,1},
                {2,1,0,0,0,1},
                {0,0,0,1,0,3}
        };
        int show[][]={
                {1,1,1,1,1,1},
                {0,0,0,0,0,1},
                {1,0,1,0,1,0},
                {0,0,0,1,0,1},
                {2,1,0,0,0,1},
                {0,0,0,1,0,3}
        };

        System.out.println("welcome to Maze, here is the maze.");

        class1.showmaze(show,6);

        System.out.println("Can key y' or 'Y' to show the Maze Solver.");
        System.out.print("insert : ");

        String start ;
        int status=0;

        while(status!=1)
        {
            start = S.next();
            if( start.equals("y") || start.equals("Y"))
            {
                int sx=4;
                int sy=0;
                System.out.println();
                class1.findway(lai,show,6,sx,sy);
                System.out.println();
                status=1;
            }
            else
            {
                System.out.println("you have no other choose! Please key 'y' or 'Y' ! hahaha!");
                System.out.print("insert : ");
            }
        }

        System.out.println("Now, we have a random maze , do you want to try ? [y/n]");
        System.out.print("insert : ");
        String again = S.next();

        if (again.equals("y") || again.equals("Y"))
        {
            System.out.println();
            randomMaze.randomM();
            System.out.println("Thank you, have a nice day!");
        }
        else if (again.equals("n") || again.equals("N"))
        {
            System.out.println("Never mind, have a nice day!");
        }
        else
        {
            System.out.println(again+"...er...can't recognized, but never mind, have a nice day.");
        }

    }
}
