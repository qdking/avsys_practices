package com.shangce;

import java.util.Random;
import java.util.Scanner;

public class ClassMethods {

    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    public static int game_counter = 0;     // game_counter: number of moves made
    public static int results_counter = 0;     // 1 if player wins, 2 if computer wins. 0 by default.

    int[][] Grid = new int[ROWS][COLUMNS];

    public static int getGame_counter() {
        return game_counter;
    }

    public static int getResults_counter() {
        return results_counter;
    }

    public void printRowLabels() {

        // Leaving 2 spaces for vertical grid label numbers
        System.out.print("  ");

        // To print horizontal grid label numbers
        for (int i = 1; i < COLUMNS + 1; i++) {
            System.out.print(i + "   ");
        }
        // Print a line after horizontal the grid label numbers
        System.out.print("\n");
    }

    public boolean checkAvailability(int rows, int columns){
        if(Grid[rows][columns] == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void printGrid(){
        // Print the horizontal row numbering labels on top first.
        printRowLabels();

        // temporary integer to adjust printing vertical grid number correctly
        int temp = 0;

        // Print the grid and current results.
        for (int i = 1; i < COLUMNS + 1 + 2; i ++)
        {
            if (i % 2 == 0)
            {
                System.out.print(" ---+---+---");
            }
            if (i % 2 != 0)
            {
                // Printing out the vertical grid number
                System.out.print(i - temp + " ");

                // Print the results within the grid, blank by default
                for (int j = 0; j < COLUMNS + 1 - 1 ; j++)
                {
                    // Print out the computer/player's input
                    switch (Grid[i - 1 - temp][j])
                    {
                        case 1:
                            System.out.print("X");
                            break;
                        case 2:
                            System.out.print("O");
                            break;
                        case 0:
                            System.out.print(" ");
                            break;
                    }

                    // Print out the vertical grid
                    if (j != COLUMNS - 1 )
                    {
                        System.out.print(" | ");
                    }
                }
                // temp++ after an actual printing of row instead of a grid
                temp++;
            }

            // Go over to a  new row
            System.out.print("\n");
        }
    }

    public void playerInput(){
        Scanner input = new Scanner(System.in);
        int x, y;
        System.out.println("Now is your turn.");
        System.out.println("Choose the vertical point, X co-ordinate (1 to 3) for your input:");
        do {
            do
            {
                while (!input.hasNextInt())
                {
                    input.next();
                }
                x = input.nextInt();
                if (x > ROWS || x < 1)
                {
                    System.out.println("Please choose a value 1 to 3 for your vertical point, X co-ordinate.");
                }
            }
            while (x > ROWS || x < 1);

            System.out.println("Choose the horizontal point, Y co-ordinate (1 to 3) for your input:");
            do
            {
                while (!input.hasNextInt())
                {
                    input.next();
                }
                y = input.nextInt();
                if (y > COLUMNS || y < 1)
                {
                    System.out.println("Please choose a value 1 to 3 for your horizontal point, Y co-ordinate.");
                }
            }
            while (y > COLUMNS || y < 1);

            if (!checkAvailability(x - 1, y - 1))
            {
                System.out.println("Coordinate is already occupied in the TicTacToe grid.");
            }
        }
        while (!checkAvailability(x - 1, y - 1));

        if(checkAvailability(x - 1, y - 1))
        {
            Grid[x - 1][y - 1] = 1;
            game_counter++;
        }
        printGrid();
    }

    public void computerInput(){
        int x, y;
        Random rnd = new Random();
        System.out.println("The computer's turn:");
        do {
            //Generate a pair of co-ordinates
            x = rnd.nextInt(ROWS);
            y = rnd.nextInt(COLUMNS);
        }
        //Check whether the spot is free.
        while(!checkAvailability(x, y));

        if (checkAvailability(x, y))
        {
            Grid[x][y] = 2;
            game_counter++;
        }
        printGrid();
    }

    // Check winning/lose/draw condition
    public void gameSimulation(){

        // 8 ways to win, 4 main points to look at
        for (int i = 0; i < ROWS; i++)
        {
            // Check for all 3 horizontal ways
            if (Grid[i][0] != 0 && Grid[i][0] == Grid[i][1] && Grid[i][0] == Grid[i][2])
            {
                results_counter = Grid[i][0];
                break;
            }
            // Check for all 3 vertical ways
            if (Grid[0][i] != 0 && Grid[0][i] == Grid[1][i] && Grid[0][i] == Grid[2][i])
            {
                results_counter = Grid[0][i];
                break;
            }

            // Checking all 2 diagonal ways (black-slash direction):
            if (Grid[0][0] !=0 && Grid[1][1] != 0 && Grid[2][2] != 0
                    && Grid[0][0] == Grid[1][1] && Grid[0][0] == Grid[2][2])
            {
                results_counter = Grid[0][0];
                break;
            }
            //(slash direction):
            if (Grid[0][2] !=0 && Grid[1][1] != 0 && Grid[2][0] != 0
                    && Grid[0][2] == Grid[1][1] && Grid[0][2] == Grid[2][0])
            {
                results_counter = Grid[0][2];
                break;
            }
        }

        if (results_counter == 1)
        {
            System.out.println("Congrats, you've won the game!");
        }
        if (results_counter == 2)
        {
            System.out.println("Oh no, the computer has beaten you in the game!");
        }
        if (results_counter == 0 && game_counter == 9)
        {
            System.out.println("No more spaces, the game result is a DRAW!");
        }
    }
}


/* Code dump
            // Check for all 3 horizontal ways
            if (Grid[i][0] == 1 && Grid[i][1] == 1 && Grid[i][2] == 1)
            {
                results_counter = 1;
                break;
            }
            if (Grid[i][0] == 2 && Grid[i][1] == 2 && Grid[i][2] == 2)
            {
                results_counter = 2;
                break;
            }
            // Check for all 3 vertical ways
            if (Grid[0][i] == 1 && Grid[1][i] == 1 && Grid[2][i] == 1)
            {
                results_counter = 1;
                break;
            }
            if (Grid[0][i] == 2 && Grid[1][i] == 2 && Grid[2][i] == 2)
            {
                results_counter = 2;
                break;
            }
            // Checking all 2 diagonal ways (black-slash direction):
            if (Grid[0][0] == 1 && Grid[1][1] == 1 && Grid[2][2] == 1)
            {
                results_counter = 1;
                break;
            }
            if (Grid[0][0] == 2 && Grid[1][1] == 2 && Grid[2][2] == 2)
            {
                results_counter = 2;
                break;
            }
            //(slash direction):
            if (Grid[0][2] == 1 && Grid[1][1] == 1 && Grid[2][0] == 1)
            {
                results_counter = 1;
                break;
            }
            if (Grid[0][2] == 2 && Grid[1][1] == 2 && Grid[2][0] == 2)
            {
                results_counter = 1;
                break;
            }
        }
        if (results_counter == 1)
        {
            System.out.println("Congrats, you've won the game!");
        }
        if (results_counter == 2)
        {
            System.out.println("Oh no, the computer has beaten you in the game!");
        }
        if (results_counter == 0 && game_counter == 9)
        {
            System.out.println("No more spaces, the game result is a DRAW!");
        }


 */