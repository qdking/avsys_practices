package com.shangce;

public class Main {

    public static void main(String[] args) {

        ClassMethods ticTacToe = new ClassMethods();
        // Printing the TicTacToe grids
        ticTacToe.printGrid();

        do
        {
            // Prompts Player's coordinate inputs to the grid. Rejects if it's already occupied.
            ticTacToe.playerInput();
            ticTacToe.gameSimulation();

            // Check winning condition after player's move, followed by computer's input if undetermined yet.
            if (ClassMethods.getGame_counter() != 9 && ClassMethods.getResults_counter() == 0)
            {
                ticTacToe.computerInput();
                ticTacToe.gameSimulation();
            }
        }
        while (ClassMethods.getGame_counter() != 9 && ClassMethods.getResults_counter() == 0);
    }
}
