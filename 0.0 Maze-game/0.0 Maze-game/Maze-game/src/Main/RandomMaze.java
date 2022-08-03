package Main;

import java.util.Scanner;

public class RandomMaze {
    public void randomM() {
        MazeClass class1 = new MazeClass();
        int random;

        int lmp[][] = {
                {1, 2, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 3, 1}
        };

        int checking[][] = {
                {1, 2, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 3, 1}
        };

        int wall[][] = {
                {1, 2, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 3, 1}
        };

        class1.showmaze(lmp, 8);
        int sx = 1;
        int sy = 1;
        checking[sx][sy] = 2;

        class1.rmaze_create(lmp, checking, wall, 8, sx, sy);

        Scanner S = new Scanner(System.in);
        class1.showmaze(lmp, 8);

        System.out.println("Can key y' or 'Y' to show the Maze Solver.");
        System.out.print("insert : ");

        String start;
        int status = 0;

        while (status != 1) {
            start = S.next();
            if (start.equals("y") || start.equals("Y")) {
                sx = 0;
                sy = 1;
                System.out.println();
                class1.findway(checking, lmp, 8, sx, sy);
                System.out.println();
                status = 1;
            } else {
                System.out.println("you have no other choose! Please key 'y' or 'Y' ! hahaha!");
                System.out.print("insert : ");
            }

        }
    }
}
